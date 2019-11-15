
package ohtu;

import java.util.Comparator;

public class Player implements Comparator<Player>{
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }        
        
    @Override
    public String toString() {
        return name + "\t" + team + "\t" + goals + " + " + assists + " = " + (goals + assists);
    }

    @Override
    public int compare(Player o1, Player o2) {
        return (o1.goals + o1.assists) - (o2.goals + o2.assists);
    }
      
}
