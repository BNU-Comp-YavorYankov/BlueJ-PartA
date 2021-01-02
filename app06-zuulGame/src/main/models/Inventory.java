package main.models;

import main.items.Dagger;
import main.items.Item;
import main.items.Shield;
import main.items.Sword;
import main.utilities.InputReader;

/**
 * Class Inventory - a player in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * An "Inventory" represents the player`s equipment in the game. It keeps
 * information about:
 * 
 * @weapon If a weapon is already equipped and 
 * the other weapon is tried to be equipped 
 * the current weapon will be replaced with the new one.
 * The player can carry up to two daggers.
 * 
 * @shield If a shield is already equipped and 
 * the other shield is tried to be equipped 
 * the current shield will be replaced with the new one.
 * 
 * @author Yavor Yankov
 * @version 29/12/2020
 */
public class Inventory 
{
    private Player player; // owner of this inventory
    private Item[] weapon; // weapon of this inventory
    private Shield shield; // shield of this inventory

    /**
     * The constructor create a new inventory.
     * 
     * @param player who is the owner of this inventory
     */
    public Inventory(Player player) 
    {
        this.player = player;
        this.weapon = new Item[2];
    }

    /**
     * @return the equipped weapon
     */
    public Item[] getWeapon()
    {
        return this.weapon;
    }

    /**
     * @return the equipped shield
     */
    public Shield getShield()
    {
        return this.shield;
    }

    /**
     * Equip shield this inventory.
     * 
     * @param shield to be equipped
     */
    public void equipShield(Item shield)
    {
        if(this.shield != null)
        {
            System.out.println(this.shield.getName() + " was replaced with " + shield.getName());
        }
        else
        {
            System.out.println(shield.getName() + " was equipped...");
        }
        this.shield = (Shield)shield;

        this.player.increaseHealthCapacity(this.shield.getPoints());
    }

    /**
     * Equip sword or dagger to this inventory.
     * 
     * @param weapon to be equipped
     */
    public void equipWeapon(Item weapon)
    {
        if(weapon instanceof Sword)
        {
            equipSword(weapon);
        }
        else if(weapon instanceof Dagger)
        {
            equipDagger(weapon);
        }
    }
    
    /**
     * Equip sword to this inventory
     * 
     * @param sword that would be equiped
     */
    private void equipSword(Item sword)
    {
        this.weapon = new Item[1];
        this.weapon[0] = sword;
        
        System.out.println(sword.getName() + " was equipped...");

        this.player.setAttackPoints(sword.getPoints());
    }
    
    /**
     * Equip dagger to that inventory.
     * If there is an equipped dagger the new one
     * will be equipped as a second one.
     * If there are two daggers equipped, the player
     * should decide which one to be replaced with the
     * new one. 
     * 
     * @param dagger is the dagger that would be equiped
     */
    private void equipDagger(Item dagger) 
    {
        int attackPoints = 0;

        if(this.weapon.length < 2)
        {
            this.weapon = new Item[2];
            this.weapon[0] = dagger;

            attackPoints = dagger.getPoints();
            System.out.println(dagger.getName() + " was equipped...");
        }
        else if(this.weapon[0] != null &&
                this.weapon[1] != null)
        {
            replaceDagger(dagger);
            
            attackPoints = this.weapon[0].getPoints() + this.weapon[1].getPoints();
        }
        else if(this.weapon[0] != null)
        {
            this.weapon[1] = dagger;
            attackPoints = this.weapon[0].getPoints() + this.weapon[1].getPoints();
            System.out.println(dagger.getName() + " was equipped...");
        }
        else
        {
            this.weapon[0] = dagger;

            attackPoints = dagger.getPoints();
            System.out.println("Your weapon " + dagger.getName() + " has been equipped...");
        }

        this.player.setAttackPoints(attackPoints);
    }

    /**
     * Replace one of the equipped daggers as
     * ask player to choose which one to be replaced with
     * the new one.
     * 
     * @param item is the dagger that whould be replaced
     */
    private void replaceDagger(Item item)
    {
        System.out.println("You have two equipped daggers.\n\r");
        System.out.println("Please, choose one of your daggers to be raplaced with the new one:\n\r");
        
        for (Item dagger : weapon) 
        {
            System.out.println(dagger.getName());    
        }
        
        InputReader reader = new InputReader();
        
        /**
         * infinite loop for player`s input until 
         * one of the daggers is not replaced
         */
        while(true)
        {
            String daggerName = reader.getString();
            
            // If player`s choice is to replace the first dagger
            if(daggerName.equals(weapon[0].getName()))
            {
                System.out.println(weapon[0].getName() + " was replaced with " + item.getName());
                this.weapon[0] = item;
                break;
            }
            // If player`s choice is to replace the second dagger
            else if(daggerName.equals(weapon[1].getName()))
            {
                System.out.println(weapon[1].getName() + " was replaced with " + item.getName());
                this.weapon[1] = item;
                break;
            }
            else
            {
                System.out.println(daggerName + " is invalid!\n\rTry again...");
            }
        }
    }
}
