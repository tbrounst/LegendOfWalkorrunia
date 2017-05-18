/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town;

import GameEngine.GameEngine;
import Town.Buildings.TownHall;
import Town.Buildings.AbstractBuilding;
import Town.Buildings.RangerStation;
import Town.Buildings.TrainingGrounds;
import Town.Dungeons.Cave;
import Town.Dungeons.Forest;
import Town.Dungeons.AbstractDungeon;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Thomas
 */
public class Town {
    private final GameEngine game;
    private final HashMap<String, AbstractBuilding> buildings = new HashMap();
    private final HashMap<String, AbstractDungeon> dungeons = new HashMap();
    
    public Town(GameEngine game) {
        this.game = game;
        initializeDungeons();
        initializeBuildings();
    }
    
    public Collection<AbstractBuilding> getBuildings() {
        return buildings.values();
    }
    
    public AbstractBuilding getBuilding(String bldg){
        AbstractBuilding result = buildings.get(bldg);
        if (result == null) {
            throw new NullPointerException();
        }
        return result;
    }
    
    public Boolean buildingIsBuilt(String bldg) {
        return getBuilding(bldg).isBuilt();
    }
    
    public Collection<AbstractDungeon> getDungeons() {
        return dungeons.values();
    }
    
    public AbstractDungeon getDungeon(String dungeon) {
        AbstractDungeon result = dungeons.get(dungeon);
        if (result == null) {
            throw new NullPointerException();
        }
        return result;
    }
    
    public Boolean dungeonIsClear(String dungeon) {
        return getDungeon(dungeon).isCleared();
    }
    
    public Integer constructBuilding(AbstractBuilding bldg) {
        return constructBuilding(bldg.getName());
    }
    
    public Integer constructBuilding(String bldg) {
        return buildings.get(bldg).build();
    }

    private void initializeDungeons() {
        smartAddToListDungeon(new Forest(game, this));
        smartAddToListDungeon(new Cave(game, this));
    }

    private void initializeBuildings() {
        smartAddToList(new TownHall(game, this));
        smartAddToList(new TrainingGrounds(game, this));
        smartAddToList(new RangerStation(game, this));
    }
    
    private void smartAddToList(AbstractBuilding bldg) {
        buildings.put(bldg.getName(), bldg);
    }
    
    private void smartAddToListDungeon(AbstractDungeon dungeon) {
        dungeons.put(dungeon.getDungeonName(), dungeon);
    }
    
}
