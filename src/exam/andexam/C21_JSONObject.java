package exam.andexam;

import java.io.*;

import javax.xml.parsers.*;

import org.json.*;
import org.w3c.dom.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C21_JSONObject extends Activity {
	TextView mResult;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c21_jsonparser);

		mResult = (TextView)findViewById(R.id.result);
	}
	
	public void mOnClick(View v) {
		String Json = "[{\"Product\":\"Mouse\", \"Maker\":\"Samsung\", \"Price\":23000}," 
			+ "{\"Product\":\"KeyBoard\", \"Maker\":\"LG\", \"Price\":12000}," 
			+ "{\"Product\":\"HDD\", \"Maker\":\"Western Digital\", \"Price\":156000}]";
		try {
			String Result = "주문 목록\n";
			JSONArray ja = new JSONArray(Json);
			for (int i = 0; i < ja.length(); i++) {
				JSONObject order = ja.getJSONObject(i);
				Result += "제품명:" + order.getString("Product") + 
					",제조사:" + order.getString("Maker") + 
					",가격" + order.getInt("Price") + "\n";
			}
			mResult.setText(Result);
		} catch (JSONException e) {
			Toast.makeText(v.getContext(), e.getMessage(), 0).show();
		}
	}		
}
