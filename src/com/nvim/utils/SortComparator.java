package com.nvim.utils;

import java.util.Comparator;

import com.nvim.entity.ContactSortEntity;

/**
 * @Description 按字母排序
 */
public class SortComparator implements Comparator<ContactSortEntity> {

	public int compare(ContactSortEntity entity1, ContactSortEntity entity2) {
		if (entity2.getSortLetters().equals("#")) {
			return -1;
		} else if (entity1.getSortLetters().equals("#")) {
			return 1;
		} else {
			return entity1.getSortLetters().compareTo(entity2.getSortLetters());
		}
	}
}
