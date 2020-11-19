package StockManagerApplication.Commands;

import StockManagerApplication.*;

/**
 * The command for selling a product
 * 
 * @author Yavor Yankov
 * @version 10/11/2020
 */
public class SellProductCommand implements Command
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
    public SellProductCommand(StockManager manager) {
        this.manager = manager;
        this.input = new InputReader();
    }

    /**
     * Execute this command as sell a product and decrease its quantity.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        System.out.print("Id: ");
        int productId = this.input.getInt();

        System.out.print("Amount: ");
        int amount = this.input.getInt();

        manager.sellProduct(productId, amount);
    }
    
}
