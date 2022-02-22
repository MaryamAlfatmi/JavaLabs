import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){
        String teamsPath = "src/main/resources/teams.csv";
        String resultsPath = "src/main/resources/results.csv";
        String line = "";
        List<Team> BTeam = new ArrayList<Team>();
        List<Team> FTeam = new ArrayList<Team>();

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(teamsPath));
            while((line = br1.readLine())!=null){
                String values[] = line.split(",");
                if(values[0].equalsIgnoreCase("Basketball")) {
                    BTeam.add(new BasketballTeam(values[1],Integer.parseInt(values[2])));
                }
                else{
                    FTeam.add(new FootballTeam(values[1],Integer.parseInt(values[2]),values[3]));
                }
            }
            printResults(BTeam,FTeam);

            /*Load results.csv file
            update points of teams according to  last matches
            compute the positions of teams as per points */

            System.out.println("");
            System.out.println("Loading results.csv file............");
            BufferedReader br2 = new BufferedReader(new FileReader(resultsPath));
            while((line = br2.readLine())!=null){
                String values[] = line.split(",");
                //System.out.println(line);
                for(Team basketballTeam : BTeam){
                    if(basketballTeam.getTeamName().equalsIgnoreCase(values[0])){
                        basketballTeam.updatePoints(values[1]);
                    }
                }
                for(Team footballTeam : FTeam){
                    if(footballTeam.getTeamName().equalsIgnoreCase(values[0])){
                        footballTeam.updatePoints(values[1]);
                    }
                }
                printResults(BTeam,FTeam);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printResults(List<Team> BTeam, List<Team> FTeam){
        BTeam.sort(Comparator.comparing(Team::getPoints).reversed());
        FTeam.sort(Comparator.comparing(Team::getPoints).reversed());

        System.out.println("Standing of BasketBall Teams according to points.........");
        for(Team b:BTeam)
        {
            System.out.println(b.getTeamName() +" -> "+b.getPoints());
        }

        System.out.println("");
        System.out.println("Standing of Football Teams according to points..........");
        for(Team f:FTeam)
        {
            System.out.println(f.getTeamName() +" -> "+f.getPoints());
        }
    }
}
