package com.androidbegin.sidemenutabstutorial;

import java.lang.reflect.Field;

import com.actionbarsherlock.app.SherlockFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends SherlockFragment {
	// Declare Variable
	private FragmentTabHost mTabHost;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create FragmentTabHost
		mTabHost = new FragmentTabHost(getSherlockActivity());
		// Locate fragment1.xml to create FragmentTabHost
		mTabHost.setup(getSherlockActivity(), getChildFragmentManager(), R.layout.fragment1);
		// Create Tab 1
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Tab 1"), FragmentTab1.class, null);
		// Create Tab 2
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("Tab 2"), FragmentTab2.class, null);
		
		return mTabHost;
	}
	
	// Detach FragmentTabHost
	@Override
	public void onDetach() {
		super.onDetach();

		try {
			Field childFragmentManager = Fragment.class
					.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);

		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	// Remove FragmentTabHost 
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mTabHost = null;
	}

}
