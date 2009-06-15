package hr.ivan.unitconverter;

import hr.ivan.units.PhysicalUnit;
import hr.ivan.units.UnitsList;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SimpleUnitConverter extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ArrayList<PhysicalUnit> items = UnitsList.getInstance();
		setListAdapter(new UnitAdapter(this, items));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		PhysicalUnit pu = (PhysicalUnit) l.getItemAtPosition(position);
		Log.d("aaa", "onListItemClick : " + pu);
		Intent i = new Intent(this, UnitActivity.class);
		i.putExtra("hr.ivan.unitconverter.unitname", pu.getName());
		this.startActivity(i);
	}

	class ViewWrapper {
		View base;
		TextView tvUnitName = null;

		ViewWrapper(View base) {
			this.base = base;
		}

		TextView getTextViewUnitName() {
			if (tvUnitName == null) {
				tvUnitName = (TextView) base.findViewById(R.id.unit_list_label);
			}
			return (tvUnitName);
		}
	}

	class UnitAdapter extends ArrayAdapter<PhysicalUnit> {
		Activity context;

		UnitAdapter(Activity context, ArrayList<PhysicalUnit> list) {
			super(context, R.layout.unit_list_row_layout, list);
			this.context = context;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			ViewWrapper wrapper;
			TextView tv;

			if (row == null) {
				LayoutInflater inflater = context.getLayoutInflater();
				row = inflater.inflate(R.layout.unit_list_row_layout, null,
						false);
				wrapper = new ViewWrapper(row);
				row.setTag(wrapper);
				tv = wrapper.getTextViewUnitName();

			} else {
				wrapper = (ViewWrapper) row.getTag();
				tv = wrapper.getTextViewUnitName();
			}

			PhysicalUnit model = getItem(position);
			tv.setTag(new Integer(position));
			tv.setText(model.toString());

			return (row);
		}
	}

}