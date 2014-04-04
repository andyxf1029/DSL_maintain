package com.ebao.gs.framework.rule.maintain.service.bean;

import java.util.ArrayList;
import java.util.List;

public class Event {

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String name;

	private List<Rule> ruleList = new ArrayList<Rule>();

	private List<RuleGroup> groupList = new ArrayList<RuleGroup>();

	public List<RuleGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<RuleGroup> groupList) {
		this.groupList = groupList;
	}

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
