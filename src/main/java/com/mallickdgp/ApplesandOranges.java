package com.mallickdgp;

public class ApplesandOranges {

    public void count(int s, int t, int a, int b, int[] apples, int[] oranges){

        int cApples = 0;
        int cOranges = 0;
        for(int i=0; i<apples.length; i++){
            if(apples[i] > 0) {
                int d1 = a+apples[i];
                if(d1 >= s && d1<=t)
                cApples++;
            }
        }
        System.out.println(cApples);
        for(int j=0;j<oranges.length; j++){
            if(oranges[j]<0){
                int d2 = b+oranges[j];
                if(d2<=t && d2>=s)
                    cOranges++;
            }
        }

        System.out.println(cOranges);
    }
}
