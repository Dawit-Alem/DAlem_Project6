/**
 * @author Dawit Alem
 */

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface , Comparable<Order> {

    private int orderNum;
    private int time;
    private DAY day;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    /**
     * Constructs an order with the specified time, day, and customer.
     * @param time the time of the order
     * @param day the day of the order
     * @param customer the customer placing the order
     */
    public Order(int time, DAY day, Customer customer)
    {
        this.time = time;
        this.day = day;
        this.customer = customer;
        orderNum = orderNum();
        beverages = new ArrayList<Beverage>();
    }

    /**
     * returns random number that is the order number
     * @return orderNum
     */
    public int orderNum()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(90000)+10000;
        return randInt;
    }

    /**
     * Compares two orders to see if they are the same
     * @return 0 if same, 1 if current order number is larger, else return -1
     */
    @Override
    public int compareTo(Order o) {

        if(orderNum == o.orderNum)
            return 0;
        else if(orderNum > o.orderNum)
            return 1;
        else
            return -1;
    }

    /**
     *
     * @param day the day of the week
     * @return true if the day is a weekend day (Saturday or Sunday)
     */
    @Override
    public boolean isWeekend() {

        if(day == DAY.SATURDAY || day == DAY.SUNDAY)
        {
            return true;
        }

        return false;
    }

    /**
     * returns the beverage listed in the itemNo of the order, for example if
     * itemNo is 0 this method will return the first beverage in the order
     * Note: this method returns the shallow copy of the Beverage
     *
     * @return the beverage listed in the itemNo of the order or null if there
     *         is no item in the order
     *
     */
    @Override
    public Beverage getBeverage(int itemNo) {
        return beverages.get(itemNo);
    }

    /**
     * adds coffee order to this order
     * @param bevName beverage name
     * @param size beverage size of type SIZE
     * @param extraShot true if the coffee beverage has extra shot , false otherwise
     * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        Beverage coffee = new Coffee(bevName,size,extraShot,extraSyrup);
        beverages.add(coffee);

    }

    /**
     * adds alcohol order to this order
     * @param bevName beverage name
     * @param size beverage size
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size) {

        Beverage alcohol = new Alcohol(bevName,size,isWeekend());
        beverages.add(alcohol);

    }

    /**
     * Adds the Smoothie beverage to this order
     * @param bevName beverage name
     * @param size beverage size
     * @param numOfFruits number of fruits added
     * @param addPRotien true if protein is added, false otherwise
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
        Beverage smoothie = new Smoothie(bevName,size,numOfFruits,addPRotien);
        beverages.add(smoothie);

    }


    /**
     * Calculates and returns the total amount for this order
     * @return total amount for this order
     */
    @Override
    public double calcOrderTotal() {
        double total = 0.0;

        for(int i =0; i <beverages.size(); i++)
        {

            total += beverages.get(i).calcPrice();

        }

        return total;
    }

    /**
     * returns the number of beverages of same type in an order
     * @param type the type of the beverage
     * @return number of beverages of type type in this order
     */
    @Override
    public int findNumOfBeveType(TYPE type) {
        int total = 0;

        for(int i =0; i <beverages.size(); i++)
        {
            if(beverages.get(i).getType() == type) {
                total++;
            }

        }

        return total;
    }

    /*
     * returns String with information of order, beverages, and order total
     */
    public String toString()
    {
        String info = "Order Number: " + orderNum + "\nTime: " + time + "\nDay: " + day +
                "\nCustomer Name: " + getCustomer().getName() +
                "\nCustomer Age: " + getCustomer().getAge() + " \nList Of Beverages: ";

        for(int i =0; i <beverages.size(); i++)
        {
            info += "\n" + beverages.get(i).toString();

        }

        info += "\n" + calcOrderTotal();

        return info;
    }

    /**
     * @return total items in array
     */
    public int getTotalItems() {
        return beverages.size();
    }
    /*
     * Setters and getters
     */
    public int getOrderNo() {
        return orderNum;
    }

    public void setOrderNo(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getOrderTime() {
        return time;
    }

    public void setOrderTime(int time) {
        this.time = time;
    }

    public DAY getOrderDay() {
        return day;
    }

    public void setOrderDay(DAY day) {
        this.day = day;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }

}