package StockManagerApplication.Commands;

import StockManagerApplication.*;

/**
 * The command for searching and printing a list of products based on 
 * part of the product name. The part of the product name is provided by
 * the user input
 * 
 * @author Yavor Yankov
 * @version 10/11/2020
 */
public class SearchProductsByPartNameCommand implements Command
{
    // The stock manager of the Stock Management Application
    private StockManager manager;
    // Use to get user input
    private InputReader input;

    /**
     * The constructor of this command
     * 
     * @param manager The manager which is the reciever in the Command Design Pattern
     */
    public SearchProductsByPartNameCommand(StockManager manager) {
        this.manager = manager;
        this.input = new InputReader();
    }

    /**
     * Execute this command as search for products consisting the word provided 
     * by the user input.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        System.out.print("Part name: ");
        String partName = this.input.getString();

        manager.printProductsWithPartName(partName);
    }
}
