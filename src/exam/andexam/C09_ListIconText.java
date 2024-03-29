package exam.andexam;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C09_ListIconText extends Activity {
	ArrayList<MyItem> arItem;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c09_listview);

		arItem = new ArrayList<MyItem>();
		MyItem mi;
		mi = new MyItem(R.drawable.icon, "삼성 노트북");arItem.add(mi);
		mi = new MyItem(R.drawable.icon, "LG 세탁기");arItem.add(mi);
		mi = new MyItem(R.drawable.icon, "대우 마티즈");arItem.add(mi);

		MyListAdapter MyAdapter = new MyListAdapter(this, R.layout.c09_icontext, arItem);

		ListView MyList;
		MyList=(ListView)findViewById(R.id.list);
		MyList.setAdapter(MyAdapter);
	}
}

//리스트 뷰에 출력할 항목
class MyItem {
	MyItem(int aIcon, String aName) {
		Icon = aIcon;
		Name = aName;
	}
	int Icon;
	String Name;
}

//어댑터 클래스
class MyListAdapter extends BaseAdapter {
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<MyItem> arSrc;
	int layout;

	public MyListAdapter(Context context, int alayout, ArrayList<MyItem> aarSrc) {
		maincon = context;
		Inflater = (LayoutInflater)context.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		arSrc = aarSrc;
		layout = alayout;
	}

	public int getCount() {
		return arSrc.size();
	}

	public String getItem(int position) {
		return arSrc.get(position).Name;
	}

	public long getItemId(int position) {
		return position;
	}

	// 각 항목의 뷰 생성
	public View getView(int position, View convertView, ViewGroup parent) {
		final int pos = position;
		if (convertView == null) {
			convertView = Inflater.inflate(layout, parent, false);
		}
		ImageView img = (ImageView)convertView.findViewById(R.id.img);
		img.setImageResource(arSrc.get(position).Icon);

		TextView txt = (TextView)convertView.findViewById(R.id.text);
		txt.setText(arSrc.get(position).Name);

		Button btn = (Button)convertView.findViewById(R.id.btn);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String str = arSrc.get(pos).Name + "를 주문합니다.";
				Toast.makeText(maincon, str, Toast.LENGTH_SHORT).show();
			}
		});

		return convertView;
	}
}
