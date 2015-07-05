package homelessless.govhack.org.homelessless;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import homelessless.govhack.org.homelessless.models.Organisation;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Columns for database tables
    public static final String ORG_COLUMN_ID = "_id";
    public static final String ORG_COLUMN_NAME = "name";
    public static final String ORG_COLUMN_DESC = "description";
    public static final String ORG_COLUMN_TARGET_AUDIENCE = "targetAudience";
    public static final String ORG_COLUMN_OPERATING_HOURS = "operatingHours";

    public static final String CAT_COLUMN_ID = "_id";
    public static final String CAT_COLUMN_ORG_ID = "orgId";
    public static final String CAT_COLUMN_CATEGORY_ID = "catId";
    public static final String CAT_COLUMN_SUB_CATEGORY = "subCategory";

    private static final String DATABASE_NAME = "homelessless.db";
    private static final int DATABASE_VERSION = 1;

    private static final String ORG_CREATE_STATEMENT = "CREATE TABLE organisations (" +
            ORG_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ORG_COLUMN_NAME + " TEXT," +
            ORG_COLUMN_DESC + " description TEXT," +
            ORG_COLUMN_TARGET_AUDIENCE + " TEXT," +
            ORG_COLUMN_OPERATING_HOURS + " TEXT" +
    ")";

    private static final String ORG_CAT_CREATE_STATEMENT = "CREATE TABLE orgCat (" +
            CAT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CAT_COLUMN_ORG_ID + " INTEGER," +
            CAT_COLUMN_CATEGORY_ID + " INTEGER," +
            CAT_COLUMN_SUB_CATEGORY + " TEXT" +
    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(ORG_CREATE_STATEMENT);
        database.execSQL(ORG_CAT_CREATE_STATEMENT);
        addSampleData(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement
    }

    private void addSampleData(SQLiteDatabase database) {

        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (1, \"Child Protection Emergency Service\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (2, \"Direct Line (24-hr drug and alcohol counselling)\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (3, \"Gamblers Help Line Victoria\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (4, \"Kids Help line\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (5, \"Lifeline (24 hour crisis counselling)\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (6, \"Maternal and Child Health Line\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (7, \"Mensline Australia\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (8, \"Narcotics Anonymous - Victorian Area Helpline\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (9, \"Sexual Assault Crisis Line\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (10, \"Suicide Line\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (11, \"Victims of Crime Help Line\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (12, \"Aboriginal Family Violence Prevention and Legal Service Victoria\", \"Legal Services, Counselling Support, Information, Referral and Support, Community Education and Training\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (13, \"Action Centre\", \"contraception, sexuality and gender issues, pregnancy and unplanned pregnancy, sexually transmissible infections, sexual decision making, relationships\", \"Services are for under 25 year olds\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (14, \"Adult Outreach Support Services\", \"Adult Outreach Support Services works with people who are homeless, or at risk of homelessness, to secure and maintain safe and affordable housing and achieve independence in the community.\", \"People who are homeless, or at risk of homelessness\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (15, \"AL-ANON Family Groups\", \"Support group for family and friends of alcoholics. Alateen is also for adolescents whose lives have been affected by an alcoholic.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (16, \"Alcoholics Anonymous Victoria\", \"AA is a fellowship of men and women who share their experience, strength and hope with each other that they may solve their common problem and help others to recover from alcoholism. Two gay and lesbian groups and two Koori groups are held weekly. 24 hour\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (17, \"Anglicare Victoria - Lazarus Centre\", \"Breakfast seven days a week, BBQ lunch every Friday, Clothes, Toiletries\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (18, \"Anglicare Victoria - St.Mark's Community Centre\", \"St Mark's provides assistance to homeless people. Drop-in centre Monday to Friday. Bread, fruit, vegetables, weekly food parcels are available. Lunch, Tea and Coffee facilities, Showers, Washing machines and dryers, Toiletries, Public telephones,\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (19, \"Anglicare Victoria - Mission House\", \"Provides Emergency Relief to people living in Public Housing and rental properties with a Health Care Card.\", \"Assistance may be given to those living in the following postcodes: 3000, 3051, 3053, 3054, 3065, 3066, 3067, 3068, 3070.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (20, \"Australian College of Optometry Outreach Services\", \"Homeless Persons Eyecare Program, Supported Residential Services Project, Residential Aged Care Project, Older Persons High Rise, Aboriginal and Torres Strait Island Outreach, Visiting Disability Service\", \"Low cost eye care for those of limited means. Appointments bulk billed to Medicare. Glasses subsidized for pension/health care card holders.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (21, \"Brotherhood of St Laurence Coolibah Centre\", \"Breakfast $1.00 lunch $3, afternoon tea $0.20 showers laundry facilities health services short-term case management accommodation referral social engagement activities psychiatric referral optometry every second month.\", \"A person may be eligible for the Coolibah Centre if: they are 55 years of age or over and live in the City of Yarra they are experiencing homelessness or living in insecure housing they are socially and financially disadvantaged they have a disabili\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (22, \"CASA House Centre Against Sexual Assault\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (23, \"CatholicCare/St Mary of the Cross Centre\", \"referral, drug education, counselling, group support outreach, multicultural support, families with drug and alcohol issues, spiritual support, HIV/AIDS ministry\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (24, \"Central City Community Health Service\", \"Outreach support services for people experiencing or at risk of becoming homelessness, Allied Health Outreach Services, Mental Health Outreach Services, Royal Women's Hospital Clinic RDNS HPP Nurses, Legal Services - Justice Connect and Inn\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (25, \"Centrelink\", \"Centrelink is an Australian Government agency delivering a range of services to the community, including social security payments.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (26, \"Church of All Nations\", \"Lunch on Tuesdays, Food pantry, lnternet kiosk and drop-in centre, Carlton No Interest Loans Scheme, Carlton Worker Learning Centre,  Referral and Advocacy, Women's program, Family Learning Program/Children and Parents (Homework Club)\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (27, \"Clarendon Clinic\", \"psychiatric services for people with serious mental illness, crisis assessment\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (28, \"COHEALTH\", \"allied health services, social welfare services,  health promotion programs, dental services, medical services, counselling and mental health services\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (29, \"COHEALTH\", \"Outreach Support Services for people experiencing or at risk of becoming homelessness., Homeless Mental Health and Housing Service, Allied Health Outreach Services, Dietetics and CafÃƒÂ© Meals, Podiatry, Occupational Therapy, Physiotherapy\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (30, \"COHEALTH\", \"Provides a broad range of health and welfare services  Drop-in Clinic for homeless people every Monday from 9am -12 noon. Services include physiotherapy, podiatry, occupational therapy, dietetics, and nursing. Aboriginal engagement worker available, c\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (31, \"COHEALTH\", \"range of health and welfare services, drug and alcohol counseling, drop in social work/counselling sessions needle and syringe programs, mental health community support, doctors and nurses.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (32, \"COHEALTH\", \"broad range of allied health and counselling services, social work/counselling sessions (by appointment only), secondary needle and syringe exchange\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (33, \"COHEALTH - Inner Space\", \"Cohealth's primary health service for people who inject drugs plus primary needle and syringe program. Services include: doctors drug and alcohol counseling nursing (including psychiatric nurse) breakfast program phone, shower and laundry fac\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (34, \"Depaul House\", \"residential drug withdrawal service Self referrals via the centralized hub. Contact Direct Line on 1800 888 236 for your local hub. You can also go on line to find your local service.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (35, \"Fitzroy Legal Service\", \"A Community Legal Centre offering free legal advice, and some legal representation, community legal education, publications and law reform advocacy.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (36, \"Flagstaff Crisis Accommodation\", \"supported accommodation, health services, psychiatric referral, drug and alcohol referral free legal advice and assistance provided by Justice Connect -Tuesdays (fortnightly) at 1.00 pm. (by appointment) Access to vacancies is only through Ho\", \"Accommodates men aged 18 years and over.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (37, \"Flemington & Kensington Community Legal Centre\", \"free legal advice and assistance for residents of Flemington and Kensington\", \"residents of Flemington and Kensington\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (38, \"Foot Patrol\", \"needle exchange/health outreach program\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (39, \"Frontyard Youth Services\", \"accommodation referral, centrelink, youth connections, gateway reconnect, legal advice, health services,  Job Services Australia, family reconciliation and mediation program\", \"aged between 12 to 25 homeless, at risk of homelessness, disengaged or requiring support.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (40, \"GROW\", \"A movement of community mental health and mutual support self-help groups. Weekly groups are available for people who have been through a breakdown, or who are overwhelmed by problems and painful life experiences.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (41, \"Hanover Fitzroy\", \"The Assertive Outreach Team offers support to people sleeping out. Support can include: accommodation information and referral , sleeping gear and food bags, referral to other services such as health or legal services, visiting people who are sleeping ou\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (42, \"Hanover Southbank\", \"short term supported crisis accommodation for men, women and couples accommodation support and referrals, case management and planning, health services, learning and activities, drug and alcohol support, shared kitchen and bathroom facilities\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (43, \"Hare Krishna Temple\", \"free meals\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (44, \"HomeGround Services\", \"initial assessment and planning for housing crisis accommodation limited financial assistance assistance with public housing applications free legal advice and assistance provided by Justice Connect. Contact Justice Connect on telephone 1800 606 313 to\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (45, \"Homelessness Advocacy Service (HAS) - Council to Homeless Persons\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (46, \"Inner Melbourne Community Legal\", \"free legal information, advice and casework\", \"financially disadvantaged individuals who live, work or study in:  Ã‚Â· Melbourne CBD Ã‚Â· North Melbourne Ã‚Â· West Melbourne Ã‚Â· Docklands Ã‚Â· Carlton.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (47, \"Inner Melbourne VET Cluster (IMVC)\", \"Making Alternatives Program (MAP) Program - Term 4 (10 weeks): is designed for young adults, aged 15-18 years seeking an alternative learning environment to mainstream schooling. Students will participate in Career and Industry exploration activiti\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (48, \"Justice Connect Homeless Law\", \"Homeless Law provides free legal advice and assistance to people who are homeless or at risk of homelessness. The service assists with the following legal issues: infringements that are related to homelessness, tenancy, credit and debt, guardianship a\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (49, \"Living Room Primary Health Service\", \"Living Room is made up of a team of doctors/nurses and community development workers who provide a confidential Ã¢â‚¬Ëœuser friendlyÃ¢â‚¬â„¢ free health service. health services, referrals and information, chill out space, tea and coffee There are\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (50, \"McAuley Community Services for Women - McAuley House Program\", \"medium term supported accommodation\", \"Medium term supported accommodation for women, unaccompanied by children, aged between 25 - 55 years who are homeless, at risk of homelessness and/or have a mental illness.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (51, \"Matthew Talbot Fitzroy Soup Van\", \"The Fitzroy Soup Van does street stops around the city area and operates 7 days per week.  Monday to Friday: Sandwiches, soup, sausage rolls, meat pies, pasties, tea, coffee and cordial.  Saturday and Sunday: Sandwiches, soup, tea, coffee and cordia\", \"The Fitzroy Soup Van is a free service available to anyone in the Fitzroy area. We typically support people who face financial difficulties and those who are homeless.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (52, \"Melbourne Counselling Service\", \"gambling counselling, youth sexual assault counselling, a unit of Gamblers Help, financial counselling, general counselling\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (53, \"Melbourne Sexual Health Centre\", \"sexual health services, pregnancy testing, counselling, pharmacy, needle exchange, result and information line\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (54, \"North West Outreach Service\", \"needle and syringe program\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (55, \"Open Family Australia\", \"Outreach service for young people 10-25 years, accommodation referral, drug and alcohol referral, legal advice referral and recreational activities. The Ã¢â‚¬ËœChatter Box BusÃ¢â‚¬â„¢ operates from 8pm till late in and around Melbourne CBD Ã¢â‚¬Ëœhotsp\", \"Outreach service for young people 10-25 years\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (56, \"Orygen Youth Health\", \"Public mental health service\", \"Young people aged 15 - 24 years living in the Western and North-Western regions of Melbourne\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (57, \"Ozanam Community Centre\", \"breakfast - daily between 9.15 am - 10am lunch - daily between 12 noon - 1pm. laundry, shower, health services, dentist, drug and alcohol counselling, doctor and nurse, therapeutic groups, centrelink, Inner Melbourne Legal Services.\", \"Statewide services for homeless and disadvantaged people who are over 18 years old\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (58, \"Ozanam House\", \"crisis accommodation for men over the age of 18, food (3 meals per day to residents), laundry ($1 operation charge for residents) centrelink services Thursday 9:30am - 11.30am Accommodation Referrals for Ozanam House through VincentCare Housing Serv\", \"Crisis accommodation centre houses men over 18 years of age.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (59, \"Presbyterian and ScotsÃ¢â‚¬â„¢ Church Joint Mission (The Flemington Mission)\", \"coffee, conversation, blankets, books, etc. every Tuesday. food relief is also available on the 1st and 3rd Tuesdays of each month.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (60, \"Quin House\", \"Quin House accommodates men over 18 years. There is an abstinence-based program with referral through the withdrawal services. residential drug and alcohol rehabilitation (3 months), post-residential program, accommodation referral\", \"Men over 18 years\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (61, \"Rosies Bus\", \"Rosies Bus parks at Flinders Street Station and provides tea, coffee, biscuits, milo, and cordial. (Winter Season): Blankets/Gloves/Beanies and Scarves)\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (62, \"RDNS Homeless Person's Program\", \"Health services\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (63, \"Royal Melbourne Hospital\", \"OutpatientsÃ¢â‚¬â„¢ emergency service\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (64, \"Royal Victorian Eye & Ear Hospital\", \"OutpatientsÃ¢â‚¬â„¢ emergency service\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (65, \"Sacred Heart Mission\", \"free breakfast 8.30am - 10.30am (Monday to Friday) Saturday and Sunday and Public Holidays 9.00am - 10.30 am. free lunch 11.45am - 1.15pm every day of the year, including public holidays op shop free showers & laundry assistant with ho\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (66, \"Sacred Heart Mission's Women's House\", \"The Women's House is a safe drop-in centre for women open Monday - Friday 11.30am - 3.00pm. free lunch is available between 11.30am - 2.00pm assistance with housing and referrals, physical and mental health, counseling and support showers\", \"Single Women 25 years +\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (67, \"Sacred Heart Mission's Clinic\", \"provides natural and complementary therapies such as podiatry, physiotherapy, massage, hairdressing  appointment required\", \"Priority is given to people who hold a pension/health care card or are living in unstable accommodation and live in the City of Port Phillip or have been referred by an agency.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (68, \"Salvation Army - Project 614\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (69, \"Hamodava CafÃƒÂ©\", \"Provides meals Monday to Friday, at no cost.  a safe place for Melbourne's homeless and marginalized meals provided Monday to Friday at no cost assessment and referral for D&A, mental health and legal services\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (70, \"The Market Place\", \"provides practical support by way of our no cost supermarket. food, toiletries, clothing, etc. shower facilities assessment and referral service\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (71, \"614/AMP Youth Bus\", \"a safe place for Melbourne's homeless and marginalized youth provides activities and food referral for D&A, medical and legal services internet access\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (72, \"Salvation Army - 24/7 Melbourne's Road Home\", \"is an outreach program that seeks to search, locate and engage with rough sleepers can be contacted in regards to rough sleepers in and around the Melbourne CBD accepts referrals from police, ambulance, business owners and the general community,\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (73, \"The Couch International Student Centre\", \"links International Students to support services and provides general information provides a safe space to socialize and interact with others free meals\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (74, \"Salvation Army Open Door\", \"accommodation (transitional) laundry Referrals via HomeGround, entering through Flagstaff Crisis Accommodation or Ozanam House.\", \"Transitional accommodation (3 to 6 months) for homeless men who are over 18 years .\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (75, \"Settlement Program\", \"Providing assistance to members of the community that have lived in Australia for less than 5 years. referral service, domestic violence support, drug and gambling information, housing advice, legal information, citizenship advice, support to community\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (76, \"St. Francis Pastoral Centre\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (77, \"St. Mary's House of Welcome\", \"meals program, showers, information and referral to drugs and alcohol/housing/health etc. day-to-day living program: provides activities and programs for people living with a mental illness.\", \"All programs and services are open to adults aged over 18 years.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (78, \"St. Vincent's de Paul\", \"clothing, furniture and bric-a-brac (cheap) Call Head Office on 9895 5800 for help in finding your nearest branch.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (79, \"St. Vincent's Emergency Department\", \"OutpatientsÃ¢â‚¬â„¢ emergency service\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (80, \"Stopover Youth Services\", \"crisis refuge accommodation advocacy and general support Housing support program offered for 16-24 year old young people experiencing homelessness. Individual room and bathroom, food included, small service fee payable by clients. Stays of approximate\", \"Housing support program offered for 16-24 year old young people experiencing homelessness.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (81, \"The Alfred\", \"acute medical and surgical hospital services  inpatient and outpatient treatment including geriatric medicine centre for heart-lung transplants and treatment of trauma, HIV/AIDS, hemophilia and adult burns after-hours emergency and casualty services\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (82, \"The Big Issue Australia\", \"'The independent street magazine sold by homeless and unemployed people.' magazine vendor opportunities opportunity to make money and friends, gain confidence and learn skills choose your own hours no referral process needed vendors paid\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (83, \"The Drum Youth Services\", \"school based services, recreation programs, personal support, advocacy and referral, personal development and leadership programs, youth events, counseling, queer youth\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (84, \"TRAVELLERS AID - Spencer Street\", \"free assistance (buggy and personal guidance) for frail, infirm, older people and people with disabilities, mobility issues and vision impairments to ensure swift, confident and safe passage throughout Southern Cross Station Mobility Equipment Hire Medi\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (85, \"Travel-related Emergency Relief (Southern Cross Station)\", \"information and referrals subsidized travel fares in crisis situations\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (86, \"TRAVELLERS AID - Flinders Street\", \"Mobility Equipment Hire Medical Companion Service (free service call 1300 700 399) Free personal care for people with a disability (assistance with meals and communication, fully accessible toilets with hoist and adult change table). All opening times\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (87, \"Turning Point Drug & Alcohol Centre\", \"assessment by telephone or face to face information and advice on treatment options referral to other alcohol and drug services or health and welfare agencies pharmacotherapy forensics client service acquitted brain injury clinical consultationcomb\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (88, \"Victoria Police - Melbourne West\", \"In case of an emergency or if you require immediate assistance call Triple Zero (000)\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (89, \"Victoria Police - Melbourne East\", \"In case of an emergency or if you require immediate assistance call Triple Zero (000)\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (90, \"Victoria Police - Melbourne North\", \"In case of an emergency or if you require immediate assistance call Triple Zero (000)\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (91, \"Victorian Aboriginal Health Service\", \"health services, psychiatric services, drug and alcohol counselling, immunisation, preventative care for children, maternal and child health, women's health, ante-natal care, dentist\", \"This free health service is for Aboriginal people and Torres Strait Islanders.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (92, \"Victorian Aboriginal Legal Service\", \"legal services Provides support with civil, family and criminal law matters for Aboriginal people and Torres Strait Islanders.\", \"Aboriginal people and Torres Strait Islanders\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (93, \"Victorian Legal Aid\", \"legal advice public library\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (94, \"Vietnamese & Settlement Program\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (95, \"VincentCare Youth Support Service\", \"outreach housing support for young people\", \"Outreach housing support services for homeless young people between the ages of 16 and 25 years\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (96, \"Waratah Clinic\", \"psychiatric services\", \"Waratah helps homeless people over 18 years of age who have a psychiatric illness. Mainly in the inner-west region, and services night shelters, Office of Housing units and squats.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (97, \"William T Onus Hostel\", \"temporary accommodation for indigenous people (fees apply)\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (98, \"Wintringham\", \"residential Care outreach - support and accommodation referral housing - nursing home, independent living units and long term housing support community care packages - home based care, support and case management\", \"Wintringham provides quality care, accommodation and support services to men and women over the age of 50 years who have limited financial resources and are either homeless or at risk of becoming homeless.\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (99, \"WIRE (Women's Information and Referral Exchange)\", \"Free and confidential support, information and referrals for women by women on any issues - from leaving a violent relationship to coping with depression to everything in between. WIRE Services include: Telephone Support Service Livechat Suppo\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (100, \"Women's Health Information Centre (WHIC)\", \"The Women's Health Information Centre (WHIC) is a free, confidential health service which offers information, individualized support and referral options on a wide range of women's health issues. Experienced women's health nurses a\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (101, \"Women's Health West\", \"Women's Health West is committed to improving equity and justice for women in Melbourne's diverse western region. We incorporate a health promotion, research and development team with a family violence service for women and children providing: informat\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (102, \"Women's Housing Limited\", \"medium and long term housing accommodation  tenancy assistance housing information and referral\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (103, \"Young People's Health Service\", \"health services (free for 12-24 year olds) provides primary health care.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (104, \"Youth Support & Advocacy Service\", \"drug services (before and after detox)\", \"This service is for young people aged between 10 and 22 years\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (105, \"Youth Services\", \"You can ask to speak to a male or female youth worker. Service is based at North Melbourne Community Centre. social support, advocacy and referral, youth arts programs, school-based programs, groups for young men and women, male or female youth worker\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (106, \"Victorian State-wide Human Services Directory\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (107, \"City of Melbourne's Social Support Directory\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (108, \"InfoXchange - Housing and Homelessness\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (109, \"Council to Homeless Persons\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (110, \"Aboriginal Housing Victoria\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (111, \"Homelessness Australia\", \"\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (112, \"Salvation Army - Crisis Services - Crisis Contact Centre\", \"Homelessness support, Accommodation placement and/or support, Crisis/emergency accommodation, Housing information/referral, Financial assistance, Support\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (113, \"St Vincent de Paul Society Victoria Inc\", \"Central phone number for support services (\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (114, \"Tenants Union of Victoria\", \"We offer free and confidential advice, assistance and advocacy for tenants and residents renting residential accommodation in Victoria, including: tenants in private residential accommodation tenants in public housing residents in caravan parks reside\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (115, \"Utility Relief Grant and Non-Mains Utility Relief Grant schemes\", \"The Utility Relief Grant Scheme and the Non-Mains Utility Relief Grant Scheme provide assistance for domestic customers who are unable to pay their utility bills due to a temporary financial crisis.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (116, \"mychild.gov.au\", \"The mychild.gov.au website is Australia's online child care portal. On this website you will find information on different types of child care and how to get assistance with the cost of child care.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (117, \"Child Support Info Service\", \"Child Support Info Service is an automated telephone information system that provides information 24 hours a day, seven days a week about your child support account.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (118, \"Parentline Victoria\", \"Statewide telephone service providing counselling, information and referral for all Victorian parents and carers of children 0 - 18yrs.\", \"\");" );
        database.execSQL("INSERT INTO organisations ( _id, name, description, targetAudience ) VALUES (119, \"There is a homeless service accessibilty\", \"\", \"\");" );


        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 1, 1, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 2, 2, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 3, 3, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 4, 4, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 5, 5, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 6, 6, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 7, 7, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 8, 7, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 9, 8, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 10, 8, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 11, 9, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 12, 9, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 13, 10, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 14, 10, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 15, 11, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 16, 11, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 17, 12, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 18, 12, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 19, 13, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 20, 13, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 21, 14, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 22, 15, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 23, 16, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 24, 17, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 25, 17, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 26, 17, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 27, 18, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 28, 18, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 29, 18, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 30, 19, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 31, 19, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 32, 19, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 33, 20, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 34, 21, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 35, 21, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 36, 21, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 37, 21, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 38, 21, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 39, 22, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 40, 22, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 41, 22, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 42, 23, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 43, 23, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 44, 24, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 45, 24, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 46, 24, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 47, 25, 4, \"Employment Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 48, 25, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 49, 25, 1, \"Tenancy Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 50, 26, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 51, 27, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 52, 28, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 53, 28, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 54, 29, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 55, 29, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 56, 29, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 57, 30, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 58, 30, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 59, 30, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 60, 30, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 61, 31, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 62, 31, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 63, 31, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 64, 31, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 65, 32, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 66, 32, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 67, 33, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 68, 33, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 69, 33, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 70, 34, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 71, 35, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 72, 36, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 73, 36, 6, \"Dentistry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 74, 36, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 75, 36, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 76, 37, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 77, 37, 1, \"Tenancy Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 78, 38, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 79, 39, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 80, 39, 4, \"Employment Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 81, 39, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 82, 39, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 83, 40, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 84, 41, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 85, 41, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 86, 41, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 87, 42, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 88, 42, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 89, 42, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 90, 43, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 91, 44, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 92, 44, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 93, 44, 1, \"Tenancy Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 94, 45, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 95, 46, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 96, 47, 4, \"Employment Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 97, 47, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 98, 48, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 99, 49, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 100, 50, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 101, 50, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 102, 51, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 103, 52, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 104, 52, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 105, 53, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 106, 53, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 107, 53, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 108, 54, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 109, 55, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 110, 55, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 111, 55, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 112, 56, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 113, 56, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 114, 57, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 115, 57, 6, \"Dentistry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 116, 57, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 117, 57, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 118, 57, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 119, 58, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 120, 58, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 121, 58, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 122, 59, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 123, 59, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 124, 60, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 125, 60, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 126, 61, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 127, 62, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 128, 63, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 129, 64, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 130, 65, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 131, 65, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 132, 65, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 133, 65, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 134, 66, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 135, 66, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 136, 66, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 137, 66, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 138, 66, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 139, 67, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 140, 69, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 141, 70, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 142, 71, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 143, 73, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 144, 74, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 145, 74, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 146, 75, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 147, 75, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 148, 75, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 149, 76, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 150, 77, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 151, 77, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 152, 77, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 153, 78, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 154, 79, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 155, 80, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 156, 80, 5, \"Food\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 157, 81, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 158, 82, 4, \"Employment Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 159, 83, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 160, 83, 4, \"Employment Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 161, 84, 8, \"Showers / Laundry\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 162, 84, 9, \"Travel Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 163, 85, 9, \"Travel Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 164, 86, 9, \"Travel Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 165, 87, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 166, 87, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 167, 87, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 168, 87, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 169, 88, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 170, 89, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 171, 90, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 172, 91, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 173, 91, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 174, 91, 6, \"Needle Exchange\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 175, 92, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 176, 93, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 177, 95, 1, \"Tenancy Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 178, 96, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 179, 97, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 180, 98, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 181, 98, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 182, 99, 4, \"Employment Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 183, 99, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 184, 100, 3, \"Legal / Financial Advice\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 185, 101, 3, \"Counselling and Psychiatric Services\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 186, 102, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 187, 102, 1, \"Tenancy Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 188, 103, 6, \"Health Services / Pharmacy\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 189, 104, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 190, 104, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 191, 105, 6, \"Drug and Alcohol\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 192, 105, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 193, 106, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 194, 107, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 195, 108, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 196, 109, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 197, 110, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 198, 111, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 199, 112, 1, \"Accommodation\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 200, 112, 7, \"Helpful phone number\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 201, 112, 6, \"Hospitals / Emergency\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 202, 113, 2, \"Clothes and Blankets\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 203, 114, 1, \"Tenancy Assistance\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 204, 115, 7, \"Helpful website\");" );
        database.execSQL("INSERT INTO orgCat ( _id, orgId, catId, subCategory ) VALUES ( 205, 116, 7, \"Helpful website\");" );
    }

    public List<Organisation> getOrganisationList( int categoryId ) {
        ArrayList<Organisation> contents = new ArrayList<>();

        String sql = "SELECT org._id as orgId, org." + ORG_COLUMN_NAME + " as orgName, org." + ORG_COLUMN_DESC + " as orgDescription, orgCat." + CAT_COLUMN_CATEGORY_ID + " as catId, orgCat." + CAT_COLUMN_SUB_CATEGORY + " as subCatName " +
                "FROM organisations as org " +
                "  LEFT JOIN orgCat ON ( orgCat." + CAT_COLUMN_ORG_ID + " = org." + ORG_COLUMN_ID + " ) " +
                "WHERE orgCat." + CAT_COLUMN_CATEGORY_ID + " = " + categoryId;

        Cursor cursor = getWritableDatabase().rawQuery(sql, null);

        if (cursor .moveToFirst()) {
            while (!cursor.isAfterLast()) {
                // TODO ORGANISATION INDEXES match with object

                Organisation o = new Organisation();
                o.setId(cursor.getLong(cursor.getColumnIndex("orgId")));
                o.setName(cursor.getString(cursor.getColumnIndex("orgName")));
                o.setDescription(cursor.getString(cursor.getColumnIndex("orgDescription")));
                o.setCategoryId(cursor.getInt(cursor.getColumnIndex("catId")));
                o.setSubCategoryName(cursor.getString(cursor.getColumnIndex("subCatName")));


                contents.add(o);
                cursor.moveToNext();
            }
        }

        return contents;
    }
}
