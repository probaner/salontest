package com.test;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import SpringMyMaven.pdfStyle.CreatePdf;

public class TestPdf {
	
	public static void main(String args[]) throws IOException, DocumentException{
		
		CreatePdf createPdf = new CreatePdf();
		createPdf.createNewPdfFileInWriteMode("C:/Users/echnchy/Desktop/ossInstaView_OFFLINE/c.pdf");
		createPdf.setPageSize(600,400);
		createPdf.setMarginsSize(20,20);
		createPdf.setBorder(3);
		createPdf.createPages();
		createPdf.setImage(130,50,40,300,"C:/Users/echnchy/Desktop/ossInstaView_OFFLINE/OSSInstaViewLogs/images/singtel-logo-white.jpg");
		createPdf.setImage(70,70,500,300,"C:/Users/echnchy/Desktop/ossInstaView_OFFLINE/OSSInstaViewLogs/images/ericsson.png");
		createPdf.writeOnDocument(35,0,"TIMES_NEW_ROMAN","GARY","SINGTEL - OSS HEALTH","CENTER",100,0);
		createPdf.writeOnDocument(35,0,"TIMES_NEW_ROMAN","GARY","CHECK REPORT","CENTER",0,90);
		createPdf.writeOnDocument(28,0,"TIMES_NEW_ROMAN","GARY","RANOSS","CENTER",30,0);
		createPdf.writeOnDocument(28,0,"TIMES_NEW_ROMAN","GARY","(HOSTNAME - RANOS02)","CENTER",0,100);
		createPdf.createTabel(80, 3, 4, "abc");
		
		createPdf.closeDocument();
	}

}
