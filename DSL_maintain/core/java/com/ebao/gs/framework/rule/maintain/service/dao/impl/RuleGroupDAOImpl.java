package com.ebao.gs.framework.rule.maintain.service.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ebao.gs.framework.rule.maintain.service.bean.RuleGroup;
import com.ebao.gs.framework.rule.maintain.service.dao.IRuleGroupDAO;

public class RuleGroupDAOImpl extends SqlMapClientDaoSupport implements
		IRuleGroupDAO {

	public List<RuleGroup> findGroupList(List<Long> groupList) {

		// TODO Auto-generated method stub
		return null;
	}

	public RuleGroup searchGroupByName(String groupName) {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("name", groupName);
		return (RuleGroup) this.getSqlMapClientTemplate().queryForObject(
				"queryRules", requestMap);
	}

	public RuleGroup insertGroup(RuleGroup group) {
		Long id = (Long) this.getSqlMapClientTemplate().insert(
				"insertRuleGroup", group);
		group.setId(id);
		return group;
	}

}
