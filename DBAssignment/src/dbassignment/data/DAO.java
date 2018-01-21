/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbassignment.data;

import dbassignment.business.Team;
import dbassignment.business.User;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author auron
 */
public class DAO implements DataAccessObject
{
    
    
    public ArrayList<String> getAllFromUser()
    {
        ArrayList<String> list = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM db_as.user;";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                String names = res.getString("user.username");
                list.add(names);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public String getCorrectLocation(){
        
        try {
            String query = "SELECT loc FROM dept INNER JOIN emp ON emp.deptno=dept.deptno WHERE ename = \"ALLEN\";";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if(res.next()){
                String loc = res.getString("loc");
                return loc;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
    
    public static void main(String[] args)
    {
        System.out.println(new DAO().getAllFromUser());
        System.out.println(new DAO().getUser(5));
        System.out.println(new DAO().getUser("Anders And"));
        System.out.println(new DAO().getTeam(2));
        System.out.println(new DAO().getTeam("A"));
  
    }

    @Override
    public ArrayList<User> getTeamMembers(int team_id)
    {
        ArrayList<User> list = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM db_as.team_member;";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                list.add(getUser(team_id));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    
    }

    @Override
    public ArrayList<Team> getTeams()
    {
        ArrayList<Team> teamList = new ArrayList<>();
          int team_id = 0;
          String team_name = "";

         try {
            String query = "SELECT team.team_id, teamname FROM db_as.team;";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
               team_id = res.getInt("team_id");
               team_name = res.getString("teamname");
               
               Team team = new Team(team_id, team_name);
               teamList.add(team);
            }
            
            return teamList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

            }
    }

    @Override
    public Team getTeam(int id)
    {
       int team_id = 0;
       String team_name = "";

       
         try {
            String query = "SELECT team.team_id, teamname FROM db_as.team INNER JOIN team_member ON team.team_id=team_member.team_id WHERE team.team_id ="+id+";";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
               team_id = res.getInt("team_id");
               team_name = res.getString("teamname");
               
            }
            Team team = new Team(team_id, team_name);
            return team;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

            }
    }

    @Override
    public Team getTeam(String teamname)
    {
         int team_id = 0;

       
         try {
            String query = "SELECT team.team_id, teamname FROM db_as.team INNER JOIN team_member ON team.team_id=team_member.team_id WHERE team.teamname ='"+teamname+"';";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
               team_id = res.getInt("team_id");
               
               
            }
            Team team = new Team(team_id, teamname);
            return team;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

            }
    }

    @Override
    public ArrayList<User> getUsers()
    {
         ArrayList<User> userList = new ArrayList<>();
          int user_id = 0;
          String user_name = "";
          String password = "";
          int isAdmin = 0;

         try {
            String query = "SELECT user.user_id, username FROM db_as.user;";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
               user_id = res.getInt("user_id");
               user_name = res.getString("username");
               password = res.getString("password");
               isAdmin = res.getInt("admin");
               
               User user = new User(user_id, user_name, password, isAdmin);
               userList.add(user);
            }
            
            return userList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

            }
    }

    @Override
    public User getUser(int id)
    {
       int user_id = 0;
       String username = "";
       String password = "";
       int isAdmin = 0;
       
         try {
            String query = "SELECT * FROM db_as.user WHERE user_id ="+id+";";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
               user_id = res.getInt("user_id");
               username = res.getString("username");
               password = res.getString("password");
               isAdmin = res.getInt("admin");
            }
            User user = new User(user_id,username,password,isAdmin);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

            }
    }

    @Override
    public User getUser(String username)
    {
       int user_id = 0;
       String password = "";
       int isAdmin = 0;
       
         try {
            String query = "SELECT * FROM db_as.user WHERE username ='"+username+"';";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
               user_id = res.getInt("user_id");
               username = res.getString("username");
               password = res.getString("password");
               isAdmin = res.getInt("admin");
            }
            User user = new User(user_id,username,password,isAdmin);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

            }
    }
}
