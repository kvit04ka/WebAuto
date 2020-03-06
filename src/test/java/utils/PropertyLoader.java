package test.java.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private  static ResourceBundle src = ResourceBundle.getBundle("confi");{}

   public static String getProperty(String url){
        return src.getString(url);
   }
}
