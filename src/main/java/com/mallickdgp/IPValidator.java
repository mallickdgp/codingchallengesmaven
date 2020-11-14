package com.mallickdgp;

public class IPValidator {


    private class MyRegEx{
        private String IPDigitsRegEx = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";

        String pattern = IPDigitsRegEx + "\\."+IPDigitsRegEx+"\\."+IPDigitsRegEx+"\\."+IPDigitsRegEx;
    }
}
