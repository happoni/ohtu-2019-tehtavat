package ohtu;

import java.util.Comparator;

public class Player implements Comparable<Player> {

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
        if (this.name.length() < 16) {
            return name + "\t\t" + team + "\t" + goals + " + " + assists + " = " + (goals + assists);
        } else {
            return name + "\t" + team + "\t" + goals + " + " + assists + " = " + (goals + assists);
        }
    }

    @Override
    public int compareTo(Player o) {
        return (o.goals + o.assists) - (this.goals + this.assists);
    }

}
