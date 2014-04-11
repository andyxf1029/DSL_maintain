package com.ebao.gs.framework.rule.maintain.service;

import java.util.List;

import com.ebao.gs.framework.rule.maintain.service.bean.RuleGroup;

public interface IRuleGroupService {

	List<RuleGroup> searchRuleGroup(String groupName);

}
