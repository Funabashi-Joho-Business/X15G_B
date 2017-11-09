package jp.ac.chiba_fjb.b.ebi.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by x15g002 on 2017/10/18.
 */


public class TestDB extends SQLite {
    public TestDB(Context context) {
        //ここでデータベースのファイル名とバージョン番号を指定
        super(context, "test.db", 1);
        System.out.println("a");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //初期テーブルの作成
        System.out.println("c");
        db.execSQL("create table song_table(song_ID INTEGER PRIMARY KEY,song_name TEXT,jacket BLOB,genre TEXT,url TEXT);");
        db.execSQL("create table difficult_table(song_ID INT,difficult TEXT,level TEXT);");
        System.out.println("d");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //バージョン番号を変えた場合に呼び出される
    }


    public void tabledateDaelete() {
        System.out.println("e");
        exec("DELETE FROM song_table");
        exec("DELETE FROM difficult_table");
        System.out.println("f");
    }

    public void insertData(Data[] a) { //取得データ
        int count = 1;
        int i = 0;
        String kara = "データ無し";
        ArrayList<ArrayData> sindata = ChuniReader2.recvTest();//URLデータ
        ArrayData dt;
        for (Data data : a) {
            String check = data.title;
            dt = sindata.get(i);
                if (check.contains(dt.title2)) {
                    String sql = String.format("INSERT INTO song_table VALUES(%d,'%s','%s','%s','%s')", data.id, SQLite.STR(data.title), STR(data.image), STR(data.category), dt.URL2);
                    exec(sql);
                    String sql2 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_bas", data.lev_bas);
                    exec(sql2);
                    String sql3 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_adv", data.lev_adv);
                    exec(sql3);
                    String sql4 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_exp", data.lev_exp);
                    exec(sql4);
                    String sql5 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_mas", data.lev_mas);
                    exec(sql5);
                    i++;
                    count++;
                    //    cd =true;
                    // break;
                } else {
                    String sql = String.format("INSERT INTO song_table VALUES(%d,'%s','%s','%s','%s')", data.id, SQLite.STR(data.title), STR(data.image), STR(data.category), kara);
                    exec(sql);
                    String sql2 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_bas", data.lev_bas);
                    exec(sql2);
                    String sql3 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_adv", data.lev_adv);
                    exec(sql3);
                    String sql4 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_exp", data.lev_exp);
                    exec(sql4);
                    String sql5 = String.format("INSERT INTO difficult_table VALUES(%d,'%s','%s')", data.id, "lev_mas", data.lev_mas);
                    exec(sql5);
                    count++;
                    i++;
                }
            }

            Cursor res = query("select * from song_table;");
            while (res.moveToNext()) {
                //0列目を取り出し
                System.out.println(res.getString(0) + "  " + res.getString(1) + "  " + res.getString(2) + "  " + res.getString(3) + "  " + res.getString(4) + "\n");
            }
            res.close();
            Cursor des = query("select * from difficult_table;");
            while (des.moveToNext()) {
                System.out.println(des.getString(0) + "  " + des.getString(1) + "  " + des.getString(2) + "\n");
            }
            //カーソルを閉じる
            des.close();
        }

    }




