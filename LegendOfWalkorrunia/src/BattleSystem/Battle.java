/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem;

import Enemies.IEnemy;
import Player.Player;
import Town.Dungeons.IDungeon;

/**
 *
 * @author Thomas
 */
public class Battle {
    private final IDungeon dungeon;
    private final Player player;
    private final IEnemy enemy;
    private Integer playerHealth;
    private Integer enemyHealth;
    
    public Battle(IDungeon dungeon, Player player, IEnemy enemy) {
        this.dungeon = dungeon;
        this.player = player;
        this.enemy = enemy;
        playerHealth = player.getStats().hp;
        enemyHealth = enemy.getStats().hp;
    }
    
    public void attack() {
        if (playerHealth <= 0 || enemyHealth <= 0) return;
        enemyHealth -= Math.max(1, player.getStats().attack - enemy.getStats().defense);
        if (enemyHealth <= 0) {
            dungeon.clearDungeon();
            return;
        }
        playerHealth -= Math.max(1, enemy.getStats().attack - player.getStats().defense);
    }
    
    public String getPlayerName() {
        return player.name;
    }
    
    public String getEnemyName() {
        return enemy.enemyName();
    }
    
    public Integer getPlayerHealth() {
        return playerHealth;
    }
    
    public Integer getEnemyHealth() {
        return enemyHealth;
    }
    
}
