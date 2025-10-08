package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team();    
        team.setName("test-team");
        team.addMember("test-member");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[test-member])", team.toString());
    }

    @Test
    public void equals_returns_correctly() {
        assertTrue(team.equals(team) , "Same object should return true.");

        String test_String = "This is not a Team.";
        assertFalse(team.equals(test_String) , "Different class should return false.");

        Team team_TT = new Team();
        team_TT.setName(team.getName());
        team_TT.setMembers(team.getMembers());
        assertTrue(team.equals(team_TT) , "TT should return true.");

        Team team_TF = new Team();
        team_TF.setName(team.getName());
        assertFalse(team.equals(team_TF) , "TF return false.");

        Team team_FT = new Team();
        team_FT.setMembers(team.getMembers());
        assertFalse(team.equals(team_FT) , "FT return false.");

        Team team_FF = new Team();
        assertFalse(team.equals(team_FF) , "FF return false.");

    }

    @Test
    public void hashCode_returns_correctly() {
            int result = team.hashCode();
            int expectedResult = -1208227076;
            assertEquals(expectedResult, result);

    }


}
