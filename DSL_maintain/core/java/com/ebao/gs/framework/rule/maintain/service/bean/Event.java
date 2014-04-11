package com.ebao.gs.framework.rule.maintain.service.bean;

import java.util.ArrayList;
import java.util.List;

public class Event {

	private long id;

	private String fieldLabel;

	private String fieldLevel;

	private String code;

	private String eventName;

	private String eventType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public String getFieldLevel() {
		return fieldLevel;
	}

	public void setFieldLevel(String fieldLevel) {
		this.fieldLevel = fieldLevel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	private String triggerType;

	private List<Rule> ruleList = new ArrayList<Rule>();

	//
	private List<RuleGroup> groupList = new ArrayList<RuleGroup>();

	public List<RuleGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<RuleGroup> groupList) {
		this.groupList = groupList;
	}

	//
	public List<Rule> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<Rule> ruleList) {
		this.ruleList = ruleList;
	}

}
