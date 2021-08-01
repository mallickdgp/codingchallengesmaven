import com.mallickdgp.QueensAttackHackerRank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QueensAttackHackerRankTest {

    @Test
    public void testUC01TC01(){
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        List<List<Integer>> obstacles = new ArrayList<>();

        obstacles.add(Arrays.asList(5,5));
        obstacles.add(Arrays.asList(4,2));
        obstacles.add(Arrays.asList(2,3));

        int numberOfMoves = QueensAttackHackerRank.solution(n,k,r_q,c_q,obstacles);

        assertEquals(10, numberOfMoves);
    }

    @Test
    public void testUC01TC02(){
        int n = 1;
        int k = 0;
        int r_q = 1;
        int c_q = 1;
        List<List<Integer>> obstacles = new ArrayList<>();

        obstacles.add(Arrays.asList(5,5));
        obstacles.add(Arrays.asList(4,2));
        obstacles.add(Arrays.asList(2,3));

        int numberOfMoves = QueensAttackHackerRank.solution(n,k,r_q,c_q,obstacles);

        assertEquals(0, numberOfMoves);
    }

    @Test
    public void testUC01TC03(){
        int n = 4;
        int k = 0;
        int r_q = 4;
        int c_q = 4;
        List<List<Integer>> obstacles = new ArrayList<>();

        obstacles.add(Arrays.asList(5,5));
        obstacles.add(Arrays.asList(4,2));
        obstacles.add(Arrays.asList(2,3));

        int numberOfMoves = QueensAttackHackerRank.solution(n,k,r_q,c_q,obstacles);

        assertEquals(9, numberOfMoves);
    }
}
