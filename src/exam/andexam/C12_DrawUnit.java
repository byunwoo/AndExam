package exam.andexam;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class C12_DrawUnit extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c12_drawunit);
	}
}

class DrawUnitView extends View {
	public DrawUnitView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void onDraw(Canvas canvas) {
		Paint Pnt = new Paint();
		Pnt.setColor(Color.YELLOW);
		Resources res = getResources();
		int width, height;
		int y = 0;
		
		// 원론적인 방법
		DisplayMetrics dm = res.getDisplayMetrics(); 
		width = (int)(160 * dm.density);
		height = (int)(60 * dm.density);
		canvas.drawRect(0, y, width, y + height, Pnt);
		y+= (height * 1.2f);
		
		// dimen 리소스 사용
		width = (int)res.getDimension(R.dimen.drawunit_width);
		height = (int)res.getDimension(R.dimen.drawunit_height);
		canvas.drawRect(0, y, width, y + height, Pnt);
		y+= (height * 1.2f);
		
		// 직접 계산
		width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 160, dm);
		height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, dm);
		canvas.drawRect(0, y, width, y + height, Pnt);
		y+= (height * 1.2f);
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			String msg = String.format("x = %d, y = %d", 
					(int)event.getX(), (int)event.getY());
			Toast.makeText(getContext(), msg, 1).show();
			return true;
		}
		return false;
	}
}
