/**
 * Copyright (c),2016-2018, iThinkDT
 * <br/>This program is protected by copyright laws;
 * <br/>Program Name: other_study<b>ithinkdt<b>
 * <br/>
 * Package: com.kangaroo <br <br/>
 * FileName: Test<br <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author ithinkdt
 * @version 1.0
 * @since JDK 1.8
 */
package com.kangaroo;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * * com.ithinkdt.dqa.admin.config
 *
 * @version 1.0
 * @descreption:
 * @date:2019/4/11 10:35
 * @author: liubo
 * @since JDK1.8
 */
public class Test {

    public static void main(String[] args) throws Exception{
        OutputStream out = new FileOutputStream("E:\\PPPP.xlsx");
        StyleExcelHandler handler=new StyleExcelHandler();
        ExcelWriter writer = EasyExcelFactory.getWriterWithTempAndHandler(null, out, ExcelTypeEnum.XLSX, true, handler);
//        ExcelWriter writer = EasyExcelFactory.getWriterWithTemp(inputStream,out,ExcelTypeEnum.XLSX,false,handler);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");


        //写sheet2  模型上打有表头的注解
        Table table2 = new Table(2);
//        table2.setTableStyle(createTableStyle());
        table2.setClazz(WriteModel.class);

        writer.write(createTestListJavaMode(), sheet1, table2);


        writer.finish();
        out.close();
    }

    public static List<WriteModel> createTestListJavaMode(){
        List<WriteModel> model1s = new ArrayList<WriteModel>();
        for (int i = 0; i <100; i++) {
            WriteModel model1 = new WriteModel();
            model1.setP3(33+i);
            model1.setP4(44);
            model1.setP5("555");
            model1.setP6(666.2f);
            model1.setP7(new BigDecimal("454545656343434"+i));
            model1.setP8(new Date());
            model1.setP9("llll9999>&&&&&6666^^^^");
            model1.setP10(1111.77+i);
            model1s.add(model1);
        }
        return model1s;
    }
}
