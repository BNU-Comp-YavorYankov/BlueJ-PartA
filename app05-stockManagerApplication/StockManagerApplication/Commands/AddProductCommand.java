package StockManagerApplication.Commands;

import StockManagerApplication.*;

/**
 * The command for adding a new product on stock
 * 
 * @author Yavor Yankov
 * @version 10/11/2020
 */
public class AddProductCommand implements Command 
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
    public AddProductCommand(StockManager manager) 
    {
        this.manager = manager;
        this.input = new InputReader();
    }

    /**
     * Execute this command as create a new product and add it on stock.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        Product product = createProduct();

        manager.addProduct(product);
    }

    /**
     * Create a new product as use the user input for product id and name.
     * 
     * @return The newly created product.
     */
    private Product createProduct() 
    {
        System.out.println("Add product:");

        System.out.print("Id: ");
        int productId = this.input.getInt();
        
        System.out.print("Name: ");
        String productName = this.input.getString();
        
        return new Product(productId,productName);
    }
}
