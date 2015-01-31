package com.nvim.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.nvim.R;

public abstract class TTBaseActivity extends Activity {
	protected ImageView topLeftBtn;
	protected ImageView topRightBtn;
	protected TextView topTitleTxt;
	protected TextView leftTitleTxt;
	protected ViewGroup topBar;
	protected float x1, y1, x2, y2 = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		this.setContentView(R.layout.tt_activity_base);

		topBar = (ViewGroup) this.findViewById(R.id.topbar);
		topTitleTxt = (TextView) this.findViewById(R.id.base_activity_title);
		topLeftBtn = (ImageView) this.findViewById(R.id.left_btn);
		topRightBtn = (ImageView) this.findViewById(R.id.right_btn);
		leftTitleTxt = (TextView) this.findViewById(R.id.left_txt);

		topTitleTxt.setVisibility(View.GONE);
		topRightBtn.setVisibility(View.GONE);
		leftTitleTxt.setVisibility(View.GONE);
		topLeftBtn.setVisibility(View.GONE);
	}

	protected void setLeftText(String text) {
		if (null == text) {
			return;
		}
		leftTitleTxt.setText(text);
		leftTitleTxt.setVisibility(View.VISIBLE);
	}

	protected void setTitle(String title) {
		if (title == null) {
			return;
		}
		if (title.length() > 12) {
			title = title.substring(0, 11) + "...";
		}
		topTitleTxt.setText(title);
		topTitleTxt.setVisibility(View.VISIBLE);
	}

	@Override
	public void setTitle(int id) {
		String strTitle = getResources().getString(id);
		setTitle(strTitle);
	}

	protected void setLeftButton(int resID) {
		if (resID <= 0) {
			return;
		}

		topLeftBtn.setImageResource(resID);
		topLeftBtn.setVisibility(View.VISIBLE);
	}

	protected void setRightButton(int resID) {
		if (resID <= 0) {
			return;
		}

		topRightBtn.setImageResource(resID);
		topRightBtn.setVisibility(View.VISIBLE);
	}

	protected void setTopBar(int resID) {
		if (resID <= 0) {
			return;
		}

		topBar.setBackgroundResource(resID);
	}

	protected void initHandler() {

	}
}
