package com.ebao.gs.framework.rule.maintain.web.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.service.IRuleGroupService;
import com.ebao.gs.framework.rule.maintain.web.rule.bean.RuleGroup;

@Controller
public class RuleGourpResouceHandler {
	
	
	private IRuleGroupService groupService;

	
	@RequestMapping(value = "ruleGourps", method = RequestMethod.GET)
	@ResponseBody
	public String searchRules(@RequestParam("name") String searchName) {

		System.out.println(searchName);
		// Search Index

		// DAO

		List<RuleGroup> groupList = new ArrayList<RuleGroup>();

		RuleGroup group1 = new RuleGroup();
		RuleGroup group2 = new RuleGroup();
		group1.setId(1L);
		group2.setId(2L);
		group1.setName("Save Policy");
		group2.setName("Save Binder");
		groupList.add(group1);
		groupList.add(group2);
		return JSON.toJSONString(groupList);

	}

}
