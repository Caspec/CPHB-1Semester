package dbassignment;


import dbassignment.business.Team;
import dbassignment.business.User;
import dbassignment.data.DataAccessObject;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataAccessObjectTest {
    private static DataAccessObject dao;
    
    public DataAccessObjectTest() {
    }
    
    // Setup
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new DataAccessObjectImpl();
    }
    
    @After
    public void tearDown() {
    }

    
    // Test teams
    @Test
    private void testGetTeamMembers_positiveTest() {
        User user;
        
        ArrayList<User> teamMembers = dao.getTeamMembers(1);
        assertNotNull(teamMembers);
        assertFalse(teamMembers.isEmpty());
        assertEquals(teamMembers.size(), 3);
        
        user = teamMembers.get(0);
        assertEquals(user.getId(), 2);
        assertEquals(user.getUsername(), "Mickey Mouse");
        assertEquals(user.getPassword(), "5678");
        assertEquals(user.isAdmin(), true);
        
        user= teamMembers.get(1);
        assertEquals(user.getId(), 3);
        assertEquals(user.getUsername(), "Fedtmule");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);
        
        user = teamMembers.get(2);
        assertEquals(user.getId(), 7);
        assertEquals(user.getUsername(), "Pluto");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);
    }
    @Test
    private void testGetTeamMembers_negativeTest() {
        ArrayList<User> teamMembers = dao.getTeamMembers(99);
        assertNotNull(teamMembers);
        assertTrue(teamMembers.isEmpty());
    }
    
    @Test
    public void testGetTeams() {
        ArrayList<Team> teams = dao.getTeams();
        assertNotNull(teams);
        assertFalse(teams.isEmpty());
        Team team = teams.get(0);
        assertEquals(team.getName(), "A");
        assertEquals(team.getMembers().size(), 3);
    }

    @Test
    private void testGetTeam_int_positiveTests() {
        Team team = dao.getTeam(1);
        assertNotNull(team);
        assertEquals(team.getName(), "A");
        assertEquals(team.getMembers().size(), 3);
    }
    @Test
    private void testGetTeam_int_negativeTests() {
        Team team = dao.getTeam(99);
        assertNull(team);
    }
    
    @Test
    public void testGetTeam_String_positiveTests() {
        Team team = dao.getTeam("A");
        assertNotNull(team);
        assertEquals(team.getId(), 1);
        assertEquals(team.getMembers().size(), 3);
    }
    @Test
    public void testGetTeam_String_negativeTests() {
        Team team = dao.getTeam("Not a team name!");
        assertNull(team);
    }

    // Test users
    @Test
    public void testGetUsers() {
        fail();
    }

    @Test
    public void testGetUser_int() {
        fail();
    }

    @Test
    public void testGetUser_String() {
        fail();
    }

}
