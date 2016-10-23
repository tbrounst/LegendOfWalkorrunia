/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Dungeons;

import BattleSystem.Battle;

/**
 *
 * @author Thomas
 */
public interface IDungeon {
    
    public String getDungeonName();
    
    public Boolean canAccess();
    
    public Boolean isCleared();
    
    public void clearDungeon();
    
    public Battle createBattle();
    
}
