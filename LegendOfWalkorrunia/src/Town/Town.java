/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town;

import GameEngine.GameEngine;
import Town.Buildings.TownHall;
import Town.Buildings.IBuilding;
import Town.Buildings.RangerStation;
import Town.Buildings.TrainingGrounds;
import Town.Dungeons.Cave;
import Town.Dungeons.Forest;
import Town.Dungeons.IDungeon;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Thomas
 */
public class Town {
    private final GameEngine game;
    private final HashMap<String, IBuilding> buildings = new HashMap();
    private final HashMap<String, IDungeon> dungeons = new HashMap();
    
    public Town(GameEngine game) {
        this.game = game;
        initializeDungeons();
        initializeBuildings();
    }
    
    public Collection<IBuilding> getBuildings() {
        return buildings.values();
    }
    
    public IBuilding getBuilding(String bldg) {
        return buildings.get(bldg);
    }
    
    public Boolean buildingIsBuilt(String bldg) {
        return buildings.get(bldg).isBuilt();
    }
    
    public Collection<IDungeon> getDungeons() {
        return dungeons.values();
    }
    
    public IDungeon getDungeon(String dungeon) {
        return dungeons.get(dungeon);
    }
    
    public Boolean dungeonIsClear(String dungeon) {
        return dungeons.get(dungeon).isCleared();
    }
    
    public void constructBuilding(IBuilding bldg) {
        constructBuilding(bldg.getName());
    }
    
    public void constructBuilding(String bldg) {
        buildings.get(bldg).build();
    }
    
    public void clearDungeon(String dungeon) {
        dungeons.get(dungeon).clearDungeon();
    }

    private void initializeDungeons() {
        smartAddToListDungeon(new Forest(game, this));
        smartAddToListDungeon(new Cave(game, this));
    }

    private void initializeBuildings() {
        smartAddToList(new TownHall(this));
        smartAddToList(new TrainingGrounds(game, this));
        smartAddToList(new RangerStation(this));
    }
    
    private void smartAddToList(IBuilding bldg) {
        buildings.put(bldg.getName(), bldg);
    }
    
    private void smartAddToListDungeon(IDungeon dungeon) {
        dungeons.put(dungeon.getDungeonName(), dungeon);
    }
    
}
