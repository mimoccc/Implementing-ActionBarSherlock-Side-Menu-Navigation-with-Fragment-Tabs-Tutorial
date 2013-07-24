package com.androidbegin.sidemenutabstutorial;

import com.actionbarsherlock.app.SherlockFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTab4 extends SherlockFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragmenttab4, container,
				false);
		return rootView;
	}

}
