/**
 *
 * @author Dawit Alem
 *
 */
public class Customer {

    private int age;
    private String name;

    /**
     * @param name name of customer
     * @param age age of customer
     * Parameterized Constructor
     */
    public Customer(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    /**
     * @param c Customer object
     * Copy Constructor
     */
    public Customer (Customer c)
    {
        this.name = c.name;
        this.age = c.age;
    }

    public String toString()
    {
        return "Customer Name and Age: " + name + ", " + age;
    }

    /*
     * setters and getters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}