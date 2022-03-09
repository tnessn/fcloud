package com.github.tnessn.fcloud.common.util;

/**
 * @author Jeffrey
 */
public class MyThreadContext {
	
	private static final ThreadLocal<String> LANG=new ThreadLocal<>();
	
	private MyThreadContext() {};

	public static String getLang() {
		return LANG.get();
	}

	public static void setLang(String lang) {
		MyThreadContext.LANG.set(lang);
	}
	
	public static void unload() {
		LANG.remove(); 
	  }

}

