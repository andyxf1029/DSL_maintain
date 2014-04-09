package com.ebao.gs.framework.rule.maintain.service;

import java.util.List;
import java.util.Map;

import com.ebao.gs.framework.rule.maintain.service.bean.Event;
import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleGroup;

public interface IEventService {

	void assignGourpToEvent(Event event, List<RuleGroup> list);

	void assignRuleToEvent(Event event, List<Rule> ruleList);

	List<Event> searchEventByCondition(Map<String, Object> requestMap);

	Event loadEventRelationship(Event event);

}
