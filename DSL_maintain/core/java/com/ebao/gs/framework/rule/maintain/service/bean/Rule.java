package com.ebao.gs.framework.rule.maintain.service.bean;

public class Rule {

	private String name;

	public String getRulePath() {
		return rulePath;
	}

	public void setRulePath(String rulePath) {
		this.rulePath = rulePath;
	}

	public Integer getRuleType() {
		return ruleType;
	}

	public void setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
	}

	public Integer getRuleLevel() {
		return ruleLevel;
	}

	public void setRuleLevel(Integer ruleLevel) {
		this.ruleLevel = ruleLevel;
	}

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	private String rulePath;

	private Long id;

	private Integer ruleType;

	private Integer ruleLevel;

	private String ruleDescription;

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
