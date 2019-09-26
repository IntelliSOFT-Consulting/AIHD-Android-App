package org.aihdint.aihd.app;

/**
 * Developed by Rodney on 19/01/2018.
 */
public class Variables {
    // File upload url (replace the url with your server address)
    private static final String BASE_URL = "http://45.79.145.240";
    public static final String LOGIN_URL = BASE_URL + ":8080/ems/ws/rest/v1/session";
    //private static final String BASE_URL = "http://104.248.38.22";
    //public static final String LOGIN_URL = BASE_URL + ":8080/openmrs/ws/rest/v1/session";
    public static final String FILE_UPLOAD_URL = BASE_URL + "/file_upload.php";
    public static final String LOGIN_LOCATION = BASE_URL + "/api/login";
    public static final String PATIENT_REGISTER_URL = BASE_URL + "/api/patient/register";
    public static final String PATIENT_DEATH_URL = BASE_URL + "/api/patient/death";
    public static final String PATIENT_URL = BASE_URL + "/api/patients";

    // Directory name to store captured images and videos
    public static final String IMAGE_DIRECTORY_NAME = "aihd/images";
}
