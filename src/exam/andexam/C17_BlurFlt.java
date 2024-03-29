package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class C17_BlurFlt extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	protected class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);
			Paint Pnt = new Paint();
			Pnt.setAntiAlias(true);

			Bitmap cup = BitmapFactory.decodeResource(getContext().getResources(), 
					R.drawable.cup);

			BlurMaskFilter blur = new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL);
			Pnt.setMaskFilter(blur);
			canvas.drawBitmap(cup, 30, 30, Pnt);
		}
	}
}