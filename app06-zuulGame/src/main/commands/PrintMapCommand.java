package main.commands;

import main.models.Map;

/**
 * The command prints out the map of this game.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class PrintMapCommand implements Command 
{
    private Map map; // the map of this game

    /**
     * The constructor which recieve the map 
     * of this game
     * 
     * @param map of this game
     */
    public PrintMapCommand(Map map) 
    {
        this.map = map;
    }

    /**
     * Execute this command as prints out the map of this game.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        System.out.println(this.map);
    }
}
