package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C08_EditSelect extends Activity {
	EditText mEdit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c08_editselect);

		mEdit = (EditText)findViewById(R.id.edit);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.home:
			mEdit.setSelection(0);
			break;
		case R.id.end:
			mEdit.setSelection(mEdit.getText().length());
			break;
		case R.id.selblock:
			mEdit.setSelection(3,10);
			break;
		case R.id.selall:
			mEdit.selectAll();
			break;
		case R.id.getsel:
			int start = mEdit.getSelectionStart();
			int end = mEdit.getSelectionEnd();
			Toast.makeText(C08_EditSelect.this, 
					"start = " + start + ",end = " + end, 
					Toast.LENGTH_LONG).show();
			break;
		}
	}
}