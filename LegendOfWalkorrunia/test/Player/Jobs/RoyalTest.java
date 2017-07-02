/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Jobs;

import GameEngine.GameEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class RoyalTest {
    GameEngine game;
    Royal royal;
    
    public RoyalTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        royal = new Royal(game);
    }
    
    @After
    public void tearDown() {
        game = null;
        royal = null;
    }

    /**
     * Test of prereqsMet method, of class Royal.
     */
    @Test
    public void testPrereqsMet() {
        System.out.println("prereqsMet");
        assertTrue(royal.prereqsMet());
    }
    
}
