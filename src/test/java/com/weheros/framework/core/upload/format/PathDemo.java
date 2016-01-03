package com.weheros.framework.core.upload.format;

import java.nio.file.Path;
import java.nio.file.Paths;



public class PathDemo {

	public static void main(String[] args) {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		
		
		
		System.out.println("---user.dir is---" + System.getProperty("user.dir"));
	}

}
