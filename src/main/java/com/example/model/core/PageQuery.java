package com.example.model.core;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PageQuery {

	private Integer offset = 0;

	private Integer limit = 20;

	private Integer pageNumber = 1;

	private Integer page;

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPage() {
		if (limit == null || pageNumber == null) {
			return null;
		}
		return (pageNumber - 1) * limit;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<String> getObjList(String values, List<String> objList) {
		if (CollectionUtils.isNotEmpty(objList)) {
			return objList;
		}
		values = StringUtils.trimToNull(values);
		if (StringUtils.isNotBlank(values)) {
			objList = new ArrayList<>();
			String str[] = values.replace("，", ",").split("\\,");
			for (String st : str) {
				if (StringUtils.isNotBlank(st)) {
					objList.add(st);
				}
			}
		}

		return objList;
	}

}