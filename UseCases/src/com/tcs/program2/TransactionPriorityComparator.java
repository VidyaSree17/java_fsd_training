package com.tcs.program2;

import java.util.Comparator;

public class TransactionPriorityComparator implements Comparator<Transaction>{

	@Override
	public int compare(Transaction o1, Transaction o2) {
		// TODO Auto-generated method stub
		int transprior1=getPriority(o1.getTransactionType());
		int transprior2=getPriority(o2.getTransactionType());
		
		int compareType=Integer.compare(transprior2,transprior1);
		if(compareType!=0) {
			return compareType;
		}
		
		int compareAmount=Double.compare(o2.getAmount(), o1.getAmount());
		if(compareAmount!=0) {
			return compareAmount;
		}
		
		int compareTimestamp=Long.compare(o1.getTimestamp(), o2.getTimestamp());
		if(compareTimestamp!=0) {
			return compareTimestamp;
		}
		return 0;
	}
	
	public static int getPriority(String transactionType) {
		
		if(transactionType==null) {
			return 0;
		}
		switch(transactionType) {
		case "NEFT":return 1;
		case "IMPS":return 2;
		case "RTGS":return 3;
		default:return 0;
		}
		
	}

}
