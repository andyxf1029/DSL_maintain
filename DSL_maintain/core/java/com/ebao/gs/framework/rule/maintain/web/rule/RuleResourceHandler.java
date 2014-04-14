package com.ebao.gs.framework.rule.maintain.web.rule;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.ebao.gs.framework.rule.maintain.service.IRuleService;
import com.ebao.gs.framework.rule.maintain.service.bean.FileMeta;
import com.ebao.gs.framework.rule.maintain.service.bean.Rule;
import com.ebao.gs.framework.rule.maintain.service.bean.RuleContent;

@Controller
@RequestMapping("/rule")
public class RuleResourceHandler {

	private IRuleService ruleService;

	public void setRuleService(IRuleService ruleService) {
		this.ruleService = ruleService;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public String searchRules(@RequestParam("name") String searchName) {
		List<Rule> rules = ruleService.searchRule(searchName);
		return JSON.toJSONString(rules);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public String findRuleById(@PathVariable String id) {
		return JSON
				.toJSONString(this.ruleService.findRuleById(Long.valueOf(id)));

	}

	@RequestMapping(value = "body/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String findRuleBodyById(@PathVariable String id) throws IOException {
		RuleContent content = this.ruleService.loadRuleBody(Long.valueOf(id));
		return JSON.toJSONString(content);

	}

	@RequestMapping(value = "body", method = RequestMethod.POST)
	@ResponseBody
	public void saveRuleBody(String content) throws IOException {
		RuleContent ruleContent = JSON.parseObject(content, RuleContent.class);
		this.ruleService.saveRuleBody(ruleContent);

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public long addOrUpdateRule(@RequestBody String ruleJson) {
		Rule rule = JSON.parseObject(ruleJson, Rule.class);
		return this.ruleService.addOrUpdate(rule);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRule(@RequestParam("id") String id) {
		this.ruleService.deleteRule(Long.valueOf(id));
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	LinkedList<FileMeta> upload(MultipartHttpServletRequest request,
			HttpServletResponse response) {

		LinkedList<FileMeta> files = new LinkedList<FileMeta>();

		// 1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		
		

		// 2. get each file
		while (itr.hasNext()) {

			// 2.1 get next MultipartFile
			mpf = request.getFile(itr.next());

			// 2.3 create new fileMeta
			FileMeta fileMeta = new FileMeta();
			fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileMeta.setFileType(mpf.getContentType());

			try {
				fileMeta.setBytes(mpf.getBytes());

				// copy file to local disk (make sure the path
				// "e.g. D:/temp/files" exists)
//				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
//						"D:/temp/files/" + mpf.getOriginalFilename()));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2.4 add to files
			files.add(fileMeta);
		}
		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
		return files;
	}
}
