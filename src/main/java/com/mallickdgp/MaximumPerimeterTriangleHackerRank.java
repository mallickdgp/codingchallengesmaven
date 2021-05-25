package com.mallickdgp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given an array of stick lengths, use 3 of them to construct a non-degenerate triangle with the maximum
possible perimeter. Return an array of the lengths of its sides as  integers in non-decreasing order.

If there are several valid triangles having the maximum perimeter:

Choose the one with the longest maximum side.
If more than one has that maximum, choose from them the one with the longest minimum side.
If more than one has that maximum as well, print any one them.
If no non-degenerate triangle exists, return -1.*/

public class MaximumPerimeterTriangleHackerRank {

    public static List<Integer> solution(List<Integer> sticks){

        Integer maxSum = -1;
        Integer localSum;
        List<Integer> localTraingle;

        Map<Integer, List<Integer>> periMap = new HashMap<>();
        for(int i=0; i<sticks.size(); i++){
            for(int j=i+1; j<sticks.size();j++){
                for(int k=j+1; k<sticks.size();k++){
                    if(sticks.get(i) + sticks.get(j) > sticks.get(k) && sticks.get(j) + sticks.get(k) > sticks.get(i)
                    && sticks.get(k) + sticks.get(i) > sticks.get(j)){
                        localSum = sticks.get(i) + sticks.get(j) + sticks.get(k);
                        if(maxSum == -1 || localSum >= maxSum){
                            maxSum = localSum;
                            localTraingle = Stream.of(sticks.get(i), sticks.get(j), sticks.get(k))
                            .sorted().collect(Collectors.toList());
                            if(!periMap.isEmpty() && periMap.containsKey(maxSum)){
                                if(periMap.get(maxSum).get(0) < localTraingle.get(0) ||
                                        periMap.get(maxSum).get(2) < localTraingle.get(2)){
                                    periMap.put(maxSum, localTraingle);
                                }
                            }else {
                                periMap.clear();
                                periMap.put(maxSum, localTraingle);
                            }
                        }
                    }
                }
            }
        }

        if(maxSum == -1)
            return Arrays.asList(-1);
        else
            return periMap.entrySet().stream().findFirst().get().getValue();
    }
}
