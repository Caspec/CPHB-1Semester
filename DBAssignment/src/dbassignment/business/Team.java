package dbassignment.business;

import java.util.ArrayList;

public class Team {
    
    private int team_id;
    private int id;
    private String name;
    private ArrayList members;

    public Team(int team_id, String name)
    {
        this.team_id = team_id;
        this.name = name;
    }

    
    
    public int getTeam_id()
    {
        return team_id;
    }

    public void setTeam_id(int team_id)
    {
        this.team_id = team_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList getMembers()
    {
        return members;
    }

    public void setMembers(ArrayList members)
    {
        this.members = members;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Team{" + "team_id=" + team_id + ", id=" + id + ", name=" + name + ", members=" + members + '}';
    }
    
    
}
