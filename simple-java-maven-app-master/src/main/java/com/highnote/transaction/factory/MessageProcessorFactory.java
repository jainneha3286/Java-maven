package com.highnote.transaction.factory;

import com.hingnote.itransaction.MessageProcessor;
import com.highnote.transaction.util.HeaderFooterMessageProcessor;
import com.highnote.transaction.util.TransactionDataMessageProcessor;

public class MessageProcessorFactory {
	private MessageProcessorFactory() {};
    public static MessageProcessor create(String sectionType) {
        if (sectionType.startsWith("Header Information:") || sectionType.startsWith("Footer Information:")) {
            return new HeaderFooterMessageProcessor();
        } else if (sectionType.startsWith("Transaction Data:")) {
            return new TransactionDataMessageProcessor();
        }
        return null; // Handle unsupported section types if necessary
    }
}