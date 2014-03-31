package com.ebao.gs.framework.rule.maintain.web.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.service.IEventService;
import com.ebao.gs.framework.rule.maintain.web.rule.bean.Event;

@Controller
public class EventResourceHandler {

	private IEventService eventService;

	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}
	
	

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	@ResponseBody
	public void assignRuleToEvent(@RequestParam("id") String id,
			@RequestParam("isGroup") String isGroup) {
		if (isGroup.equals("true")) {
			// update
		}

	}
	
	@RequestMapping(value="/events",method = RequestMethod.GET)
	@ResponseBody
	public String searchEvents(@RequestParam("name") String searchName) {
		
		
		
		

		List<Event> eventList = new ArrayList<Event>();

		Event event = new Event();
		
		event.setId(3);

		eventList.add(event);

		event.setName("Save Policy");

		return JSON.toJSONString(eventList);
	}

}
