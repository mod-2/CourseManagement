package com.example.coursemanagement.Thread;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.coursemanagement.beans.Course;

import android.content.Context;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;
import jxl.Sheet;
import jxl.Workbook;

public class readRunnable implements Runnable {
	private static final String APP_ID = "e4f8d1e1ba3b0ff995032e07e0b6a9cd";
	private String path = new String();
	Context context;

	public void setPath(String path) {
		this.path = path;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public void run() {
		// 初始化Bmob
		Bmob.initialize(context, APP_ID);
		try {
			List<BmobObject> courseBeans = new ArrayList<BmobObject>();
			InputStream is = new FileInputStream(path);
			// Workbook book = Workbook.getWorkbook(new
			// File("mnt/sdcard/test.xls"));
			Workbook book = Workbook.getWorkbook(is);
			Sheet sheet = book.getSheet(0);
			int Rows = sheet.getRows();
			int Cols = sheet.getColumns();
			System.out.println(String.valueOf(Rows));
			for (int i = 3; i < Rows; ++i) {
				Course courseBean = new Course();
				System.out.println("grade:" + sheet.getCell(0,i)
						.getContents().toString());
				courseBean.setGrade(sheet.getCell(0,i)
						.getContents().toString());
				
				courseBean.setMajor(sheet.getCell(1, i).getContents()
						.toString());
				courseBean.setNumber(sheet.getCell(2, i)
						.getContents().toString());
				courseBean.setCoursename(sheet.getCell(3, i).getContents()
						.toString());
				courseBean.setCoursetype(sheet.getCell(4, i).getContents()
						.toString());
				courseBean.setCredit(sheet.getCell(5, i)
						.getContents().toString());
				courseBean.setPeriod(sheet.getCell(6, i)
						.getContents().toString());
				courseBean.setTestperiod(sheet.getCell(7, i)
						.getContents().toString());
				courseBean.setOperateperiod(sheet
						.getCell(8, i).getContents().toString());
				courseBeans.add(courseBean);
			}
			book.close();

			new BmobObject().insertBatch(context, courseBeans,
					new SaveListener() {

						@Override
						public void onSuccess() {
							Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT)
									.show();
						}

						@Override
						public void onFailure(int arg0, String arg1) {
							Toast.makeText(context, "添加失败", Toast.LENGTH_SHORT)
									.show();
						}
					});

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
