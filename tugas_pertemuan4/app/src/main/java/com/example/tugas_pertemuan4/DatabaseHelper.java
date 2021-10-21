package com.example.tugas_pertemuan4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String nama_db="DB_ANIME";
    public final static String nama_table="Anime";

    public final static String field_01="nomor";
    public final static String field_02="tokoh_anime";
    public final static String field_03="ttl_anime";
    public final static String field_04="pembuat_anime";
    public final static String field_05="nama_anime";


    public DatabaseHelper( Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+nama_table+"(nomor text primary key,tokoh_anime text,ttl_anime text,pembuat_anime text,nama_anime text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+nama_table);
        onCreate(db);
    }

    public void tambah_data(String xnomor, String xtokoh_anime, String xttl_anime, String xpembuat_anime, String xnama_anime) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(field_01,xnomor);
        contentValues.put(field_02,xtokoh_anime);
        contentValues.put(field_03,xttl_anime);
        contentValues.put(field_04,xpembuat_anime);
        contentValues.put(field_05,xnama_anime);

        db.insert(nama_table,null,contentValues);


    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+nama_table,null);
        return res;
    }


    public void update_data(String toString, String toString1, String toString2, String toString3, String toString4) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(field_01,toString);
        contentValues.put(field_02,toString1);
        contentValues.put(field_03,toString2);
        contentValues.put(field_04,toString3);
        contentValues.put(field_05,toString4);

        db.update(nama_table,contentValues,"nomor=?",new String[] {toString});
    }

    public void hapus_data(String toString) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(nama_table,"nomor=?",new String[] {toString});
    }
}
