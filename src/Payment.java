import java.util.Scanner;
public class Payment {
    private String payment_method;

    private boolean payment_status=false;
    private double total;
    private String creditCardNumber;
    private String CCV;



    public Payment(double total){
        this.total=total;
    }
    public void setPayment_method(String payment_method){

        this.payment_method=payment_method;
    }
    public String getPaymentMethod(){

        return payment_method;
    }
    public void setPayment_status(boolean payment_status){

        this.payment_method=payment_method;
    }
    public boolean getPaymentStatus(){
        return payment_status;
    }
    public void setTotal(double total){

        this.total=total;
    }

    public double getTotal(){

        return total;
    }
    public void paymentinfo(){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("The total is"+total);
        System.out.println("Payment Method: " + payment_method);
        System.out.println("Payment Status: " +(payment_status?"valid payment":"invalid payment"));
        System.out.println("-------------------------------------------------------------------------");
    }


    public void processPayment() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to choose a payment method
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Choose a payment method: ");
        System.out.println("1. Credit");
        System.out.println("2. Cash");
        System.out.println("-------------------------------------------------------------------------");


        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==1){
            payment_method = "Credit";
            enterCreditCardNumber();
            payment_status = true;
        }
        else if(choice==2 ){
            payment_method = "Cash";
            payment_status = true;
        }else {
            System.out.println("Invalid choice. Defaulting to Cash.");
            payment_method = "Cash";
            payment_status = true;
        }

    }
    private void enterCreditCardNumber() {
        Scanner scanner = new Scanner(System.in);
        String CreditCardNumber;
        while(true) {


            System.out.println("Enter credit card number: ");
            CreditCardNumber = scanner.nextLine();
            if(CreditCardNumber.matches("\\d+")){
            if (CreditCardNumber.length() != 16) {
                System.out.println("invalid card number");

            }
            else{
                break;
            }
        }
        else {
            System.out.println("invalid card number");
            }
        }
        while(true){

            System.out.println("enter CCV");
            String CCV = scanner.nextLine();
            if(CCV.matches("\\d+")){
            if (CCV.length() > 3) {
                System.out.println("invalid CCV");

            } else if(CCV.length() < 3){System.out.println("invalid CCV");}
            else {
                System.out.println("Credit card number entered: " + CreditCardNumber);
                break;
            }}
            else{
                System.out.println("invalid CCV");
                }



        }}}
