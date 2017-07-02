/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem;

import Player.Stats;

/**
 *
 * @author Thomas
 */
public class Buff {
    private final ICombatant character;
    private Integer turnsRemaining;
    private final Stats changes;
    
    public Buff(ICombatant character, Integer lengthOfBuff, Stats changes) {
        this.character = character;
        if (lengthOfBuff < 1) lengthOfBuff = 1;
        this.turnsRemaining = lengthOfBuff;
        this.changes = changes;
    }
    
    public ICombatant getCharacter() {
        return character;
    }
    
    void decrementTurnsRemaining() {
        turnsRemaining--;
    }
    
    public Boolean isFinished() {
        return (turnsRemaining < 1);
    }
    
    public Integer turnsRemaining() {
        return turnsRemaining;
    }
    
    public Stats getChanges() {
        return changes;
    }
    
    
}
