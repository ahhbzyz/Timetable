package com.xjtlu.timetable;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dean Zhang on 13-9-22.
 */
public class classes extends Activity {


    private MySQLiteOpenHelper myOpenHelper;
    private SQLiteDatabase mysql; // 实例数据库
    private SimpleAdapter listItemAdapter;
    private ListView listview;
    private int year;
    private String modulename;
    private int flag = 0;

    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.classes);


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


        Intent intent = this.getIntent();        //获取已有的intent对象
        Bundle bundle = intent.getExtras();    //获取intent里面的bundle对象
        year = bundle.getInt("y");
        modulename = bundle.getString("programme"); //获取Bundle里面的字符串

        String y = String.valueOf(year);


        Cursor cur = mysql.rawQuery("select * from timetables where year=? and programmeName=? group by classesName",
                new String[]{y, modulename});


        String classesName = "` ~";
        if (cur != null) {
            while (cur.moveToNext()) {
                classesName += cur.getString(2) + "` ~";

            }

        }
        cur.close();


        String[] classesNamearray = classesName.split("` ~");


        listview = (ListView) findViewById(R.id.cl_list);
        List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 1; i < classesNamearray.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();

            map.put("ItemName", classesNamearray[i]);

            listItem.add(map);
        }

        //生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this, listItem,//数据源
                R.layout.classes_name,//ListItem的XML实现
                //动态数组与ImageItem对应的子项
                new String[]{"ItemName"},
                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.cl_name}
        );

        //添加并且显示
        listview.setAdapter(listItemAdapter);
        listItemAdapter.notifyDataSetChanged();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long i) {


                ListView listView = (ListView) parent;
                HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
                String classeName = data.get("ItemName").toString();

                ContentValues values = new ContentValues();
                values.put("year2", year);
                values.put("programmeName2", modulename);
                values.put("classesName2", classeName);

                String y = String.valueOf(1);


                mysql.update("classes", values, "id=?",
                        new String[]{y});


                Intent intent = new Intent(classes.this, Main.class);
                startActivity(intent);

                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);


            }
        });


    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // do something on back.
            classes.this.finish();
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
        }
        return super.onKeyDown(keyCode, event);
    }


}
