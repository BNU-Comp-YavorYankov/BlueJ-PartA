import java.util.HashMap;

/**
 * CommandInvoke is responsible to parse the user input and execute the proper command
 * Command Design Pattern: The Invoker class
 *  
 * @author Yavor Yankov
 * @version 11/10/2020
 */
public class CommandInvoker 
{
    /**
     * All commands which can be executed 
     * @key Keeps the name of the command
     * @value Keeps the command class
     */
    private final HashMap<String,Command> commands;
    /**
     * The stock manager of this Stock Management Application.
     * Command Design Pattern: this is the Reciever
     **/
    private StockManager manager;

    /**
     * The constructor of this command invoker class
     */
    public CommandInvoker() 
    {
        this.manager = new StockManager();
        this.commands = new HashMap<String, Command>();
  
        seedAvailableCommands();
    }

    /**
     * Execute the command based on the user input.
     * 
     * @param userInput The user input which will execute a command.
     */
    public void execute(String userInput) 
    {
        Command command = this.commands.get(userInput.toLowerCase());

        if(command == null)
        {
            System.out.println(" Invalid command!");
        }
        else
        {
            command.execute();
        }
    }

    /**
     * Add all available commands in the commands collection
     */
    private void seedAvailableCommands() 
    {
        this.commands.put("add", new AddProductCommand(this.manager));
        this.commands.put("remove", new RemoveProductCommand(this.manager));
        this.commands.put("print", new PrintAllProductsCommand(this.manager));
        this.commands.put("search", new SearchProductsByPartNameCommand(this.manager));
        this.commands.put("low-stock", new PrintLowStockLevelProductsCommand(this.manager));
        this.commands.put("deliver", new DeliverProductCommand(this.manager));
        this.commands.put("sell", new SellProductCommand(this.manager));
        this.commands.put("re-stock", new ReStockProductsCommand(this.manager));
    }
}
