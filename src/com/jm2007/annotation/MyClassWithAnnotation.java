package com.jm2007.annotation;

import com.jm2007.annotation.cust.ClassInfo;

@ClassInfo(author = "Atul Dwivedi", 
createdDate = "2018-06-17", 
learners = { "NagMohan", "Akshay", "Ajay", "Bikash" }, 
version = 1.0)
public class MyClassWithAnnotation {

	/*@ClassInfo(author = "Atul Dwivedi", 
			createdDate = "2018-06-17", 
			learners = { "NagMohan", "Akshay", "Ajay", "Bikash" }, 
			version = 1.0)*/
	public static void main(String[] args) {
		System.out.println("This is a class with ClassInfo annotation.");
	}
}
