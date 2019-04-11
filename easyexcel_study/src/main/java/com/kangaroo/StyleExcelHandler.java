/**
 * Copyright (c),2016-2018, iThinkDT
 * <br/>This program is protected by copyright laws;
 * <br/>Program Name: easyexcel<b>ithinkdt<b>
 * <br/>
 * Package: com.alibaba.easyexcel.test <br <br/>
 * FileName: StyleExcelHandler<br <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author ithinkdt
 * @version 1.0
 * @since JDK 1.8
 */
package com.kangaroo;

import com.alibaba.excel.event.WriteHandler;
import org.apache.poi.ss.usermodel.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * * com.ithinkdt.dqa.admin.config
 *
 * @version 1.0
 * @descreption:
 * @date:2019/4/10 19:04
 * @author: liubo
 * @since JDK1.8
 */
public class StyleExcelHandler implements WriteHandler {

    private Map<String, CellStyle> stlyeMap = new ConcurrentHashMap<>();

    @Override
    public void sheet(int i, Sheet sheet) {
    }

    @Override
    public void row(int i, Row row) {
    }

    @Override
    public void cell(int i, Cell cell) {
        // 从第二行开始设置格式，第一行是表头
        Workbook workbook = cell.getSheet().getWorkbook();
        CellStyle cellStyle ;
        if(i>3 &&i<5){
            cellStyle=getStyle(workbook,"custom1");
        }else {
            cellStyle=getStyle(workbook,"default");
        }
        cell.getRow().getCell(i).setCellStyle(cellStyle);
    }

    private CellStyle getStyle(Workbook workbook, String key) {
        if (stlyeMap.containsKey(key)) {
            return stlyeMap.get(key);
        }
        if ("default".equals(key)) {
            CellStyle cellStyle = createStyle(workbook);
            stlyeMap.put(key, cellStyle);
            return cellStyle;
        } else {
            CellStyle cellStyle = createStyle(workbook);
            cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            stlyeMap.put(key, cellStyle);
            return cellStyle;
        }
    }


    private CellStyle createStyle(Workbook workbook){
        CellStyle cellStyle = workbook.createCellStyle();
        // 下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        // 左边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        // 上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 右边框
        cellStyle.setBorderRight(BorderStyle.DASH_DOT);
        // 水平对齐方式
        cellStyle.setAlignment(HorizontalAlignment.RIGHT);
        // 垂直对齐方式
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

}
