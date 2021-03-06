package main.models;

/**
 * Class Map - a map in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * A "Map" represents a map in the game.
 * It keeps information about all locations in the "World of Zuul".
 *
 * @author Yavor Yankov
 * @version 28/12/2020
 */
public class Map 
{
    // Constant for pub location
    private static final Location PUB = new Location("in the campus pub");
    // Constant for outside location
    private static final Location OUTSIDE = new Location("outside the main entrance of the university");
    // Constant for theatre location
    private static final Location THEATRE = new Location("in a lecture theatre");
    // Constant for lab location
    private static final Location LAB = new Location("in a computing lab");
    // Constant for office location
    private static final Location OFFICE = new Location("in the computing admin office");
    // Constant for warehouse location
    private static final Location WAREHOUSE = new Location("in the pub`s warehouse");
    // Constant for shopping centre location
    private static final Location SHOPPING_CENTRE = new Location("in the shopping centre");
    // Constant for dungeon location
    private static final Location DUNGEON = new Location("in the dungeon");

    /**
     * The constructor of this map which links locations` exits together.
     */
    public Map() 
    {
        setLocationsExits();
    }

    /**
     * @return pub location
     */
    public Location getPub() 
    {
        return PUB;
    }
    
    /**
     * @return outside location
     */
    public Location getOutside() 
    {
        return OUTSIDE;
    }

    /**
     * @return theatre location
     */
    public Location getTheatre() 
    {
        return THEATRE;
    }

    /**
     * @return lab location
     */
    public Location getLab() 
    {
        return LAB;
    }

    /**
     * @return office location
     */
    public Location getOffice() 
    {
        return OFFICE;
    }

    /**
     * @return pub`s warehouse location
     */
    public Location getWarehouse() 
    {
        return WAREHOUSE;
    }

    /**
     * @return shopping centre location
     */
    public Location getShoppingCentre() 
    {
        return SHOPPING_CENTRE;
    }
    
    /**
     * @return dungeon location
     */
    public Location getDungeon() 
    {
        return DUNGEON;
    }

    /**
     * @return all locations on the map
     */
    public Location[] getLocations()
    {
        return new Location[] 
        {
            OUTSIDE, 
            PUB, 
            THEATRE, 
            LAB, 
            OFFICE, 
            WAREHOUSE, 
            SHOPPING_CENTRE,
            DUNGEON
        }; 
    }

    /**
     * Visualize this map as return its location as a string.
     */
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(" +-------------------------------------------------+\n\r");
        stringBuilder.append(" | +---------+       +-----------------+           |\n\r");
        stringBuilder.append(" | | DUNGEON | <---> | SHOPPING CENTRE |           |\n\r");
        stringBuilder.append(" | +---------+       +-----------------+           |\n\r");
        stringBuilder.append(" |                       /|\\                       |\n\r");
        stringBuilder.append(" |                        |                        |\n\r");
        stringBuilder.append(" |                       \\|/                       |\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" | |   PUB   | <---> | OUTSIDE | <---> | THEATRE | |\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" |     /|\\               /|\\                       |\n\r");
        stringBuilder.append(" |      |                 |                        |\n\r");
        stringBuilder.append(" |     \\|/               \\|/                       |\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" | |WAREHOUSE|       |   LAB   | <---> | OFFICE  | |\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" +-------------------------------------------------+\n\r\n\r");

        return stringBuilder.toString();
    }

    /**
     * Link locations` exits together.
     */
    private void setLocationsExits() 
    {
        PUB.setExit("east", OUTSIDE);
        PUB.setExit("south", WAREHOUSE);

        OUTSIDE.setExit("east", THEATRE);
        OUTSIDE.setExit("south", LAB);
        OUTSIDE.setExit("west", PUB);
        OUTSIDE.setExit("north", SHOPPING_CENTRE);

        THEATRE.setExit("west", OUTSIDE);

        LAB.setExit("north", OUTSIDE);
        LAB.setExit("east", OFFICE);

        OFFICE.setExit("west", LAB);

        WAREHOUSE.setExit("north", PUB);

        SHOPPING_CENTRE.setExit("south", OUTSIDE);
        SHOPPING_CENTRE.setExit("west", DUNGEON);

        DUNGEON.setExit("east", SHOPPING_CENTRE);
    }
}