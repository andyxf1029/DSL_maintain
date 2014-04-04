package com.ebao.gs.framework.rule.maintain.web.rule;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.service.IRuleService;
import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleContent;

@Controller
@RequestMapping("/rule")
public class RuleResourceHandler {

	private IRuleService ruleService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public String searchRules(@RequestParam("name") String searchName) {
		List<Rule> rules = ruleService.searchRule(searchName);
		return JSON.toJSONString(rules);

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String findRuleById(@RequestParam("id") String id) {
		return JSON
				.toJSONString(this.ruleService.findRuleById(Long.valueOf(id)));

	}

	@RequestMapping(value = "body/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String findRuleBodyById(@PathVariable String id) throws IOException {
		RuleContent content = this.ruleService.loadRuleBody(Long.valueOf(id));
		return JSON.toJSONString(content);

	}

	@RequestMapping(value = "body", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveRuleBody(String content) throws IOException {
		RuleContent ruleContent = JSON.parseObject(content, RuleContent.class);
		return this.ruleService.saveRuleBody(ruleContent);

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public long addOrUpdateRule(@RequestBody String ruleJson) {
		Rule rule = JSON.parseObject(ruleJson, Rule.class);
		return this.ruleService.addOrUpdate(rule);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRule(@RequestParam("id") String id) {
		this.ruleService.deleteRule(Long.valueOf(id));
	}

}
