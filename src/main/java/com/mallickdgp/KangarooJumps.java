package com.mallickdgp;

public class KangarooJumps {

    public static void solution(int x1, int v1, int x2, int v2){
        if(x1==x2 && v1 == v2)
            System.out.println("YES");
        else if(x1 != x2 && v1 == v2)
            System.out.println("NO");
        else{
            int currentPoint1 = x1;
            int currentPoint2 = x2;
            while(true){
                currentPoint1 = currentPoint1 + v1;
                currentPoint2 = currentPoint2 + v2;
                if(currentPoint1 == currentPoint2){
                    System.out.println("YES");
                    break;
                }

            }
        }
    }
}
