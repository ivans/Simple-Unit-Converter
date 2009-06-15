package hr.ivan.unitconverter;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

public class UnitActivity extends Activity {

	private TextView mTextDebug;
	private SurfaceView mSurfaceCamera;
	private Camera mCamera;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String unitName = getIntent().getExtras().getString(
				"hr.ivan.unitconverter.unitname");
		Log.d("UnitActivity", "showing activity for unit: " + unitName);
		setContentView(R.layout.main);

		mTextDebug = (TextView) findViewById(R.id.text_debug);
		mSurfaceCamera = (SurfaceView) findViewById(R.id.surface_camera);

		mCamera = Camera.open();
		try {
			mCamera.setPreviewDisplay(mSurfaceCamera.getHolder());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.d("UnitActivity", "Camera: " + mCamera);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mCamera != null) {
			mCamera.release();
		}
	}

}
