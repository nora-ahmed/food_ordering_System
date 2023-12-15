import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.InputMismatchException;

class Main {

    static List<Restaurant> restaurants=new ArrayList<>();
    static int thisUser;
    static int thisRes;
    static List<User> user = new ArrayList<>();
    static Cart c = new Cart();

    public static void main(String[] args) throws InterruptedException, IOException {
        Restaurant r= new Restaurant("Tikka", "City Stars", "indian", "01550200168", 0.0F);
        restaurants.add(r);
        Restaurant r2=new Restaurant("Casamia", "El-korba", "Italian", "0113457890", 0.0F);
        restaurants.add(r2);
        Restaurant r3= new Restaurant("Al-Rukn al-sharki", "Nasr city", "arabian", "0110230678", 0.0F);
 restaurants.add(r3);
        MainMenu j = new MainMenu();
        j.ReadAllFiles();
        j.WelcomePage();


    }
}
