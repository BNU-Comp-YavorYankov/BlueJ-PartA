package main.commands;

import main.Game;

/**
 * The command prints out the map of this game.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class PrintMapCommand implements Command 
{
    private Game game; // instance of this game

    /**
     * The constructor which recieve the instance 
     * of this game
     * 
     * @param map of this game
     */
    public PrintMapCommand(Game game) 
    {
        this.game = game;
    }

    /**
     * Execute this command as prints out the map 
     * of this game and the current location of the player.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        System.out.println(this.game.getMap());
        this.game.printCurrentLocationLongDescription();
    }
    
    /**
     * @return description of this command
     */
    @Override
    public String toString()
    {
        return "map - print out the map";
    }
}
