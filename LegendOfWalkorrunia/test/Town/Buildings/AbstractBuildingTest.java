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
public class AbstractBuildingTest {
    GameEngine game;
    Town town;
    AbstractBuilding building;
    
    public AbstractBuildingTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        town = game.getTown();
        building = new AbstractBuildingImpl(game, town);
    }
    
    @After
    public void tearDown() {
        game = null;
        town = null;
        building = null;
    }

    /**
     * Test of getName method, of class AbstractBuilding.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("Abstract building", building.getName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDescription method, of class AbstractBuilding.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        assertEquals("Dumb abstract building", building.getDescription());
    }

    /**
     * Test of build method, of class AbstractBuilding.
     */
    @Test
    public void testBuild() {
        System.out.println("build");
        game.getPlayer().setEps(0);
        assertEquals((Integer) 1, building.build());
        assertEquals((Integer) 0, game.getPlayer().getEps());
        
        game.getPlayer().setEps(600);
        assertEquals((Integer) 3, building.build());
        assertEquals((Integer) 600, game.getPlayer().getEps());
        
        game.getPlayer().setEps(800);
        assertEquals((Integer) 0, building.build());
        assertEquals((Integer) 300, game.getPlayer().getEps());
        
        game.getPlayer().setEps(1000);
        assertEquals((Integer) 2, building.build());
        assertEquals((Integer) 1000, game.getPlayer().getEps());
    }

    public class AbstractBuildingImpl extends AbstractBuilding {

        public AbstractBuildingImpl(GameEngine game, Town town) {
            super(game, town);
            super.buildingName = "Abstract building";
            super.buildingDescription = "Dumb abstract building";
            super.buildingCost = 500;
        }

        public boolean canBeBuilt() {
            return (game.getPlayer().getEps() > 700);
        }
    }
    
}
