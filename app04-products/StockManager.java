import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(isIdExists(item.getID()))
        {
            System.out.println("Duplicate Ids, please provide different id!");
        }
        else if(isNameExists(item.getName()))
        {
            System.out.println("Name already exists, please provide different name!");
        }
        else
        {
            stock.add(item);
        }
    }
    
    /**
     * Receive a delivery of a particular product. Increase the quantity of the
     * product by the given amount.
     * 
     * @param id     The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
    }
    
    public Product findProduct(int id)
    {
        return null;
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            printProduct(id);
            product.sellOne();
            printProduct(id);
        }
    }    
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }
    
    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        System.out.println();
        System.out.println("Yankov's Stock List");
        System.out.println("====================");
        System.out.println();
        
        if(stock.size() > 0)
        {
            for(Product product : stock)
            {
                System.out.println(product);
            }
        }
        else
        {
            System.out.println("Stock list is empty!");
        }
    }

    /**
     * @return Is id exists in the stock collection
     * 
     * @param productId The id of a product
     */
    private boolean isIdExists(int productId) 
    {
        for (Product product : stock) {
            if(product.getID() == productId)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @return Is name exists in the stock collection
     * 
     * @param productName The name of a product 
     */
    private boolean isNameExists(String productName) 
    {
        for (Product product : stock) {
            if(product.getName() == productName)
            {
                return true;
            }
        }
        return false;
    }

}