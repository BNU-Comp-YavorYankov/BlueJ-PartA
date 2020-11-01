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
    // Test the method... -------------------------------------------------------------------
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
     * Finds the product and rename the existing name with a new one provided from the parameter. 
     * @param id The id of the product
     * @param newProductName The new name of the product
     */
    public void renameProduct(int id,String newProductName)
    {
        var product = findProductById(id);

        if(product != null)
        {
            // Keeps the old name of the product
            var oldName = product.getName();
            // Sets the new name of the product
            product.setName(newProductName);

            // Check is the new product`s name set successfully
            if(oldName != product.getName())
            {
                System.out.println("Renamed product name: "+ oldName+ " to " + product.getName());

                updateProductInStock(product);
            }
            else
            {
                System.out.println("The product has not been renamed!");
            }
        }
    }

    /**
     * Locate a product with the given ID, and return how many of this item are in
     * stock. If the ID does not match any product, return zero.
     * 
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    // Test the method... -------------------------------------------------------------------
    public int getNumberInStock(int id)
    {
        var product = findProductById(id);

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
    // Test the method... -------------------------------------------------------------------
    public void delivery(int id, int amount)
    {
        var product = findProductById(id);

        if(product != null)
        {
            product.increaseQuantity(amount);
        }
    }
    
    /**
     * @return The product which has same id as parameter`s id.
     * 
     * @param id The id of a product.
     */
    // Test the method... -------------------------------------------------------------------
    public Product findProductById(int id)
    {
        for (Product product : stock) {
            if(product.getID() == id)
            {
                return product;
            }
        }
        System.out.println("Product with id: "+id+" cannot be found!");
        return null;
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     * @param amount The amount of the products being sold.
     */
    // Test the method... -------------------------------------------------------------------
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
     * @param id The id of the product.
     */
    public void deleteProduct(int id)
    {
        var product = findProductById(id);

        if(product != null)
        {
            this.stock.remove(product);
            System.out.println(product + " has been deleted successfully!");
        }
    }

    /**
     * Print details of the given product. If found, its name and stock quantity
     * will be shown.
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
     */
    public void printProductsWithPartName(String partName)
    {
        var products = findProductsByPartName(partName);

        if(products.size() > 0)
        {
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
        var products = getLowStockLevelProducts();

        if(products.size() > 0)
        {
            for (Product product : products) {
                System.out.println(product);
            }
        }
        else
        {
            System.out.println("There is no any products with low stock level!");
        }
    }

     /**
     * Find all products which have same word in their names as from the parameter 
     * 
     * @param partName The part of the product name
     * @return The products with a same part in their names
     */
    private ArrayList<Product> findProductsByPartName(String partName)
    {
        var result = new ArrayList<Product>();
        for (Product product : stock) {
            for (String word : product.getName().split(" ")) {
                if(word == partName)
                {
                    result.add(product);
                }
            }
        }
        return result;
    }

    /**
     * Get all products whose stock level is low
     * @return The products with low stock level
     */
    private ArrayList<Product> getLowStockLevelProducts() 
    {
        var result = new ArrayList<Product>();
        for (Product product : stock) {
            if(product.getQuantity() <= 1)
            {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Update a product in the stock collection.
     * 
     * @param updatedProduct The updated product which will replace the non-updated
     *                       one in the stock.
     */
    private void updateProductInStock(Product updatedProduct)
    {
        // get non updated product
        var product = findProductById(updatedProduct.getID());

        // the index of the non updated product in the stock arraylist
        var index = stock.indexOf(product);

        // set the updated product in stock collection
        this.stock.set(index, updatedProduct);
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