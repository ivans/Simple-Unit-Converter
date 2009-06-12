package hr.ivan.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class UnitActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String unitName = getIntent().getExtras().getString(
				"hr.ivan.unitconverter.unitname");
		Log.d("UnitActivity", "showing activity for unit: " + unitName);
		setContentView(R.layout.main);
	}

}
