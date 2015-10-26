package com.xjtlu.timetable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dean Zhang on 13-9-22.
 */

public class programme extends Activity {


    private SimpleAdapter listItemAdapter;
    private ListView listview;

    private int year;
    private String[] prgrammeNamearray;

    private MySQLiteOpenHelper myOpenHelper;
    private SQLiteDatabase mysql; // 实例数据库

    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.programme);

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
        year = bundle.getInt("bt");    //获取Bundle里面的字符串


        String y = String.valueOf(year);


        Cursor cur = mysql.rawQuery("select * from timetables where year=?  group  by programmeName  ",
                new String[]{y});


        String programmeName = "` ~";
        if (cur != null) {
            while (cur.moveToNext()) {
                programmeName += cur.getString(1) + "` ~";

            }

        }
        cur.close();


        prgrammeNamearray = programmeName.split("` ~");


        listview = (ListView) findViewById(R.id.pr_list);

        MyAdapter mAdapter = new MyAdapter(this);//得到一个MyAdapter对象

        listview.setAdapter(mAdapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long i) {

                String modulename = prgrammeNamearray[position + 1];


                Intent intent = new Intent(programme.this, classes.class);
                Bundle bundle = new Bundle();                           //创建Bundle对象
                bundle.putInt("y", year);
                bundle.putString("programme", modulename); //装入数据
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);

            }
        });


    }


    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 1; i < prgrammeNamearray.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("ItemName", prgrammeNamearray[i]);

            list.add(map);
        }


        return list;
    }

    public final class ViewHolder {

        public TextView title;
        private Button color;
    }


    class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return getData().size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {

                holder = new ViewHolder();

                convertView = mInflater.inflate(R.layout.programme_name, null);

                holder.title = (TextView) convertView.findViewById(R.id.pr_name);
                holder.color = (Button) convertView.findViewById(R.id.color);

                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }


            holder.title.setText(getData().get(position).get("ItemName").toString());


            if (holder.title.getText().toString().equals("FMA")||holder.title.getText().toString().equals("AMA"))
            {
                holder.color.setBackgroundColor(getResources().getColor(R.color.mathScience));
            }
            else if (holder.title.getText().toString().equals("ACC")||holder.title.getText().toString().equals("BAD")||holder.title.getText().toString().equals("HRM")
                    ||holder.title.getText().toString().equals("MKT")||holder.title.getText().toString().equals("ECO")||holder.title.getText().toString().equals("IMS"))
            {
                holder.color.setBackgroundColor(getResources().getColor(R.color.business));
            }
            else if (holder.title.getText().toString().equals("ARC"))
            {
                holder.color.setBackgroundColor(getResources().getColor(R.color.architecture));
            }
            else if (holder.title.getText().toString().equals("ENB")||holder.title.getText().toString().equals("ENC")||holder.title.getText().toString().equals("ENF")
                    ||holder.title.getText().toString().equals("ENV"))
            {
                holder.color.setBackgroundColor(getResources().getColor(R.color.language));
            }
            else if (holder.title.getText().toString().equals("EEE")||holder.title.getText().toString().equals("DMT"))
            {
                holder.color.setBackgroundColor(getResources().getColor(R.color.eee));
            }
            else if (holder.title.getText().toString().equals("CHM")||holder.title.getText().toString().equals("BIO"))
            {
                holder.color.setBackgroundColor(getResources().getColor(R.color.biology));
            }
            else if (holder.title.getText().toString().equals("CST")||holder.title.getText().toString().equals("ICS"))
            {
                holder.color.setBackgroundColor(getResources().getColor(R.color.computer));
            }





            return convertView;
        }

    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // do something on back.
            programme.this.finish();
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
        }
        return super.onKeyDown(keyCode, event);
    }


}

