package com.example.coursemanagement.activity;

import com.example.coursemanagement.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetail extends Activity {
	private TextView text_grade, text_major, text_number, text_coursename,
	text_coursetype, text_credit, text_period, text_testperiod,
	text_operateperiod;
	
	
	/*//text_grade=(TextView)findViewById(R.id.id_text_grade).setText(personid);
	map.put("grade", course.getGrade());
	// ������ݵ�major��Ϣ
	map.put("major", course.getMajor());
	// ������ݵ�number��Ϣ
	map.put("number", course.getNumber());
	// ���coursename����Ϣ
	map.put("coursename", course.getCoursename());
	// �������coursetype��Ϣ
	map.put("coursetype", course.getCoursetype());
	// �������credit��Ϣ
	map.put("credit", course.getCredit());
	// ���period����Ϣ
	map.put("period", course.getPeriod());
	// �������testperiod��Ϣ
	map.put("testperiod", course.getTestperiod());
	// �������coperateperiod��Ϣ
	map.put("operateperiod", course.getOperateperiod());*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_layout);
		Intent intent = this.getIntent(); 
		//
		text_coursename = (TextView) this.findViewById(R.id.id_text_coursename);
		text_coursename.setText(intent.getStringExtra("coursename"));
		//
		text_credit = (TextView) this.findViewById(R.id.id_text_credit);
		text_credit.setText(intent.getStringExtra("credit"));
		//
		text_grade = (TextView) this.findViewById(R.id.id_text_grade);
		text_grade.setText(intent.getStringExtra("grade"));
		//
		text_number = (TextView) this.findViewById(R.id.id_text_number);
		text_number.setText(intent.getStringExtra("number"));
		//
		text_operateperiod = (TextView) this.findViewById(R.id.id_text_operateperiod);
		text_operateperiod.setText(intent.getStringExtra("operateperiod"));
		//
		text_period = (TextView) this.findViewById(R.id.id_text_period);
		text_period.setText(intent.getStringExtra("period"));
		//
		text_testperiod = (TextView) this.findViewById(R.id.id_text_testperiod);
		text_testperiod.setText(intent.getStringExtra("testperiod"));
	}
}
