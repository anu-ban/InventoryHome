package com.example.inventoryhome;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //*********** inserts Data to the Database*************
    public void insertData(String name, String price, String dateOfPurchase, String location, String description, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO ITEM VALUES (NULL, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindString(3, dateOfPurchase);
        statement.bindString(4, location);
        statement.bindString(5, description);
        statement.bindBlob(6, image);

        statement.executeInsert();
    }

    //*********** updates Data to the Database*************
    public void updateData(String name, String price, String dateOfPurchase, String location, String description, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();


        String sql = "UPDATE ITEM SET name = ?, price = ?, dateofPurchase = ?, location = ?, description = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindString(3, dateOfPurchase);
        statement.bindString(4, location);
        statement.bindString(5, description);
        statement.bindBlob(6, image);
        statement.bindDouble(7, (double)id);

        statement.execute();
        database.close();
    }
    //*********** deletes Data to the Database*************
    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM ITEM WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    //***************** Obtains all the fields in the database
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
