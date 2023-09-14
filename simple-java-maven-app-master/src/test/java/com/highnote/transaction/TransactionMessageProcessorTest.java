package com.highnote.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.highnote.transaction.service.TransactionMessageProcessor;

public class TransactionMessageProcessorTest {

    @Test
    public void testProcessTransactionData() {
        // Redirect stdout to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the TransactionMessageProcessor
        TransactionMessageProcessor.main(new String[]{});
        
        // Restore the original stdout
        System.setOut(originalOut);

        // Extract and format the captured console output
        String capturedOutput = outContent.toString().trim(); // Remove leading/trailing whitespace
        
        System.out.println(capturedOutput);
        capturedOutput = capturedOutput.replaceAll("\r\n", "\n"); // Normalize line endings
        
        String excepout = "Header and Footer Information:\n"+
        	"Header Information: Company: ABC Inc. | Date: 2023-09-14 | Location: New York\n"+
        	"Transaction Data:\n"+
        	"Transaction Data:\n"+
        	"Transaction ID,Transaction Date,Transaction Time,Transaction Type,Product,Quantity,Unit Price,Total Amount,Payment Method,Payment Status\n"+
        	"1,2023-09-14,15:45:30,Purchase,Widget X,2,$10.00,$20.00,Credit Card,Approved\n" +
        	"2,2023-09-15,09:30:00,Refund,Widget Y,1,$15.00,$15.00,PayPal,Approved\n"+
        	"3,2023-09-16,14:15:00,Purchase,Widget Z,3,$8.00,$24.00,Debit Card,Approved\n"+
        	"Header and Footer Information:\n"+
        	"Footer Information: Total Transactions: 3 | Total Sales: $59.00";


        String expectedOutput = 
            "Header and Footer Information:\n" +
            "Header Information: Company: ABC Inc. | Date: 2023-09-14 | Location: New York\n" +
            "Footer Information: Total Transactions: 3 | Total Sales: $59.00\n" +
            "Transaction Data:\n" +
            "Transaction ID,Transaction Date,Transaction Time,Transaction Type,Product,Quantity,Unit Price,Total Amount,Payment Method,Payment Status\n" +
            "1,2023-09-14,15:45:30,Purchase,Widget X,2,$10.00,$20.00,Credit Card,Approved\n" +
            "2,2023-09-15,09:30:00,Refund,Widget Y,1,$15.00,$15.00,PayPal,Approved\n" +
            "3,2023-09-16,14:15:00,Purchase,Widget Z,3,$8.00,$24.00,Debit Card,Approved";

        // Assert that the captured output matches the expected output
        assertEquals(excepout, capturedOutput);
    }
}
