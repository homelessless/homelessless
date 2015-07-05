package homelessless.govhack.org.homelessless;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Columns for database tables
    public static final String COLUMN_ID = "_id";



    private static final String DATABASE_NAME = "homelessless.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_STATEMENT = "";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement
    }
}
