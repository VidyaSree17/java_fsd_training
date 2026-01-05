package com.tcs.program2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionMain {

	public static void main(String[] args) {
		
		List<Transaction> tran=new ArrayList<>();
		//List with identical priorities and amounts
		/*tran.add(new Transaction("TXN001","RTGS",300000.0,1678886400000L));
		tran.add(new Transaction("TXN002","RTGS",300000.0,1678886400001L));
		tran.add(new Transaction("TXN003","RTGS",300000.0,1678886400002L));
		
		//Same priority types with varying amounts and timestamps
		tran.add(new Transaction("TXN001","IMPS",10000.0,1678886400000L));
		tran.add(new Transaction("TXN002","IMPS",15000.0,1678886400000L));
		tran.add(new Transaction("TXN003","IMPS",10000.0,1678886400001L));*/
		
		//Mixed priorities,amounts and timestamps
		tran.add(new Transaction("A","NEFT",50000.0,100));
		tran.add(new Transaction("B", "IMPS", 10000.0, 100));
		tran.add(new Transaction("C", "RTGS", 250000.0, 100));
		tran.add(new Transaction("D", "NEFT", 75000.0, 100));
		tran.add(new Transaction("E", "IMPS", 10000.0, 101));
		tran.add(new Transaction("F", "RTGS", 250000.0, 101));
		
		//Single transaction of each type
		/*tran.add(new Transaction("A","NEFT",50000.0,100));
		tran.add(new Transaction("B","IMPS",100000.0,101));
		tran.add(new Transaction("C","RTGS",300000.0,102));
		
		//Sorting with mixed types and same amounts
		tran.add(new Transaction("A","NEFT",50000.0,100));
		tran.add(new Transaction("B","IMPS",50000.0,101));
		tran.add(new Transaction("C","RTGS",50000.0,102));
		
		//Natural ordering of transactionPriorityComparator
		tran.add(new Transaction("A","RTGS",100000.0,100));
		tran.add(new Transaction("B","RTGS",100000.0,101));*/
		
		System.out.println("Before Sorting");
		for(Transaction t:tran) {
			System.out.println(t.getTransactionId()+"  "+t.getTransactionType()+"  "+t.getAmount()+"  "+t.getTimestamp());
		}
		
		Collections.sort(tran,new TransactionPriorityComparator());
		System.out.println("After Sorting");
		for(Transaction t:tran) {
			System.out.println(t.getTransactionId()+"  "+t.getTransactionType()+"  "+t.getAmount()+"  "+t.getTimestamp());
		}
	}
}
