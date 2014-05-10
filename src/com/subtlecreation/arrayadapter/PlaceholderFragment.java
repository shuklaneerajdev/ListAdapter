package com.subtlecreation.arrayadapter;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class PlaceholderFragment extends ListFragment {
	List<String> names;
	ArrayAdapter<String> adapter;
	public PlaceholderFragment() {
		names = new ArrayList<String>();
		names.add("London");
		names.add("Paris");
		names.add("New York");
	}
	public void addCity(String name){
		names.add(0, name);
		adapter.notifyDataSetChanged();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		return rootView;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		adapter = new ArrayAdapter<>(	getActivity().getApplicationContext(), 
				android.R.layout.simple_expandable_list_item_1,
				names);
		setListAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
}