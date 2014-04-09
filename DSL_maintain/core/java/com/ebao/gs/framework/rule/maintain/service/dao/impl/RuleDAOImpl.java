package com.ebao.gs.framework.rule.maintain.service.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.util.Assert;

import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.dao.IRuleDAO;

public class RuleDAOImpl extends SqlMapClientDaoSupport implements IRuleDAO {

	public List<Rule> searchRule(String searchName) {
		Map<String, Object> paramterMap = new HashMap<String, Object>();
		paramterMap.put("name", searchName);
		List<Rule> rules = this.getSqlMapClientTemplate().queryForList(
				"queryRules", paramterMap);
		return rules;
	}

	public Rule findRuleById(Long id) {
		return (Rule) this.getSqlMapClientTemplate().queryForObject(
				"selectByPrimaryKey", id);
	}

	public void update(Rule rule) {
		int result = this.getSqlMapClientTemplate().update("updateRule", rule);
		Assert.isTrue(result <= 1, "upadte more than one record");
	}

	public Long addRule(Rule rule) {
		Object id = this.getSqlMapClientTemplate().insert("insertRule", rule);
		return (Long) id;
	}

	public Object deleteRule(long id) {
		return this.getSqlMapClientTemplate().delete("deleteRule", id);
	}

}
