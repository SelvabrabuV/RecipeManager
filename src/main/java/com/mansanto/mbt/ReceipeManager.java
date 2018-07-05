package com.mansanto.mbt;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class ReceipeManager {
	
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	ReceipeManager()
	{
		System.out.println("started");
		this.session.beginTransaction();
	}
	
	public List getRecipeWithName()
	{
		List<Integer> a = session.createSQLQuery("select id from receipelist").list();
	List<ReceipeList> b = new ArrayList<ReceipeList>();
	for (int c : a)
		b.add((ReceipeList) this.session.get(ReceipeList.class,c));
		
		  return b;
			 
	}
	
	public List getRecipe(int id)
	{
		List<ReceipeList> a = new ArrayList();
		a.add((ReceipeList)this.session.get(ReceipeList.class,id));
		return a;
		
	}

	public int setreceipe(String name,String receipe1,String receipe2,String receipe3,String receipe4)
	{
		System.out.println(name+receipe1+receipe2+receipe3+ receipe4);
		ReceipeList rl = new ReceipeList(name,receipe1,receipe2,receipe3, receipe4);
		this.session.save(rl);
		if (!this.session.getTransaction().wasCommitted()) 
			this.session.getTransaction().commit();
		System.out.println(rl.getid());
		return rl.getid();
		
	}
	
	public void sesclose()
	{
		this.session.close();
	}
	
	
}
