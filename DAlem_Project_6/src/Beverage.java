/**
 * Abstract class representing a beverage with details such as name, type, and size.
 *
 * @author Dawit Alem
 */
public abstract class Beverage {
    private String name;
    private TYPE type;
    private SIZE size;
    private final double BASE_PRICE = 2.00;
    private final double SIZE_PRICE = 1.00; //

    /**
     *
     * @param name name of beverage
     * @param type type of beverage
     * @param size size of beverage
     */
    public Beverage(String name, TYPE type, SIZE size)
    {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    /**
     * @return price of beverage
     * abstract method
     */
    public abstract double calcPrice();

    /**
     * returns string of beverage name and size
     */
    @Override
    public String toString()
    {
        return "Beverage Name: " + name + " \nBeverage Size: " + size;
    }

    /**
     *
     * @param b beverage object
     * @return true if equal, false if not
     * checks to see if two beverages are equal
     */
    public boolean equals (Beverage b)
    {
        if(name.equals(b.name) && type == b.getType() && size == b.getSize())
        {
            return true;
        }

        else return false;
    }
    /*
     * setters and getters
     */
    public double getBasePrice() {
        return BASE_PRICE;
    }

    public double getSizePrice() {
        return SIZE_PRICE;
    }

    public String getName() {
        return name;
    }

    public void setName(String bevName) {
        this.name = bevName;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE bevType) {
        this.type = bevType;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }


}