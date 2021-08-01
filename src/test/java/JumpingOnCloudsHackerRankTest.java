import com.mallickdgp.JumpingOnCloudsHackerRank;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class JumpingOnCloudsHackerRankTest {

    @Test
    public void testUC01TC01(){

        int jumps = JumpingOnCloudsHackerRank.solution(Arrays.asList(0,1,0,0,0,1,0));

        assertEquals(3, jumps);

    }

    @Test
    public void testUC01TC02(){

        int jumps = JumpingOnCloudsHackerRank.solution(Arrays.asList(0,0,1,0,0,1,0));

        assertEquals(4, jumps);

    }

    @Test
    public void testUC01TC03(){

        int jumps = JumpingOnCloudsHackerRank.solution(Arrays.asList(0,0,0,1,0,0));

        assertEquals(3, jumps);

    }
}
