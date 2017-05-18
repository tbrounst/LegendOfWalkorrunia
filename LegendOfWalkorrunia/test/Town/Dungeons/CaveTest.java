/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Dungeons;

import Enemies.IEnemy;
import GameEngine.GameEngine;
import Town.Town;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class CaveTest {
    GameEngine game;
    Town town;
    AbstractDungeon cave;
    
    public CaveTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        town = game.getTown();
        cave = town.getDungeon("Cave");
    }
    
    @After
    public void tearDown() {
        game = null;
        town = null;
        cave = null;
    }

    /**
     * Test of canAccess method, of class Cave.
     */
    @Test
    public void testCanAccess() {
        System.out.println("canAccess");
        
        Boolean canAccess = cave.canAccess();
        assertFalse(canAccess);
        
        town.getDungeon("Forest").clearDungeon();
        canAccess = cave.canAccess();
        assertTrue(canAccess);
    }    
}
