package com.ebao.gs.framework.rule.maintain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ebao.gs.framework.rule.maintain.service.IEventService;
import com.ebao.gs.framework.rule.maintain.service.bean.Event;
import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleGroup;
import com.ebao.gs.framework.rule.maintain.service.dao.IRelationshipDAO;

public class EventServiceImpl implements IEventService {

	private IRelationshipDAO relationshipDAO;

	public void setRelationshipDAO(IRelationshipDAO relationshipDAO) {
		this.relationshipDAO = relationshipDAO;
	}

	public void assignGourpToEvent(Event event, List<RuleGroup> list) {
		for (RuleGroup ruleGroup : list) {
			relationshipDAO
					.insertLinkForGroupAndEvent(ruleGroup.getId(), event);
		}
	}

	public void assignRuleToEvent(Event event, List<Rule> ruleList) {
		for (Rule rule : ruleList) {
			relationshipDAO.insertLinkForRuleAndEvent(rule.getId(), event);
		}
	}

	public List<Event> searchEventByCondition(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		Event event = new Event();
		event.setDriverId(1L);
		event.setFieldId(2L);
		event.setTriggerId(3L);
		event.setName("Save Policy");
		List<Event> eventList = new ArrayList<Event>();
		eventList.add(event);
		return eventList;
	}

	public Event loadEventRelationship(Event event) {
		List<RuleGroup> grouplist = relationshipDAO.findGroupByEvent(event);
		
		
		

		List<Rule> ruleList = relationshipDAO.findRuleByEvent(event);

//		event.setRuleList(ruleList);

		// TODO Auto-generated method stub
		return null;
	}
}
