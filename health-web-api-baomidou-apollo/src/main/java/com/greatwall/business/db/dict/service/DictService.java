package com.greatwall.business.db.dict.service;

import com.baomidou.mybatisplus.service.IService;
import com.greatwall.business.db.dict.model.DictModel;

import xingkong.tool.core.web.form.PageForm;

public interface DictService extends IService<DictModel> {

	//Object list(DictModel dict, PageForm pageForm);
	
	//Object queryByTrem(DictModel dict, PageForm pageForm);

	DictModel view(DictModel dict);

	int add(DictModel dict);

	void delete(DictModel dict);

	void update(DictModel dict);
}
