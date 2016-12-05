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
public class SuperDefense extends AbstractAttack{
    String thisAttackName = "Super Defense";
    String thisAttackDescription = "Grants incredible defense for two turns";
    
    public SuperDefense(/*Battle battle*/) {
        //super(battle);
        super();
        super.attackName = thisAttackName;
        super.attackDescription = thisAttackDescription;
    }
    
    @Override
    public void attack(Battle battle, ICombatant attacker, ICombatant defender) {
        Stats statBoost = new Stats(0, 0, 50, 0, 0, 0);
        Buff buff = new Buff(attacker, 3, statBoost);
        battle.addBuff(buff);
    }
    
}
