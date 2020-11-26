package com.linda.demo.practice;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.JacocoCoverageReport;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.LineChartSeries;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JenkinsChart {
  static String jenkinsRootUrl =
      "https://gkejen4ctrlframwork.jaas-gcp.cloud.sap.corp/" + "job/GRC-DPP/job/";
  static String jenkinsLibUrl =
      "https://gkejen4ctrlframwork.jaas-gcp.cloud.sap.corp/" + "job/GRC-Library/job/";
  static String MDBackendSheetName = "MD Service";
  static String regBackendSheetName = "Regulation Service";
  static String docLibBackendSheetName = "Document Service Lib";
  static String mdClientLibBackendSheetName = "MD Client Lib";
  static int springNum = 59;

  public static void main(String[] args) throws IOException {

    String excelFilePath = "C:\\repo\\coverage\\seperate\\test.xlsx";
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

      int[] param0 = {0, 6, 16, 20};
      Map<String, String> backendMap = buildBackendMap();
      Iterator<Map.Entry<String, String>> entries = backendMap.entrySet().iterator();
      while (entries.hasNext()) {
        Map.Entry<String, String> entry = entries.next();
        Map<Integer, Double> coverageMap;
        if (entry.getKey().equals(docLibBackendSheetName) || entry.getKey()
            .equals(mdClientLibBackendSheetName)) {
          coverageMap = getBackendCoverage(jenkinsLibUrl, entry.getValue());
        } else {
          coverageMap = getBackendCoverage(jenkinsRootUrl, entry.getValue());
        }

        writeExcelHorizontally(workbook, entry.getKey(), springNum, coverageMap);
      }

      Sheet sheet = workbook.createSheet("result");
      for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
        drawLineChart(workbook.getSheetAt(i), Arrays.asList(param0));
      }
      //图表位置
      //            int[] param0 = {0, 6, 16, 20};
      //            // 横坐标
      //            int[] param1 = {0, 0, 0, 6};
      //            //数据源范围
      //            int[] param2 = {1, 1, 0, 6};
      //            int[] param3 = {2, 2, 0, 6};
      //            int[] param4 = {3, 3, 0, 6};
      //            int[] param5 = {4, 4, 0, 6};
      //            int[] param6 = {5, 5, 0, 6};
      //            int[] param7 = {6, 6, 0, 6};
      //
      //            drawLineChart(workbook.getSheetAt(0),
      //                Arrays.asList(param0, param1, param2, param3, param4, param5, param6,
      //                param7));

      inputStream.close();

      workbook.write(outputStream);
      workbook.close();
      outputStream.close();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    }
  }

  //    private static void drawLineChart(Sheet sheet, List<int[]> params) {
  //
  //      Drawing drawing = sheet.createDrawingPatriarch();
  //      // 设置位置 起始横坐标，起始纵坐标，终点横，终点纵
  //      ClientAnchor anchor = drawing
  //          .createAnchor(0, 0, 0, 0, params.get(0)[0], params.get(0)[1], params.get(0)[2],
  //              params.get(0)[3]);
  //      Chart chart = drawing.createChart(anchor);
  //
  //      // 创建图形注释的位置
  //      ChartLegend legend = chart.getOrCreateLegend();
  //      legend.setPosition(LegendPosition.BOTTOM);
  //      // 创建绘图的类型 LineChartData 折线图
  //      LineChartData chartData = chart.getChartDataFactory().createLineChartData();
  //      // 设置横坐标
  //      ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition
  //      .BOTTOM);
  //      bottomAxis.setCrosses(AxisCrosses.AUTO_ZERO);
  //      // 设置纵坐标
  //      ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
  //      leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
  //      // 从Excel中获取数据.CellRangeAddress-->params: 起始行号，终止行号， 起始列号，终止列号
  //      // 数据类别（x轴）
  //      ChartDataSource xAxis = DataSources.fromStringCellRange(sheet,
  //          new CellRangeAddress(params.get(1)[0], params.get(1)[1], params.get(1)[2],
  //              params.get(1)[3]));
  //      for (int i = 2, len = params.size(); i < len; i++) {
  //        // 数据源
  //        ChartDataSource dataAxis = DataSources.fromNumericCellRange(sheet,
  //            new CellRangeAddress(params.get(i)[0], params.get(i)[1], params.get(i)[2],
  //                params.get(i)[3]));
  //
  //        //chartData.addSeries(xAxis, dataAxis);
  //
  //       LineChartSeries chartSeries = chartData.addSeries(xAxis, dataAxis);
  ////        //给每条折线创建名字
  ////        chartSeries.setTitle(sheet.getRow(params.get(i)[0]).getCell(0).getStringCellValue());
  //      }
  //
  //      setChartTitle((XSSFChart) chart, sheet.getSheetName());
  //      // 开始绘制折线图
  //      chart.plot(chartData, bottomAxis, leftAxis);
  //    }

  private static void drawLineChart(Sheet sheet, List<int[]> params) {

    Drawing drawing = sheet.createDrawingPatriarch();
    // 设置位置 起始横坐标，起始纵坐标，终点横，终点纵
    ClientAnchor anchor = drawing
        .createAnchor(0, 0, 0, 0, params.get(0)[0], params.get(0)[1], params.get(0)[2],
            params.get(0)[3]);
    Chart chart = drawing.createChart(anchor);

    // 创建图形注释的位置
    ChartLegend legend = chart.getOrCreateLegend();
    legend.setPosition(LegendPosition.BOTTOM);
    // 创建绘图的类型 LineChartData 折线图
    LineChartData chartData = chart.getChartDataFactory().createLineChartData();
    // 设置横坐标
    ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
    bottomAxis.setCrosses(AxisCrosses.AUTO_ZERO);
    // 设置纵坐标
    ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
    leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
    // 从Excel中获取数据.CellRangeAddress-->params: 起始行号，终止行号， 起始列号，终止列号
    // 数据类别（x轴）
    int lastCellNum = sheet.getRow(0).getLastCellNum();
    ChartDataSource xAxis =
        DataSources.fromStringCellRange(sheet, new CellRangeAddress(0, 0, 1, lastCellNum - 1));
    for (int i = 1; i <= sheet.getLastRowNum(); i++) {

      // 数据源
      ChartDataSource dataAxis =
          DataSources.fromNumericCellRange(sheet, new CellRangeAddress(i, i, 1, lastCellNum - 1));

      // chartData.addSeries(xAxis, dataAxis);
      LineChartSeries chartSeries = chartData.addSeries(xAxis, dataAxis);
      //给每条折线创建名字
      chartSeries.setTitle(sheet.getRow(i).getCell(0).getStringCellValue());
    }

    setChartTitle((XSSFChart) chart, sheet.getSheetName());
    // 开始绘制折线图
    chart.plot(chartData, bottomAxis, leftAxis);
  }

  private static void setChartTitle(XSSFChart xchart, String titleStr) {
    CTChart ctChart = xchart.getCTChart();

    CTTitle title = CTTitle.Factory.newInstance();
    CTTx cttx = title.addNewTx();
    CTStrData sd = CTStrData.Factory.newInstance();
    CTStrVal str = sd.addNewPt();
    str.setIdx(123459);
    str.setV(titleStr);
    cttx.addNewStrRef().setStrCache(sd);

    ctChart.setTitle(title);
  }

  private static Map<String, String> buildBackendMap() {
    Map<String, String> backendMap = new HashMap<>();
    String mdBackendUrl = "masterdata-service/";
    String regBackendUrl = "regulation-service/";
    String docLibBackendUrl = "document-service-lib/";
    String mdClientLibBackendUrl = "masterdata-client/";
    backendMap.put(MDBackendSheetName, mdBackendUrl);
    backendMap.put(regBackendSheetName, regBackendUrl);
    backendMap.put(docLibBackendSheetName, docLibBackendUrl);
    backendMap.put(mdClientLibBackendSheetName, mdClientLibBackendUrl);
    return backendMap;
  }

  private static Map<Integer, Double> getBackendCoverage(String jenkinsUrl, String serviceUrl) {
    JenkinsServer jenkins = null;
    Map<Integer, Double> coverageMap = new HashMap<>();
    //NumberFormat numberFormat = NumberFormat.getPercentInstance();
    try {
      jenkins = new JenkinsServer(new URI(jenkinsUrl + serviceUrl));
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    try {
      JobWithDetails job;
      JacocoCoverageReport report;
      if (jenkins.getJobs().get("dev") == null) {
        job = jenkins.getJobs().get("master").details();
        report = job.getLastSuccessfulBuild().getClient()
            .get("job/master/lastSuccessfulBuild/jacoco/", JacocoCoverageReport.class);
      } else {
        job = jenkins.getJobs().get("dev").details();
        report = job.getLastSuccessfulBuild().getClient()
            .get("job/dev/lastSuccessfulBuild/jacoco/", JacocoCoverageReport.class);
      }

      coverageMap.put(0, Double.valueOf(
          0.01 * report.getInstructionCoverage().getPercentageFloat()));
      coverageMap.put(1,
          Double.valueOf(0.01 * report.getBranchCoverage().getPercentage()));
      coverageMap.put(2, Double
          .valueOf(0.01 * report.getComplexityScore().getPercentageFloat()));
      coverageMap.put(3, Double
          .valueOf(0.01 * report.getLineCoverage().getPercentageFloat()));
      // no method coverage API
      coverageMap.put(4, Double
          .valueOf(0.01 * report.getLineCoverage().getPercentageFloat()));
      coverageMap.put(5, Double
          .valueOf(0.01 * report.getClassCoverage().getPercentageFloat()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return coverageMap;
  }

  //  private static Map<Integer, String> getBackendCoverage(String jenkinsUrl, String serviceUrl) {
  //    JenkinsServer jenkins = null;
  //    Map<Integer, String> coverageMap = new HashMap<>();
  //    NumberFormat numberFormat = NumberFormat.getPercentInstance();
  //    try {
  //      jenkins = new JenkinsServer(new URI(jenkinsUrl + serviceUrl));
  //    } catch (URISyntaxException e) {
  //      e.printStackTrace();
  //    }
  //    try {
  //      JobWithDetails job;
  //      JacocoCoverageReport report;
  //      if (jenkins.getJobs().get("dev") == null) {
  //        job = jenkins.getJobs().get("master").details();
  //        report = job.getLastCompletedBuild().getClient()
  //            .get("job/master/lastCompletedBuild/jacoco/", JacocoCoverageReport.class);
  //      } else {
  //        job = jenkins.getJobs().get("dev").details();
  //        report = job.getLastCompletedBuild().getClient()
  //            .get("job/dev/lastCompletedBuild/jacoco/", JacocoCoverageReport.class);
  //      }
  //
  //      coverageMap
  //          .put(0, numberFormat.format(0.01 * report.getInstructionCoverage()
  //          .getPercentageFloat()));
  //      coverageMap.put(1, numberFormat.format(0.01 * report.getBranchCoverage().getPercentage
  //      ()));
  //      coverageMap
  //          .put(2, numberFormat.format(0.01 * report.getComplexityScore().getPercentageFloat()));
  //      coverageMap.put(3, numberFormat.format(0.01 * report.getLineCoverage()
  //      .getPercentageFloat()));
  //      // no method coverage API
  //      coverageMap.put(4, numberFormat.format(0.01 * report.getLineCoverage()
  //      .getPercentageFloat()));
  //      coverageMap
  //          .put(5, numberFormat.format(0.01 * report.getClassCoverage().getPercentageFloat()));
  //    } catch (IOException e) {
  //      e.printStackTrace();
  //    }
  //    return coverageMap;
  //  }

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

  //  private static void writeExcelHorizontally(Workbook workbook, String sheetName, int sprintNum,
  //      Map<Integer, String> coverageMap) throws IOException {
  //    String sprint = "Sprint " + sprintNum;
  //    Sheet sheet = workbook.getSheet(sheetName);
  //    int lastRowCount = sheet.getLastRowNum();
  //    int cellNum = sheet.getRow(lastRowCount).getLastCellNum();
  //    // if current sprint hasn't been writen to sheet
  //    if (sheet.getRow(0).getCell(cellNum) == null) {
  //      CellStyle cellStyle = workbook.createCellStyle();
  //
  //      for (int i = 0; i <= lastRowCount; i++) {
  //        Cell cell = sheet.getRow(i).createCell(cellNum);
  //        cell.setCellStyle(cellStyle);
  //        if (i == 0) {
  //          cellStyle.setAlignment(HorizontalAlignment.LEFT);
  //          cell.setCellStyle(cellStyle);
  //          cell.setCellValue(sprint);
  //        } else {
  //          int j = i - 1;
  //          cellStyle.setAlignment(HorizontalAlignment.RIGHT);
  //          cell.setCellStyle(cellStyle);
  //          cell.setCellValue(coverageMap.get(j));
  //        }
  //      }
  //    } else {
  //      for (int i = 1; i < cellNum; i++) {
  //        int j = i - 1;
  //        sheet.getRow(i).getCell(cellNum).setCellValue(coverageMap.get(j));
  //      }
  //    }
  //  }

  private static void writeExcelHorizontally(Workbook workbook, String sheetName, int sprintNum,
      Map<Integer, Double> coverageMap) throws IOException {
    String sprint = "Sprint " + sprintNum;
    Sheet sheet = workbook.getSheet(sheetName);
    int lastRowCount = sheet.getLastRowNum();
    int cellNum = sheet.getRow(lastRowCount).getLastCellNum();
    // if current sprint hasn't been writen to sheet
    if (sheet.getRow(0).getCell(cellNum) == null) {
      CellStyle cellStyle = workbook.createCellStyle();

      for (int i = 0; i <= lastRowCount; i++) {
        Cell cell = sheet.getRow(i).createCell(cellNum);
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
      for (int i = 1; i < cellNum; i++) {
        int j = i - 1;
        sheet.getRow(i).getCell(cellNum).setCellValue(coverageMap.get(j));
      }
    }
  }
}