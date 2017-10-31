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
public class Enemy implements Actor{
    String name;
    int currentHealth;
//    int maxHealth;
//    int maxMana;
    int currentMana;
//    Position position;
    Weapon weapon;
    Spell spell;
    
    public Enemy(String name, int health, int mana, Weapon weapon, Spell spell)
    {
        this.name = name;
        this.currentHealth = health;
        this.currentMana = mana;
        this.weapon = weapon;
        this.spell = spell;
    }
    
    public String getName(){ return name; }
    public int getHealth(){ return currentHealth; }
    public int getMana(){ return currentMana; }
    
    public boolean isAlive()
    {
        return currentHealth > 0;
    }
    
    public Weapon getWeapon()
    {
        return weapon;
    }
    
    public Spell getSpell()
    {
        return spell;
    }
    
    public void takeDamage(int damagePoints)
    {
        currentHealth -= damagePoints;
        if( currentHealth < 0 )
            currentHealth = 0;
    }
    
    public int attack()
    {
        int att = 0;
        if(weapon != null)
            att = weapon.getDamage();
        
        if(spell != null && spell.getDamage() > att 
                && currentMana >= spell.getManaCost())
        {
            att = spell.getDamage();
            currentMana -= spell.getManaCost();
        }
        
        return att;
    }
}
