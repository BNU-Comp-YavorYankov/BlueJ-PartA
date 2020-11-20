package StockManagerApplication;

import java.util.ArrayList;
 
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * Command Design Pattern: This class is the Reciever
 * 
 * @author Yavor Yankov
 * @version 10/11/2020
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
     * 
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(isIdExists(item.getID()))
        {
            System.out.println("Id "+ item.getID() +" is duplicate, please provide different id!");
        }
        else if(isNameExists(item.getName()))
        {
            System.out.println("Product with name " + item.getName() + " already exists, please provide different name!");
        }
        else
        {
            stock.add(item);
            System.out.println(item + " has been added on stock.");
        }
    }

    /**
     * Finds the product and rename the existing name with 
     * a new one provided from the parameter.
     *  
     * @param id The id of the product
     * @param newProductName The new name of the product
     */
    public void renameProduct(int id,String newProductName)
    {
        Product product = findProductById(id);

        if(product != null)
        {
            if(isNameExists(newProductName))
            {
                System.out.println("Name already exists, please provide different name!");
            }
            else
            {
                // Keeps the old name of the product
                String oldName = product.getName();
                // Sets the new name of the product
                product.setName(newProductName);
                
                // Check is the new product`s name set successfully
                if(oldName != product.getName())
                {
                    System.out.println("Renamed product name: "+ oldName+ " to " + product.getName());
                }
                else
                {
                    System.out.println("The product has not been renamed!");
                }
            }
        }
    }

    /**
     * Locate a product with the given ID, and return how many of this item are in
     * stock. If the ID does not match any product, return zero.
     *
     * @return The quantity of the given product in stock.
     * 
     * @param id The ID of the product.
     */
    public int getNumberInStock(int id)
    {
        Product product = findProductById(id);

        if(product != null)
        {
            return product.getQuantity();
        }
        return 0;
    }

    /**
     * Receive a delivery of a particular product. Increase the quantity of the
     * product by the given amount if the product exists. 
     * If the product does not exists it will be added to the stock collection.
     * 
     * @param id     The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProductById(id);

        if(product != null)
        {
            product.increaseQuantity(amount);
        }
    }
    
    /**
     * Find a product by its id
     * 
     * @return The product which has same id as parameter`s id.
     * 
     * @param id The id of a product.
     */
    public Product findProductById(int id)
    {
        for (Product product : stock) {
            if(product.getID() == id)
            {
                return product;
            }
        }
        System.out.println("Product with id: " + id + " cannot be found!");
        return null;
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * 
     * @param id The ID of the product being sold.
     * @param amount The amount of the products being sold.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = findProductById(id);
        
        if(product != null) 
        {
            product.sell(amount);
            printProduct(id);
        }
    }    

    /**
     * Find and delete a product from the stock collection
     * 
     * @param id The id of the product.
     */
    public void deleteProduct(int id)
    {
        Product product = findProductById(id);

        if(product != null)
        {
            this.stock.remove(product);
            System.out.println(product + " has been deleted from stock list!");
        }
    }

    /**
     * Re-stock all the low stock items up to a set minimum level.
     */
    public void restockLowStockLevelProducts()
    {
        System.out.println();
        System.out.println("Re-stock low stock level products");
        System.out.println("=================================");
        System.out.println();

        ArrayList<Product> lowStockLevelProducts = getLowStockLevelProducts();
        
        if (lowStockLevelProducts.size() > 0) 
        {
            for (Product product : lowStockLevelProducts) 
            {
                product.increaseQuantity(1);
                System.out.println(product);
            }    
        }
    }

    /**
     * Print details of the given product. If found, 
     * its name and stock quantity will be shown.
     * 
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProductById(id);
        
        if(product != null) 
        {
            System.out.println(product);
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
     * Print all products which has the word from the parameter in their names.
     * 
     * @param partName A word which might consists in some products` names.
     */
    public void printProductsWithPartName(String partName)
    {
        ArrayList<Product> products = findProductsByPartName(partName);

        if(products.size() > 0)
        {
            System.out.println();
            System.out.println("Products consisting " + partName + ":");
            System.out.println("=====================================");
            System.out.println();
            for (Product product : products) {
                System.out.println(product);
            }
        }
        else
        {
            System.out.println("There is no any products consisting " + partName + " in their names!");
        }
    }

    /**
     * Print out each product in the stock
     * whose stock level is low
     */
    public void printLowStockLevelProducts()
    {
        System.out.println();
        System.out.println("Low stock level products list");
        System.out.println("=============================");
        System.out.println();
        
        ArrayList<Product> products = getLowStockLevelProducts();

        if(products.size() > 0)
        {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    /**
     * Find all products which have same word in their names as from the parameter 
     * @return The products with a same word in their names
     * 
     * @param partName The part of the product name
     */
    private ArrayList<Product> findProductsByPartName(String partName)
    {
        ArrayList<Product> result = new ArrayList<Product>();
            
        //Iterate all the products in stock collection
        for (Product product : stock) {
            // Get the product name then split it by space
            String[] productNameWords = product
                .getName()
                .split(" ");
            
            // Iterate the words
            for (String word : productNameWords)
            {
                if(word.equals(partName))
                {
                    result.add(product);
                }
            }
        }
        return result;
    }

    /**
     * Get all products whose stock level is low
     * 
     * @return The products with low stock level
     */
    private ArrayList<Product> getLowStockLevelProducts() 
    {
        ArrayList<Product> result = new ArrayList<Product>();
        
        for (Product product : stock) {
            if(product.getQuantity() <= 1)
            {
                result.add(product);
            }
        }
        
        if(result.size() == 0)
        {
            System.out.println("There is no low stock level products.");
        }

        return result;
    }

    /**
     * Is id exists in the stock collection
     * @return Is id exists in the stock collection as return true or false
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
     * Is name exists in the stock collection
     * @return Is name exists in the stock collection as return true or false
     * 
     * @param productName The name of a product 
     */
    private boolean isNameExists(String productName) 
    {
        for (Product product : stock) {
            if(product.getName().equals(productName))
            {
                return true;
            }
        }
        return false;
    }
}