package com.ebao.gs.framework.rule.maintain.service.dao;

import java.util.List;

public interface IRelationshipDAO {

	List<Long> findGourpByRuleId(long id);

	List<Long> findEventByRuleId(Long id);

}
