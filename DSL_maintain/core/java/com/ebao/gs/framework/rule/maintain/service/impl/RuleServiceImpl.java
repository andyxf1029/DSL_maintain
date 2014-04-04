package com.ebao.gs.framework.rule.maintain.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebao.gs.framework.rule.maintain.service.IRuleService;
import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleContent;
import com.ebao.gs.framework.rule.maintain.service.dao.IRuleDAO;

public class RuleServiceImpl implements IRuleService {

	private IRuleDAO ruleDao;

	public void setRuleDao(IRuleDAO ruleDao) {
		this.ruleDao = ruleDao;
	}

	private Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);

	public List<Rule> searchRule(String searchName) {
		logger.debug("searchRule :" + searchName);
		List<Rule> ruleList = ruleDao.searchRule(searchName);
		logger.debug("search Rule result: " + ruleList);
		return ruleList;
	}

	public Rule findRuleById(long id) {
		logger.debug("findRuleById :" + id);
		Rule rule = ruleDao.findRuleById(id);
		logger.debug("findRuleById result: " + rule);
		return rule;
	}

	public RuleContent loadRuleBody(long id) throws IOException {
		Rule rule = this.findRuleById(id);
		RuleContent content = new RuleContent();
		if (StringUtils.isEmpty(rule.getRulePath())) {
			logger.error("loadRuleBody ,path is empty");
		} else {
			String fileBody = FileUtils.readFileToString(new File(rule
					.getRulePath()));
			content.setId(id);
			content.setContent(fileBody);
		}

		return content;
	}

	public Boolean saveRuleBody(RuleContent content) throws IOException {
		Rule rule = this.findRuleById(content.getId());
		if (StringUtils.isEmpty(rule.getRulePath())) {
			logger.error("loadRuleBody ,path is empty");
		} else {
			// TODO backup file
			FileUtils.deleteDirectory(new File(rule.getRulePath()));
			FileUtils.writeStringToFile(new File(rule.getRulePath()),
					content.getContent());
		}
		// TODO Auto-generated method stub
		return false;
	}

	public Long addOrUpdate(Rule rule) {
		if (rule.getId() != null) {
			ruleDao.update(rule);
		} else {
			return ruleDao.addRule(rule);
		}

		return rule.getId();
	}

	public void deleteRule(long id) {
		ruleDao.deleteRule(id);
	}

}
