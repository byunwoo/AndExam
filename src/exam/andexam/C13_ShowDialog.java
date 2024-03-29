package exam.andexam;

import java.util.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C13_ShowDialog extends Activity {
	final static int SampleDialog = 0;
	final static int QuestionDialog = 1;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c13_showdialog);

		Button btn = (Button)findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				showDialog(SampleDialog);
			}
		});		
		Button btn2 = (Button)findViewById(R.id.call2);
		btn2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				showDialog(QuestionDialog);
			}
		});		
	}
	
    protected Dialog onCreateDialog(int id) {
    	switch (id) {
    	case SampleDialog:
    		return new AlertDialog.Builder(C13_ShowDialog.this)
			.setTitle("알립니다.")
			.setMessage("대화상자를 열었습니다.")
			.setIcon(R.drawable.icon)
			.setPositiveButton("닫기", null)
			.create();
    	case QuestionDialog:
    		return new AlertDialog.Builder(C13_ShowDialog.this)
			.setTitle("질문")
			.setMessage("밥 먹었어요?")
			.setPositiveButton("먹었다", null)
			.setNegativeButton("굶었다", null)
			.create();
    	}
    	return null;
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
    	super.onPrepareDialog(id, dialog);
    	switch (id) {
    	case SampleDialog:
    		break;
    	case QuestionDialog:
    		Calendar calendar = Calendar.getInstance();
    		String stime = String.format("%d시 %d분 %d초", 
    				calendar.get(Calendar.HOUR_OF_DAY),
    				calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    		dialog.setTitle(stime);
    		break;
    	}
    }
}

