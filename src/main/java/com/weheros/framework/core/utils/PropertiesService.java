/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.framework.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.weheros.framework.core.log.LogService;



/**
 * Load the properties file.
 * @ClassName: PropertiesService
 * @author Yang
 * @date 2014年5月7日 下午10:10:02
 */
public class PropertiesService {
	
	private static Properties props = new Properties();
	static{
		String path="infrastructure/app.properties";
		InputStream is = PropertiesService.class.getClassLoader().getResourceAsStream(path);
		try {
			props.load(is);
		} catch (IOException e) {			
			
			LogService.error(PropertiesService.class, "---load the properties "+path+" fiel fail.---");
		}
	}
	public static String takeValueOfKey(String key){
		return props.getProperty(key);
	}
	public static Properties takeProperties(){
		return props;
	}

}
