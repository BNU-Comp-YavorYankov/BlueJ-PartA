/**
 * Enumeration Coin keeps data for different coins which 
 * can be used for the ticket machine.
 *
 * @author Yavor Yankov
 * @version 06/10/2020
 */
public enum Coin {
    // fixed constant for 10 pennies with its value
    p10 (10),
    // fixed constant for 20 pennies with its value
    p20 (20),
    // fixed constant for 100 pennies with its value
    p100 (100),
    // fixed constant for 100 pennies with its value
    p200 (200);

    // Value of this coin
    private final int value;

    // Whenever is added new fixed constant it will be created new Coin with provided parameter
    private Coin(int value)
    {
        this.value = value;
    }

    /**
     * Return the value of this coin
     */
    public int getValue()
    {
        return this.value;
    }
}
