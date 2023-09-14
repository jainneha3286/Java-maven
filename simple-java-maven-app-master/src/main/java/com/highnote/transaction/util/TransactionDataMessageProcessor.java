package com.highnote.transaction.util;

import com.hingnote.itransaction.MessageProcessor;

public class TransactionDataMessageProcessor implements MessageProcessor {
    @Override
    public void process(String message) {
        System.out.println("Transaction Data:");
        System.out.println(message);
        // Add logic to process transaction data here
    }
}