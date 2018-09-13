package com.lrn.dava.doukoudai.day20180913;

import org.junit.Test;

public class ReportsTest {
    @Test
    public void inheritTest(){
        DocReports docReports = new DocReports();
        TxtReports txtReports = new TxtReports();

        System.out.println("DOC:"+docReports.getType());
        System.out.println("TXT:"+txtReports.getType());
    }
}
