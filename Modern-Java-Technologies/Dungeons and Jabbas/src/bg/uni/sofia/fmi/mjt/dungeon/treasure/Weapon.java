/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.uni.sofia.fmi.mjt.dungeon.treasure;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
/**
 *
 * @author dobri
 */
public class Weapon implements Treasure{
    String name;
    int damage;
    public Weapon(String name, int damage)
    {
        this.name = name;
        this.damage = damage;
    }
    
    public String getName(){ return name; }
    public int getDamage(){return damage; }
    
    public String collect(Hero h)
    {
        h.equip(this);
        return "Weapon found! Damage points: " + damage;
    }
}
