package com.linda.demo.practice;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChromeExample {
  static String jenkinsRootUrl =
      "https://gkejen4ctrlframwork.jaas-gcp.cloud.sap" + ".corp/job/GRC-DPP/job/";
  static String mdUIUrl = jenkinsRootUrl + "masterdata-ui/job/dev";
  static String regOrgUIUrl = jenkinsRootUrl + "regulation-ui/job/dev";

  public static void main(String[] args) {
//    System.setProperty("webdriver.chrome.driver",
//        "C://Users//I308725//Downloads//chromedriver_win32_80//chromedriver.exe");
    System.out.println(12);
    System.out.println(13);
    System.out.println(14);
    System.out.println(12);
    System.out.println(12);


    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    String excelFilePath = "C:\\repo\\coverage\\Coverage.xlsx";
    FileInputStream inputStream;
    FileOutputStream outputStream;

    try {
      inputStream = new FileInputStream(new File(excelFilePath));
      Workbook workbook = WorkbookFactory.create(inputStream);
      outputStream = new FileOutputStream(excelFilePath);

      //write backend coverage to excel sheet
      Map<String, String> backendMap = getBackendMap();
      Iterator<Map.Entry<String, String>> entries = backendMap.entrySet().iterator();
      while (entries.hasNext()) {
        Map.Entry<String, String> entry = entries.next();
        Map<Integer, String> coverageMap = getBackendCoverage(entry.getValue(), driver);
        writeExcel(workbook, outputStream, entry.getKey(), 45, coverageMap);
      }

      //write md UI coverage to excel sheet
      driver.get(mdUIUrl);
      WebElement buildNumber =
          driver.findElement(By.cssSelector("a[update-parent-class='.build-row']:first-of-type"));
      buildNumber.click();
      writeMDUICoverage(outputStream, workbook, driver);
      workbook.write(outputStream);

      inputStream.close();
      workbook.close();
      outputStream.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  //key: sheet name, value: service url
  public static Map<String, String> getBackendMap() {
    Map<String, String> backendMap = new HashMap<>();
    String mdBackendUrl = jenkinsRootUrl + "masterdata-service/job/dev";
    String regBackendUrl = jenkinsRootUrl + "regulation-service/job/dev";
    backendMap.put("MD Backend", mdBackendUrl);
    backendMap.put("Regulation Service", regBackendUrl);
    return backendMap;
  }

  public static void writeExcel(Workbook workbook, FileOutputStream outputStream, String sheetName,
      int sprintNum, Map<Integer, String> coverageMap) throws IOException {
    String sprint = "Sprint " + sprintNum;
    Sheet sheet = workbook.getSheet(sheetName);
    int lastRowCount = sheet.getLastRowNum();
    int cellNum = sheet.getRow(lastRowCount).getLastCellNum();
    if (!sheet.getRow(lastRowCount).getCell(0).getStringCellValue().equals(sprint)) {
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

  public static Map<Integer, String> getBackendCoverage(String url, WebDriver driver) {
    driver.get(url);
    WebElement buildNumber =
        driver.findElement(By.cssSelector("a[update-parent-class='.build-row']:first-of-type"));
    buildNumber.click();
    String instructionLocator = "//*[text()='INSTRUCTION']";
    String branchLocator = "//*[text()='BRANCH']";
    String complexityLocator = "//*[text()='COMPLEXITY']";
    String lineLocator = "//*[text()='LINE']";
    String methodLocator = "//*[text()='METHOD']";
    String classLocator = "//*[text()='CLASS']";
    String[] locators =
        {instructionLocator, branchLocator, complexityLocator, lineLocator, methodLocator,
            classLocator};
    Map<Integer, String> coverageMap = new HashMap<>();
    for (int i = 0; i < locators.length; i++) {
      coverageMap.put(i,
          driver.findElement(By.xpath(locators[i] + "/following-sibling::td[1]")).getText());
    }
    return coverageMap;
  }

  public static String[] getFrontendArray() {
    String regUIUrl = jenkinsRootUrl + "regulation-ui/job/dev";
    String mdUIUrl = jenkinsRootUrl + "masterdata-ui/job/dev";
    String[] frontendArray = {regUIUrl, mdUIUrl};
    return frontendArray;
  }

  public static void writeMDUICoverage(FileOutputStream outputStream, Workbook workbook,
      WebDriver driver) throws IOException, InterruptedException {
    String complianceUrl =
        "LCOV Coverage target-coverage-allComplianceManageTests-report-lcov-lcov-report";
    String orgUrl = "LCOV Coverage target-coverage-allOrganizationTests-report-lcov-lcov-report";
    String processUrl = "LCOV Coverage target-coverage-allProcessTests-report-lcov-lcov-report";
    String repositoryUrl =
        "LCOV Coverage target-coverage-allRepositoryTests-report-lcov-lcov-report";

    Map<String, String> mdUIMap = new HashMap<>();
    mdUIMap.put("MD Comp Manage", complianceUrl);
    mdUIMap.put("Organization UI", orgUrl);
    mdUIMap.put("Process UI", processUrl);
    mdUIMap.put("Repository UI", repositoryUrl);
    Iterator<Map.Entry<String, String>> entries = mdUIMap.entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<String, String> entry = entries.next();
      WebElement serviceUrl =
          driver.findElement(By.xpath("//a[text()='" + entry.getValue() + "']"));
      serviceUrl.click();
      Map<Integer, String> coverageMap = getUICoverage(driver);
      writeExcel(workbook, outputStream, entry.getKey(), 45, coverageMap);
    }
  }

  public static Map<Integer, String> getUICoverage(WebDriver driver) throws InterruptedException {
    driver.switchTo().frame(0);

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
    driver.switchTo().window(driver.getWindowHandle());
    driver.navigate().back();
    return coverageMap;
  }
}