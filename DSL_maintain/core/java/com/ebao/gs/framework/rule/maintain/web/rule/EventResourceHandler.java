package com.ebao.gs.framework.rule.maintain.web.rule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/event")
public class EventResourceHandler {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void assignRuleToEvent(@RequestParam("id") String id,
			@RequestParam("isGroup") String isGroup) {
		if (isGroup.equals("true")) {
			// update
		}

	}

}
