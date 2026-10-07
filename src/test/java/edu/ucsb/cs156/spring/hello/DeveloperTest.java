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
        assertEquals("Chi", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("Supermonters", Developer.getGithubId());
    }    
    
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f26-15", t.getName());
    }
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();

        assertTrue(t.getMembers().contains("Chi"),"Team should contain Chi");

        assertTrue(t.getMembers().contains("Grace"),"Team should contain Grace");

        assertTrue(t.getMembers().contains("Leo"),"Team should contain Leo");
        
        assertTrue(t.getMembers().contains("Haasini"),"Team should contain Haasini");

        assertTrue(t.getMembers().contains("Roland"),"Team should contain Roland");
        
        assertTrue(t.getMembers().contains("Siddharth"),"Team should contain Siddharth");
    }
}
