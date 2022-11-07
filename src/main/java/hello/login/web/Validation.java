package hello.login.web;

import java.util.regex.Matcher;


public class Validation {
    public static final String p1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
    public static final String p2 = "^[A-Za-z[0-9]]{10,20}$";
    public static final String p3 = "^[[0-9]$@$!%*#?&]{10,20}$";
    public static final String p4 = "^[[A-Za-z]$@$!%*#?&]{10,20}$";
    public static final String p5 = "(\\w)\\1\\1";
    Matcher m;

}
