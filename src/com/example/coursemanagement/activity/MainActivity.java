package com.example.coursemanagement.activity;

import com.a.a.in;
import com.example.coursemanagement.R;
import com.example.coursemanagement.R.id;
import com.example.coursemanagement.R.layout;
import com.example.coursemanagement.Thread.readRunnable;
import com.example.coursemanagement.utils.FileUtils;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private static final  int FILE_SELECT_CODE = 1;
    private  Button btImport ;
    private  Button btDisplay;
    private  Thread mthread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        btDisplay = (Button)this.findViewById(R.id.btDisplay);
        btImport = (Button)this.findViewById(R.id.btImport);
        btImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Import",Toast.LENGTH_SHORT).show();//// TODO: 2015/9/27
                //选取文件，读取excel
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                try {
                    startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), FILE_SELECT_CODE);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "Please install a File Manager.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Display", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)  {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    String path = FileUtils.getPath(this, uri);
                    Log.i("filepath",path);
                    readExcel(path);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void readExcel(String path) {
        readRunnable myRunnable = new readRunnable();
        myRunnable.setPath(path);
        myRunnable.setContext(this);
        mthread = new Thread(myRunnable);
        mthread.start();
    }

}
