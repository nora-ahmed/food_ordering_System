
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public  class MainMenu {

    public static void ReadUser() throws IOException {
        //connect the program with the text file for reading

        File userFile = new File("user.txt");
        Scanner readFile = new Scanner(userFile);

        StringTokenizer token = null;

        String userName = "";
        String email = "";
        String password = "";
        String deliveryAddress = "";

        while (readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");

            userName = token.nextToken();
            email = token.nextToken();
            password = token.nextToken();
            deliveryAddress = token.nextToken();

            User user = new User(userName, email, password, deliveryAddress);


            Main.user.add(user);
        }

    }

    public static void ReadDish1() throws IOException {
        //connect the program with the text file for reading
        File dishFile = new File("res1.txt");

        Scanner readFile = new Scanner(dishFile);

        StringTokenizer token = null;

        String name = "";
        float price = 0;
        String description = "";
        Menu menu=new Menu();
        while (readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");

            name = token.nextToken();
            price = Float.parseFloat(token.nextToken());
            description = token.nextToken();

            Dish dish = new Dish(name, price, description);

            menu.addDish(dish);

        }

        Main.restaurants.get(0).setMenu(menu);

    }

    public static void ReadDish2() throws IOException {
        //connect the program with the text file for reading
        Menu menu=new Menu();

        File dishFile = new File("res2.txt");

        Scanner readFile = new Scanner(dishFile);

        StringTokenizer token = null;

        String name = "";
        float price = 0;
        String description = "";

        while (readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");

            name = token.nextToken();
            price = Float.parseFloat(token.nextToken());
            description = token.nextToken();

            Dish dish = new Dish(name, price, description);

            menu.addDish(dish);

        }

        Main.restaurants.get(1).setMenu(menu);
    }

    public static void ReadDish3() throws IOException {

        Menu menu = new Menu();
        //connect the program with the text file for reading
        File dishFile = new File("res3.txt");
        Scanner readFile = new Scanner(dishFile);

        StringTokenizer token = null;

        String name = "";
        float price = 0;
        String description = "";

        while (readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");

            name = token.nextToken();
            price = Float.parseFloat(token.nextToken());
            description = token.nextToken();

            Dish dish = new Dish(name, price, description);

            menu.addDish(dish);

        }

        Main.restaurants.get(2).setMenu(menu);
    }

    public static void ReadReview1() throws IOException {
        //connect the program with the text file for reading
        File dishFile = new File("review1.txt");
        Scanner readFile = new Scanner(dishFile);

        StringTokenizer token = null;
        String name="";
        int rating = 0;
        String feedback = "";

        while (readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");
            name=token.nextToken();
            rating = Integer.parseInt(token.nextToken());
            feedback = token.nextToken();

            Review review = new Review(name,rating, feedback);

            Main.restaurants.get(0).addReview(review);

        }
    }

    public static void ReadReview2() throws IOException {
        //connect the program with the text file for reading
        File dishFile = new File("review2.txt");
        Scanner readFile = new Scanner(dishFile);

        StringTokenizer token = null;

        int rating = 0;
        String feedback = "";
        String name="";

        while (readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");
            name=token.nextToken();
            rating = Integer.parseInt(token.nextToken());
            feedback = token.nextToken();

            Review review = new Review(name,rating, feedback);

            Main.restaurants.get(1).addReview(review);

        }
    }


    //connect the program with the text file for reading
    public static void ReadReview3() throws IOException {
        File dishFile = new File("review3.txt");
        Scanner readFile = new Scanner(dishFile);

        StringTokenizer token = null;
        String name="";
        int rating = 0;
        String feedback = "";

        while(readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");
            name=token.nextToken();
            rating = Integer.parseInt(token.nextToken());
            feedback = token.nextToken();

            Review review = new Review(name,rating, feedback);

            Main.restaurants.get(2).addReview(review);

        }
    }

    public void  ReadAllFiles()throws IOException{

        ReadUser();
        ReadDish1();
        ReadDish2();
        ReadDish3();
        ReadReview1();
        ReadReview2();
        ReadReview3();

    }
    public static void  AdminDashboard()
    {
        Admin admin1 = new Admin();
        admin1.displayInfo();
        Scanner scanner = new Scanner(System.in);
        boolean exitRequested = false;
        while(true){
            System.out.println("Choose a restaurant:");
            for (int i = 0; i < 3; i++) {
                System.out.println((i + 1) + ") Restaurant: " + Main.restaurants.get(i).getName());
            }
            System.out.println("or enter 0 to go back:");
            int restaurantChoice = getValidIntegerInput(scanner);
            switch (restaurantChoice) {
                case 1:
                    admin1 = new Admin(Main.restaurants.get(0));
                    break;
                case 2:
                    admin1 = new Admin(Main.restaurants.get(1));
                    break;
                case 3:
                    admin1 = new Admin(Main.restaurants.get(2));
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }

            do {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("1. Add Dish to Menu");
                System.out.println("2. Remove Dish from Menu");
                System.out.println("3. Update Dish Price");
                System.out.println("4. View Menu");
                System.out.println("5. View Daily Report");
                System.out.println("6. Exit");
                System.out.println("Enter your choice: ");
                System.out.println("-------------------------------------------------------------------------");

                int choice = getValidIntegerInput(scanner);


                switch (choice) {
                    case 1:
                        System.out.print("Enter dish name: ");
                        String dishName = scanner.nextLine();
                        System.out.println("Enter dish price: ");
                        float dishPrice = getValidFloatInput(scanner);
                        System.out.print("Enter dish description: ");
                        String dishDescription = scanner.nextLine();
                        Dish newDish = new Dish(dishName, dishPrice, dishDescription);
                        admin1.addDishToMenu(newDish);
                        break;

                    case 2:
                        System.out.print("Enter dish name to remove: ");
                        String dishToRemove = scanner.nextLine();
                        Dish dish = new Dish(dishToRemove);
                        admin1.removeDishFromMenu(dish);
                        break;

                    case 3:
                        System.out.print("Enter dish name to update price: ");
                        String dishToUpdate = scanner.nextLine();
                        Dish dishToUpdateObj = new Dish(dishToUpdate);
                        System.out.print("Enter new dish price: ");
                        float newPrice = getValidFloatInput(scanner);
                        admin1.updateDishPrice(dishToUpdateObj, newPrice);
                        break;

                    case 4:
                        admin1.viewMenu();
                        break;
                    case 5:
                        admin1.generateReports();
                        break;

                    case 6:

                        exitRequested = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }

            } while (!exitRequested);
        }}
    public void WelcomePage() throws InterruptedException, IOException {


        int option = 0;
        boolean state = true;

        Scanner read = new Scanner(System.in);
        System.out.println("                       Welcome To Rush Munch                             ");
        System.out.println("-------------------------------------------------------------------------");

        do {
            System.out.println("-------------------------------------------------------------------------");

            System.out.println("press 1 to register");

            System.out.println("press 2 to login");

            System.out.println("press 0 to close the program");
            System.out.println("-------------------------------------------------------------------------");


            try {
                option = read.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                read.nextLine(); // Clear the invalid input
                WelcomePage();
            }
            switch (option){
                case 1:{
                    Main.user.add(User.register(Main.user));
                    break;
                }

                case 2:{
                    int loginResult = User.Login(Main.user);
                    switch (loginResult){
                        case 1:{
                            System.out.println("Login successfully.");
                            this.displayMainMenu();
                            break;
                        }
                        case 2:{
                            MainMenu.AdminDashboard();
                            break;
                        }
                        case 0:{
                            System.out.println("Login failed.");
                            break;
                        }
                        default:
                            System.out.println("unknown result");
                    }
                    break;
                }

                case 0:{
                    state = false;
                    this.writeFiles();
                    break;
                }

                default:{
                    System.out.println("invalid option. please try again");
                }
            }
        }while (state);


    }


    public void displayMainMenu() throws InterruptedException {
// hello
        while (true) {
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Please enter your choice:");
            System.out.println("1) Display all restaurants.");
            System.out.println("2) Search.");
            System.out.println("3) View cart.");
            System.out.println("4) Log out.");
            System.out.println("-------------------------------------------------------------------------");


            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    displayRestaurants();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    this.viewCart();
                    break;
                case 4:
                    Main.thisUser = -1;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayRestaurants() {
        Scanner resScanner = new Scanner(System.in);

        for (int i = 0; i < Main.restaurants.size(); i++) {
            System.out.println((i + 1) + ") Restaurant: " + Main.restaurants.get(i).getName());
            System.out.println("Rating: " + Main.restaurants.get(i).getRatings());
        }

        System.out.println("0) Go back");
        System.out.println("Please enter your choice: 0-3:");

        int resChoice;

        while (true) {
            try {
                resChoice = resScanner.nextInt();
                if (resChoice == 0) {
                    return;
                } else if (resChoice >= 1 && resChoice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                resScanner.nextLine(); // Clear the invalid input
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("1) View Menu");
        System.out.println("2) View Reviews");
        System.out.println("3) Go back");
        System.out.println("Please enter your choice: 1-3:");
        System.out.println("-------------------------------------------------------------------------");

        int viewChoice=0;

        while(true){
            try{
                //hgjhfjh
                viewChoice=resScanner.nextInt();
                if(viewChoice==3){
                    return;
                }
                else if(viewChoice==1){
                    break;
                }
                else if(viewChoice==2){   Main.restaurants.get(resChoice - 1).displayReviews();
                    break;
                }
                else
                {
                    System.out.println("Invalid choice. Please enter either 1 or 3.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                resScanner.nextLine(); // Clear the invalid input
            }


        }

        Main.restaurants.get((resChoice - 1)).displayMenu();

        while (true) {
            System.out.println("Please enter your choice: 1-"+Main.restaurants.get(resChoice-1).getMenuSize()+" or 0 to go back:");

            int dishChoice;


            while (true) {
                try {
                    dishChoice = resScanner.nextInt();
                    if(dishChoice==0){
                        return;
                    }
                    if (dishChoice > 0 && dishChoice <= Main.restaurants.get(resChoice-1).getMenuSize()) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 0 and "+Main.restaurants.get(resChoice-1).getMenuSize()+":");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    resScanner.nextLine(); // Clear the invalid input
                }
            }


            if (dishChoice == 3) {
                break;
            } else if (dishChoice >= 1 && dishChoice <= Main.restaurants.size()) {
                if(!Main.c.display().equals("Your Cart is Empty.")&&!Main.c.getResName().equals(Main.restaurants.get(resChoice-1).getName())){
                    while(true) {
                        System.out.println("You can't make orders from different restaurants at the same time. ");
                        System.out.println("Enter yes to clear the cart or no to go back:");
                        Scanner scanner = new Scanner(System.in);
                        String cart = scanner.next();
                        if (cart.equalsIgnoreCase("yes")) {
                            Main.c.emptyCart();
                            System.out.println("Cart cleared");
                            break;
                        } else if (cart.equalsIgnoreCase("no")) {
                            return;

                        } else {
                            System.out.println("Invalid, please try again.");

                        }
                    }

                }
                Main.thisRes=resChoice-1;
                Dish d = Main.restaurants.get((resChoice - 1)).getDish(dishChoice - 1);
                CartItem ci = new CartItem(d, 1);
                Main.c.addItem(ci);
                Main.c.setResName(Main.restaurants.get(resChoice-1).getName());
            }
        }
    }



    public void searchByCategory() {
        System.out.println("Please enter the category number:");

        for (int i = 0; i < Main.restaurants.size(); i++) {
            System.out.println((i + 1) + ") Category: " + Main.restaurants.get(i).getCategory());
        }
        System.out.println("0) Go back");
        Scanner scanner = new Scanner(System.in);

        int categoryChoice;
        try {
            categoryChoice = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Clear the invalid input
            return;
        }
        if (categoryChoice==0){
            return;
        }
        boolean flag = false;


        for (int i = 0; i < Main.restaurants.size(); i++) {
            if (categoryChoice == i + 1) {
                flag = true;
                Main.restaurants.get(i).displayMenu();

                while (true) {
                    System.out.println("Please enter your choice: 1-"+Main.restaurants.get(i).getMenuSize()+" or enter 0 to go back:");

                    int dishChoice;

                    try {
                        dishChoice = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scanner.nextLine(); // Clear the invalid input
                        continue;
                    }

                    if (dishChoice == 0) {
                        return;
                    } else if (dishChoice >= 1 && dishChoice <= Main.restaurants.size()) {
                        if(!Main.c.display().equals("Your Cart is Empty.")&&!Main.c.getResName().equals(Main.restaurants.get(i).getName())){
                            while(true) {
                                System.out.println("You can't make orders from different restaurants at the same time. ");
                                System.out.println("Enter yes to clear the cart or no to go back:");
                                Scanner scanner1 = new Scanner(System.in);
                                String cart = scanner1.next();
                                if (cart.equals("yes")) {
                                    Main.c.emptyCart();
                                    System.out.println("Cart cleared");
                                    break;
                                } else if (cart.equals("no")) {
                                    return;

                                } else {
                                    System.out.println("Invalid, please try again.");

                                }
                            }

                        }
                        Main.thisRes=i;
                        Dish d = Main.restaurants.get((i )).getDish(dishChoice-1 );
                        CartItem ci = new CartItem(d, 1);
                        Main.c.addItem(ci);
                        Main.c.setResName(Main.restaurants.get(i).getName());
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("Invalid category choice. Please try again.");
        }
    }

    public void search() {
        while (true) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Please enter your choice:");
            System.out.println("1) Search by restaurant name.");
            System.out.println("2) Search by restaurant category.");
            System.out.println("3) Go back.");
            System.out.println("-------------------------------------------------------------------------");

            Scanner scanner = new Scanner(System.in);

            int searchChoice;

            try {
                searchChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            if (searchChoice == 1) {
                System.out.println("Please enter the restaurant name or 0 to go back:");

                Scanner scanner1 = new Scanner(System.in);
                String resName = scanner1.next();
                if(resName.equals("0")){
                    return;
                }
                boolean flag = false;

                for (int i = 0; i < Main.restaurants.size(); i++) {
                    if (resName.equals(Main.restaurants.get(i).getName())) {
                        flag = true;
                        Main.restaurants.get(i).displayMenu();

                        while (true) {
                            System.out.println("Please enter your choice: 1-"+Main.restaurants.get(i).getMenuSize()+" or enter 0 to go back:");

                            Scanner scanner2 = new Scanner(System.in);

                            int dishChoice;

                            try {
                                dishChoice = scanner2.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer.");
                                scanner2.nextLine(); // Clear the invalid input
                                continue;
                            }

                            if (dishChoice == 0) {
                                break;
                            } else if (dishChoice >= 1 && dishChoice <=Main.restaurants.size()) {
                                if(!Main.c.display().equals("Your Cart is Empty.")&&!Main.c.getResName().equals(Main.restaurants.get(i).getName())){
                                    while(true) {
                                        System.out.println("You can't make orders from different restaurants at the same time. ");
                                        System.out.println("Enter yes to clear the cart or no to go back:");
                                        Scanner scanner3 = new Scanner(System.in);
                                        String cart = scanner3.next();
                                        if (cart.equalsIgnoreCase("yes")) {
                                            Main.c.emptyCart();
                                            System.out.println("Cart cleared");
                                            break;
                                        } else if (cart.equalsIgnoreCase("no")) {
                                            return;

                                        } else {
                                            System.out.println("Invalid, please try again.");

                                        }
                                    }

                                }
                                Main.thisRes=i-1;
                                Dish d = Main.restaurants.get((i)).getDish(dishChoice - 1);
                                CartItem ci = new CartItem(d, 1);
                                Main.c.addItem(ci);
                                Main.c.setResName(Main.restaurants.get(i).getName());
                            }
                        }
                    }
                }

                if (!flag) {
                    System.out.println("Sorry, we don't have this restaurant.");
                    break;
                }
            } else if (searchChoice == 2) {
                searchByCategory();
            } else if (searchChoice == 3) {
                break;
            }
        }
    }

    public void viewCart() throws InterruptedException {

        String cartDisplay = Main.c.display(); // Get the cart display string
        // Print the cart display
        System.out.println(cartDisplay);
        if (cartDisplay.equals("Your Cart is Empty.")){
            return;
        }


        while (true) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Please enter your choice:");
            System.out.println("1) Edit your order.");
            System.out.println("2) Place your order.");
            System.out.println("3) Go back.");

            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------------------------------------------------------");
            int cartChoice;
            try {
                cartChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
                continue; // Continue the loop
            }

            if (cartChoice == 1) {
                while (true) {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Please enter your choice:");
                    System.out.println("1) Edit quantity.");
                    System.out.println("2) Delete an item.");
                    System.out.println("3) Go back");
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("-------------------------------------------------------------------------");

                    int cusChoice;

                    try {
                        cusChoice = scanner1.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scanner1.nextLine(); // Clear the invalid input
                        continue;
                    }

                    if (cusChoice == 1) {
                        // Edit quantity
                        System.out.println("Please enter the item's name you want to edit quantity for or 0 to go back:");
                        String itemName;
                        Scanner scanner2 = new Scanner(System.in);
                        itemName = scanner2.nextLine();
                        if(itemName.equals("0")){
                            break;
                        }
                        Main.c.editQuantity(itemName);
                        if (Main.c.display().equals("Your Cart is Empty.")){
                            return;
                        }
                    }  else if (cusChoice == 2) {
                        System.out.println("Please enter the item's name you want to delete or 0 to go back:");
                        String itemName;
                        Scanner scanner2 = new Scanner(System.in);
                        itemName = scanner2.nextLine();
                        if(itemName.equals("0")){
                            break;
                        }
                        Main.c.removeItem(itemName);
                        if (Main.c.display().equals("Your Cart is Empty.")){
                            return;
                        }
                    } else if (cusChoice == 3) {
                        break;
                    }

                }
            } else if (cartChoice == 2) {
                // Process payment
                Payment payment = new Payment(Main.c.getTotalPrice());
                payment.processPayment();

                // Check if the payment was successful
                if (payment.getPaymentStatus()) {
                    // Create the order
Person news=new User();
news=Main.user.get(Main.thisUser);

                    Order order = new Order(Main.c,news, Main.restaurants.get(Main.thisRes), payment);
                    order.Preferred_DeliveryTime();
                    int orderTime = 2 * 60; // Convert minutes to seconds
                    OrderTimer orderTimer = new OrderTimer(orderTime);
                    orderTimer.startTimer();
                    order.DisplayOrder();
                    TimeUnit.MINUTES.sleep(2);
                    Main.c.emptyCart();
                    Review userReview = new Review(Main.user.get(Main.thisUser).getUserName());
                    userReview.getReview();
                    Main.restaurants.get(Main.thisRes).addReview(userReview);
                    Main.restaurants.get(Main.thisRes).addOrder(order);
                    break;


                } else {
                    System.out.println("Payment failed. Please try again.");
                }
            } else if (cartChoice == 3) {
                break;
            }
            else {
                System.out.println("please enter a number between 1-3:");
            }
        }
    }

    private static float getValidFloatInput(Scanner scanner) {
        float value;
        while (true) {
            try {
                value = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid float.");
            }
        }
        return value;
    }

    private static int getValidIntegerInput(Scanner scanner) {
        int value;
        while (true) {
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return value;
    }
    public void writeFiles() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("user.txt"));
        for(int i=0;i<Main.user.size();i++){
            writer.write(Main.user.get(i).toString());
            writer.newLine();
        }
        writer.close();
        Main.restaurants.get(0).writeMenuFile("res1.txt");
        Main.restaurants.get(0).writeReviewFile("review1.txt");
        Main.restaurants.get(1).writeMenuFile("res2.txt");
        Main.restaurants.get(1).writeReviewFile("review2.txt");
        Main.restaurants.get(2).writeMenuFile("res3.txt");
        Main.restaurants.get(2).writeReviewFile("review3.txt");
    }

}
