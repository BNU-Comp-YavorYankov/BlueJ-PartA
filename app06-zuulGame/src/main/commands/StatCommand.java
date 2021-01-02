package main.commands;

import main.Game;
import main.items.Item;
import main.models.Inventory;
import main.models.Player;

/**
 * The command prints out information
 * about the player of this game
 * 
 * @author Yavor Yankov
 * @version 02/01/2021
 */
public class StatCommand implements Command 
{
    private Game game; // instance of this game

    /**
     * The constructor which recieve the instance 
     * of this game
     * 
     * @param map of this game
     */
    public StatCommand(Game game) 
    {
        this.game = game;
    }

    /**
     * Execute this command as prints out information
     * about the player of this game.
     */
    @Override
    public void execute() 
    {
        Player player = this.game.getPlayer();
        Inventory playerInventory = player.getInventory();

        System.out.println(
            "name:      " + player.getName() + "\n\r" +
            "health:    " + player.getHealth() + "/" + player.getMaxHealthCapacity() + "\n\r" +
            "energy:    " + player.getEnergy() + "/100" + "\n\r" +
            "attack:    " + player.getAttackPoints() + "\n\r" +
            "inventory: ");
        
        if(playerInventory.getWeapon()[0] == null &&
            playerInventory.getShield() == null)
        {
            System.out.println(" - empty");
        }
        else
        {
            for (Item item : playerInventory.getWeapon()) 
            {
                if(item != null)
                {
                    System.out.println(
                        " - " + item.getName() + ": " + 
                        item.getPoints() + " attack");
                }
            }

            if(playerInventory.getShield() != null)
            {
                System.out.println(
                    " - " + playerInventory.getShield().getName() + 
                    ": +" + playerInventory.getShield().getPoints() + 
                    " max health capacity");
            }
        }
        System.out.println();
        this.game.printCurrentLocationLongDescription();
    }
    
    /**
     * @return description of this command
     */
    @Override
    public String toString()
    {
        return "stat - print out information about this player";
    }
}
