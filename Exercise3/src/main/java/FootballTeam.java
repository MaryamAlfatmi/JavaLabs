public class FootballTeam implements Team{
    private String teamName;
    private int points;
    private String sponsor;

    public FootballTeam(String teamName, int points, String sponsor) {
        this.teamName = teamName;
        this.points = points;
        this.sponsor = sponsor;
    }

    @Override
    public void updatePoints(String result) {
        if(result.equalsIgnoreCase("Win")){
            points += 3;
        }else if(result.equalsIgnoreCase("Drawn")){
            points += 1;
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
