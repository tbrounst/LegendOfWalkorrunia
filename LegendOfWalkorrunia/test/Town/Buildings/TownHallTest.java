/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Buildings;

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
public class TownHallTest {
    GameEngine game;
    Town town;
    AbstractBuilding building;
    
    public TownHallTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        town = game.getTown();
        building = town.getBuilding("Town Hall");
    }
    
    @After
    public void tearDown() {
        game = null;
        town = null;
        building = null;
    }

    /**
     * Test of canBeBuilt method, of class TownHall.
     */
    @Test
    public void testCanBeBuilt() {
        System.out.println("canBeBuilt");
        Boolean canBeBuilt = building.canBeBuilt();
        assertTrue(canBeBuilt);
    }
    
}
