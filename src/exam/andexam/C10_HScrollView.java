package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C10_HScrollView extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c10_hscrollview);

		HorizontalScrollView svw = (HorizontalScrollView)findViewById(R.id.scr);
		svw.addView(new HColorView(this));
	}
}

class HColorView extends View {
	public HColorView(Context context) {
		super(context);
	}

	public void onDraw(Canvas canvas) {
		Paint Pnt = new Paint();
		for (int x = 0;x < 1280;x += 5) {
			Pnt.setARGB(255, 255 - x / 5, 255 - x / 5, 255);
			canvas.drawRect(x, 0, x + 5, 1280, Pnt);
		}
	}

	protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(1280, 1280);
	}
}
