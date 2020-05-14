package com.linda.demo.practice;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.JacocoCoverageReport;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Jenkins {
  static String jenkinsRootUrl =
      "https://gkejen4ctrlframwork.jaas-gcp.cloud.sap.corp/" + "job/GRC-DPP/job/";
  static String jenkinsLibUrl =
      "https://gkejen4ctrlframwork.jaas-gcp.cloud.sap.corp/" + "job/GRC-Library/job/";
  static String mdUIUrl = jenkinsRootUrl + "masterdata-ui/job/dev";
  static String reUIUrl = jenkinsRootUrl + "regulation-ui/job/dev";
  static String MDBackendSheetName = "MD Backend";
  static String regBackendSheetName = "Regulation Service";
  static String docLibBackendSheetName = "Document-Service-Lib";
  static String regUISheetName = "Regulation UI";
  static String regComplianceUISheetName = "Regulation Compliance Manage";
  static String mdOrgUISheetName = "Organization UI";
  static String mdProUISheetName = "Process UI";
  static String mdRepUISheetName = "Repository UI";
  static String mdCommplianceUISheetName = "MD Comp Manage";

  public static void main(String[] args) throws URISyntaxException, IOException {

    String excelFilePath = "C:\\repo\\coverage\\Coverage.xlsx";
    FileInputStream inputStream;
    FileOutputStream outputStream;

    try {
      inputStream = new FileInputStream(new File(excelFilePath));
      Workbook workbook = WorkbookFactory.create(inputStream);
      outputStream = new FileOutputStream(excelFilePath);

      /**
       * write backend coverage to excel sheet
       * Prerequisite
       * we need import certificate of jenkins server to our jre environment.
       * 1. download certificate form jenkins server
       * 2. copy downloaded certificate to "C:\Program Files\Java\jdk1.8.0_211\jre\lib\security",
       * where your jre locates.
       * 3. run command in administrator mode to import certificate to jre:
       * keytool -import -alias jenkins_certificate -keystore cacerts -file jenkins_certificate.cer
       * 4. check whether certificate imported to jre successfully or not
       * keytool -list -keystore cacerts -alias jenkins_certificate
       */
      Map<String, String> backendMap = buildBackendMap();
      Iterator<Map.Entry<String, String>> entries = backendMap.entrySet().iterator();
      while (entries.hasNext()) {
        Map.Entry<String, String> entry = entries.next();
        Map<Integer, String> coverageMap;
        if (entry.getKey().equals(docLibBackendSheetName)) {
          coverageMap = getBackendCoverage(jenkinsLibUrl, entry.getValue());
        } else {
          coverageMap = getBackendCoverage(jenkinsRootUrl, entry.getValue());
        }

        writeExcel(workbook, entry.getKey(), 45, coverageMap);
      }

      //write frontend coverage to excel sheet
      writeFrontendCoverage(workbook);

      workbook.write(outputStream);
      inputStream.close();
      workbook.close();
      outputStream.close();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    }
  }

  private static void writeFrontendCoverage(Workbook workbook) {
    System.setProperty("webdriver.chrome.driver",
        "C://Users//I308725//Downloads//chromedriver_win32_80//chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    // get regulation-ui coverage
    driver.get(reUIUrl);
    WebElement buildNumber =
        driver.findElement(By.cssSelector("a[update-parent-class='.build-row']:first-of-type"));
    buildNumber.click();
    try {
      writeRegUICoverage(workbook, driver);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //get masterdata-ui coverage
    driver.get(mdUIUrl);
    WebElement mdbuildNumber =
        driver.findElement(By.cssSelector("a[update-parent-class='.build-row']:first-of-type"));
    mdbuildNumber.click();

    writeMDUICoverage(workbook, driver);
  }

  // there are four repports in masterdata-ui
  public static void writeMDUICoverage(Workbook workbook, WebDriver driver) {
    String complianceUrl =
        "LCOV Coverage target-coverage-allComplianceManageTests-report-lcov-lcov-report";
    String orgUrl = "LCOV Coverage target-coverage-allOrganizationTests-report-lcov-lcov-report";
    String processUrl = "LCOV Coverage target-coverage-allProcessTests-report-lcov-lcov-report";
    String repositoryUrl =
        "LCOV Coverage target-coverage-allRepositoryTests-report-lcov-lcov-report";

    Map<String, String> mdUIMap = new HashMap<>();
    mdUIMap.put(mdCommplianceUISheetName, complianceUrl);
    mdUIMap.put(mdOrgUISheetName, orgUrl);
    mdUIMap.put(mdProUISheetName, processUrl);
    mdUIMap.put(mdRepUISheetName, repositoryUrl);
    writeUICoverage(mdUIMap.entrySet().iterator(), driver, workbook);
  }

  // there are two repports in regulation-ui
  public static void writeRegUICoverage(Workbook workbook, WebDriver driver)
      throws IOException, InterruptedException {
    String regComplianceUrl =
        "LCOV Coverage target-coverage-allComplianceManageTests-report-lcov-lcov-report";
    String regUIUrl = "LCOV Coverage target-coverage-allRegulationTests-report-lcov-lcov-report";
    Map<String, String> regUIMap = new HashMap<>();
    regUIMap.put(regComplianceUISheetName, regComplianceUrl);
    regUIMap.put(regUISheetName, regUIUrl);
    writeUICoverage(regUIMap.entrySet().iterator(), driver, workbook);
  }

  // go to each report to get frontend coverage
  private static void writeUICoverage(Iterator<Map.Entry<String, String>> entries, WebDriver driver,
      Workbook workbook) {
    while (entries.hasNext()) {
      Map.Entry<String, String> entry = entries.next();
      WebElement serviceUrl =
          driver.findElement(By.xpath("//a[text()='" + entry.getValue() + "']"));
      serviceUrl.click();
      Map<Integer, String> coverageMap = getModuleUICoverage(driver);
      try {
        writeExcel(workbook, entry.getKey(), 45, coverageMap);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static Map<Integer, String> getModuleUICoverage(WebDriver driver) {
    driver.switchTo().frame(0);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String statementLocator = "//span[text()='Statements']";
    String branchLocator = "//span[text()='Branches']";
    String functionLocator = "//span[text()='Functions']";
    String lineLocator = "//span[text()='Lines']";
    String[] locators = {statementLocator, branchLocator, functionLocator, lineLocator};
    Map<Integer, String> coverageMap = new HashMap<>();
    for (int i = 0; i < locators.length; i++) {
      coverageMap.put(i,
          driver.findElement(By.xpath(locators[i] + "/preceding-sibling::span[1]")).getText());
    }
    driver.navigate().back();
    driver.switchTo().window(driver.getWindowHandle());
    return coverageMap;
  }

  private static Map<String, String> buildBackendMap() {
    Map<String, String> backendMap = new HashMap<>();
    String mdBackendUrl = "masterdata-service/";
    String regBackendUrl = "regulation-service/";
    String docLibBackendUrl = "document-service-lib/";
    backendMap.put(MDBackendSheetName, mdBackendUrl);
    backendMap.put(regBackendSheetName, regBackendUrl);
    backendMap.put(docLibBackendSheetName, docLibBackendUrl);
    return backendMap;
  }

  private static Map<Integer, String> getBackendCoverage(String jenkinsUrl, String serviceUrl) {
    JenkinsServer jenkins = null;
    Map<Integer, String> coverageMap = new HashMap<>();
    NumberFormat numberFormat = NumberFormat.getPercentInstance();
    try {
      jenkins = new JenkinsServer(new URI(jenkinsUrl + serviceUrl));
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    try {
      JobWithDetails job = jenkins.getJobs().get("dev").details();
      Build lastCompletedBuild = job.getLastCompletedBuild();
      JacocoCoverageReport report = lastCompletedBuild.getClient()
          .get("job/dev/lastCompletedBuild/jacoco/", JacocoCoverageReport.class);
      coverageMap
          .put(0, numberFormat.format(0.01 * report.getInstructionCoverage().getPercentageFloat()));
      coverageMap.put(1, numberFormat.format(0.01 * report.getBranchCoverage().getPercentage()));
      coverageMap
          .put(2, numberFormat.format(0.01 * report.getComplexityScore().getPercentageFloat()));
      coverageMap.put(3, numberFormat.format(0.01 * report.getLineCoverage().getPercentageFloat()));
      // no method coverage API
      coverageMap.put(4, numberFormat.format(0.01 * report.getLineCoverage().getPercentageFloat()));
      coverageMap
          .put(5, numberFormat.format(0.01 * report.getClassCoverage().getPercentageFloat()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return coverageMap;
  }

  private static void writeExcel(Workbook workbook, String sheetName, int sprintNum,
      Map<Integer, String> coverageMap) throws IOException {
    String sprint = "Sprint " + sprintNum;
    Sheet sheet = workbook.getSheet(sheetName);
    int lastRowCount = sheet.getLastRowNum();
    int cellNum = sheet.getRow(lastRowCount).getLastCellNum();
    // if current sprint hasn't been writen to sheet
    if (!sheet.getRow(lastRowCount).getCell(0).getStringCellValue().trim().equals(sprint.trim())) {
      Row row = sheet.createRow(++lastRowCount);
      CellStyle cellStyle = workbook.createCellStyle();

      for (int i = 0; i < cellNum; i++) {
        Cell cell = row.createCell(i);
        cell.setCellStyle(cellStyle);
        if (i == 0) {
          cellStyle.setAlignment(HorizontalAlignment.LEFT);
          cell.setCellStyle(cellStyle);
          cell.setCellValue(sprint);
        } else {
          int j = i - 1;
          cellStyle.setAlignment(HorizontalAlignment.RIGHT);
          cell.setCellStyle(cellStyle);
          cell.setCellValue(coverageMap.get(j));
        }
      }
    } else {
      Row row = sheet.getRow(lastRowCount);
      for (int i = 1; i < cellNum; i++) {
        int j = i - 1;
        row.getCell(i).setCellValue(coverageMap.get(j));
      }
    }
  }
}