package com.demo.ocr;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.pdfbox.pdmodel.PDDocument;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class TestOCR {
    public static void main(String[] args) {
    	
        String pdf_path = "C:\\Users\\user\\Downloads\\File For OCR.pdf";
        
        String doc_path = "C:\\Users\\user\\Downloads\\ConvertedOCR.docx";

        pdfOCR(pdf_path, doc_path);
    }

    public static void pdfOCR(String pdf_path, String doc_path) {
        try {
            PDDocument pdfdoc = PDDocument.load(new File(pdf_path));

            ITesseract tesseract = new Tesseract();
            
            // Tesseract installation path
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

            // perform ocr
            String ocrText = tesseract.doOCR(new File(pdf_path));

            // save to word document
            XWPFDocument wordDocument = new XWPFDocument();
            XWPFParagraph paragraph = wordDocument.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(ocrText);

            // write document file
            try (FileOutputStream out = new FileOutputStream(new File(doc_path))) {
                wordDocument.write(out);
                System.out.println("Word document created successfully at: " + doc_path);
            }

            // Close the PDF document
            pdfdoc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
