package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Ajay", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("AJP1012", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("f25-04" , team.getName());
        assertTrue(team.getMembers().contains("Ajay")      ,"Team should contain Ajay");
        assertTrue(team.getMembers().contains("Ryan")      ,"Team should contain Ryan");
        assertTrue(team.getMembers().contains("Chiran")    ,"Team should contain Chiran");
        assertTrue(team.getMembers().contains("Dave")      ,"Team should contain Dave");
        assertTrue(team.getMembers().contains("Anthony")   ,"Team should contain Anthony");
        assertTrue(team.getMembers().contains("Max")       ,"Team should contain Max");
    }

}
