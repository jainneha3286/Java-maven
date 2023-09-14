package com.highnote.transaction.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.hingnote.itransaction.MessageProcessor;
import com.highnote.transaction.factory.*;

public class TransactionMessageProcessor {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/transaction_messages.txt"; // Replace with your input file path

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            StringBuilder sectionBuilder = new StringBuilder();
            MessageProcessor currentProcessor = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Header Information:") || line.startsWith("Footer Information:") || line.startsWith("Transaction Data:")) {
                    if (currentProcessor != null) {
                        currentProcessor.process(sectionBuilder.toString().trim());
                    }
                    currentProcessor = MessageProcessorFactory.create(line);
                    sectionBuilder.setLength(0); // Clear the section builder for a new section
                }
                sectionBuilder.append(line).append("\n");
            }

            // Process the last section
            if (currentProcessor != null) {
                currentProcessor.process(sectionBuilder.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


