package com.mallickdgp;

public class LambdaOddEvenPalindrome {


        public boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        public PerformOperation isOdd(){
            return (n -> n%2 == 0 ? false : true);
        }

        public PerformOperation isPrime(){
            return (n -> {
                if(n == 0 || n == 1 || n == 2)
                    return true;
                for(int i=3;i<=n/2;i++){
                    if(n%i == 0)
                        return false;
                }

                return true;
            });
        }

        public PerformOperation isPalindrome(){
            return (n -> {
                char[] numArr = (n+"").toCharArray();
                for(int i=0; i<numArr.length/2; i++){
                    if(numArr[i] == numArr[numArr.length-1-i])
                        continue;
                    else{
                        return false;
                    }

                }
                return true;
            });
        }

    }


interface PerformOperation {
    boolean check(int a);
}
