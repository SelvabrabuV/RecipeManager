package com.mansanto.mbt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ReceipeList {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="Recipe_name")
	private String Recipe_name ;

	private String receipe1;
	private String receipe2;
	private String receipe3;
	private String receipe4;
	ReceipeList(){}
	ReceipeList(String name,String receipe1,String receipe2,String receipe3,String receipe4)
	{
		
		this.Recipe_name=name;
		this.receipe1=receipe1;
		this.receipe2=receipe2;
		this.receipe3=receipe3;
		this.receipe4=receipe4;
	}
	ReceipeList(int id,String name)
	{
		this.id=id;
		this.Recipe_name=name;
	}
public int getid()
{
	return this.id;
}
public String getname()
{
	return this.Recipe_name;
}

public String getReceipe1() {
	return receipe1;
}

public void setReceipe1(String receipe1) {
	this.receipe1 = receipe1;
}

public String getReceipe2() {
	return receipe2;
}

public void setReceipe2(String receipe2) {
	this.receipe2 = receipe2;
}

public String getReceipe3() {
	return receipe3;
}

public void setReceipe3(String receipe3) {
	this.receipe3 = receipe3;
}

public String getReceipe4() {
	return receipe4;
}

public void setReceipe4(String receipe4) {
	this.receipe4 = receipe4;
}
	
}
