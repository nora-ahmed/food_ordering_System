import java.util.List;

public class Admin extends Person {

    private Menu menu;
    private Restaurant restaurant;
    private List<Order> orders;

    public Admin(Restaurant restaurant) {
        this.menu = restaurant.getMenu();
        this.orders=restaurant.getOrders();

    }
public Admin(){
        super();
}

    @Override
    public void displayInfo() {
        System.out.println("---------------------------Welcome admin Susan---------------------------");
        System.out.println("-------------------------------------------------------------------------");

    }



    public void addDishToMenu(Dish dish) {
        menu.addDish(dish);
    }

    public void removeDishFromMenu(Dish dish) {
        menu.deleteDish(dish);
    }

    public void updateDishPrice(Dish dish, float newPrice) {
        menu.getDishes().stream()
                .filter(d -> d.getName().equalsIgnoreCase(dish.getName()))
                .findFirst()
                .ifPresent(d -> {
                    d.setPrice(newPrice);
                    System.out.println("Dish price updated successfully.");
                });
    }

    public void viewMenu() {
        System.out.println("Menu:");
        menu.displayMenu();
    }

    public void generateReports() {
        if (orders == null) {
            System.out.println("No orders available for generating reports.");
            return;
        }

        double totalProfit = 0.0;
        int totalOrders = orders.size();

        for (Order order : orders) {
            if (order != null && order.getPayment() != null) {
                double orderTotal = order.getPayment().getTotal();
                totalProfit += orderTotal;
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Reports for the day:");
        System.out.println("Total Profit: $" + totalProfit);
        System.out.println("Total Number of Orders: " + totalOrders);
        System.out.println("-------------------------------------------------------------------------");

    }

}