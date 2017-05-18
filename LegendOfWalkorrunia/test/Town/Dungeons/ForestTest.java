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
public class ForestTest {
    GameEngine game;
    Town town;
    AbstractDungeon forest;
    
    public ForestTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        town = game.getTown();
        forest = town.getDungeon("Forest");
    }
    
    @After
    public void tearDown() {
        game = null;
        town = null;
        forest = null;
    }

    /**
     * Test of canAccess method, of class Forest.
     */
    @Test
    public void testCanAccess() {
        System.out.println("canAccess");
        
        Boolean canAccess = forest.canAccess();
        assertTrue(canAccess);
    }    
}
