package com.example.coursemanagement.activity;

import java.util.HashMap;

import com.example.coursemanagement.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends Activity {
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_layout);
		listView = (ListView) findViewById(R.id.listView);
		/*
		 *date的格式。 
		 *
		 * List<Person> persons = service.getScrollData(0, 10);
		 * 
		 * List<HashMap<String, Object>> data = new ArrayList<HashMap<String,
		 * Object>>();
		 * 
		 * /*for(Person person : persons){ HashMap<String, Object> item = new
		 * HashMap<String, Object>(); item.put("id", person.getId());
		 * item.put("name", person.getName()); item.put("phone",
		 * person.getPhone()); item.put("amount", person.getAmount());
		 * data.add(item); }
		 */

		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.itemlayout, new String[] { "grade", "major" },
				new int[] { R.id.tv_grade, R.id.tv_name });
		// 实现列表的显示
		listView.setAdapter(adapter);
		// 条目点击事件
		listView.setOnItemClickListener(new ItemClickListener());
	}

	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView
					.getItemAtPosition(position);
			String personid = data.get("id").toString();
			Toast.makeText(getApplicationContext(), personid, 1).show();
		}
	}
}
