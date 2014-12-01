package com.assignment.util;

import java.io.IOException;
import java.util.Properties;

public class Props {
	public static String getProperty(String name){
		Properties props = new Properties();
		try {
			props.load(Props.class.getClassLoader().getResourceAsStream("mongo.properties"));
		} catch (IOException e) {
			return "";
		}
		return props.getProperty(name);
	}
}
