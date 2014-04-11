package com.ebao.gs.framework.rule.maintain.web.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.service.IEventService;
import com.ebao.gs.framework.rule.maintain.service.bean.Event;

@Controller
@RequestMapping("/event")
public class EventResourceHandler {

	private IEventService eventService;

	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void assignToEvent(@RequestBody String eventJson) {
		Event event = JSON.parseObject(eventJson, Event.class);
		eventService.assignGourpToEvent(event, event.getGroupList());
		eventService.assignRuleToEvent(event, event.getRuleList());
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public String findEventById(@PathVariable String id) {
		Event event = new Event();
		event.setId(Long.valueOf(id));
		eventService.loadEventRelationship(event);
		return JSON.toJSONString(event);
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public String searchEvents(@RequestParam("name") String searchName,
			@RequestParam("type") String eventType) {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("EventName", searchName);
		requestMap.put("eventType", eventType);
		List<Event> eventList = eventService.searchEventByCondition(requestMap);
		return JSON.toJSONString(eventList);
	}

	// @RequestMapping(value = "relationship", method = RequestMethod.POST)
	// public Event loadEventRelationship(Event event) {
	// return eventService.loadEventRelationship(event);
	//
	// }
}
