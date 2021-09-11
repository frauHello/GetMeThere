package com.example.user.getmethere;
import  android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class SqlConnect  extends SQLiteOpenHelper
{
    public static String DB_NAME = "db.db";
    public static String DB_PATH = "";
    public static String IdUSer;
    public static Context Mycontext;
    public static String Password;
    public static String UserName;
    public static SQLiteDatabase myDataBase;
    public static InputStream myInput;
    // Labels table name
    private static final String TABLE_LABELS = "labels";

    public SqlConnect(Context paramContext)
    {
        super(paramContext, DB_NAME, null, 1);
        File localFile = new File(Environment.getExternalStorageDirectory().toString() + "/DataBase");
        localFile.mkdirs();
        DB_PATH = localFile.toString();
    }

    public static int Delete_Data(String table, String whereClause, String[] whereArgs)
    {
        return myDataBase.delete(table, whereClause, whereArgs);
    }

    public static Long Insert_Data(String paramString1, String paramString2, ContentValues paramContentValues)
    {
        SQLiteDatabase localSQLiteDatabase = myDataBase;
        int i = Select_Data(paramString1, null, null, null, null, null, null).getCount();
        return Long.valueOf(Long.valueOf(localSQLiteDatabase.insert(paramString1, paramString2, paramContentValues)).longValue() - i);
    }

    public static Cursor Select_Data(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
    {
        return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy) ;
    }

    public static int Update_Data(String table, ContentValues values, String whereClause, String[] whereArgs)
    {
        return myDataBase.update(table, values, whereClause, whereArgs);
    }

    private static boolean checkDataBase()
    {
        SQLiteDatabase localSQLitedatabase=null;
        try
        {
            localSQLitedatabase = SQLiteDatabase.openDatabase(DB_PATH + "/" + DB_NAME, null, 0);
        }
        catch (SQLiteException localSQLiteException)
        {
        }
        if (localSQLitedatabase != null)
        {
            localSQLitedatabase.close();
            return true;
        }
        return false;
    }

    public static void copyDataBase()throws IOException
    {
        FileOutputStream localFileOutputStream = new FileOutputStream(DB_PATH + "/" + DB_NAME);
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
            int i = myInput.read(arrayOfByte);
            if (i <= 0)
            {
                localFileOutputStream.flush();
                localFileOutputStream.close();
                myInput.close();
                return;
            }
            localFileOutputStream.write(arrayOfByte, 0, i);
        }
    }

    public static void openDataBase()
            throws SQLException
    {
        myDataBase = SQLiteDatabase.openDatabase(DB_PATH + "/" + DB_NAME, null, 0);
    }

    public void close()
    {
        try
        {
            if (myDataBase != null) {
                myDataBase.close();
            }
            super.close();
            return;
        }
        finally {}
    }

    public void createDataBase()
            throws IOException
    {
        if (!checkDataBase()) {
            getReadableDatabase();
        }
        try
        {
            copyDataBase();
            return;
        }
        catch (IOException localIOException)
        {
            throw new Error("Error copying database");
        }
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}

}
