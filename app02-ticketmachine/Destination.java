
/**
 * Enumeration Destination keeps data for the possible destinations and its
 * price for a single ticket as a value of the enumeration. The values are
 * presented in pennies. Also, there is the names of the destinations as a String values
 *
 * @author Yavor Yankov
 * @version 10/10/2020
 */
public enum Destination {
    // fixed constant for Aylesbury with its destination name and price in pennies
    Aylesbury("Aylesbury", 220), 
    // fixed constant for Amersham with its destination name and price in pennies
    Amersham("Amersham", 300), 
    // fixed constant for High Wycombe with its destination name and price in pennies
    HighWycombe("High Wycombe", 330);

    // Destination name of this destination as a String value
    private final String destinationName;
    // Price in pennies of this destination
    private final int priceInPennies;

    // Whenever is added new fixed constant it will be created new Destination with provided parameters
    private Destination(String destinationName, int priceInPennies) {
        this.destinationName = destinationName;
        this.priceInPennies = priceInPennies;
    }

    /**
     * Return the price in pennies of this destination 
     */
    public int getPriceInPennies() {
        return this.priceInPennies;
    }

    /**
     * Return the destination name of this destination as a String value 
     */
    public String getDestinationName() {
        return this.destinationName;
    }
}
