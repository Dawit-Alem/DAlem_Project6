/**
 *
 * @author Dawit Alem
 *
 */
public class Smoothie extends Beverage{

    private int numFruits;
    private boolean proteinPow;
    private final double ADD_PROTEIN = 1.50;
    private final double ADD_FRUITS = 0.50;

    /**
     *
     * @param name name of beverage
     * @param size size of beverage
     * @param numFruits how many fruits are added
     * @param proteinPow true if protien powder is added
     */
    public Smoothie (String name, SIZE size, int numFruits, boolean proteinPow)
    {
        super(name, TYPE.SMOOTHIE, size);
        this.proteinPow = proteinPow;
        this.numFruits = numFruits;
    }

    @Override
    public boolean equals (Beverage b)
    {
        Smoothie s = (Smoothie) b;
        if(super.equals(s) && numFruits == s.getNumOfFruits() && proteinPow == s.getAddProtien())
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

        if(numFruits > 0)
        {
            price += numFruits * ADD_FRUITS;
        }

        if(proteinPow == true)
        {
            price += ADD_PROTEIN;
        }

        return price;
    }

    @Override
    public String toString()
    {
        String proPow = "";

        if(proteinPow == true)
        {
            proPow = "\nProtein Poweder Added";
        }

        return super.toString() + proPow + "\nPrice: $" + calcPrice();
    }

    /*
     * setters and getters
     */
    public int getNumOfFruits() {
        return numFruits;
    }


    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }


    public boolean getAddProtien() {
        return proteinPow;
    }


    public void setAddProtein(boolean proteinPow) {
        this.proteinPow = proteinPow;
    }


    public double getADD_PROTEIN() {
        return ADD_PROTEIN;
    }


    public double getADD_FRUITS() {
        return ADD_FRUITS;
    }

}