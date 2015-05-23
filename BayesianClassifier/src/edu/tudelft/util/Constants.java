package edu.tudelft.util;




/**
 * Created by arpan on 5/4/2015.
 */
public class Constants {
/*File path where data file is written */
    public static final String WRITE_PATH = "Z:\\01_TUD\\es\\Q4\\smart_phone_sensing\\data\\app.txt";
    public static final String WRITE_PATH_DEBUG = "Z:\\01_TUD\\es\\Q4\\smart_phone_sensing\\data\\app_debug.txt";

    /*File path for Trained values for standing*/
    public static final String READ_PATH_ClASS_STANDING = "Z:\\01_TUD\\es\\Q4\\smart_phone_sensing\\data\\app_standing.txt";
    /*File path for Trained values for walking*/
    public static final String READ_PATH_CLASS_WALKING = "Z:\\01_TUD\\es\\Q4\\smart_phone_sensing\\data\\app_walking.txt";
    /*File path for Trained values for bayesian*/
    public static final String PATH_BAYESIAN_DATA= "Z:\\01_TUD\\es\\Q4\\smart_phone_sensing\\data\\bayesianData.txt";
    /*File path for Trained values for test*/
    public static final String TEST_FILE_PATH = "Z:\\01_TUD\\es\\Q4\\smart_phone_sensing\\data\\testdata.txt";
    /*class representation for standing*/
    public static final int STANDING = 0;
    /*class representation for walking*/
    public static final int WALKING = 25;
    /*Value of K*/
    public static final int K =5;

    /*FFT SIZE*/
    public static final int FFT_SIZE = 64;

    /*OVERLAPPING SIZE*/
    public static final int OVERLAP_SIZE = 32;
    /*Number of Blocks*/
	public static final int NUMBER_OF_BLOCKS = 11 ;
	
}

