package homelessless.govhack.org.homelessless;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import homelessless.govhack.org.homelessless.models.Organisation;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Columns for database tables
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY_ID = "catId";
    public static final String COLUMN_SUB_CATEGORY = "subCategory";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_TARGET_AUDIENCE = "targetAudience";
    public static final String COLUMN_OPERATING_HOURS = "operatingHours";

    private static final String DATABASE_NAME = "homelessless.db";
    private static final int DATABASE_VERSION = 1;

    private static final String ORG_CREATE_STATEMENT = "CREATE TABLE organisations (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_CATEGORY_ID + " INTEGER," +
            COLUMN_SUB_CATEGORY + " TEXT," +
            COLUMN_DESC + " description TEXT," +
            COLUMN_TARGET_AUDIENCE + "targetAudience TEXT," +
            COLUMN_OPERATING_HOURS + "operatingHours TEXT" +
    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(ORG_CREATE_STATEMENT);
        addSampleData(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement
    }

    private void addSampleData(SQLiteDatabase database) {
        // Organisations
        database.execSQL("INSERT INTO \"organisations\" VALUES (1, 'Child Protection Emergency Service', 7, 'Helpful phone number', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (2, 'Direct Line (24-hr drug and alcohol counselling)', 7, 'Helpful phone number', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (3, 'Gamblers Help Line Victoria', 7, 'Helpful phone number', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (4, 'Kids Help line', 7, 'Helpful phone number', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (5, 'Lifeline (24 hour crisis counselling)', 7, 'Helpful phone number', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (6, 'Maternal and Child Health Line', 7, 'Helpful phone number', '', '', NULL);\n");
        database.execSQL("INSERT INTO \"organisations\" VALUES (7, 'Mensline Australia', 7, 'Helpful phone number', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (8, 'Narcotics Anonymous - Victorian Area Helpline', 7, 'Helpful website', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (9, 'Sexual Assault Crisis Line', 7, 'Helpful phone number', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (10, 'Suicide Line', 7, 'Helpful website', '', '', NULL);");
        database.execSQL("INSERT INTO \"organisations\" VALUES (11, 'Victims of Crime Help Line', 7, 'Helpful phone number', '', '', NULL);");
    }

    public List<Organisation> getOrganisationList( int categoryId ) {
        ArrayList<Organisation> contents = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM organisations WHERE " + COLUMN_CATEGORY_ID + " = " + categoryId, null);

        if (cursor .moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                // TODO ORGANISATION INDEXES match with object

                Organisation o = new Organisation();
                o.setId(cursor.getLong(0));
                o.setName(cursor.getString(1));

                contents.add(o);
                cursor.moveToNext();
            }
        }

        return contents;
    }
}
