package com.mallickdgp;

import java.util.LinkedList;
import java.util.List;

public class CompareTriplets {

    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> points = new LinkedList<>();
        if (a == null || b == null)
            return points;

        int AlicePoints = 0;
        int BobPoints = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i))
                AlicePoints++;
            else if (a.get(i) < b.get(i))
                BobPoints++;
        }
        points.add(AlicePoints);
        points.add(BobPoints);

        return points;
    }
}
