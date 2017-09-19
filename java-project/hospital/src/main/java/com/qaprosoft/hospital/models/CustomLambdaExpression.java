package com.qaprosoft.hospital.models;

public class CustomLambdaExpression {
	
	public static void main(String[] args) {  
		Workable s=(years)->{  
	        return "I have been working in the hospital for " + years + " years.";  
	    };  
	    System.out.println(s.work("4"));  
	}
}

