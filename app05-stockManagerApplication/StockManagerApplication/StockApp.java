package StockManagerApplication;

/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 11/10/2020
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    // Command invoker of this application
    private CommandInvoker commandInvoker;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        this.input = new InputReader();
        this.commandInvoker = new CommandInvoker();
    }

    /**
     * Run the Stock Management Application.
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * Get user input and invoke command parser as pass the user input.
     */
    public void getMenuChoice()
    {
        printMenuChoices();

        String choice = input.getString();
        
        while(true)
        {
            this.commandInvoker.execute(choice);
            
            printMenuChoices();
            choice = input.getString();
        }
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Deliver:    Deliver a quantity of product");
        System.out.println("    Sell:       Sell a quantity of product");
        System.out.println("    Re-Stock:   Re-stock all the low stock products up to a set minimum level");
        System.out.println("    Search:     Print products based on part of the product name");
        System.out.println("    Low-Stock:  Print products whose stock levels are low");
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Yavor Yankov");
        System.out.println("******************************");
    }
}
