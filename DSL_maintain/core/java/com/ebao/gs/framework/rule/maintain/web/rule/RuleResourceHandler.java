package com.ebao.gs.framework.rule.maintain.web.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.web.rule.bean.Rule;

@Controller
@RequestMapping("/rule")
public class RuleResourceHandler {

	// @RequestMapping(method = RequestMethod.GET)
	// @ResponseBody
	// public String getRule() {
	//
	// System.out.println("!!!!!!!Test  ");

	// }

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String findRuleById(@RequestParam("id") String id) {

		System.out.println(id);
		List<Rule> rulelist = new ArrayList<Rule>();
		Rule rule = new Rule();
		rule.setName("GGGGOOOOO");

		rulelist.add(rule);
		return JSON.toJSONString(rulelist);

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public long createOrUpdateRule(@RequestBody String ruleJson) {
		Rule rule = JSON.parseObject(ruleJson, Rule.class);

		// Save rule

		return 0;

	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRule(@RequestParam("id") String id) {
		// Rule rule = JSON.parseObject(ruleJson, Rule.class);

	}
	
	
}
