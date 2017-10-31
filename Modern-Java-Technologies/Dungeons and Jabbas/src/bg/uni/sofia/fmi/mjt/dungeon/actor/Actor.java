/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.uni.sofia.fmi.mjt.dungeon.actor;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
/**
 *
 * @author dobri
 */
public interface Actor {
    String getName();
    int getHealth();
    int getMana();
    boolean isAlive();
    Weapon getWeapon();
    Spell getSpell();
    void takeDamage(int damagePoints);
    int attack();
}
