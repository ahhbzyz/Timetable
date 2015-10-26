package com.xjtlu.timetable;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Dean Zhang on 13-9-21.
 */
public class extraInfo extends Activity {

    private EditText edText;
    private MySQLiteOpenHelper myOpenHelper;
    private SQLiteDatabase mysql;
    private Button confirm;
    private Button back;
    private int year;
    private String programme;
    private String classes;
    private String no;
    private String num = "";
    private String tmday;
    private int realno;


    public void onCreate(Bundle savedInstanceState) {
        System.out.println("进入onCreate");
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.edit_extrainfo);


        Bundle bundle = getIntent().getExtras();

        year = bundle.getInt("year");
        programme = bundle.getString("programme");
        classes = bundle.getString("classes");

        tmday = bundle.getString("day");
        no = bundle.getString("no");

//        FileDB dbHelper = new FileDB(this);
//        dbHelper.openDatabase();
//        myOpenHelper = new MySQLiteOpenHelper(this);
//        mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.DB_PATH + "/" + FileDB.DB_NAME, null);

        //*判断是否存在SD卡，如果存在就创建一个数据库文件
        myOpenHelper = new MySQLiteOpenHelper(this);
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            if (FileDB.f.exists())
                mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.f, null);               //无论数据库在哪里创建都需要首先声明这�?
            else {
                FileDB.create();
                if (FileDB.fileflag) {
                    mysql = SQLiteDatabase.openOrCreateDatabase(FileDB.f, null);          //在sd卡创建数据库的语�?
                    myOpenHelper.onCreate(mysql);                                       //在sd卡创建数据库的语�?
                } else
                    mysql = myOpenHelper.getReadableDatabase();
            }
        else
            mysql = myOpenHelper.getReadableDatabase();

        confirm = (Button) findViewById(R.id.confirm);
        back = (Button) findViewById(R.id.back);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edText = (EditText) findViewById(R.id.editText);
                num = edText.getText().toString();
                if ("".equals(edText.getText().toString().trim())) {
                    new AlertDialog.Builder(extraInfo.this)
                            .setCancelable(false)
                            .setIcon(android.R.drawable.btn_star)
                            .setTitle("注意")
                            .setMessage("请输入内容！")
                            .setPositiveButton("确定",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            dialog.cancel();
                                        }
                                    })
                            .setNegativeButton("取消",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            dialog.cancel();
                                        }
                                    }).show();

                } else {
                    addData(num);
                    InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    Toast.makeText(getApplicationContext(), "添加备注成功",
                            Toast.LENGTH_SHORT).show();
                    extraInfo.this.finish();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                extraInfo.this.finish();
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
            }
        });


    }

    public void addData(String num) {


        realno = Integer.parseInt(no);

        String info = "(备注)";

        mysql.execSQL("UPDATE timetables SET extraInfo='" + num + "' WHERE year=" + year + " " +
                "AND programmeName='" + programme + "' AND classesName = '" + classes + "' AND " +
                "day='" + tmday + "' AND no=" + realno + ";");
        mysql.execSQL("UPDATE timetables SET info='" + info + "' WHERE year=" + year + " " +
                "AND programmeName='" + programme + "' AND classesName = '" + classes + "' AND " +
                "day='" + tmday + "' AND no=" + realno + ";");
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // do something on back.
            extraInfo.this.finish();
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onPause() {
        // TODO Auto-generated method stub
        if (mysql.isOpen())
            mysql.close();
        super.onPause();
    }

}
