package com.ebao.gs.framework.rule.maintain.service.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ebao.gs.framework.rule.maintain.service.dao.IRelationshipDAO;

public class RelationshipDAOImpl extends SqlMapClientDaoSupport implements
		IRelationshipDAO {

	public List<Long> findGourpByRuleId(long id) {
		return this.getSqlMapClientTemplate().queryForList("findGourpByRuleId",
				id);
	}

	public List<Long> findEventByRuleId(Long id) {
		return this.getSqlMapClientTemplate().queryForList("findEventByRuleId",
				id);
	}

	public List<Long> findRuleGroupByEventId(Long id) {
		return this.getSqlMapClientTemplate().queryForList(
				"findRuleGroupByEventId", id);
	}

	public List<Long> findRuleByEventId(Long id) {
		return this.getSqlMapClientTemplate().queryForList("findRuleByEventId",
				id);
	}

}
