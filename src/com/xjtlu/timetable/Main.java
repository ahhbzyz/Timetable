package com.xjtlu.timetable;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.os.Parcelable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

/**
 * Created by Dean Zhang on 13-9-21.
 */

public class Main extends Activity {

    private String[] dayarray;
    private String[] noarray;
    private String[] namearray;
    private String[] addressarray;
    private String[] timearray;
    private String[] lecturerarray;
    private String[] textArray;
    private ListView listView2, listView3, listView4, listView5, listView1;
    private String y;
    private String d;
    private MySQLiteOpenHelper myOpenHelper;
    private SQLiteDatabase mysql;
    private TextView clName;
    int dayOfWeek;
    private SimpleAdapter listItemAdapter;
    private static int c_id = 0;
    private ViewPager mViewPager;
    private PagerTitleStrip mPagerTitleStrip;
    private ArrayList<View> views;
    private ArrayList<String> titles;
    private int year;
    private String programmeName, classesName;
    private List<HashMap<String, Object>> listItem;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent2 = new Intent();
                intent2.setClass(Main.this, login.class);
                Main.this.startActivity(intent2);
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
                break;

            case R.id.item3:
                Intent intent = new Intent();
                intent.setClass(Main.this, About.class);
                Main.this.startActivity(intent);
                break;
            case R.id.item4:
                new AlertDialog.Builder(this)
                        .setCancelable(false)
                        .setTitle("退出")
                        .setMessage("您确认要退出程序吗？")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Main.this.finish(); // 关闭程序的核心方法
                                    }
                                })
                        .setNegativeButton("取消",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        dialog.cancel();
                                    }
                                }).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onResume() {
        super.onResume();
        setList(1, listView1);
        setList(2, listView2);
        setList(3, listView3);
        setList(4, listView4);
        setList(5, listView5);
        clName.setText("Y" + year + "-" + programmeName + "-" + classesName);

    }


    public void onCreate(Bundle savedInstanceState) {
        System.out.println("进入onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        //find();
        SysApplication.getInstance().addActivity(this);
        clName = (TextView) findViewById(R.id.clName);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertab);
        mPagerTitleStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 23);


        //将要分页显示的View装入数组中

        LayoutInflater inflater = getLayoutInflater();

        listView1 = (ListView) (inflater.inflate(R.layout.monday, null)).findViewById(R.id.listMonday);
        listView2 = (ListView) (inflater.inflate(R.layout.tuesday, null)).findViewById(R.id.listTuesday);
        listView3 = (ListView) (inflater.inflate(R.layout.wednesday, null)).findViewById(R.id.listWednesday);
        listView4 = (ListView) (inflater.inflate(R.layout.thursday, null)).findViewById(R.id.listThursday);
        listView5 = (ListView) (inflater.inflate(R.layout.friday, null)).findViewById(R.id.listFriday);


        //每个页面的Title数据
        views = new ArrayList<View>();


        views.add(listView1);
        views.add(listView2);
        views.add(listView3);
        views.add(listView4);
        views.add(listView5);


        titles = new ArrayList<String>();
        titles.add("星期一");

        titles.add("星期二");

        titles.add("星期三");
        titles.add("星期四");
        titles.add("星期五");


        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));

        if (c.get(Calendar.DAY_OF_WEEK) == 1 || c.get(Calendar.DAY_OF_WEEK) == 7)
            dayOfWeek = 6;
        else {
            dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 2;
        }
        mViewPager.setAdapter(new MyAdapter());
        mViewPager.setOnPageChangeListener(new MyListener());
        mViewPager.setCurrentItem(dayOfWeek);


    }

    public void setList(int dayOfWeek, ListView listview) {

//        FileDB dbHelper = new FileDB(this);
//        dbHelper.openDatabase();
//        myOpenHelper = new MySQLiteOpenHelper(this);
//        mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.DB_PATH + "/" + FileDB.DB_NAME, null);

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


        Cursor curChoose = mysql.rawQuery("select * from classes", null);
        while (curChoose.moveToNext()) {

            year = curChoose.getInt(1);
            programmeName = curChoose.getString(2);
            classesName = curChoose.getString(3);
        }

        y = String.valueOf(year);
        d = String.valueOf(dayOfWeek);
        if (programmeName != null) {

            Cursor cur = mysql.rawQuery("select * from timetables where year=? and programmeName=? and classesName=? " +
                    "and day=? order by no",
                    new String[]{y, programmeName, classesName, d});


            String day = "` ~", no = "` ~", name = "` ~", address = "` ~", time = "` ~", lecturer = "` ~", text = "` ~";
            if (cur != null) {
                while (cur.moveToNext()) {
                    day += cur.getInt(3) + "` ~";
                    no += cur.getInt(4) + "` ~";
                    name += cur.getString(5) + "` ~";
                    address += cur.getString(6) + "` ~";
                    time += cur.getString(7) + "` ~";
                    lecturer += cur.getString(8) + "` ~";
                    text += cur.getString(10) + "` ~";

                }

            }
            cur.close();


            dayarray = day.split("` ~");
            noarray = no.split("` ~");
            namearray = name.split("` ~");
            addressarray = address.split("` ~");
            timearray = time.split("` ~");
            lecturerarray = lecturer.split("` ~");
            textArray = text.split("` ~");


            listItem = new ArrayList<HashMap<String, Object>>();
            for (int i = 1; i < namearray.length; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("ItemName", namearray[i]);
                map.put("ItemNo", noarray[i]);
                map.put("ItemAddress", addressarray[i]);
                map.put("ItemTime", timearray[i]);
                map.put("ItemDay", dayarray[i]);
                map.put("ItemLecturer", lecturerarray[i]);
                map.put("ItemText", textArray[i]);
                listItem.add(map);
            }

            //生成适配器的Item和动态数组对应的元素
            listItemAdapter = new SimpleAdapter(this, listItem,//数据源
                    R.layout.user_list_cell,//ListItem的XML实现
                    //动态数组与ImageItem对应的子项
                    new String[]{"ItemName", "ItemAddress", "ItemTime", "ItemText"},
                    //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                    new int[]{R.id.tvModule, R.id.tvRoom, R.id.tvTime, R.id.textInfo}
            );

            //添加并且显示
            listview.setAdapter(listItemAdapter);
            listItemAdapter.notifyDataSetChanged();

            SimpleAdapter sAdapter = (SimpleAdapter) listview.getAdapter();
            sAdapter.notifyDataSetChanged();

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long i) {

                    listItemAdapter.notifyDataSetChanged();


                    ListView listView = (ListView) parent;
                    HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
                    String modulename = data.get("ItemName").toString();
                    String moduleno = data.get("ItemNo").toString();
                    String moduleday = data.get("ItemDay").toString();
                    String moduletime = data.get("ItemTime").toString();
                    String moduleroom = data.get("ItemAddress").toString();
                    String modulelecturer = data.get("ItemLecturer").toString();


                    Intent intent = new Intent(Main.this, ModuleInfo.class);
                    Bundle bundle = new Bundle();


                    bundle.putInt("year", year);
                    bundle.putString("programme", programmeName);
                    bundle.putString("classes", classesName);

                    bundle.putString("name", modulename);
                    bundle.putString("no", moduleno);
                    bundle.putString("day", moduleday);
                    bundle.putString("time", moduletime);
                    bundle.putString("address", moduleroom);
                    bundle.putString("lecturer", modulelecturer);

                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);

                }
            });

            curChoose.close();
        } else {
            Intent intent = new Intent();
            intent.setClass(Main.this, login.class);
            startActivity(intent);


        }


    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return super.getItemPosition(object);
        }

        public CharSequence getPageTitle(int position) {

            return titles.get(position);

        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            // TODO Auto-generated method stub
            //((ViewPager) arg0).removeView(list.get(arg1));
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            Log.d("instantiateItem", "" + arg0 + " " + arg1);
            try {
                if (views.get(arg1).getParent() == null)
                    ((ViewPager) arg0).addView(views.get(arg1), 0);
                else {
                    //  很难理解新添加进来的view会自动绑定一个父类，由于一个儿子view不能与两个父类相关，所以得解绑
                    //不这样做否则会产生 viewpager java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
// 还有一种方法是viewPager.setOffscreenPageLimit(3); 这种方法不用判断parent 是不是已经存在，但多余的listview不能被destroy
                    ((ViewGroup) views.get(arg1).getParent()).removeView(views.get(arg1));
                    ((ViewPager) arg0).addView(views.get(arg1), 0);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("parent=", "" + views.get(arg1).getParent());
                e.printStackTrace();
            }
            return views.get(arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public Parcelable saveState() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void finishUpdate(View arg0) {
            // TODO Auto-generated method stub

        }
    }


    class MyListener implements OnPageChangeListener {

        //当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub
            //arg0=arg0%list.size();

        }

        //当当前页面被滑动时调用
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        //当新的页面被选中时调用
        @Override
        public void onPageSelected(int arg0) {
            if (arg0 > 2) {
                arg0 = arg0 % views.size();
            }
            c_id = arg0;


            Log.e("-------------", "当前是第" + c_id + "页");
        }
    }

//    public  void find() {
//        myOpenHelper = new MySQLiteOpenHelper(this);
//        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
//            if (FileDB.f.exists())
//                mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.f, null);               //无论数据库在哪里创建都需要首先声明这句
//            else {
//                FileDB.create();
//                if (FileDB.fileflag) {
//                    mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.f, null);          //在sd卡创建数据库的语句1
//                    myOpenHelper.onCreate(mysql);                                       //在sd卡创建数据库的语句2
//                } else
//                    mysql = myOpenHelper.getReadableDatabase();
//            }
//        else
//            mysql = myOpenHelper.getReadableDatabase();
//        //可以换种思路，把数组放到set里面（set的值不会重复）就可以去重了
//        String test=null;String[] testArray=null;
//        Cursor  cur = mysql.rawQuery("select * from teachers",null);
//
//
//        if (cur != null) {
//
//            while (cur.moveToNext()) {
//
//                test += cur.getString(0)+ "` ~";;
//
//            }
//
//        }
//        cur.close();
//
//        testArray = test.split("` ~");
//
//
//        Set<String> set = new HashSet<String>();
//        for(String i : testArray)
//            set.add(i);
//        for(String s1 : set){          //遍历set
//            System.out.println();   //每遍历一次set值,做换行操作.
//            for(String s2 : testArray)      //遍历list
//                if(s1.equals(s2)){        //比较set和list中的值,获取到与s1值相同的s2
//                    //s2就是获取到的值.将s2放入数组,即可得到最终所需要的结果.
//                    System.out.print(s2 + " "+"AAAAAAAAAAAAAAAAAAAAAAAAAAA");//输出s2
//                }
//        }
//
//    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle("退出")
                    .setMessage("您确认要退出程序吗？")
                    .setPositiveButton("确定",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Main.this.finish(); // 关闭程序的核心方法
                                }
                            })
                    .setNegativeButton("取消",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();
                                }
                            }).show();
        }
        return false;
    }


    //处理 壁纸的选择对layout的设置

    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    protected void onPause() {
        // TODO Auto-generated method stub
        if (mysql.isOpen())
            mysql.close();
        super.onPause();
    }

}