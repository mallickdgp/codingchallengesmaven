package com.mallickdgp;

public class StringSplit {

    public static void solution(String s){
        if(s == null || s.trim().equals(""))
            System.out.println(0);
        else{
            s = s.trim();
            String[] arr = s.split("[ !,?._'@]+");
            System.out.println(arr.length);

            for(int i=0; i<arr.length; i++)
                System.out.println(arr[i]);
        }
    }
}
