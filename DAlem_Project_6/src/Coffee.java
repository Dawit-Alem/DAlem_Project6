/**
 *
 * @author Dawit Alem
 *
 */
public class Coffee extends Beverage{

    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_SHOT = 0.50;
    private final double EXTRA_SYRUP = 0.50;

    /**
     *
     * @param name beverage name
     * @param size size of beverage
     * @param extraShot true for extra shot
     * @param extraSyrup true for extra syrup
     */
    public Coffee (String name, SIZE size, boolean extraShot, boolean extraSyrup)
    {
        super(name, TYPE.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }


    /**
     * @return price of beverage
     */
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

        if(extraShot == true)
        {
            price += EXTRA_SHOT;
        }

        if(extraSyrup == true)
        {
            price += EXTRA_SYRUP;
        }

        return price;
    }


    @Override
    public boolean equals (Beverage b)
    {
        Coffee c = (Coffee) b;
        if(super.equals(c) && extraShot == c.getExtraShot() && extraSyrup == c.getExtraSyrup())
        {
            return true;
        }

        return false;
    }

    @Override
    public String toString()
    {
        String shot = "";
        String syrup = "";

        if(extraShot == true)
        {
            shot = "\nExtra Shot";
        }

        if(extraSyrup == true)
        {
            syrup = "\nExtra Syrup";
        }

        return super.toString() + shot + syrup + "\nPrice: $" + calcPrice();
    }


    /*
     * setters and getters
     */
    public boolean getExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

    public double getEXTRA_SHOT() {
        return EXTRA_SHOT;
    }

    public double getEXTRA_SYRUP() {
        return EXTRA_SYRUP;
    }
}