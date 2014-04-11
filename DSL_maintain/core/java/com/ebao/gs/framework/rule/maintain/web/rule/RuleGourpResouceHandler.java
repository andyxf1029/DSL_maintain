package com.ebao.gs.framework.rule.maintain.web.rule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.service.IRuleGroupService;

@Controller
public class RuleGourpResouceHandler {

	private IRuleGroupService groupService;

	@RequestMapping(value = "group/list", method = RequestMethod.GET)
	@ResponseBody
	public String searchRules(@RequestParam("name") String searchName) {
		return JSON.toJSONString(groupService.searchRuleGroup(searchName));
	}

}
