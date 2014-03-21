package com.ebao.gs.framework.rule.maintain.web.rule.bean;

import java.util.ArrayList;
import java.util.List;

public class Event {

	private String name;

	private List<Rule> ruleList = new ArrayList<Rule>();

	public List<Rule> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<Rule> ruleList) {
		this.ruleList = ruleList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
