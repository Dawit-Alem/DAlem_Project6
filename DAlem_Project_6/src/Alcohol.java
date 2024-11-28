/**
 * Class representing an alcoholic beverage, extending the Beverage class.
 *
 * @author Dawit Alem
 */
public class Alcohol extends Beverage {

    private boolean weekend;
    private final double WEEKEND_PRICE = 0.60;

    /**
     * Constructs an Alcohol instance.
     *
     * @param name the name of the beverage
     * @param size the size of the beverage
     * @param weekend a flag indicating if the beverage is available on weekends
     */
    public Alcohol (String name, SIZE size, boolean weekend)
    {
        super(name, TYPE.ALCOHOL, size);
        this.weekend = weekend;
    }

    @Override
    public boolean equals (Beverage bev)
    {
        Alcohol alc = (Alcohol) bev;

        if(super.equals(alc) && weekend == alc.getWeekend())
        {
            return true;
        }

        return false;
    }

    @Override
    public double calcPrice()
    {
        double price = super.getBasePrice();

        if(super.getSize() == SIZE.MEDIUM)
        {
            price += super.getSizePrice();
        }

        if(super.getSize() == SIZE.LARGE)
        {
            price += 2 * super.getSizePrice();
        }

        if (weekend)
        {
            price += WEEKEND_PRICE;
        }
        return price;
    }

    @Override
    public String toString()
    {
        String str = "";

        if(weekend)
        {
            str = "\nWeekend";
        }

        return super.toString() + str + "\nPrice: $" + calcPrice();
    }

    /**
     * Returns whether the beverage is available on the weekend.
     *
     * @return true if the beverage is available on the weekend, false otherwise
     */
    public boolean getWeekend() {
        return weekend;
    }

    /**
     * Sets whether the beverage is available on the weekend.
     *
     * @param weekend a flag indicating if the beverage is available on the weekend
     */
    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    /**
     * Returns the price adjustment for weekend availability.
     *
     * @return the weekend price increase
     */
    public double getWEEKEND_PRICE() {
        return WEEKEND_PRICE;
    }
}