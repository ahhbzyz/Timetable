package com.xjtlu.timetable;

import android.app.Activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Dean Zhang on 13-9-21.
 */

public class ModuleInfo extends Activity {

    private TextView tvName;
    private TextView tvWeek;
    private TextView tvTime;
    private TextView tvRoom;
    private TextView tvLecturer;

    private EditText extraInfo;
    private Button delete;
    private LinearLayout teacher;

    private int year;
    private String programme;
    private String classes;

    private String no;
    private String tmday;
    private String name;
    private String time;
    private String address;
    private String lecturer;
    private String text = "";
    private String realyear;
    private String realno;
    private String num;
    private String info;
    private MySQLiteOpenHelper myOpenHelper;
    private SQLiteDatabase mysql; // 实例数据库
    private String realLecturer;
    private String[] lecturerArray;

    public void onCreate(Bundle savedInstanceState) {
        System.out.println("进入onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }

    protected void onResume() {
        super.onResume();
        setContentView(R.layout.info);


        tvName = (TextView) findViewById(R.id.tvName);
        tvWeek = (TextView) findViewById(R.id.tvWeek);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvRoom = (TextView) findViewById(R.id.tvRoom);
        tvLecturer = (TextView) findViewById(R.id.tvLecturer);
        extraInfo = (EditText) findViewById(R.id.extraInfo);
        delete = (Button) findViewById(R.id.delete);


        Bundle bundle = getIntent().getExtras();
        year = bundle.getInt("year");
        programme = bundle.getString("programme");
        classes = bundle.getString("classes");
        name = bundle.getString("name");
        tmday = bundle.getString("day");
        no = bundle.getString("no");
        time = bundle.getString("time");
        address = bundle.getString("address");
        lecturer = bundle.getString("lecturer");

        String day;
        if (Integer.parseInt(tmday) == 1)
            day = "星期一";
        else if (Integer.parseInt(tmday) == 2)
            day = "星期二";
        else if (Integer.parseInt(tmday) == 3)
            day = "星期三";
        else if (Integer.parseInt(tmday) == 4)
            day = "星期四";
        else
            day = "星期五";


        tvName.setText(name);
        tvWeek.setText(day);
        tvTime.setText(time);
        tvRoom.setText(address);
        tvLecturer.setText(lecturer);


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
        realyear = String.valueOf(year);
        realno = String.valueOf(no);


        Cursor cur = mysql.rawQuery("select * from timetables where year=? and programmeName=? and classesName=? " +
                "and day= ? and no=?",
                new String[]{realyear, programme, classes, tmday, realno});
        if (cur != null) {

            while (cur.moveToNext()) {

                text = cur.getString(9);

            }
        }
        cur.close();

        extraInfo.setText(text);


        extraInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ModuleInfo.this, extraInfo.class);
                Bundle bundle = new Bundle();
                bundle.putInt("year", year);
                bundle.putString("programme", programme);
                bundle.putString("classes", classes);
                bundle.putString("day", tmday);
                bundle.putString("no", no);
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num = "";
                info = " ";
                deleteData2(num);
                deleteData(info);
                Intent intent = new Intent(ModuleInfo.this, ModuleInfo.class);
                Bundle bundle = new Bundle();
                bundle.putInt("year", year);
                bundle.putString("programme", programme);
                bundle.putString("classes", classes);
                bundle.putString("day", tmday);
                bundle.putString("no", no);
                bundle.putString("name", name);
                bundle.putString("time", time);
                bundle.putString("address", address);
                bundle.putString("lecturer", lecturer);
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        teacher = (LinearLayout) findViewById(R.id.teacher);
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (lecturer.indexOf(String.valueOf(',')) == -1) {
                    realLecturer = lecturer;
                    Intent it = new Intent(ModuleInfo.this, webView.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("lecturer", realLecturer);
                    it.putExtras(bundle);
                    startActivity(it);
                    overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
                } else {

                    lecturerArray = lecturer.split(", ");
                    final CharSequence[] items = lecturerArray;
                    AlertDialog.Builder builder = new AlertDialog.Builder(ModuleInfo.this);

                    builder.setTitle("请选择教师");
                    builder.setItems(
                            items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            realLecturer = String.valueOf(items[i]);
                            Intent it = new Intent(ModuleInfo.this, webView.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("lecturer", realLecturer);

                            it.putExtras(bundle);
                            startActivity(it);
                            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
                        }
                    })
                            .setNegativeButton(
                                    "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                    builder.create().show();


                }


            }
        });


    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // do something on back.
            ModuleInfo.this.finish();
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void deleteData(String info) {
        mysql.execSQL("UPDATE timetables SET info='" + info + "' WHERE year=" + year + " " +
                "AND programmeName='" + programme + "' AND classesName = '" + classes + "' AND " +
                "day='" + tmday + "' AND no=" + realno + ";");


    }

    public void deleteData2(String num) {

        mysql.execSQL("UPDATE timetables SET extraInfo='" + num + "' WHERE year=" + year + " " +
                "AND programmeName='" + programme + "' AND classesName = '" + classes + "' AND " +
                "day='" + tmday + "' AND no=" + realno + ";");
        Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
    }


}

