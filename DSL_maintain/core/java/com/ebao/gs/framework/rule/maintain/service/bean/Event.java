package com.ebao.gs.framework.rule.maintain.service.bean;

import java.util.ArrayList;
import java.util.List;

public class Event {

	private long driverId;

	private long fieldId;

	private long triggerId;

	private String fieldLabel;

	private String fieldLevel;

	private String code;

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

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}

	public long getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(long triggerId) {
		this.triggerId = triggerId;
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

}
