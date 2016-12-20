//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.service.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author Hung Dong Nguyen
 *
 */
@Service("RouterService")
@Configuration
@PropertySource("classpath:config/router-api-config.properties")
public class RouterService {
	@Autowired
	private Environment env;// For get config properties 
	
	private static List<String> systemObject = new ArrayList<String>();
	private List<Class<?>> systemClasses;
	
	public RouterService(){
		this.systemClasses = getClassesForPackage("com.chick.model.object");		
	}
		
	public String forTest(){
		for(int i =0; i < this.systemClasses.size();i++){
			System.out.println(RouterService.systemObject.get(i));
		}
		return "asd";
	}
	
/*	This function to boot System Classes
	@pagram: The name of package want to scan
	@return: List of classes
*/	
	private ArrayList<Class<?>> getClassesForPackage(String pkgname) {
		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
		try{
		    // Get a File object for the package
		    File directory = null;
		    String relPath = RouterService.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1) + '/' + pkgname.replace('.', '/');
		    System.out.println("Present Project Directory : "+ relPath);
		    try {
		        directory = new File(relPath);
		    } catch (Exception e) {
		        directory = null;
		    }
		    System.out.println("ClassDiscovery: Directory = " + directory);

		    if (directory != null && directory.exists()) {
		        // Get the list of the files contained in the package
		        String[] files = directory.list();
		        for (int i = 0; i < files.length; i++) {
		            // we are only interested in .class files
		            if (files[i].endsWith(".class")) {
		                // removes the .class extension
		            	String filesName= files[i].substring(0, files[i].length() - 6);
		            	if(!RouterService.systemObject.contains(filesName.toLowerCase(Locale.ENGLISH)))RouterService.systemObject.add(filesName.toLowerCase(Locale.ENGLISH));
		                String className = pkgname + '.' + filesName;
		                try {
		                    classes.add(Class.forName(className));
		                } 
		                catch (ClassNotFoundException e) {
		                    throw new RuntimeException("ClassNotFoundException loading " + className);
		                }
		            }
		        }
		    }
		    return classes;
		}
		catch(Exception e){
			e.printStackTrace();
			String [] systemObjectArray = env.getProperty("system.object").split(",");
			for(String sOA : systemObjectArray){
				if(!RouterService.systemObject.contains(sOA.toLowerCase(Locale.ENGLISH))){
					RouterService.systemObject.add(sOA.toLowerCase(Locale.ENGLISH));
					try {
						classes.add(Class.forName(pkgname + '.' + sOA));
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
			return classes;
		}	    
	}	
}
