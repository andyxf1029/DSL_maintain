package com.ebao.gs.framework.rule.maintain.web.rule.bean;

public class Rule {

	private String name;

	private String ruleGroup;

	public String getRuleGroup() {
		return ruleGroup;
	}

	public void setRuleGroup(String ruleGroup) {
		this.ruleGroup = ruleGroup;
	}

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
