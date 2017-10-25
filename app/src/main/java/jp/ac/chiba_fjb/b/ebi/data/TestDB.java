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
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //初期テーブルの作成
        db.execSQL("create table song_table(song_ID INTEGER PRIMARY KEY,song_name TEXT,jacket BLOB,genre TEXT,url TEXT);");
        db.execSQL("create table 難易度テーブル(song_ID INT,difficult TEXT,level TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //バージョン番号を変えた場合に呼び出される
    }
}
