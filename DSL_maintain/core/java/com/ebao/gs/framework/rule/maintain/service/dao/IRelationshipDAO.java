package com.ebao.gs.framework.rule.maintain.service.dao;

import java.util.List;

import com.ebao.gs.framework.rule.maintain.service.bean.Event;
import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleGroup;

public interface IRelationshipDAO {

	

//	List<Long> findEventByRuleId(Long id);

	void insertRuleAndGroupLink(long ruleId, long id);

	List<Long> findEventByGourpIdList(List<Long> groupIdList);

	void insertLinkForGroupAndEvent(long id, Event event);

	void insertLinkForRuleAndEvent(Long id, Event event);

	List<RuleGroup> findGroupByEvent(Event event);

	List<Rule> findRuleByEvent(Event event);

}
