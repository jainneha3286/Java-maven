package com.highnote.transaction.util;

import com.hingnote.itransaction.MessageProcessor;

public class HeaderFooterMessageProcessor implements MessageProcessor {
    @Override
    public void process(String message) {
        System.out.println("Header and Footer Information:");
        System.out.println(message);
    }
}
