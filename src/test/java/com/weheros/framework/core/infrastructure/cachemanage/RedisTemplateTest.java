/**
 * Copyright (c) 2013-2014 HZCW Technology Inc,All Rights Reserved.
 */
	
package com.weheros.framework.core.infrastructure.cachemanage;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.weheros.test.GenericJunitTestCase;


/**
 * @ClassName: RedisTemplateTest
 * @author Administrator
 * @date 2014年3月25日 下午10:38:46
 */
public class RedisTemplateTest extends GenericJunitTestCase{
	 // inject the actual template
	private String key="lonely";
	
	@After
	public void cleanUp(){
		this.redisTemplate.delete(key);
	}
    @Autowired    
    private RedisTemplate<String, String> redisTemplate;

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    //@Repository(name="redisTemplate")
    //private ListOperations<String, String> listOps;
    @Test
    public void testRedisTemplate(){
    	
    	redisTemplate.boundListOps(key).leftPush("show me the meaning of being this.");
    
    	redisTemplate.boundListOps(key).leftPush("second show me the meaning of being lonely.");
    	
    	System.out.println("-----------------"+redisTemplate.opsForList().leftPop(key));
    	
    }
}
