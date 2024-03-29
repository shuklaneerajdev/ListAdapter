package com.subtlecreation.arrayadapter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.subtlecreation.arrayadapter.PlaceholderFragment;
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.listFragment, new PlaceholderFragment(), "NAMES").commit();
		}
		getSupportFragmentManager().executePendingTransactions();
		final PlaceholderFragment cityNames = (PlaceholderFragment)getSupportFragmentManager().findFragmentByTag("NAMES");
		Button createTaskButton = (Button)findViewById(R.id.createTaskButton);
		createTaskButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText textWritten = (EditText)findViewById(R.id.newTask);
				if(cityNames!=null){
					Log.d("FoundFragment", "Found the fragment");
					cityNames.addCity(textWritten.getText().toString());
				}else{
					Log.d("NotFoundFragment", "The fragment is missing");
				}
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
