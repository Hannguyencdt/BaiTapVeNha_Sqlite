package devpro.vn.baitapvenha_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

/*** Created by Admin on 4/5/2018.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    // TÃªn cÆ¡ sá»Ÿ dá»¯ liá»‡u.
    private static final String DATABASE_NAME = "Student_Manager";


    private static final String TABLE_STUDENT = "student";

    private static final String COLUMN_NOTE_ID ="id";
    private static final String COLUMN_NOTE_NAME ="name";
    private static final String COLUMN_NOTE_OLD = "old";
    private static final String COLUMN_NOTE_ADD = "add";
    private static final String COLUMN_NOTE_NAME_CLASS = "nameClass";



    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

      //  Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script táº¡o báº£ng.
        String script = "CREATE TABLE " + TABLE_STUDENT + "("
                + COLUMN_NOTE_ID + " INTEGER PRIMARY KEY," + COLUMN_NOTE_NAME + " TEXT,"
                + COLUMN_NOTE_OLD + " TEXT" + ")" + COLUMN_NOTE_ADD + " TEXT" + ")"+  COLUMN_NOTE_NAME_CLASS + " TEXT" + ")";
        // Cháº¡y lá»‡nh táº¡o báº£ng.
        db.execSQL(script);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        // Há»§y (drop) báº£ng cÅ© náº¿u nÃ³ Ä‘Ã£ tá»“n táº¡i.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);


        // VÃ  táº¡o láº¡i.
        onCreate(db);


    }
    public void addStudent(StudentModel studentModel){
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_NAME, studentModel.getName());
        values.put(COLUMN_NOTE_OLD, studentModel.getOld());
        values.put(COLUMN_NOTE_ADD, studentModel.getAdd());
        values.put(COLUMN_NOTE_NAME_CLASS, studentModel.getNameClas());
        writableDatabase.insert(TABLE_STUDENT, null, values);
        writableDatabase.close();
        Log.d("HanNguyen","okie");
    }
    public ArrayList<StudentModel> getAllStudent() {
        ArrayList<StudentModel> studentModels = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT;
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                StudentModel model = new StudentModel();
                model.setId(Integer.parseInt(cursor.getString(0)));
                model.setName(cursor.getString(1));
                model.setOld(Integer.parseInt(cursor.getString(2)));
                model.setAdd(cursor.getString(3));
                model.setNameClas(cursor.getString(4));
                studentModels.add(model);
            } while (cursor.moveToNext());
        }
        return studentModels;
    }
    public int updateStudent(int id, StudentModel model) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_NAME, model.getName());
        values.put(COLUMN_NOTE_OLD, model.getOld());
        values.put(COLUMN_NOTE_ADD, model.getAdd());
        values.put(COLUMN_NOTE_NAME_CLASS, model.getNameClas());
        return writableDatabase.update(TABLE_STUDENT, values, COLUMN_NOTE_ID + " = ?",
                new String[]{String.valueOf(id)});}


    public void deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENT, COLUMN_NOTE_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }


}