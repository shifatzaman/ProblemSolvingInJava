package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner implements ISolution{
    @Override
    public void solve() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(new ArrayList<>(List.of("HTML", "C#")));
        competitions.add(new ArrayList<>(List.of("C#", "PYTHON")));
        competitions.add(new ArrayList<>(List.of("PYTHON", "HTML")));
        ArrayList<Integer> results = new ArrayList<>(new ArrayList<>(List.of(1,0,0)));


        String result = tournamentWinner(competitions, results);
        System.out.println(result);
    }

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        // Write your code here.
        Map<String, Integer> tournamentMappers = new HashMap<>();

        int competitionNumber = 0;
        String winner = "";
        Integer currentHighestWin = 0;
        for (ArrayList<String> competition : competitions) {
            String currentWinner = results.get(competitionNumber) == 0 ? competition.get(1) : competition.get(0);
            if (tournamentMappers.containsKey(currentWinner)) {
                tournamentMappers.put(currentWinner, tournamentMappers.get(currentWinner) + 1);
            } else {
                tournamentMappers.put(currentWinner, 1);
            }

            if (tournamentMappers.get(currentWinner) > currentHighestWin) {
                currentHighestWin = tournamentMappers.get(currentWinner);
                winner = currentWinner;
            }

            competitionNumber++;
        }

        return winner;
    }
}

