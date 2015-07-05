package homelessless.govhack.org.homelessless.models;

import java.io.Serializable;

// TODO: Implement parcelable instead
public class Organisation implements Serializable {

    private long _id;
    private String name;
    private String description; // What?
    private String targetAudience; // Who is the service for? (Can be null).
    private String operatingHours;

}
