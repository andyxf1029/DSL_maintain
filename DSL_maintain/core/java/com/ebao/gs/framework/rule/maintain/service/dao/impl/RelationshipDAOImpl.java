package com.ebao.gs.framework.rule.maintain.service.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ebao.gs.framework.rule.maintain.service.bean.Event;
import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleGroup;
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

	public List<Long> findEventByGourpIdList(List<Long> groupIdList) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertRuleAndGroupLink(long ruleId, long groupId) {
		Map<String, Object> paramterMap = new HashMap<String, Object>();
		paramterMap.put("rule_id", ruleId);
		paramterMap.put("group_id", groupId);
		this.getSqlMapClientTemplate().insert("insertLinkForRuleAndGroup",
				paramterMap);
	}

	public void insertLinkForGroupAndEvent(long id, Event event) {
		// TODO Auto-generated method stub

	}

	public void insertLinkForRuleAndEvent(Long id, Event event) {
		// TODO Auto-generated method stub

	}

	public List<RuleGroup> findGroupByEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Rule> findRuleByEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

}
