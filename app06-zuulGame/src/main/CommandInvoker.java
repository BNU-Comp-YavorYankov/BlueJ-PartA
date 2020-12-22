package main;

import java.util.HashMap;
import java.util.Set;
import main.commands.*;
import main.utilities.InputReader;

/**
 * CommandInvoker checks user input against the known commands, 
 * and if the input is not one of the known commands, 
 * it prints out an error message.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class CommandInvoker 
{
    /**
     * All commands which can be executed 
     * @key Keeps the name of the command
     * @value Keeps the command class
     */
    private final HashMap<String,Command> commands;
    private InputReader reader; // user input source
    private Game game;          // the new game instance

    /**
     * The constructor of this command invoker class
     * which initialize the commands collection and 
     * adds the known commands into the collection.
     * Also, it initializes the game.
     */
    public CommandInvoker() 
    {
        this.commands = new HashMap<String, Command>();
        this.reader = new InputReader();
        this.game = new Game();
        
        seedAvailableCommands();
    }

    /**
     *  Main play routine. Loops until end of play.
     */
    public void run() 
    {            
        this.game.printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the user run quit command and confirm it.
        while (true) 
        {
            String userCommand = reader.getString();
            this.execute(userCommand);
        }
    }

    /**
     * Execute the command based on the user input.
     * 
     * The way it works is: Recieve the user input
     * and gets all the words in its input.
     * If there is a second word it will be set to direction field.
     * It gets the command from the commands collection,
     * if command exists it will be executed,
     * if no it prints out an error message.
     * 
     * @param userInput The user input which will execute a command.
     */
    public void execute(String userInput) 
    {
        /**
         * Firts index is the command.
         * Second item is additional value such as direction.
         */
        String[] userInputWords = userInput.split(" ");

        Command command = this.commands.get(userInputWords[0]);

        if(command == null)
        {
            System.out.println("I don't know what you mean...");
        }
        else
        {
            /**
             * If the user command is 'go' and there is more than one word
             */
             if(userInputWords[0].equals("go") && userInputWords.length > 1)
            {
                //Gets the go command from commands collection
                command = this.commands.get("go");

                //Cast command interface to GoCommand child class
                ((GoCommand) command).setDirection(userInputWords[1]);
            }
            command.execute();
        }
    }

    
    /**
     * Add all available commands in the commands collection
     */
    private void seedAvailableCommands() 
    {
        this.commands.put("go", new GoCommand(this.game));
        this.commands.put("help", new HelpCommand(getCommandsNames()));
        this.commands.put("quit", new QuitCommand());
    }
    
    /**
     * It gets only the keys/commands names from the commands collection
     * and return them in Set collection
     * 
     * @return Keys/commands names of this commands collection
     */
    private Set<String> getCommandsNames()
    {
        return this.commands.keySet();
    }
}