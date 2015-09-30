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
	// 获得数据的major信息
	map.put("major", course.getMajor());
	// 获得数据的number信息
	map.put("number", course.getNumber());
	// 获得coursename的信息
	map.put("coursename", course.getCoursename());
	// 获得数据coursetype信息
	map.put("coursetype", course.getCoursetype());
	// 获得数据credit信息
	map.put("credit", course.getCredit());
	// 获得period的信息
	map.put("period", course.getPeriod());
	// 获得数据testperiod信息
	map.put("testperiod", course.getTestperiod());
	// 获得数据coperateperiod信息
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
			text_coursename.setText("空");
		}
		//
		text_credit = (TextView) this.findViewById(R.id.id_text_credit);
		if(!intent.getStringExtra("credit").equals("")){
			text_credit.setText(intent.getStringExtra("credit"));
		} else {
			text_credit.setText("空");
		}
		//
		text_grade = (TextView) this.findViewById(R.id.id_text_grade);
		if(!intent.getStringExtra("grade").equals("")){
			text_grade.setText(intent.getStringExtra("grade"));
		} else {
			text_grade.setText("空");
		}
		//
		text_number = (TextView) this.findViewById(R.id.id_text_number);
		if(!intent.getStringExtra("number").equals("")){
			text_number.setText(intent.getStringExtra("number"));
		} else {
			text_number.setText("空");
		}
		//
		text_operateperiod = (TextView) this.findViewById(R.id.id_text_operateperiod);
		if(!intent.getStringExtra("operateperiod").equals("")){
			text_operateperiod.setText(intent.getStringExtra("operateperiod"));
		} else {
			text_operateperiod.setText("空");
		}
		//
		text_period = (TextView) this.findViewById(R.id.id_text_period);
		if(!intent.getStringExtra("period").equals("")){
			text_period.setText(intent.getStringExtra("period"));
		} else {
			text_period.setText("空");
		}
		//
		text_testperiod = (TextView) this.findViewById(R.id.id_text_testperiod);
		if(!intent.getStringExtra("testperiod").equals("")){
			text_testperiod.setText(intent.getStringExtra("testperiod"));
		} else {
			text_testperiod.setText("空");
		}
		text_coursetype = (TextView) this.findViewById(R.id.id_text_coursetype);
		if(!intent.getStringExtra("coursetype").equals("")){
			text_coursetype.setText(intent.getStringExtra("coursetype"));
		} else {
			text_coursetype.setText("空");
		}
		
	}
}
