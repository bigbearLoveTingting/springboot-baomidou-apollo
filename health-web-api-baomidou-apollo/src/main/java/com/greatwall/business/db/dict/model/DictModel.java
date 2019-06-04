package com.greatwall.business.db.dict.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import xingkong.framework.annotation.ExportConfig;


@Table(name = "dict")
@Data
public class DictModel  {
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "dict_id")
	@ExportConfig(value = "字典ID")
	private Long dictId;

	@Column(name = "table_name")
	@ExportConfig(value = "表名")
	private String tableName;
	
	@Column(name = "field_name")
	@ExportConfig(value = "字段名")
	private String fieldName;
	
	@Column(name = "`key`")
	@ExportConfig(value = "字典Key")
	private String key;

	@Column(name = "value")
	@ExportConfig(value = "字典Value")
	private String value;

	@Column(name = "short_value")
	@ExportConfig(value = "字典短Value")
	private String shortValue;

	

}