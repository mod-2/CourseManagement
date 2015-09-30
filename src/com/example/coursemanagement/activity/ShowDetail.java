package com.example.coursemanagement.activity;

import com.example.coursemanagement.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
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
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.info_layout);
		
		Intent intent = this.getIntent(); 
		//
		text_coursename = (TextView) this.findViewById(R.id.id_text_coursename);
		if(!intent.getStringExtra("coursename").equals("")){
			text_coursename.setText(intent.getStringExtra("coursename"));
		} else {
			text_coursename.setText("��");
		}
		//
		text_credit = (TextView) this.findViewById(R.id.id_text_credit);
		if(!intent.getStringExtra("credit").equals("")){
			text_credit.setText(intent.getStringExtra("credit"));
		} else {
			text_credit.setText("��");
		}
		//
		text_grade = (TextView) this.findViewById(R.id.id_text_grade);
		if(!intent.getStringExtra("grade").equals("")){
			text_grade.setText(intent.getStringExtra("grade"));
		} else {
			text_grade.setText("��");
		}
		//
		text_number = (TextView) this.findViewById(R.id.id_text_number);
		if(!intent.getStringExtra("number").equals("")){
			text_number.setText(intent.getStringExtra("number"));
		} else {
			text_number.setText("��");
		}
		//
		text_operateperiod = (TextView) this.findViewById(R.id.id_text_operateperiod);
		if(!intent.getStringExtra("operateperiod").equals("")){
			text_operateperiod.setText(intent.getStringExtra("operateperiod"));
		} else {
			text_operateperiod.setText("��");
		}
		//
		text_period = (TextView) this.findViewById(R.id.id_text_period);
		if(!intent.getStringExtra("period").equals("")){
			text_period.setText(intent.getStringExtra("period"));
		} else {
			text_period.setText("��");
		}
		//
		text_testperiod = (TextView) this.findViewById(R.id.id_text_testperiod);
		if(!intent.getStringExtra("testperiod").equals("")){
			text_testperiod.setText(intent.getStringExtra("testperiod"));
		} else {
			text_testperiod.setText("��");
		}
		text_coursetype = (TextView) this.findViewById(R.id.id_text_coursetype);
		if(!intent.getStringExtra("coursetype").equals("")){
			text_coursetype.setText(intent.getStringExtra("coursetype"));
		} else {
			text_coursetype.setText("��");
		}
		
	}
}
