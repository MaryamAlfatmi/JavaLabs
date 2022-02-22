import static org.junit.Assert.*;

public class FootballTeamTest {

    @org.junit.Test
    public void updatePoints() {
        FootballTeam fTeam = new FootballTeam("Chelsea",33,"Happy Foot");
        String result = "Win";
        fTeam.updatePoints(result);
        assertEquals(36,fTeam.getPoints());
        String result2 = "Drawn";
        fTeam.updatePoints(result2);
        assertEquals(37,fTeam.getPoints());

        String result3 = "Loose";
        fTeam.updatePoints(result3);
        assertEquals(37,fTeam.getPoints());

    }
}