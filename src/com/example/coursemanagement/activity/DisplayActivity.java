package com.example.coursemanagement.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

import com.example.coursemanagement.R;
import com.example.coursemanagement.beans.Course;

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
	private TextView text_grade,text_major,text_number,text_coursename,text_coursetype,text_credit,text_period,text_testperiod,text_operateperiod;
	
	private static final String APP_ID = "e4f8d1e1ba3b0ff995032e07e0b6a9cd";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_layout);
		Bmob.initialize(getApplicationContext(), APP_ID);
		listView = (ListView) findViewById(R.id.listView);
		/*
		 * date�ĸ�ʽ��
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
	
			BmobQuery<Course> query = new BmobQuery<Course>();
			// ��ѯplayerName�С���Ŀ��������
			//query.addWhereEqualTo("playerName", "��Ŀ");
			// ����50�����ݣ����������������䣬Ĭ�Ϸ���10������
			query.setLimit(1000);
			// ִ�в�ѯ����

			query.findObjects(this, new FindListener<Course>() {
				@Override
				public void onSuccess(List<Course> object) {
					// TODO Auto-generated method stub
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					Toast.makeText(getApplicationContext(), "��ѯ�ɹ�", Toast.LENGTH_SHORT)
					.show();
					for (Course course : object) {
						Map<String, Object> map = new HashMap<String, Object>();
						//���grade����Ϣ
						map.put("grade", course.getGrade());
						// ������ݵ�major��Ϣ
						map.put("major", course.getMajor());
						// ������ݵ�number��Ϣ
						map.put("number", course.getNumber());
						//���coursename����Ϣ
						map.put("coursename", course.getCoursename());
						// �������coursetype��Ϣ
						map.put("coursetype", course.getCoursetype());
						// �������credit��Ϣ
						map.put("credit", course.getCredit());
						//���period����Ϣ
						map.put("period", course.getPeriod());
						// �������testperiod��Ϣ
						map.put("testperiod", course.getTestperiod());
						// �������coperateperiod��Ϣ
						map.put("operateperiod", course.getOperateperiod());
						//��ӵ�list��
						list.add(map);
					}
					SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), list,
							R.layout.itemlayout, new String[] { "grade", "coursename" },
							new int[] { R.id.tv_grade, R.id.tv_name });
					// ʵ���б����ʾ
					listView.setAdapter(adapter);
					// ��Ŀ����¼�
					listView.setOnItemClickListener(new ItemClickListener());

				}

				@Override
				public void onError(int code, String msg) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "��ѯʧ��", Toast.LENGTH_SHORT)
					.show();
				}
			});
		
	
	}

	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView
					.getItemAtPosition(position);
			String personid = data.get("coursename").toString();
			Toast.makeText(getApplicationContext(), personid, 1).show();
			text_grade=(TextView)findViewById(R.id.id_text_grade).setText(personid);
		}
	}


}
