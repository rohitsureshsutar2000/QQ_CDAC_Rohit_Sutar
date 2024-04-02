

package com.demo.test;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.opencsv.CSVWriter;

public class PDFTranslatorNew {
    public static void main(String[] args) {
        try {
            // Load PDF document
            try (PDDocument document = PDDocument.load(new File("input.pdf"))) {

                // Extract text from specific rows (4, 7, 8)
                PDFTextStripper stripper = new PDFTextStripper();
                stripper.setStartPage(4);
                stripper.setEndPage(8);
                String marathiText = stripper.getText(document);

                // Translate Marathi text to English
                String englishText = translateText(marathiText);

                // Write translated text to CSV file
                writeCSV(englishText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to translate text from Marathi to English
    private static String translateText(String marathiText) {
        // Initialize translation service
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // Translate text
        Translation translation = translate.translate(marathiText, Translate.TranslateOption.targetLanguage("en"));

        // Return translated text
        return translation.getTranslatedText();
    }

    // Method to write translated text to CSV file
    private static void writeCSV(String translatedText) {
        // Create FileWriter object with file name and path
        try (FileWriter outputfile = new FileWriter("translated_text.csv");
             // Create CSVWriter object
             CSVWriter writer = new CSVWriter(outputfile)) {

            // Split translated text into rows
            String[] rows = translatedText.split("\n");

            // Write rows to CSV
            writer.writeAll(Arrays.asList(rows));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

