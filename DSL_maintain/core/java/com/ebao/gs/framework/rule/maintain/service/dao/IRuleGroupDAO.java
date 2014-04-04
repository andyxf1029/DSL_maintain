package com.ebao.gs.framework.rule.maintain.service.dao;

import java.util.List;

import com.ebao.gs.framework.rule.maintain.service.bean.RuleGroup;

public interface IRuleGroupDAO {

	List<RuleGroup> findGroupList(List<Long> groupList);

}
