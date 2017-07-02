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
public class KnightTest {
    GameEngine game;
    Knight knight;
    
    public KnightTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        knight = new Knight(game);
    }
    
    @After
    public void tearDown() {
        game = null;
        knight = null;
    }

    /**
     * Test of prereqsMet method, of class Knight.
     */
    @Test
    public void testPrereqsMet() {
        System.out.println("prereqsMet");
        assertFalse(knight.prereqsMet());
        
        game.getTown().getDungeon("Forest").clearDungeon();
        game.getTown().constructBuilding("Training Grounds");
        assertTrue(knight.prereqsMet());
    }
    
}
