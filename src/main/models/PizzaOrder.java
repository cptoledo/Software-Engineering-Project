package models;

public class PizzaOrder extends ItemOrder {

    private String pizzaSize;
    private String pizzaTopping;

    /**
     * Construct a PizzaOrder object to store information about the pizza order.
     * @param pizzaSize         The pizza size.
     * @param pizzaTopping      The pizza topping.
     */
    public PizzaOrder(String pizzaSize, String pizzaTopping, int numPizzas, int price) {
        super("1", numPizzas, price);
        this.pizzaSize = pizzaSize;
        this.pizzaTopping = pizzaTopping;
    }

    /**
     * Get the pizza size.
     * @return The pizza size.
     */
    public String getPizzaSize() {
        return pizzaSize;
    }

    /**
     * Set the pizza size.
     * @param pizzaSize A pizza size.
     */
    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    /**
     * Get the pizza topping.
     * @return The pizza topping.
     */
    public String getPizzaTopping() {
        return pizzaTopping;
    }

    /**
     * Set the pizza topping.
     * @param pizzaTopping A pizza topping.
     */
    public void setPizzaTopping(String pizzaTopping) {
        this.pizzaTopping = pizzaTopping;
    }
}
