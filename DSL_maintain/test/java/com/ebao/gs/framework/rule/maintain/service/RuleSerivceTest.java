package com.ebao.gs.framework.rule.maintain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ebao.gs.framework.rule.maintain.service.bean.Rule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/rule-engine.xml")
public class RuleSerivceTest {

	@Autowired
	protected IRuleService ruleService;

	@Test
	public void testSearchRule() {
		System.out.println(this.ruleService.searchRule("Test"));
	}

	@Test
	public void testAddRule() {
		Rule rule = new Rule();
		rule.setId(3L);
		rule.setName("GIGI");
		ruleService.addOrUpdate(rule);

	}
}
