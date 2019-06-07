package homework.lesson11.MyNewLocal;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyLocal {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        printInfo("", "");
//        printInfo("ru", "RU");
        printInfo("en", "US");



    }

    private static void printInfo(String language, String country) {
        Locale locale = new Locale(language, country);

        ResourceBundle rb = ResourceBundle.getBundle("text", locale);

        String s1 = rb.getString("str1");
        String s2 = rb.getString("str2");
        String s3 = rb.getString("str3");
        String s4 = rb.getString("str4");
        String s5 = rb.getString("str5");
        String s6 = rb.getString("str6");
        String s7 = rb.getString("str7");
        String s8 = rb.getString("str8");
        String s9 = rb.getString("str9");
        String s10 = rb.getString("str10");
        String s11 = rb.getString("str11");
        String s12 = rb.getString("str12");
        String s13 = rb.getString("str13");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s9);
        System.out.println(s10);
        System.out.println(s11);
        System.out.println(s12);
        System.out.println(s13);
    }
}
