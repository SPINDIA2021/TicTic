package com.tiktoknew;

import android.content.Context;
import android.content.SharedPreferences;


/* created by rani on 23 Oct 2019
 */
public class Preferences {
    public static final String VerificationID = "VerificationID";
    public static String editWardName="editWardName";
    public static String editWardId="editWardId";
    public static String editFormId="editFormId";
    public static String editFormName="editFormName";
    public static String editFormImgString="editFormImgString";
    public static String editDefaultFormImg="editDefaultFormImg";
    public static String editFrom="editFrom";



    private static SharedPreferences sharedPref;
    private static final String PREF_NAME = "TICTIC Preference";
    public static String DISCHARGE_DATE="DISCHARGE_DATE";
    public static final String LOGIN_DOC_ID = "LOGIN_DOC_ID";
    public static final String PTMASTID = "PtmastId";
    public static final String USER = "User";
    public static final String USERCODE = "UserCode";
    public static final String CompName = "CompName";
    public static final String COMPANY_NAME = "companyname";
    public static final String USER_NAME = "username";
    public static final String WARD_NAME = "ward_name";
    public static final String WARD_ID = "ward_id";
    public static final String PATIENT_POSTION = "PatientPosition";
    public static final String ADDRESS = "address";
    public static final String DEPT= "dept";
    public static final String EMPNAME = "empname";
    public static final String PROOFWITHIMAGE = "proofwithimage";
    public static final String AppUserName = "AppUserName";
    public static final String MOBILE = "mobile";
    public static final String DOCID = "docId";
    public static final String CONTRACT_FILE = "contract_file";
    public static final String PROFILE_PHOTO = "PROFILE_PHOTO";
    public static final int HEADID = 0;
    public static final String AuthPswd = "1269C48227AB2E13298623FEC51D88B0";
    public static final String DOB = "dob";
    public static final String GENDER = "gender";
    public static final String EMPID = "empId";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirmPass";
    public static final String LOGINOTP = "loginotp";
    public static final String REGISTERED = "registered";
    public static final String CUMULATIVE_PATH = "cumulativePath";
    public static final String USERID = "UserID";
    public static final String MENU_LIST = "MenuList";
    public static final String WARD_LIST = "WardList";
    public static final String PROFILE_LIST = "ProfileList";
    public static final String PATIENT_LIST = "PatientList";
    public static final String OPD_PATIENT_LIST = "OPDPatientList";
    public static final String GET_MEDICATION_MEDICINE_LIST = "MedicineList";

    public static void init(Context context) {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void saveValue(String key, String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void saveValue(String key, long value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }


    public static void saveValue(String key, int value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void saveValue(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void saveNoti(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static String getString(String key) {
        return sharedPref.getString(key, "");
    }

    public static int getInt(String key) {
        return sharedPref.getInt(key, 0);
    }

    public static int getDays(String key) {
        return sharedPref.getInt(key, 90);
    }

    public static long getLong(String key) {
        return sharedPref.getLong(key, 0L);
    }

    public static boolean getBoolean(String key) {
        return sharedPref.getBoolean(key, false);
    }

    public static boolean getNoti(String key) {
        return sharedPref.getBoolean(key, true);
    }

    public static void clearAll() {
        sharedPref.edit().clear().apply();
    }

    public static void clear(String key) {


    }


}
