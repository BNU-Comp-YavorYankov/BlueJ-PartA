package main.commands;

import main.Game;
import main.items.Item;
import main.models.Location;
import main.models.Player;

/**
 * The command pick an item from a location
 * and add it to player`s inventory.
 * 
 * @author Yavor Yankov
 * @version 29/12/2020
 */
public class PickCommand implements Command
{
    /**
     * The item which will be added in the
     * player`s inventory
     */
    private Item item;
    // instance of this game 
    private Game game; 

    /**
     * The constructor which recieve the
     * game instance.
     * 
     * @param game instance of this game
     */
    public PickCommand(Game game) 
    {
        this.game = game;
    }

    /**
     * Sets the item as it finds it from 
     * items in the current locaiton.
     * 
     * @param itemName the item name 
     */
    public void setItem(String itemName)
    {
        this.item = this.game.getCurrentLocation()
            .getItems()
            .get(itemName);
    }

    /**
     * Execute this command as checks is the item exists
     * if not prints out error message,
     * if so add it to players inventory and remove it from
     * the given location.
     */
    @Override
    public void execute() 
    {
        Player player = this.game.getPlayer();
        Location currentLocation = this.game.getCurrentLocation();

        if(this.item == null)
        {
            System.out.println(
                player.getName() + 
                ", the item you are trying to pick cannot be found!");
        }
        else
        {
            player.addItem(this.item);
            
            currentLocation.removeItem(
                this.item.getName());
        }

        if(currentLocation.getItems().size() == 0)
        {
            System.out.println("There are no more items in this location");
        }
    }
}