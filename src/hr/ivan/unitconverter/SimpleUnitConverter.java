package hr.ivan.unitconverter;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SimpleUnitConverter extends ListActivity {

	String[] items = { "Lenght", "Time", "Mass" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setListAdapter(new ArrayAdapter<String>(this,
				R.layout.unit_list_row_layout, R.id.unit_list_label, items));
	}
}