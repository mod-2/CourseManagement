package com.example.coursemanagement.beans;

import cn.bmob.v3.BmobObject;

/**
 * Created by youbing on 2015/9/29.
 */
public class Course extends BmobObject {
	private String grade;
    private String major;
    private String number;
    private String coursename;
    private String coursetype;
    private String credit;
    private String period;
    private String testperiod;
    private String operateperiod;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getTestperiod() {
		return testperiod;
	}
	public void setTestperiod(String testperiod) {
		this.testperiod = testperiod;
	}
	public String getOperateperiod() {
		return operateperiod;
	}
	public void setOperateperiod(String operateperiod) {
		this.operateperiod = operateperiod;
	}
    
    
   
}

