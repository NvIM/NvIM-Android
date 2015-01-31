package com.nvim.adapter;

import java.util.List;

import com.nvim.entity.ContactSortEntity;

public interface ContactBaseAdapter {
	int getPositionForSection(int section);

	int getSectionForPosition(int position);

	void updateListView(List<ContactSortEntity> list);

	Object getItem(int position);
}
