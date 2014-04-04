package com.ebao.gs.framework.rule.maintain.service.dao;

import java.util.List;

import com.ebao.gs.framework.rule.maintain.service.bean.Rule;

public interface IRuleDAO {

	List<Rule> searchRule(String searchName);

	Rule findRuleById(Long id);

	void update(Rule rule);

	Long addRule(Rule rule);

	Object deleteRule(long id);

}
