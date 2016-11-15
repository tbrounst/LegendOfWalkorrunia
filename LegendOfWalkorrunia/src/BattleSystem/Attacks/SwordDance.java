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
public class SwordDance extends AbstractAttack {
    String thisAttackName = "Sword Dance";
    String thisAttackDescription = "Boost attack and defense.";
    
    public SwordDance(Battle battle) {
        super(battle);
        super.attackName = thisAttackName;
        super.attackDescription = thisAttackDescription;
    }
    
    @Override
    public void attack(ICombatant attacker, ICombatant defender) {
        Stats statBoost = new Stats(0, 2, 2, 0, 0, 0);
        Buff buff = new Buff(attacker, 5, statBoost);
        battle.addBuff(buff);
    }
}
