package main;

/**
 * This class creates an instance of the CommandInvoker which initialize the
 * game.
 *
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class App
{
    private CommandInvoker invoker;
    
    /**
     * This method creates and runs an instance of
     * the command invoker class
     */
    public static void main(String[] args)
    {
        invoker = new CommandInvoker();
        invoker.run();
    }
}
