package com.mallickdgp;

public class KangarooJumps {

    /*
    You are choreographing a circus show with various animals. For one act, you are given two kangaroos
    on a number line ready to jump in the positive direction (i.e, toward positive infinity)
The first kangaroo starts at location x1and moves at a rate of v1meters per jump
The second kangaroo starts at location x2and moves at a rate of v2meters per jump
You have to figure out a way to get both kangaroos at the same location at the same time as part of the show.
If it is possible, return YES. Otherwise, return NO.
For example, kangaroo 1 starts at x1 = 2 with a jump distance of v1 = 1and kangaroo 2 start at x2= 1with a jump
 distance of v2 = 2. After one jump, they are both at x = 3, as x1 + v1 = 2+1 = 3, x2 + v2 = 1+2 = 3,
 so our answer is YES
     */

    public static String solution(int x1, int v1, int x2, int v2){
        if(x1 == x2 && v1 != v2)
            return "NO";
        if(x1 < x2 && v1 < v2)
            return "NO";
        else if(x1 > x2 && v1 > v2)
            return  "NO";
        if ((v1 != v2) && ((x1 - x2) % (v2 - v1) == 0 || (x2 - x1) % (v1 - v2) == 0))
                return "YES";

        else
            return "NO";
    }
}
