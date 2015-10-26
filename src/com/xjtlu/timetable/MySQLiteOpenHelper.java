package com.xjtlu.timetable;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dean Zhang on 13-9-21.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public final static int VERSION = 1;// 版本号
    public final static String TABLE_NAME = "timetables";// 表名
    public final static String TABLE_NAME2 = "classes";// 表名2
    public final static String TABLE_NAME3 = "teachers";// 表名3

    public final static String Day = "day";// 后面ContentProvider使用
    public final static String Year = "year";
    public final static String ClassesName = "classesName";
    public final static String ProgrammeName = "programmeName";

    public final static String ExtraInfo = "extraInfo";
    public final static String Info = "info";


    public final static String Year2 = "year2";
    public final static String ClassesName2 = "classesName2";
    public final static String ProgrammeName2 = "programmeName2";


    public final static String No = "no";
    public final static String Id = "id";
    public final static String Name = "name";
    public final static String Address = "address";
    public final static String Time = "time";
    public final static String Lecturer = "lecturer";

    public final static String Teacher = "teacher";
    public final static String Url = "url";


    public static final String DATABASE_NAME = "timetables.db";
    public static SQLiteDatabase mysql;

    public MySQLiteOpenHelper(Context context) {
        // 在Android 中创建和打开一个数据库都可以使用openOrCreateDatabase 方法来实现，
        // 因为它会自动去检测是否存在这个数据库，如果存在则打开，不过不存在则创建一个数据库；
        // 创建成功则返回一个 SQLiteDatabase对象，否则抛出异常FileNotFoundException。
        // 下面是来创建一个名为"DATABASE_NAME"的数据库，并返回一个SQLiteDatabase对象

        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    // 在数据库第一次生成的时候会调用这个方法，一般我们在这个方法里边生成数据库表;
    public void onCreate(SQLiteDatabase db) {



        if (!this.tableis(db, TABLE_NAME)) {


            String str_sql = "CREATE TABLE " +
                    TABLE_NAME + "(" + Year + " INTEGER," + ProgrammeName + " TEXT," + ClassesName + " TEXT," + Day
                    + " INTEGER," + No + " INTEGER," + Name + " text," + Address + " text," + Time + " text," + Lecturer + " text," + ExtraInfo + " TEXT," + Info + " TEXT);";

            // CREATE TABLE 创建一张表 然后后面是我们的表名
            // 然后表的列，第一个是id 方便操作数据,int类型
            // PRIMARY KEY 是指主键 这是一个int型,用于唯一的标识一行;
            // AUTOINCREMENT 表示数据库会为每条记录的key加一，确保记录的唯一性;
            // 最后我加入一列文本 String类型
            // 注意：这里str_sql是sql语句，注意空格！

            //Y3-ENV-A Automatic Subgroup

            db.execSQL(str_sql);
            db.beginTransaction();




//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

            //Y2-FMA-A1
            onInsert(db, 2, "FMA", "A1", 1, 1, "MAN105 Tutorial", "BA418", "10:00-11:00", "Peng H.", "", " ");
            onInsert(db, 2, "FMA", "A1", 1, 2, "MTH105 Lecture", "SC169", "13:00-16:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A1", 2, 1, "ECO109 Tutorial, Fortnightly", "BA418", "10:00-11:00", "Kong X.", "", " ");
            onInsert(db, 2, "FMA", "A1", 2, 2, "MTH103 Lecture", "SC176", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A1", 2, 3, "EAP101 Seminar", "SD254", "15:00-17:00", "Hsu C.", "", " ");
            onInsert(db, 2, "FMA", "A1", 3, 1, "ACF103 Lecture", "SC176", "09:00-11:00", "Huang J., Zhang N.", "", " ");
            onInsert(db, 2, "FMA", "A1", 3, 2, "ECO109 Lecture", "SA169", "11:00-13:00", "Xu J., Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A1", 4, 1, "ACF103 Tutorial", "BA205", "10:00-11:00", "Argyris A.", "", " ");
            onInsert(db, 2, "FMA", "A1", 4, 2, "MTH103 Comp. Lab", "SD546", "11:00-12:00", "Dixon N.", "", " ");
            onInsert(db, 2, "FMA", "A1", 4, 3, "EAP101 Seminar", "SD254", "14:00-16:00", "Hsu C.", "", " ");
            onInsert(db, 2, "FMA", "A1", 5, 1, "MTH105 Tutorial", "SB152", "10:00-11:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A1", 5, 2, "MAN105 Lecture", "SA169", "11:00-13:00", "Cai Y., Batmanghlich C., Davies D.", "", " ");

            //Y2-FMA-A2
            onInsert(db, 2, "FMA", "A2", 1, 1, "MAN105 Tutorial", "BA418", "10:00-11:00", "Peng H.", "", " ");
            onInsert(db, 2, "FMA", "A2", 1, 2, "MTH105 Lecture", "SC169", "13:00-16:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A2", 2, 1, "ECO109 Tutorial, Fortnightly", "BA418", "10:00-11:00", "Xu J.", "", " ");
            onInsert(db, 2, "FMA", "A2", 2, 2, "MTH103 Lecture", "SC176", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A2", 2, 3, "EAP101 Seminar", "SC454", "14:00-16:00", "Critchley S.", "", " ");
            onInsert(db, 2, "FMA", "A2", 3, 1, "ACF103 Lecture", "SC176", "09:00-11:00", "Huang J., Zhang N.", "", " ");
            onInsert(db, 2, "FMA", "A2", 3, 2, "ECO109 Lecture", "SA169", "11:00-13:00", "Xu J., Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A2", 4, 1, "ACF103 Tutorial", "BA205", "10:00-11:00", "Argyris A.", "", " ");
            onInsert(db, 2, "FMA", "A2", 4, 2, "MTH103 Comp. Lab", "SD546", "11:00-12:00", "Dixon N.", "", " ");
            onInsert(db, 2, "FMA", "A2", 4, 3, "EAP101 Seminar", "SC454", "13:00-15:00", "Critchley S.", "", " ");
            onInsert(db, 2, "FMA", "A2", 5, 1, "MTH105 Tutorial", "SB152", "10:00-11:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A2", 5, 2, "MAN105 Lecture", "SA169", "11:00-13:00", "Cai Y., Batmanghlich C., Davies D.", "", " ");
            // Y2-FMA-A3
            onInsert(db, 2, "FMA", "A3", 1, 1, "MTH105 Lecture", "SC169", "13:00-16:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A3", 2, 1, "MTH103 Lecture", "SC176", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A3", 2, 2, "EAP101 Seminar", "SD354", "14:00-16:00", "Li T.", "", " ");
            onInsert(db, 2, "FMA", "A3", 2, 3, "ACF103 Tutorial", "BA205", "16:00-17:00", "Argyris A.", "", " ");
            onInsert(db, 2, "FMA", "A3", 3, 1, "ACF103 Lecture", "SC176", "09:00-11:00", "Huang J., Zhang N.", "", " ");
            onInsert(db, 2, "FMA", "A3", 3, 2, "ECO109 Lecture", "SA169", "11:00-13:00", "Xu J., Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A3", 4, 1, "ECO109 Tutorial", "BA105", "09:00-10:00", "Xu J.", "", " ");
            onInsert(db, 2, "FMA", "A3", 4, 2, "MAN105 Tutorial", "BA105", "10:00-11:00", "Pak D.", "", " ");
            onInsert(db, 2, "FMA", "A3", 4, 3, "MTH103 Comp. Lab", "SD546", "11:00-12:00", "New staff", "", " ");
            onInsert(db, 2, "FMA", "A3", 5, 1, "MTH105 Tutorial", "SB152", "10:00-11:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A3", 5, 2, "MAN105 Lecture", "SA169", "11:00-13:00", "Cai Y., Batmanghlich C., Davies D.", "", " ");
            onInsert(db, 2, "FMA", "A3", 5, 3, "EAP101 Seminar", "SD354", "15:00-17:00", "Li T.", "", " ");

            //Y2-FMA-A4
            onInsert(db, 2, "FMA", "A4", 1, 1, "MTH105 Lecture", "SC169", "13:00-16:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A4", 2, 1, "MTH103 Lecture", "SC176", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A4", 2, 2, "EAP101 Seminar", "SC336", "14:00-16:00", "Tyers E.", "", " ");
            onInsert(db, 2, "FMA", "A4", 2, 3, "ACF103 Tutorial", "BA205", "16:00-17:00", "Argyris A.", "", " ");
            onInsert(db, 2, "FMA", "A4", 3, 1, "ACF103 Lecture", "SC176", "09:00-11:00", "Huang J., Zhang N.", "", " ");
            onInsert(db, 2, "FMA", "A4", 3, 2, "ECO109 Lecture", "SA169", "11:00-13:00", "Xu J., Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A4", 4, 1, "ECO109 Tutorial", "BA105", "09:00-10:00", "Xu J.", "", " ");
            onInsert(db, 2, "FMA", "A4", 4, 2, "MAN105 Tutorial", "BA105", "10:00-11:00", "Pak D.", "", " ");
            onInsert(db, 2, "FMA", "A4", 4, 3, "MTH103 Comp. Lab", "SD546", "11:00-12:00", "New staff", "", " ");
            onInsert(db, 2, "FMA", "A4", 4, 4, "EAP101 Seminar", "SC336", "13:00-15:00", "Tyers E.", "", " ");
            onInsert(db, 2, "FMA", "A4", 5, 1, "MTH105 Tutorial", "SB152", "10:00-11:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A4", 5, 2, "MAN105 Lecture", "SA169", "11:00-13:00", "Cai Y., Batmanghlich C., Davies D.", "", " ");

            //Y2-FMA-A5
            onInsert(db, 2, "FMA", "A5", 1, 1, "EAP101 Seminar", "SC279", "11:00-13:00", "Pandavar A.", "", " ");
            onInsert(db, 2, "FMA", "A5", 2, 1, "ECO109 Tutorial, Fortnightly", "BA418", "10:00-11:00", "Xu J.", "", " ");
            onInsert(db, 2, "FMA", "A5", 2, 2, "MTH103 Lecture", "SC176", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A5", 2, 3, "MTH105 Lecture", "SC169", "13:00-16:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A5", 2, 4, "ACF103 Tutorial", "BA205", "16:00-17:00", "Argyris A.", "", " ");
            onInsert(db, 2, "FMA", "A5", 3, 1, "ACF103 Lecture", "SC176", "09:00-11:00", "Huang J., Zhang N.", "", " ");
            onInsert(db, 2, "FMA", "A5", 3, 2, "ECO109 Lecture", "SA169", "11:00-13:00", "Xu J., Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A5", 4, 1, "MAN105 Tutorial", "BA109", "10:00-11:00", "Xun J.", "", " ");
            onInsert(db, 2, "FMA", "A5", 4, 2, "MTH103 Comp. Lab", "SD546", "11:00-12:00", "New staff", "", " ");
            onInsert(db, 2, "FMA", "A5", 4, 3, "EAP101 Seminar", "SC279", "13:00-15:00", "Pandavar A.", "", " ");
            onInsert(db, 2, "FMA", "A5", 5, 1, "MTH105 Tutorial", "SB152", "10:00-11:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A5", 5, 2, "MAN105 Lecture", "SA169", "11:00-13:00", "Cai Y., Batmanghlich C., Davies D.", "", " ");


            //Y2-FMA-A6
            onInsert(db, 2, "FMA", "A6", 1, 1, "ACF103 Lecture", "SA169", "16:00-18:00", "Huang J., Zhang N.", "", " ");
            onInsert(db, 2, "FMA", "A6", 2, 1, "EAP101 Seminar", "SC279", "09:00-11:00", "Nield S.", "", " ");
            onInsert(db, 2, "FMA", "A6", 2, 2, "MTH103 Lecture", "SC176", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A6", 2, 3, "MTH105 Lecture", "SC169", "13:00-16:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A6", 3, 1, "ECO109 Lecture", "SA169", "11:00-13:00", "Xu J., Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A6", 4, 1, "ECO109 Tutorial, Fortnightly", "BA105", "09:00-10:00", "Xu J.", "", " ");
            onInsert(db, 2, "FMA", "A6", 4, 2, "MAN105 Tutorial", "BA109", "10:00-11:00", "Xun J.", "", " ");
            onInsert(db, 2, "FMA", "A6", 4, 3, "MTH103 Comp. Lab", "SD546", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A6", 4, 4, "EAP101 Seminar", "SC279", "15:00-17:00", "Nield S.", "", " ");
            onInsert(db, 2, "FMA", "A6", 5, 1, "MTH105 Tutorial", "SB152", "10:00-11:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A6", 5, 2, "MAN105 Lecture", "SA169", "11:00-13:00", "Cai Y., Batmanghlich C., Davies D.", "", " ");
            onInsert(db, 2, "FMA", "A6", 5, 3, "ACF103 Tutorial", "BA318", "14:00-15:00", "Argyris A.", "", " ");

            //Y2-FMA-A7
            onInsert(db, 2, "FMA", "A7", 1, 1, "EAP101 Seminar", "SC464", "14:00-16:00", "Nield S.", "", " ");
            onInsert(db, 2, "FMA", "A7", 1, 1, "ACF103 Lecture", "SA169", "16:00-18:00", "Huang J., Zhang N.", "", " ");
            onInsert(db, 2, "FMA", "A7", 2, 1, "MTH103 Lecture", "SC176", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A7", 2, 2, "MTH105 Lecture", "SC169", "13:00-16:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A7", 3, 1, "ECO109 Lecture", "SA169", "11:00-13:00", "Xu J., Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A7", 4, 1, "MTH103 Comp. Lab", "SD554", "11:00-12:00", "Liu D.", "", " ");
            onInsert(db, 2, "FMA", "A7", 4, 2, "MAN105 Tutorial", "BA109", "12:00-13:00", "Goldsborough A.", "", " ");
            onInsert(db, 2, "FMA", "A7", 4, 3, "EAP101 Seminar", "SC464", "15:00-17:00", "Tyers E.", "", " ");
            onInsert(db, 2, "FMA", "A7", 5, 1, "ECO109 Tutorial, Fortnightly", "BA318", "09:00-10:00", "Fang E.", "", " ");
            onInsert(db, 2, "FMA", "A7", 5, 2, "MTH105 Tutorial", "SB152", "10:00-11:00", "Cariolaro D.", "", " ");
            onInsert(db, 2, "FMA", "A7", 5, 3, "MAN105 Lecture", "SA169", "11:00-13:00", "Cai Y., Batmanghlich C., Davies D.", "", " ");
            onInsert(db, 2, "FMA", "A7", 5, 4, "ACF103 Tutorial", "BA318", "14:00-15:00", "Argyris A.", "", " ");




//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


            db.setTransactionSuccessful();
            db.endTransaction();


        }


        if (!this.tableis(db, TABLE_NAME2)) {
            String str_sql = "CREATE TABLE " +
                    TABLE_NAME2 + "(" + Id + " INTEGER primary key, " + Year2 + " INTEGER," + ProgrammeName2 + " TEXT," + ClassesName2 + " TEXT);";

            // CREATE TABLE 创建一张表 然后后面是我们的表名
            // 然后表的列，第一个是id 方便操作数据,int类型
            // PRIMARY KEY 是指主键 这是一个int型,用于唯一的标识一行;
            // AUTOINCREMENT 表示数据库会为每条记录的key加一，确保记录的唯一性;
            // 最后我加入一列文本 String类型
            // 注意：这里str_sql是sql语句，注意空格！

            db.execSQL(str_sql);
            db.execSQL("INSERT INTO " + TABLE_NAME2 + " VALUES(" + 1 + ",null,null,null);");

        }


        if (!this.tableis(db, TABLE_NAME3)) {
            String str_sql = "CREATE TABLE " +
                    TABLE_NAME3 + "(" + Teacher + " INTEGER," + Url + " TEXT);";

            // CREATE TABLE 创建一张表 然后后面是我们的表名
            // 然后表的列，第一个是id 方便操作数据,int类型
            // PRIMARY KEY 是指主键 这是一个int型,用于唯一的标识一行;
            // AUTOINCREMENT 表示数据库会为每条记录的key加一，确保记录的唯一性;
            // 最后我加入一列文本 String类型
            // 注意：这里str_sql是sql语句，注意空格！

            db.execSQL(str_sql);
            //CCT
            onInsertTeacher(db,"Jia W.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/545-jiawei.html");
            onInsertTeacher(db,"Xu H.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/272-xu-haiyan.html");
            onInsertTeacher(db,"Zhan J.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/547-zhanjingqiu.html");
            onInsertTeacher(db,"Xie B.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/271-xie-bo.html");

            //math center
            onInsertTeacher(db,"Zhang R.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/747-zhang-rui.html");
            onInsertTeacher(db,"Wu X.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/658-wu-xionghua.html");
            onInsertTeacher(db,"Kong X.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/657-kong-xianfen.html");
            onInsertTeacher(db,"MPC - Liang H.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/613-liang-haixia.html");
            onInsertTeacher(db,"Fei J.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/611-fei-jie.html");
            onInsertTeacher(db,"Zhu A.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/266-zhu-annie.html");
            onInsertTeacher(db,"Zhang D.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/265-zhang-dongen.html");
            onInsertTeacher(db,"Ying M.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/263-ying-ming.html");
            onInsertTeacher(db,"Yan L.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/261-yan-li.html");
            onInsertTeacher(db,"Xiong H.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/260-xiong-hongyun.html");
            onInsertTeacher(db,"Xie G.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/259-xie-guorui.html");
            onInsertTeacher(db,"MPC - Wang Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/256-wang-yinglin.html");
            onInsertTeacher(db,"Niu Q.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/254-niu-qiang.html");
            onInsertTeacher(db,"Liu L.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/253-liu-liying.html");
            onInsertTeacher(db,"Liu G.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/252-liu-gang.html");
            onInsertTeacher(db,"Han Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/250-han-yunrui.html");
            onInsertTeacher(db,"Guo J.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/249-guo-jingming.html");

            //PE
            onInsertTeacher(db,"Zhao P.","http://www.xjtlu.edu.cn/cn/faculty-zh/first-year-teaching-staff-zh/item/248-zhao-peng.html");

            //LC
            onInsertTeacher(db,"Rotsinger A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/489-rotsinger-aaron.html");
            onInsertTeacher(db,"O Shea A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/466-oshea-alyson.html");
            onInsertTeacher(db,"Campbell A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/763-campbell-anastasia.html");
            onInsertTeacher(db,"Haywood A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/461-haywood-andy.html");
            onInsertTeacher(db,"Snyder A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/195-snyder-andy.html");
            onInsertTeacher(db,"Kaczor A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/481-kaczor-aneta.html");
            onInsertTeacher(db,"Pandavar A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/472-pandavar-anjuli.html");
            onInsertTeacher(db,"Brantingham A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/486-brantingham-ann.html");
            onInsertTeacher(db,"Fogarty A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/655-fogarty-anthony.html");
            onInsertTeacher(db,"Steward A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/566-steward-anthony-r-m.html");
            onInsertTeacher(db,"Paterson A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/496-paterson-antonia.html");
            onInsertTeacher(db,"Wang A.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/492-wang-anying.html");

            onInsertTeacher(db,"Zou B.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/190-zou-bin.html");


            onInsertTeacher(db,"Ridyard C.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/750-ridyard-carly.html");
            onInsertTeacher(db,"Li C.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/580-li-chengcheng.html");
            onInsertTeacher(db,"Gruce C.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/949-gruce-christopher.html");

            onInsertTeacher(db,"Burke D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/184-burke-dan.html");
            onInsertTeacher(db,"Fryatt D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/762-fryatt-david.html");
            onInsertTeacher(db,"Munn D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/797-munn-david.html");
            onInsertTeacher(db,"Markus D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/958-davis-markus.html");
            onInsertTeacher(db,"Jones D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/579-jones-debra.html");
            onInsertTeacher(db,"Tyler D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/153-tyler-denis-w.html");
            onInsertTeacher(db,"Delany D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/204-delany-dennis.html");
            onInsertTeacher(db,"Goin D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/953-goin-denny.html");
            onInsertTeacher(db,"Meyer D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/749-meyer-donald.html");
            onInsertTeacher(db,"Mackinnon D.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/164-mackinnon-douglas-e.html");

            onInsertTeacher(db,"Liu E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/165-liu-ediyanto.html");
            onInsertTeacher(db,"Chwa E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/572-chwa-ee-loon.html");
            onInsertTeacher(db,"Tyers E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/495-tyers-eleanor-a.html");
            onInsertTeacher(db,"Stockham E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/155-stockham-elizabeth.html");
            onInsertTeacher(db,"Touchstone E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/754-touchstone-ellen.html");
            onInsertTeacher(db,"Hayes E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/957-hayes-emer.html");
            onInsertTeacher(db,"O brien E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/198-obrien-eoghan.html");
            onInsertTeacher(db,"Jordan E.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/509-jordan-eoin-p.html");

            onInsertTeacher(db,"Li F.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/166-li-fan.html");
            onInsertTeacher(db,"Wang F.","http://www.xjtlu.edu.cn/en/faculty/academic-support-team/item/571-wang-fang.html");
            onInsertTeacher(db,"Cao F.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/493-cao-feng.html");
            onInsertTeacher(db,"Lal F.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/784-lal-fiona.html");

            onInsertTeacher(db,"Morris G.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/465-morris-gareth.html");
            onInsertTeacher(db,"Thornberry G.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/513-thornberry-george.html");
            onInsertTeacher(db,"Boyle G.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/490-boyle-gerard.html");
            onInsertTeacher(db,"Cotten G.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/475-cotten-glen.html");
            onInsertTeacher(db,"Molinero G.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/494-molinero-gloria.html");


            onInsertTeacher(db,"Lal H.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/773-lal-hans.html");
            onInsertTeacher(db,"Gasking H.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/752-gasking-helen.html");
            onInsertTeacher(db,"Hu H.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/174-hu-hongmei.html");

            onInsertTeacher(db,"Moore I.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/464-moore-lan.html");

            onInsertTeacher(db,"Parkinson J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/508-parkinson-jack.html");
            onInsertTeacher(db,"Hemingway J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/476-hemingway-jackie.html");
            onInsertTeacher(db,"Banki J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/186-banki-jacqueline.html");
            onInsertTeacher(db,"Lee J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/479-lee-james.html");
            onInsertTeacher(db,"Wilson J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/772-wilson-james.html");
            onInsertTeacher(db,"Roebuck J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/755-roebuck-james.html");
            onInsertTeacher(db,"LC - Xu J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/148-xu-jianing.html");
            onInsertTeacher(db,"Wu J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/583-wu-jinling.html");
            onInsertTeacher(db,"Ma J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/211-ma-jinying.html");
            onInsertTeacher(db,"Russell J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/565-russell-joel.html");
            onInsertTeacher(db,"Coffey J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/181-coffey-john-anthony.html");
            onInsertTeacher(db,"English J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/480-english-jonathan.html");
            onInsertTeacher(db,"Savery J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/157-savery-jonathan.html");
            onInsertTeacher(db,"Williams J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/656-williams-julianne.html");
            onInsertTeacher(db,"Scott J.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/756-scott-june.html");

            onInsertTeacher(db,"O Toole K.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/587-otoole-karen.html");
            onInsertTeacher(db,"Reimer K.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/484-reimer-kristin.html");

            onInsertTeacher(db,"Shelmerdine L.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/478-shelmerdine-layla.html");
            onInsertTeacher(db,"Shelmerdine Lee.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/467-shelmerdine-lee.html");
            onInsertTeacher(db,"Ni G.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/199-ni-grace.html");
            onInsertTeacher(db,"Harrison L.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/785-harrison-lucy-j.html");

            onInsertTeacher(db,"Gardiner M.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/473-gardiner-marion.html");
            onInsertTeacher(db,"Coyle M.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/180-coyle-mark-f-j.html");
            onInsertTeacher(db,"Krugman M.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/771-krugman-mark.html");
            onInsertTeacher(db,"Warrick M.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/152-warrick-michael.html");
            onInsertTeacher(db,"Zhang M.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/753-zhang-rainie-minghao.html");
            onInsertTeacher(db,"Johnson M.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/170-johnson-murray-krimmer.html");

            onInsertTeacher(db,"Martin N.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/463-martin-nakisha.html");
            onInsertTeacher(db,"Meintjes N.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/160-natalie-meintjes.html");
            onInsertTeacher(db,"Bostock N.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/514-bostock-nicholas-a.html");
            onInsertTeacher(db,"Dixon N.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/178-dixon-nigel-j.html");
            onInsertTeacher(db,"McIntosh N.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/497-mcintosh-nicholas.html");

            onInsertTeacher(db,"Walsholan O.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/144-walsholan.html");

            onInsertTeacher(db,"Brown P.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/757-brown-pamela.html");
            onInsertTeacher(db,"Smit P.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/952-smit-paul.html");
            onInsertTeacher(db,"Xing P.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/149-xing-peiling.html");
            onInsertTeacher(db,"McConnell P.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/163-mcconnell-peter-john.html");

            onInsertTeacher(db,"Hughes R.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/758-hughes-ralph.html");
            onInsertTeacher(db,"Davis R.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/215-davis-raymond-f.html");
            onInsertTeacher(db,"Kirchner R.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/168-kirchner-renate-e.html");
            onInsertTeacher(db,"Bradford R.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/207-bradford-richard.html");
            onInsertTeacher(db,"Green R.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/175-green-richard-a-r.html");
            onInsertTeacher(db,"Edwards R.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/590-edwards-roy.html");

            onInsertTeacher(db,"Ng S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/470-ng-samantha.html");
            onInsertTeacher(db,"Arulanandam S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/462-arulanandam-santha-devi.html");
            onInsertTeacher(db,"Hartigan S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/759-hartigan-seth.html");
            onInsertTeacher(db,"Ireland S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/203-ireland-shendon-j.html");
            onInsertTeacher(db,"Zhou S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/584-zhou-sijia.html");
            onInsertTeacher(db,"Deng S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/540-deng-shu.html");
            onInsertTeacher(db,"Jeaco S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/146-jeaco-steve.html");
            onInsertTeacher(db,"Critchley S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/483-critchley-stephen-mark.html");
            onInsertTeacher(db,"Bateman S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/578-bateman-steven.html");
            onInsertTeacher(db,"Nield S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/469-nield-stewart.html");
            onInsertTeacher(db,"Donaldson S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/760-donaldson-tuart.html");
            onInsertTeacher(db,"Perrin S.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/742-perrin-stuart.html");

            onInsertTeacher(db,"Greatrex T.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/955-greatrex-terry.html");
            onInsertTeacher(db,"Casteling T.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/488-casteling-timothy.html");
            onInsertTeacher(db,"Wallis T.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/956-wallis-tim.html");
            onInsertTeacher(db,"Li T.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/154-li-ting.html");

            onInsertTeacher(db,"Peng W.H.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/197-peng-wangheng.html");
            onInsertTeacher(db,"Peng W.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/468-peng-way-sit.html");
            onInsertTeacher(db,"Guo W.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/761-guo-wei-gwen.html");
            onInsertTeacher(db,"Chu W.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/950-chu-weiyi.html");
            onInsertTeacher(db,"Zhang W.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/147-zhang-wei.html");
            onInsertTeacher(db,"Hsu W.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/471-hsu-wen-cheng.html");

            onInsertTeacher(db,"Wang X.","http://www.xjtlu.edu.cn/en/faculty/academic-support-team/item/570-wang-xixi.html");

            onInsertTeacher(db,"Pierce W. G.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/158-pierce-william-glenn.html");

            onInsertTeacher(db,"Shen X.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/559-shen-xuanying.html");
            onInsertTeacher(db,"Xu X.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/487-xu-xuelian.html");


            onInsertTeacher(db,"Si Y.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/951-si-yanfang.html");
            onInsertTeacher(db,"Xu Y.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/519-xu-yang.html");
            onInsertTeacher(db,"Xiong Y.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/518-xiong-yimei.html");
            onInsertTeacher(db,"Hu Y.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/173-hu-yuan.html");
            onInsertTeacher(db,"Zhang Y.","http://www.xjtlu.edu.cn/en/faculty/language-centre-team/item/959-zhang-yuren.html");


            //BIO
            onInsertTeacher(db,"Sun T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/887-sun-tao.html");
            onInsertTeacher(db,"Liu H.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/879-liu-hebin.html");
            onInsertTeacher(db,"David O.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/573-david-oconnor.html");
            onInsertTeacher(db,"Tsigkou A.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/285-anastasia-tsigkou-zh.html");
            onInsertTeacher(db,"Han G.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/284-han-guoxia-zh.html");
            onInsertTeacher(db,"Liu J.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/283-liu-jian.html");
            onInsertTeacher(db,"Lu Z.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/282-lu-zhiliang.html");
            onInsertTeacher(db,"Lee M. H.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/281-meng-huee-lee.html");
            onInsertTeacher(db,"Rong R.","http://www.xjtlu.edu.cn//cn/faculty-zh/subject-staff-zh/item/280-rong-rong.html");
            onInsertTeacher(db,"Raju S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/279-raju-sekar.html");
            onInsertTeacher(db,"Kadowaki T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/277-tatsuhiko-kadowaki.html");
            onInsertTeacher(db,"Wang M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/275-wang-minyan.html");
            onInsertTeacher(db,"BIO - Zhang J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/273-zhang-junlong.html");

            //Bussiness
            onInsertTeacher(db,"Jiang Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/903-jiang-yue.html");
            onInsertTeacher(db,"Lim T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/891-lim-thian-cheng.html");
            onInsertTeacher(db,"Fu H.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/885-fu-haifeng.html");
            onInsertTeacher(db,"BUS - Xu J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/868-xu-junqian.html");
            onInsertTeacher(db,"Yang B.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/863-yang_bo.html");
            onInsertTeacher(db,"Xun J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/815-xun_jiyao.html");
            onInsertTeacher(db,"Hack-Polay D.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/814-dieu-hack-polay.html");
            onInsertTeacher(db,"Bao C.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/796-bao-chanzi.html");
            onInsertTeacher(db,"Yang Carol","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/746-yang-chi-yih-carol.html");
            onInsertTeacher(db,"Davies D.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/727-doug_davies.html");
            onInsertTeacher(db,"Fang E.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/725-eddy-s-fang.html");
            onInsertTeacher(db,"Freire T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/722-freire_tiago.html");
            onInsertTeacher(db,"Qian L.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/711-qian_lixian.html");
            onInsertTeacher(db,"Cheng P.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/593-cheng-peng.html");
            onInsertTeacher(db,"Liu S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/582-liu_sun.html");
            onInsertTeacher(db,"Chen Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/577-chen_yang.html");
            onInsertTeacher(db,"Zhang N.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/568-zhang_ning.html");
            onInsertTeacher(db,"Liu Z.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/563-liu_zheng.html");
            onInsertTeacher(db,"Ye Q.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/557-ye_qing.html");
            onInsertTeacher(db,"Sun Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/534-sun_yan.html");
            onInsertTeacher(db,"Cai Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/528-yujie_cai.html");
            onInsertTeacher(db,"Liao Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/527-yingying_liao.html");
            onInsertTeacher(db,"Hong Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/453-hong_yi.html");
            onInsertTeacher(db,"Rudkin S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/432-simon_rudkin.html");
            onInsertTeacher(db,"Zuo L.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/309-zuo-lingyan.html");
            onInsertTeacher(db,"Salike N.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/303-salike-nimesh.html");
            onInsertTeacher(db,"Regis P.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/302-regis-paulo.html");
            onInsertTeacher(db,"Priede M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/301-priede-martins.html");
            onInsertTeacher(db,"Pei D.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/300-pei-donglin.html");
            onInsertTeacher(db,"Huang J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/297-huang-jing.html");
            onInsertTeacher(db,"Ding X.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/296-ding-xiaoming.html");
            onInsertTeacher(db,"Chong W.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/294-chong-woon-kian-tristan.html");
            onInsertTeacher(db,"Cheong C.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/293-cheong-chongcheul.html");
            onInsertTeacher(db,"Cao X.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/290-cao-xuanwei.html");
            onInsertTeacher(db,"Pak D.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/287-ah-pak-donald-h.html");
            onInsertTeacher(db,"Tao J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/293-cheong-chongcheul.html");

            //Uban planning
            onInsertTeacher(db,"Pernice R.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/708-raffaele-pernice.html");
            onInsertTeacher(db,"Cocks M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/644-matthew-anthony-cocks.html");
            onInsertTeacher(db,"Kim J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/598-kim-joon-sik.html");
            onInsertTeacher(db,"Kiddle R.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/597-kiddle-rebecca-frances.html");
            onInsertTeacher(db,"Zhong S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/596-zhong-sheng.html");
            onInsertTeacher(db,"Zhang X.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/340-zhang-xiaonan.html");
            onInsertTeacher(db,"CDE - Wang Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/339-wang-yiwen.html");
            onInsertTeacher(db,"Verdini G.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/338-verdini-giulio.html");
            onInsertTeacher(db,"Karki T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/337-karki-tej-kumar.html");
            onInsertTeacher(db,"Chen B.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/336-chen-bing.html");
            onInsertTeacher(db,"Chang Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/335-chang-ying.html");

            //Tumu
            onInsertTeacher(db,"Bao Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/692-yuanfeng-bao.html");
            onInsertTeacher(db,"Krevaikas T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/690-theofanis-krevaikas.html");
            onInsertTeacher(db,"Zhang C","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/686-cheng-zhang.html");
            onInsertTeacher(db,"Chin C.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/638-chee-seong-chin.html");
            onInsertTeacher(db,"Jensen J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/636-joergen-lauritzen-jensen.html");
            onInsertTeacher(db,"Zhang C.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/618-cheng-zhang.html");
            onInsertTeacher(db,"Tang K.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/348-tang-kangkang.html");
            onInsertTeacher(db,"Steve M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/347-steve-millard.html");
            onInsertTeacher(db,"Wilkinson S. P","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/346-stephen-wilkinson.html");
            onInsertTeacher(db,"Gu S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/345-sai-gu.html");
            onInsertTeacher(db,"Pan J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/344-pan-jinsheng.html");
            onInsertTeacher(db,"Nanayakkara O.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/343-ominda-nanayakkara.html");
            onInsertTeacher(db,"Papadikis K.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/342-konstantinos-papadikis.html");

            //CSE

            onInsertTeacher(db,"Ross P.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/606-ross-paul.html");
            onInsertTeacher(db,"CSE - Liang H.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/605-liang-hai-ning.html");
            onInsertTeacher(db,"Fleming C.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/603-fleming-charles.html");
            onInsertTeacher(db,"Yuen K.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/539-yuen-kevin-kam-fung.html");
            onInsertTeacher(db,"Zhang B.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/359-zhangbailing.html");
            onInsertTeacher(db,"Wan K.Y","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/357-wan-kaiyu.html");
            onInsertTeacher(db,"Emmanuel M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/356-tadjouddine-emmanuel-m.html");
            onInsertTeacher(db,"Lv W.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/353-lu-wenjin.html");
            onInsertTeacher(db,"Li G.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/352-li-gangmin.html");
            onInsertTeacher(db,"Guan S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/350-guan-steven-sheng-uei.html");

            //EEE

            onInsertTeacher(db,"Huang K.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/900-huang-kaizhu.html");
            onInsertTeacher(db,"Lam S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/898-lam-sang.html");
            onInsertTeacher(db,"Wen H.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/896-wen-huiqing.html");
            onInsertTeacher(db,"Yu L.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/895-yu-limin.html");
            onInsertTeacher(db,"Tayahi M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/696-tayahi-moncef.html");
            onInsertTeacher(db,"Qian K.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/607-kejun-qian.html");
            onInsertTeacher(db,"Zhao C.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/376-zhao-cezhou.html");
            onInsertTeacher(db,"EEE - Zhang J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/375-zhang-jinling.html");
            onInsertTeacher(db,"Zhai Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/374-zhai-yujia.html");
            onInsertTeacher(db,"Xu M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/373-xu-ming.html");
            onInsertTeacher(db,"Wu Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/372-wu-yanyan.html");
            onInsertTeacher(db,"Wang Z.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/370-wang-zhao.html");
            onInsertTeacher(db,"Tillo T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/369-tillo-tammam.html");
            onInsertTeacher(db,"Ting T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/368-tiew-on-ting.html");
            onInsertTeacher(db,"Shi Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/367-shi-yuhui.html");
            onInsertTeacher(db,"Lee S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/366-sanghyuk-lee.html");
            onInsertTeacher(db,"Nayel M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/365-nayel-mohamed-aai.html");
            onInsertTeacher(db,"Lim E.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/363-lim-eng-gee.html");

            //Math Science
            onInsertTeacher(db,"Longhi I.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/971-longhi-ignazio.html");
            onInsertTeacher(db,"Ye Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/883-yinna-ye.html");
            onInsertTeacher(db,"Efstathiou K.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/881-konstantinos-efstathiou.html");
            onInsertTeacher(db,"Schauz U.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/769-uwe-schauz.html");
            onInsertTeacher(db,"MTH - Wang Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/767-yafang-wang.html");
            onInsertTeacher(db,"Mikayelyan H.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/707-hayk-mikayelyan.html");
            onInsertTeacher(db,"Cheng J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/446-jie-cheng.html");
            onInsertTeacher(db,"Wu Z.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/389-wu-zili.html");
            onInsertTeacher(db,"Shaw J.S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/385-shaw-stephen-james.html");
            onInsertTeacher(db,"Ha M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/383-michael-ha.html");
            onInsertTeacher(db,"Liu D.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/382-liu-david.html");
            onInsertTeacher(db,"Ender M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/381-ender-manuela.html");
            onInsertTeacher(db,"Cariolaro D.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/380-cariolaro-david.html");
            onInsertTeacher(db,"Goncu A.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/377-ahmet-goncu.html");

            //Language
            onInsertTeacher(db,"Dodigovic M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/701-marina-dodigovic.html");
            onInsertTeacher(db,"Duggett T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/609-tom-duggett.html");
            onInsertTeacher(db,"De La Garza A.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/608-armida-de-la-garza.html");
            onInsertTeacher(db,"Tickoo A.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/427-dr-asha-tickoo.html");
            onInsertTeacher(db,"Ruan Z.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/397-ruan-zhoulin.html");
            onInsertTeacher(db,"Li S.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/396-li-songqing.html");
            onInsertTeacher(db,"Li H.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/395-hui-li.html");
            onInsertTeacher(db,"Ding P.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/394-ding-peng.html");

            //ARC
            onInsertTeacher(db,"Wash Ivanovic G.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/741-glen-wash-ivanovic.html");
            onInsertTeacher(db,"Westermann C.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/740-claudiawestermann.html");
            onInsertTeacher(db,"Dong Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/668-yiping-dong.html");
            onInsertTeacher(db,"Spaeth B.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/535-achim-benjamin-spaeth.html");
            onInsertTeacher(db,"Diniz N.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/452-nancy-diniz.html");
            onInsertTeacher(db,"Fischer T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/402-thomas-fischer.html");
            onInsertTeacher(db,"Dounas T.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/401-theodoros-dounas.html");
            onInsertTeacher(db,"Farrell E.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/400-edward-farrell.html");
            onInsertTeacher(db,"Herr C. M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/399-christiane-m-herr.html");
            onInsertTeacher(db,"Williams A.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/398-austin-williams.html");

            //CHM
            onInsertTeacher(db,"Dawson D.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/942-dr-graham-dawson.html");
            onInsertTeacher(db,"Wang R.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/939-prof-ruiyao-wang.html");
            onInsertTeacher(db,"Yang L.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/935-dr-li-yang.html");
            onInsertTeacher(db,"Konysheva E.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/715-dr-elena-konysheva.html");
            onInsertTeacher(db,"Matziari M.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/684-dr-magdalini-matziari.html");
            onInsertTeacher(db,"Li P.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/457-dr-peiyi-li.html");
            onInsertTeacher(db,"Li Y.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/456-dr-yi-li.html");
            onInsertTeacher(db,"Lau K.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/455-prof-kim-lau.html");
            onInsertTeacher(db,"Kuo J.","http://www.xjtlu.edu.cn/cn/faculty-zh/subject-staff-zh/item/454-prof-john-kuo.html");

        }

    }


    public void onInsert(SQLiteDatabase db, int year, String programmeName, String classesName,
                         int day, int no, String name, String address, String time, String lecturer, String text, String info) {
        String str_sql = "INSERT INTO " + TABLE_NAME +
                " VALUES(" + year + ",'" + programmeName + "','" + classesName + "'," + day + "," + no + ",'" + name + "','" + address + "','"
                + time + "','" + lecturer + "','" + text + "','" + info + "');";
        db.execSQL(str_sql);

        // CREATE TABLE 创建一张表 然后后面是我们的表名
        // 然后表的列，第一个是id 方便操作数据,int类型#7f8c8d
        // PRIMARY KEY 是指主键 这是一个int型,用于唯一的标识一行;
        // AUTOINCREMENT 表示数据库会为每条记录的key加一，确保记录的唯一性;
        // 最后我加入一列文本 String类型
        // 注意：这里str_sql是sql语句，注意空格！

        // 虽然此句我们生成了一张数据库表和包含该表的sql.himi文件,
        // 但是要注意 不是方法是创建，是传入的一句str_sql这句sql语句表示创建！！
        System.out.println("插入数据成功");
    }

    public void onInsertTeacher(SQLiteDatabase db, String name, String address) {
        String str_sql = "INSERT INTO " + TABLE_NAME3 +
                " VALUES('" + name + "','" + address+"');";
        db.execSQL(str_sql);

        // CREATE TABLE 创建一张表 然后后面是我们的表名
        // 然后表的列，第一个是id 方便操作数据,int类型#7f8c8d
        // PRIMARY KEY 是指主键 这是一个int型,用于唯一的标识一行;
        // AUTOINCREMENT 表示数据库会为每条记录的key加一，确保记录的唯一性;
        // 最后我加入一列文本 String类型
        // 注意：这里str_sql是sql语句，注意空格！

        // 虽然此句我们生成了一张数据库表和包含该表的sql.himi文件,
        // 但是要注意 不是方法是创建，是传入的一句str_sql这句sql语句表示创建！！
        System.out.println("插入数据成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 一般默认情况下，当我们插入 数据库就立即更新
        // 当数据库需要升级的时候，Android 系统会主动的调用这个方法。
        // 一般我们在这个方法里边删除数据表，并建立新的数据表，
        // 当然是否还需要做其他的操作，完全取决于游戏需求。





        Log.v("timetables", "onUpgrade");
    }

    @SuppressWarnings("null")
    public String[] onSelect(SQLiteDatabase db, int day, int no) {
        String[] a = null;
        Cursor cur = db.rawQuery("SELECT * FROM ACC WHERE day=" + day + " AND no=" + no + ";", null);
        if (cur != null) {
//  		          String temp = "";
//  		          String temp1="";
            int i = 0;
            while (cur.moveToNext()) {
                a[0] += cur.getString(2); // 参数0 指的是列的下标,这里的0指的是id列
                a[1] += cur.getString(3);
                i++;
//  		           if (i % 3 == 0)
//  		            temp += "\n";// 整理显示格式 
            }

        }
        System.out.println(a[0] + a[1]);
        return a;
    }


//	 public boolean tabbleIsExist(SQLiteDatabase db,String tableName){
//         boolean result = false;
//         if(tableName == null){
//                 return false;
//         }
//       //  SQLiteDatabase db = null;
//         Cursor cursor = null;
//         try {
//             //    db = this.getReadableDatabase();
//                 String sql = "SELECT COUNT(*) as C FROM "+DATABASE_NAME+" where type ='table' and name ='"+tableName.trim()+"' ";
//                 cursor = db.rawQuery(sql, null);
//                 if(cursor.moveToNext()){
//                         int count = cursor.getInt(0);
//                         if(count>0){
//                                 result = true;
//                         }
//                 }
//                 
//         } catch (Exception e) {
//                 // TODO: handle exception
//         }                
//        return result;
// }


    public boolean tableis(SQLiteDatabase db, String tableName) {


        Cursor cs = db.rawQuery("select count(*) from sqlite_master where type ='table' and name = '" + tableName + "'", null);
        if (cs.moveToNext()) {
            int count = cs.getInt(0);
            if (count > 0) {
                return true;
            }
        }
        return false;


    }


}