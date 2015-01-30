package com.nvim.ui.utils;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.nvim.log.Logger;

public class IMContactListViewHelper {

	private Logger logger = Logger.getLogger(IMContactListViewHelper.class);
	private ListView allContactListView;
	private SortSideBar sortSideBar;

	private Context ctx;

	public void onInit(Context ctx, View parentView, 
			OnItemClickListener itemClickListener) {
		logger.d("contactUI#onInit");

		this.ctx = ctx;
		allContactListView = (ListView) parentView
				.findViewById(R.id.all_contact_list);
		allContactListView.setOnItemClickListener(itemClickListener);

	}
}
