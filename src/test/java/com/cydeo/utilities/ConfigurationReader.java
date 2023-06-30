package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1- Create object of properties
    //Make it "private so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else
    private static Properties properties = new Properties();
    static {
        //2- We need to open the file in the Java memories using FileInputStream
        //3- Load the properties file in the properties objects
        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            //close the file in the memory
            file.close();

        }catch (IOException e){
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }
    //4= Use the "properties" object tp read value from the file
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
