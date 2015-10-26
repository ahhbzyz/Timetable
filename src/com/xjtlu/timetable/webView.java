package com.xjtlu.timetable;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dean Zhang on 13-9-22.
 */

public class webView extends Activity {
    private MySQLiteOpenHelper myOpenHelper;
    private SQLiteDatabase mysql; // 实例数据库
    private WebView wv;
    private String teacher;
    private AlertDialog alertDialog;
    private ProgressDialog progressBar;
    private String[] lecturerArray;
    private String realLecturer;
    String lecturer;
    Cursor cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.web_view);


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
        else {
            mysql = myOpenHelper.getReadableDatabase();
        }


        initWebView();

        // goBack()表示返回webView的上一页面


    }

    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {


            if (progressBar.isShowing()) {
                progressBar.dismiss();
            }


        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            Toast.makeText(webView.this, "网页加载出错！", Toast.LENGTH_LONG);

            alertDialog.setTitle("ERROR");
            alertDialog.setMessage(description);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                }
            });
            alertDialog.show();
        }

    }


    protected void initWebView() {
        //设计进度条


        //获得WebView组件
        wv = (WebView) this.findViewById(R.id.webView);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(0);
        WebSettings webSettings = wv.getSettings();
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setLoadWithOverviewMode(true);


        Bundle bundle = getIntent().getExtras();
        lecturer = bundle.getString("lecturer");

        cur = mysql.rawQuery("select url from teachers where teacher=?",
                new String[]{lecturer});


        if (cur != null) {

            while (cur.moveToNext()) {

                teacher = cur.getString(0);

            }

        }



        cur.close();

        if (teacher != null) {
            progressBar = ProgressDialog.show(webView.this, null, "正在进入网页，请稍后…");
            progressBar.setCancelable(true);
            wv.loadUrl(teacher);

        } else {
            progressBar = ProgressDialog.show(webView.this, null, "查无此人！");
            progressBar.setCancelable(true);

        }


        alertDialog = new AlertDialog.Builder(this).create();

        //设置视图客户端
        wv.setWebViewClient(new MyWebViewClient());
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        } else {
            finish();
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
        }

        return super.onKeyDown(keyCode, event);
    }


}