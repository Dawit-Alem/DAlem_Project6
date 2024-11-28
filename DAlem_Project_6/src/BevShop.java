/**
 * @author Dawit Alem
 */
import java.util.ArrayList;

public class BevShop implements BevShopInterfce {

    private int numAlcDrinks;
    private ArrayList<Order> orders = new ArrayList<>();

    /**
     * Validates if the given time is between 8 and 23.
     * @param time the time to check
     * @return true if valid, false otherwise
     */
    @Override
    public boolean validTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    /**
     * Checks if the current order can include more alcohol drinks.
     * @return true if more drinks can be added, false if not
     */
    @Override
    public boolean eligibleForMore() {
        return numAlcDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    /**
     * Checks if the customer is old enough for an alcohol drink.
     * @param age the age of the customer
     * @return true if eligible, false otherwise
     */
    @Override
    public boolean validAge(int age) {
        return age > MIN_AGE_FOR_ALCOHOL;
    }

    /**
     * Starts a new order.
     * @param time the order time
     * @param day the day of the order
     * @param customerName name of the customer
     * @param customerAge age of the customer
     */
    @Override
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
        numAlcDrinks = 0;
        Customer c = new Customer(customerName, customerAge);
        Order o = new Order(time, day, c);
        orders.add(o);
    }

    /**
     * Processes a coffee order.
     * @param bevName name of the beverage
     * @param size size of the beverage
     * @param extraShot true if an extra shot is added, false otherwise
     * @param extraSyrup true if extra syrup is added, false otherwise
     */
    @Override
    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    /**
     * Processes an alcohol order.
     * @param bevName name of the beverage
     * @param size size of the beverage
     */
    @Override
    public void processAlcoholOrder(String bevName, SIZE size) {
        getCurrentOrder().addNewBeverage(bevName, size);
        numAlcDrinks++;
    }

    /**
     * Processes a smoothie order.
     * @param bevName name of the beverage
     * @param size size of the beverage
     * @param numOfFruits number of fruits added
     * @param addProtien true if protein is added, false otherwise
     */
    @Override
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
    }

    /**
     * Finds an order by its number.
     * @param orderNo the order number
     * @return index of the order or -1 if not found
     */
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calculates the total price of an order.
     * @param orderNo the order number
     * @return total price of the order
     */
    @Override
    public double totalOrderPrice(int orderNo) {
        return orders.get(findOrder(orderNo)).calcOrderTotal();
    }

    /**
     * Calculates the total sales for all orders.
     * @return total sales
     */
    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    /**
     * Sorts the orders using the selection sort algorithm.
     */
    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size(); i++) {
            int minIndex = i;
            int minOrderNum = orders.get(minIndex).getOrderNo();
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).getOrderNo() < minOrderNum) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }
    }

    /**
     * Returns the order at the specified index.
     * @param index the index of the order
     * @return the order at the index
     */
    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    public boolean isMaxFruit(int i) {
        return i > MAX_FRUIT;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Order order : orders) {
            s.append(order).append("\n");
        }
        s.append("\nMonthly Sale: ").append(totalMonthlySale());
        return s.toString();
    }

    /**
     * Getters and setters
     */
    public int getNumOfAlcoholDrink() {
        return numAlcDrinks;
    }

    public void setNumOfAlcoholDrink(int numAlcDrinks) {
        this.numAlcDrinks = numAlcDrinks;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public Order getCurrentOrder() {
        return orders.get(orders.size() - 1);
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }
}
