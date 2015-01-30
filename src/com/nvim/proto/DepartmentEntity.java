package com.nvim.proto;

import com.nvim.lib.utils.SearchElement;
import com.nvim.pinyin.PinYin.PinYinElement;

public class DepartmentEntity {
	public String id;
	public String title;
	public String description;
	public String parentId;
	public String leaderId;
	public int status;
	
	public PinYinElement pinyinElement = new PinYinElement();
	public SearchElement searchElement = new SearchElement();

	@Override
	public String toString() {
		return "id:" + id + ", title:" + title + ", description:" + description
				+ ", parentId:" + parentId + ", leaderId:" + leaderId
				+ ", status:" + String.valueOf(status);
	}

}
