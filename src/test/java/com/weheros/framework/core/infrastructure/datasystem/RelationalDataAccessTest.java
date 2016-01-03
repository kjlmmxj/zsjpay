/**
 * 
 */
package com.weheros.framework.core.infrastructure.datasystem;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.weheros.framework.core.infrastructure.datasystem.IRelationalDataAccess;
import com.weheros.test.GenericJunitTestCase;

/**
 * @author AA
 *
 */
public class RelationalDataAccessTest extends GenericJunitTestCase {
 
	@Autowired
	@Qualifier("relationalDataAccessService")
	IRelationalDataAccess relationalDataAccess;
	
	@Test
	public void testInsert(){
		String sql="insert into test (name,sex) values (?,?)";
		Object[] values=new Object[]{"lxiaodao",1};
		int num=relationalDataAccess.insert(sql, values);
		Assert.assertEquals(num, 1);
	}
}
