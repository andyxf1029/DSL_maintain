package com.ebao.gs.framework.rule.maintain.service;

import java.io.IOException;
import java.util.List;

import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleContent;

public interface IRuleService {

	List<Rule> searchRule(String searchName);

	Rule findRuleById(long l);

	RuleContent loadRuleBody(long id) throws IOException;

	Boolean saveRuleBody(RuleContent content) throws IOException;

	Long addOrUpdate(Rule rule);

	void deleteRule(long id);

}
