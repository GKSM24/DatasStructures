package module2.assignment4;

public class Solution{
    public Team[] sort(Team[] teams){
        for (int index = 1; index < teams.length; index++){
            Team temp = teams[index];
            int temp_index = index;
            for(int back_index = index - 1; back_index > -1; back_index--){
                if (teams[back_index].noOfWins < temp.noOfWins)
                    teams[temp_index--] = teams[back_index];
                else if (teams[back_index].noOfWins == temp.noOfWins){
                    if (teams[back_index].noOfLosses > temp.noOfLosses)
                        teams[temp_index--] = teams[back_index];
                    else if (teams[back_index].noOfLosses == temp.noOfLosses)
                    {
                        if (teams[back_index].noOfDraws < temp.noOfDraws)
                            teams[temp_index--] = teams[back_index];
                        else
                            break;
                    }
                    else
                        break;
                }
                else
                    break;
            }
            teams[temp_index] = temp;
        }
        return teams;
    }
}
class Team{
    String teamName;
    int noOfWins;
    int noOfLosses;
    int noOfDraws;
    Team(String name, int wins, int losses, int draws){
        teamName = name;
        noOfDraws = draws;
        noOfWins = wins;
        noOfLosses = losses;
    }
    public String toString(){
        //return all the attributes as a string but appending with ", "
        return teamName+", "+noOfWins+", "+noOfLosses+", "+noOfDraws;
    }
}