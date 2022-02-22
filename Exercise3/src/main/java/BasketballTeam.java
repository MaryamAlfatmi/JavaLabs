public class BasketballTeam implements Team{
    private String teamName;
    private int points;

    public BasketballTeam(String teamName, int points) {
        this.teamName = teamName;
        this.points = points;
    }

    @Override
    public void updatePoints(String result) {
        if(result.equalsIgnoreCase("Win")){
            points += 2;

        }

    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
