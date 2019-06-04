package com.greatwall.business.db.dict.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.greatwall.business.db.dict.model.DictModel;

public interface DictMapper extends BaseMapper<DictModel> {
	
	List<DictModel> queryByTrem(DictModel dictModel);
	
	void deleteDict(DictModel dictModel);
	

}