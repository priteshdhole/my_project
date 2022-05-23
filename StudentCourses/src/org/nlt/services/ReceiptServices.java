package org.nlt.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nlt.database.Config;
import org.nlt.model.Students;
import org.nlt.model.receipts;

public class ReceiptServices implements Config
{
	public void getReceiptList()
	{
		Session ses=getConnection();
		ses.beginTransaction();
		
		Query query=ses.createQuery("from receipts where status=1");
		List<receipts> receiptList=query.list();
		receiptMap.clear();
		
		for(receipts receipt: receiptList)
		{
			receiptMap.put(receipt.getPhone()+"-"+receipt.getCourse(), receipt);
		}
	}
	
	public boolean addReceipt(receipts receipt)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.save(receipt);
		ses.getTransaction().commit();
		return true;
	}
	public boolean updateReceipt(receipts receipt)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.update(receipt);
		ses.getTransaction().commit();
		return true;
	}
	public boolean deleteReceipt(receipts receipt)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.update(receipt);
		ses.getTransaction().commit();
		return true;
	}
	
	
}
