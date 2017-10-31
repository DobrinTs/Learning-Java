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
public class Spell implements Treasure{
    String name;
    int damage;
    int manaCost;
    
    public Spell(String name, int damage, int manaCost)
    {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }
    
    public String getName(){ return name; }
    public int getDamage(){ return damage; }
    public int getManaCost(){ return manaCost; }
    
    public String collect(Hero h)
    {
        h.learn(this);
        return  "Spell found! Damage points: " + damage 
                +" Mana cost: " + manaCost;
    }
}
