package com.xjtlu.timetable;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dean Zhang on 13-9-21.
 */

public class FileDB {

    public static File path = new File("/sdcard/xjtlu/data/");// 创建目录
    public static File f = new File("/sdcard/xjtlu/data/timetables.db");// 创建文件
    public static boolean fileflag = false;

    public static void create() {
        //System.out.println(" File create()"+android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED));
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {

            if (!path.exists()) { //创建数据库mysql如下操作：
                path.mkdirs();
                System.out.println("创建目录");
            }
            if (!f.exists()) { // 文件存在返回false
                try {
                    f.createNewFile();// 创建文件
                    fileflag = true;
                    System.out.println("创建文件");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("文件创建异常");
                }
            }
        }
    }
}


//package net.iyouyu.timetables;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Environment;
//import android.util.Log;
//
//
//public class FileDB {
//
//;private final int BUFFER_SIZE = 400000;
//    public static final String DB_NAME = "timetables.db"; //保存的数据库文件名
//  public static final String PACKAGE_NAME = "net.iyouyu.timetables";
//    public static final String DB_PATH = "/data"
//            + Environment.getDataDirectory().getAbsolutePath() + "/"
//            + PACKAGE_NAME;  //在手机里存放数据库的位置(/data/data/com.cssystem.activity/cssystem.db)
//
//
//    private SQLiteDatabase database;
//    private Context context;
//
//    public FileDB(Context context) {
//        this.context = context;
//    }
//
//    public SQLiteDatabase getDatabase() {
//return database;
//      }
//
//  public void setDatabase(SQLiteDatabase database) {
//      this.database = database;
//      }
//
//    public void openDatabase() {
//        System.out.println(DB_PATH + "/" + DB_NAME);
//        this.database = this.openDatabase(DB_PATH + "/" + DB_NAME);
//    }
//
//    private SQLiteDatabase openDatabase(String dbfile) {
//
//        try {
//            if (!(new File(dbfile).exists())) {
//                //判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
//                InputStream is = this.context.getResources().openRawResource(
//                        R.raw.timetables); //欲导入的数据库
//                FileOutputStream fos = new FileOutputStream(dbfile);
//                byte[] buffer = new byte[BUFFER_SIZE];
//                int count = 0;
//                while ((count = is.read(buffer)) > 0) {
//                    fos.write(buffer, 0, count);
//                }
//                fos.close();
//                is.close();
//            }
//
//            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile,null);
//            return db;
//
//        } catch (FileNotFoundException e) {
//            Log.e("Database", "File not found");
//            e.printStackTrace();
//        } catch (IOException e) {
//            Log.e("Database", "IO exception");
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void closeDatabase() {
//        this.database.close();
//
//    }
//}