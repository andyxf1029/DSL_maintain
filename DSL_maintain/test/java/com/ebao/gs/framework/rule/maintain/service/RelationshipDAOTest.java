package com.ebao.gs.framework.rule.maintain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ebao.gs.framework.rule.maintain.service.dao.IRelationshipDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/rule-engine.xml")
public class RelationshipDAOTest {

	@Autowired
	private IRelationshipDAO relationshipDAO;

	@Test
	public void test() {
		System.out.println(relationshipDAO.findGourpByRuleId(2L));
	}

}
