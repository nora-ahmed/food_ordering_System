import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private String deliveryAddress;
User (){

}

    public void setDeliveryAddress( String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public User(String userName , String email , String password , String deliveryAddress){
        super(userName , email , password);
        this.deliveryAddress = deliveryAddress;
    }

    public static User register(List<User> userList){
        Scanner read = new Scanner(System.in);

        String newUserName;
        String newUserEmail;
        String password;
        boolean isUnique;


        do {
            System.out.print("Enter your username : ");
            newUserName = read.nextLine();

            isUnique = IsUserNameUnique(newUserName , userList);
            if (!isUnique){
                System.out.println("UserName already exists. please choose different username ");
            }

        }while (!isUnique);

        do {
            System.out.print("Enter your email : ");

            do {
                newUserEmail = read.nextLine();
                if (!IsValidEmail(newUserEmail)){
                    System.out.println("Email is not valid. please enter a valid email.");
                }
            }while (!IsValidEmail(newUserEmail));

            isUnique = IsUserEmailUnique(newUserEmail , userList);
            if (!isUnique){
                System.out.println("Email already exists. please choose different email ");
            }

        }while (!isUnique);

        System.out.print("Enter your password : ");
        do {
            password = read.nextLine();
            if (!IsValidPassword(password)){
                System.out.println("Password is not valid. at lest 8 letters");
            }
        }while (!IsValidPassword(password));


        System.out.print("Enter your deliveryAddress : ");
        String deliveryAddress = read.nextLine();

        return new User(newUserName, newUserEmail , password , deliveryAddress);
    }


    public static int Login(List<User> userList)
    {

        Scanner read = new Scanner(System.in);

        System.out.print("Enter your username : ");
        String enteredUserName = read.nextLine();

        System.out.print("Enter your password : ");
        String enteredPassword = read.nextLine();

        for (User user : userList) {

            if (user.getUserName().equals(enteredUserName) && user.getPassword().equals(enteredPassword)) {
                return 1;
            }
            else if (enteredUserName.equals("Susan") && enteredPassword.equals("12345678")){

                return 2;
            }
        }
        return 0;
    }


    private static boolean  IsUserNameUnique(String newUserName , List<User> userList){
        for (User user : userList){

            if (user.getUserName().equals(newUserName)){
                return false;
            }

        }

        return true;
    }

    private static boolean IsValidEmail(String email){

        if (email.contains("@")) {
            String[] parts = email.split("@");

            if (parts.length == 2){

                return !parts[0].isEmpty() && parts[0].matches(".*[a-zA-Z].*") && parts[1].equalsIgnoreCase("gmail.com");

            }

        }
        return false;
    }

    private static boolean IsUserEmailUnique(String newUserEmail , List<User> userList){
        for (User user : userList){

            if (user.getEmail().equals(newUserEmail)){
                return false;
            }

        }

        return true;
    }

    private static boolean IsValidPassword(String password){
        return password.length() >= 8;
    }
    public String toString(){
        return this.getUserName()+","+this.getEmail()+","+this.getPassword()+","+this.deliveryAddress;
    }

    @Override
    public void displayInfo() {
        System.out.println("-----------------------Welcome user "+getUserName()+"-----------------------");
    }
}
