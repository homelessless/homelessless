package homelessless.govhack.org.homelessless.models;

import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;

public class Category implements Serializable {

    public static int CATEGORY_ACCOM_ID = 1;
    public static int CATEGORY_CLOTHING_ID = 2;
    public static int CATEGORY_COUNSELLING_ID = 3;
    public static int CATEGORY_EMPLOYMENT_ASSIST_ID = 4;
    public static int CATEGORY_FOOD_ID = 5;
    public static int CATEGORY_HEALTH_SERVICES_ID = 6;
    public static int CATEGORY_HELP_LINES_ID = 7;
    public static int CATEGORY_SHOWERS_LAUNDRY_ID = 8;
    public static int CATEGORY_TRAVEL_ASSIST_ID = 9;

    public static String CATEGORY_ACCOM = "Accomodation";                                          // Accom/Tena Assi  1
    public static String CATEGORY_CLOTHING = "Clothing";                                           // Clothes/Blankets 2
    public static String CATEGORY_COUNSELLING = "Counselling";                                     // Counselling  3
    public static String CATEGORY_EMPLOYMENT_ASSIST = "Employment Assist";                         // Employment Assi. 4
    public static String CATEGORY_FOOD = "Food";                                                   // Food 5
    public static String CATEGORY_HEALTH_SERVICES = "Health Services";                             // Health services  6
    public static String CATEGORY_HELP_LINES = "Help Lines";                                       // Help Line/Web    7
    public static String CATEGORY_SHOWERS_LAUNDRY = "Bathing and Laundry";                         // Shows/Laundy 8
    public static String CATEGORY_TRAVEL_ASSIST = "Travel Assistance";                             //  Travel Assi 9

    private long _id;
    private String title;

    public Category(long id, String title) {
        this._id = id;
        this.title = title;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
