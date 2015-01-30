package com.nvim.utils;

import com.nvim.proto.ContactEntity;

public class ContactUtils {

	public static String getSectionName(ContactEntity contact) {	
		String pinyin = contact.pinyinElement.pinyin;
		if (pinyin == null || pinyin.isEmpty()) {
			return "";
		}
		
		return contact.pinyinElement.pinyin.substring(0, 1);
	}
}
