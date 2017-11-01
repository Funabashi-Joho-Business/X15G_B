package jp.ac.chiba_fjb.b.ebi.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by x15g002 on 2017/10/18.
 */


public class TestDB extends SQLite
{
    public TestDB(Context context) {
    //ここでデータベースのファイル名とバージョン番号を指定
    super(context, "test.db",1);
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


    public  void tabledateDaelete(){
        System.out.println("e");
        exec("DELETE FROM song_table");
        exec("DELETE FROM difficult_table");
        System.out.println("f");
    }

    public void insertData(Data[]a) {
        int count = 1;
        for (Data data : a) {
            String sql=String.format("INSERT INTO song_table VALUES(%d,'%s','%s','%s')",data.id,SQLite.STR(data.title),STR(data.image),STR(data.category));
            exec(sql);

            String sql2 = String.format("INSERT INTO difficult_table VALUES(%d,'%s')",count,data.lev_bas);
            exec(sql2);
            String sql3 = String.format("INSERT INTO difficult_table VALUES(%d,'%s')",count,data.lev_adv);
            exec(sql3);
            String sql4 = String.format("INSERT INTO difficult_table VALUES(%d,'%s')",count,data.lev_exp);
            exec(sql4);
            String sql5 = String.format("INSERT INTO difficult_table VALUES(%d,'%s')",count,data.lev_mas);
            exec(sql5);

            count++;
        }
        String sql3 = String.format("SELECT * FROM song_table");
        System.out.println(query(sql3));
    }

    }

