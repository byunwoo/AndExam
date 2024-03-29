package exam.andexam;

import android.app.*;
import android.content.*;
import android.database.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C20_CallWordCP extends Activity {
	static final String WORDURI = "content://exam.andexam.EnglishWord/word";
	EditText mText;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c20_callwordcp);

		mText = (EditText)findViewById(R.id.edittext);
    }
    
	public void mOnClick(View v) {
		ContentResolver cr = getContentResolver();
		switch (v.getId()) {
		// 전부 읽기
		case R.id.readall:
			Cursor cursor = cr.query(Uri.parse(WORDURI), null, null, null, null);
			
			String Result = "";
			while (cursor.moveToNext()) {
				String eng = cursor.getString(0);
				String han = cursor.getString(1);
				Result += (eng + " = " + han + "\n");
			}

			if (Result.length() == 0) {
				mText.setText("Empyt Set");
			} else {
				mText.setText(Result);
			}
			cursor.close();
			break;
		// 하나만 읽기
		case R.id.readone:
			Cursor cursor2 = cr.query(Uri.parse(WORDURI + "/boy"), 
					null, null, null, null);

			String Result2 = "";
			if (cursor2.moveToFirst()) {
				String eng = cursor2.getString(0);
				String han = cursor2.getString(1);
				Result2 += (eng + " = " + han + "\n");
			}
			
			if (Result2.length() == 0) {
				mText.setText("Empyt Set");
			} else {
				mText.setText(Result2);
			}
			cursor2.close();
			break;
		// 삽입
		case R.id.insert:
			ContentValues row = new ContentValues();
			row.put("eng", "school");
			row.put("han", "학교");

			cr.insert(Uri.parse(WORDURI), row);
			mText.setText("Insert Success");
			break;
		// 삭제
		case R.id.delete:
			cr.delete(Uri.parse(WORDURI), null, null);
			mText.setText("Delete Success");
			break;
		// 수정
		case R.id.update:
			ContentValues row2 = new ContentValues();
			row2.put("han", "핵교");
			cr.update(Uri.parse(WORDURI + "/school"), row2, null, null);
			mText.setText("Update Success");
			break;
		}
	}
 }
