package com.ebao.gs.framework.rule.maintain.service.bean;

import java.util.List;

public class Rule {

	private String name;

	private String rulePath;

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleLevel() {
		return ruleLevel;
	}

	public void setRuleLevel(String ruleLevel) {
		this.ruleLevel = ruleLevel;
	}

	private Long id;

	private String ruleType;

	private String ruleLevel;

	private String ruleDescription;

	private List<RuleGroup> groupList;

	private List<Event> eventList;

	public List<RuleGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<RuleGroup> groupList) {
		this.groupList = groupList;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public String getRulePath() {
		return rulePath;
	}

	public void setRulePath(String rulePath) {
		this.rulePath = rulePath;
	}

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Rule [name=" + name + ", rulePath=" + rulePath + ", id=" + id
				+ ", ruleType=" + ruleType + ", ruleLevel=" + ruleLevel
				+ ", ruleDescription=" + ruleDescription + "]";
	}

}
