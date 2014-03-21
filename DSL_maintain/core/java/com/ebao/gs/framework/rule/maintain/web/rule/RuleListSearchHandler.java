package com.ebao.gs.framework.rule.maintain.web.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.web.rule.bean.Rule;

@Controller
@RequestMapping("/rulelist")
public class RuleListSearchHandler {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String searchRules(@RequestParam("name") String searchName) {

		System.out.println(searchName);
		// Search Index

		// DAO

		List<Rule> rulelist = new ArrayList<Rule>();
		Rule rule = new Rule();
		rule.setId(1L);
		rule.setName("check limit");

		rule.setRuleGroup("Save Policy");

		Rule rule2 = new Rule();
		rule2.setId(2L);
		rule2.setName("check premium");

		rule2.setRuleGroup("Save Policy");

		rulelist.add(rule);
		rulelist.add(rule2);
		return JSON.toJSONString(rulelist);

	}
}
