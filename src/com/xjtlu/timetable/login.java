package com.xjtlu.timetable;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by Dean Zhang on 13-9-21.
 */

public class login extends Activity {

    private MySQLiteOpenHelper myOpenHelper;
    private SQLiteDatabase mysql;
    private Button bt1, bt2, bt3, bt4;
    private String programmeName;

    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        bt1 = (Button) findViewById(R.id.y1);
        bt2 = (Button) findViewById(R.id.y2);
        bt3 = (Button) findViewById(R.id.y3);
        bt4 = (Button) findViewById(R.id.y4);

        bt1.setOnClickListener(new bt1());
        bt2.setOnClickListener(new bt2());
        bt3.setOnClickListener(new bt3());
        bt4.setOnClickListener(new bt4());
        //*判断是否存在SD卡，如果存在就创建一个数据库文件
        myOpenHelper = new MySQLiteOpenHelper(this);
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            if (FileDB.f.exists())
                mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.f, null);               //无论数据库在哪里创建都需要首先声明这句
            else {
                FileDB.create();
                if (FileDB.fileflag) {
                    mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.f, null);          //在sd卡创建数据库的语句1
                    myOpenHelper.onCreate(mysql);                                       //在sd卡创建数据库的语句2
                } else
                    mysql = myOpenHelper.getReadableDatabase();
            }
        else
            mysql = myOpenHelper.getReadableDatabase();
//        FileDB dbHelper = new FileDB(this);
//        dbHelper.openDatabase();
//        myOpenHelper = new MySQLiteOpenHelper(this);
//        mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.DB_PATH + "/" + FileDB.DB_NAME, null);


    }

    class bt1 implements OnClickListener {

        public void onClick(View v) {
            //	finish();
            Intent intent = new Intent(login.this, programme.class);
            Bundle bundle = new Bundle();                           //创建Bundle对象
            bundle.putInt("bt", 1);     //装入数据
            intent.putExtras(bundle);                                //把Bundle塞入Intent里面
            startActivity(intent);
            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);

        }
    }


    class bt2 implements OnClickListener {

        public void onClick(View v) {
            //	finish();
            Intent intent = new Intent(login.this, programme.class);
            Bundle bundle = new Bundle();                           //创建Bundle对象
            bundle.putInt("bt", 2);     //装入数据
            intent.putExtras(bundle);                                //把Bundle塞入Intent里面
            startActivity(intent);
            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);

        }
    }

    class bt3 implements OnClickListener {

        public void onClick(View v) {
            //	finish();
            Intent intent = new Intent(login.this, programme.class);
            Bundle bundle = new Bundle();                           //创建Bundle对象
            bundle.putInt("bt", 3);     //装入数据
            intent.putExtras(bundle);                                //把Bundle塞入Intent里面
            startActivity(intent);
            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);

        }
    }

    class bt4 implements OnClickListener {

        public void onClick(View v) {
            //	finish();
            Intent intent = new Intent(login.this, programme.class);
            Bundle bundle = new Bundle();                           //创建Bundle对象
            bundle.putInt("bt", 4);     //装入数据
            intent.putExtras(bundle);                                //把Bundle塞入Intent里面
            startActivity(intent);
            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);

        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // do something on back.
            Cursor curChoose = mysql.rawQuery("select * from classes", null);
            while (curChoose.moveToNext()) {
                programmeName = curChoose.getString(2);
            }
            curChoose.close();
            if (programmeName == null) {


                                        SysApplication.getInstance().exit();
                                        login.this.finish();

            }

        }
        return super.onKeyDown(keyCode, event);
    }


}

