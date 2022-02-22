import org.junit.Test;

import static org.junit.Assert.*;

public class BasketballTeamTest {

    @Test
    public void updatePoints() {
        BasketballTeam bTeam = new BasketballTeam("Boston Celtics",10);
        String result = "Win";
        bTeam.updatePoints(result);
        assertEquals(12,bTeam.getPoints());
        String result2 = "Loose";
        bTeam.updatePoints(result2);
        assertEquals(12,bTeam.getPoints());

    }
}