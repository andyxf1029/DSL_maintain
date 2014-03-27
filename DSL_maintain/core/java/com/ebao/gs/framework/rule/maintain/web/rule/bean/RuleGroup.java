package com.ebao.gs.framework.rule.maintain.web.rule.bean;

import java.util.ArrayList;
import java.util.List;

public class RuleGroup {

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public List<Rule> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<Rule> ruleList) {
		this.ruleList = ruleList;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<Rule> ruleList = new ArrayList<Rule>();

}
