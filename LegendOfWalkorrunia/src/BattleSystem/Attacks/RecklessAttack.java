/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem.Attacks;

import BattleSystem.Battle;
import BattleSystem.Buff;
import BattleSystem.ICombatant;
import Player.Stats;

/**
 *
 * @author Thomas
 */
public class RecklessAttack extends AbstractAttack {
    String thisAttackName = "Reckless Attack";
    String thisAttackDescription = "Hit for extra damage, butyou take more damage as well.";
    
    public RecklessAttack(/*Battle battle*/) {
        //super(battle);
        super();
        super.attackName = thisAttackName;
        super.attackDescription = thisAttackDescription;
    }
    
    @Override
    public void attack(Battle battle, ICombatant attacker, ICombatant defender) {
        Stats statBoost = new Stats(0, 2, -2, 0, 0, 0);
        Buff buff = new Buff(attacker, 1, statBoost);
        battle.addBuff(buff);
        basicAttack(battle, attacker, defender);
    }
    
}
