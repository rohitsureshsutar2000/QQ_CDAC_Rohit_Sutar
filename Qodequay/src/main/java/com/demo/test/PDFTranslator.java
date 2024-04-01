package com.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.opencsv.CSVWriter;

public class PDFTranslator {
    public static void main(String[] args) {
        try {
            // Load PDF document
        	
//        	File f = new File("3963-गहाणखत.pdf");
//        	String parsedText;
//        	PDFParser parser = new PDFParser(new RandomAccessFile(f, "r"));
//        	parser.parse();
//        	if(parser!=null) {
//            	System.out.println("i");
//            }
        	
        	
//        	  <repository>
//              <id>google-cloud-releases</id>
//              <url>https://maven.pkg.github.com/googleapis/gax-java</url>
//          </repository>
//              
//              <dependency>
//              <groupId>com.google.cloud</groupId>
//              <artifactId>google-cloud-translate</artifactId>
//              <version>2.2.1</version> <!-- Use the latest version -->
//          </dependency>
        	
        	
            PDDocument document = PDDocument.load(new File("D:/AlgoDomain Project/Qodequry/Qodequay/3963-गहाणखत.pdf"));
            System.out.println("i think file not found");
            if(document!=null) {
            	System.out.println("i");
            }
            // Extract text from specific rows (4, 7, 8)
            PDFTextStripper stripper = new PDFTextStripper();
//            stripper.setStartPage(4);
//            stripper.setEndPage(8);
            String text = stripper.getText(document);

            // Translate text here (you can use any translation API/library)
            String translatedText = translateText(text);
            System.out.println("i think file not found line 2"+translatedText);
            // Write translated text to CSV file
            writeCSV(translatedText);

            // Close the document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to translate text (You need to implement this)
    private static String translateText(String text) {
        // Your translation logic goes here
        return text; // Dummy implementation, replace it with actual translation
    }
    
    
    private static void writeCSV(String translatedText) throws IOException {
        // Create FileWriter object with file name and path
        FileWriter outputfile = new FileWriter("translated_text.csv");

        // Create CSVWriter object
        CSVWriter writer = new CSVWriter(outputfile);

        // Split translated text into rows
        String[] rows = translatedText.split("\n");

        // Convert rows into an Iterable of String arrays
        List<String[]> rowsList = new ArrayList<String[]>();
        for (String row : rows) {
            rowsList.add(new String[]{row});
            if (rowsList!=null) {
            	 System.out.println("00");
            }
           
        }

        // Write rows to CSV
        writer.writeAll(rowsList);

        // Close CSV writer
        writer.close();
    }
    

  
}
