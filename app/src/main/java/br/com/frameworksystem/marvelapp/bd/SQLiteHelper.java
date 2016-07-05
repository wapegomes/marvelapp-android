package br.com.frameworksystem.marvelapp.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.frameworksystem.marvelapp.util.Constants;

/**
 * Created by wgomes on 04/07/16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "marvelapp.db";
    private static final int DATABASE_VERSION = 1;


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constants.DDL_CHARACTER);
        sqLiteDatabase.execSQL(Constants.DDL_EVENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static SQLiteDatabase getDatabase(Context context) {
        SQLiteHelper dbHelper = new SQLiteHelper(context);
        return dbHelper.getWritableDatabase();
    }
}
