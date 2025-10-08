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

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("AJP1012", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("f25-04" , team.getName());
        assertTrue(team.getMembers().contains("CHIRAN") ,"Team should contain CHIRAN");
        assertTrue(team.getMembers().contains("DAVE S") ,"Team should contain DAVE S");
        assertTrue(team.getMembers().contains("RYAN LEE") ,"Team should contain RYAN LEE");
        assertTrue(team.getMembers().contains("AJAY") ,"Team should contain AJAY");
        assertTrue(team.getMembers().contains("ANTHONY HERBERT") ,"Team should contain ANTHONY HERBERT");
        assertTrue(team.getMembers().contains("MAX LEE") ,"Team should contain MAX LEE");
    }

}
