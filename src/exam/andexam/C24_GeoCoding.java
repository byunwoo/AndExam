package exam.andexam;

import java.io.*;
import java.util.*;

import android.app.*;
import android.location.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C24_GeoCoding extends Activity {
	LocationManager mLocMan;
	Geocoder mCoder;
	TextView mResult;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c24_geocoding);

		mResult = (TextView)findViewById(R.id.result);
		mCoder = new Geocoder(this);

		findViewById(R.id.convert).setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				List<Address> addr;
				String slat = ((EditText)findViewById(R.id.lat)).getText().toString();
				String slon = ((EditText)findViewById(R.id.lon)).getText().toString();
				try {
					addr = mCoder.getFromLocation(Double.parseDouble(slat), 
							Double.parseDouble(slon), 5);
				} catch (IOException e) { 
					mResult.setText("IO error : " + e.getMessage());
					return; 
				}
				
				if (addr == null) {
					mResult.setText("no result");
					return;
				}

				mResult.setText("개수 = " + addr.size() + "\n" + addr.get(0).toString());
			}
		});

		findViewById(R.id.convert2).setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				List<Address> addr;
				String saddr = ((EditText)findViewById(R.id.address)).getText().toString();
				try {
					addr = mCoder.getFromLocationName(saddr, 5);
				} catch (IOException e) { 
					mResult.setText("IO error : " + e.getMessage());
					return; 
				}
				
				if (addr == null) {
					mResult.setText("no result");
					return;
				}

				mResult.setText("개수 = " + addr.size() + "\n" + addr.get(0).toString());
			}
		});
	}
}
