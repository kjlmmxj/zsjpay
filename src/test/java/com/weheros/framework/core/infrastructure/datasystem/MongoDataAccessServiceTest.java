/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.framework.core.infrastructure.datasystem;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.weheros.framework.core.infrastructure.datasystem.INoSQLDataAccess;
import com.weheros.framework.core.utils.ToJson;
import com.weheros.test.GenericJunitTestCase;


/**
 * @ClassName: MongoDataAccessService
 * @Description: TODO
 * @author Administrator
 * @date 2013年10月30日 下午10:46:44
 *
 */

public class MongoDataAccessServiceTest extends GenericJunitTestCase {
	protected Logger log = Logger.getLogger(getClass());
	
	@Autowired
	@Qualifier("mongoDataAccessService")
	INoSQLDataAccess noSQLDataAccess;
	
	@Before
	public void init(){
			
		MongoAccount mongoContact=new MongoAccount();
		
		mongoContact.setName("take it easy.");
		noSQLDataAccess.getMongoOps().insert(mongoContact);
	}
	@After
	public void destory(){
		List<MongoAccount> all=this.noSQLDataAccess.getMongoOps().findAll(MongoAccount.class);
		for(MongoAccount one:all){
			this.noSQLDataAccess.getMongoOps().remove(one);
		}
	}

	@Test
	public void testContact(){
		//527124f4ae0c8fdfba2f9910	
		//15899990001,15899990000
		List<MongoAccount> list=noSQLDataAccess.queryList(Query.query(Criteria.where("name").is("take it easy.")), MongoAccount.class);
		for(MongoAccount contact:list){
			log.debug("--------------MongoAccount from mongo-----------"+ToJson.toJson(contact));
		}
		Assert.assertSame(list.size(),1);
		
	}
	@Test
	public void testLikeQuery(){
		//can not support or in mongodb
		//.orOperator(Criteria.where("contact.phone")).regex(pattern)
		//Query.query(Criteria.where("alias").regex(pattern)
		/*Pattern pattern=Pattern.compile("5899");
		Query monquery=Query.query(Criteria.where("contact.phone").regex(pattern)).limit(20).skip(0);
		
		List<MongoContact> list=noSQLDataAccess.queryList(monquery, MongoContact.class);
		
		Assert.assertSame(list.size(),2);*/
	}
	

}
