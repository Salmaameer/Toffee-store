import java.util.random.RandomGenerator;
import java.util.Random;
import java.util.Scanner;

public class mainDemo {

    // public int createOtp(){
        // int otp = new Random().nextInt(9) + new Random().nextInt(9) + 
        // new Random().nextInt(9) + new Random().nextInt(9) + 
        // new Random().nextInt(9) + new Random().nextInt(9);

    //     return otp;
    // }

    public  static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);

       Customer customer = new Customer();


       System.out.println("Welcome to TOFFEE store, where you can find you Adrenaline ;)");
       System.out.println("1-registr \n 2-login \n 3- Start Shopping \n 4- checkout");
       int choice = scanner.nextInt();

       login

       switch (choice){

        case 1:
        Register.register(customer);

        case 2:



       }


       
        
    //     System.out.println("Choose the payment method : ");
    //     System.out.println("1- cash \n" + "2- Loyalty points" );
 
    //     Scanner scanner = new Scanner(System.in);
       
    //     System.out.println("Do you you want to login or register to the system?\n 1-regestr. \n 2-login.");
    //    int choice=scanner.nextInt();
    //     if(choice==1){
          
    //         Register registration = new Register();
    //         registration.register();
    //     }
    //     if(choice==2){
    //    login loginprocess=new login();
    //    loginprocess.userlogin();
    //     }
        
    //     Order o = new Order();

    //     System.out.println(o.getDateCreated());

    //     Customer c  = new Customer();
    //     c.setPhoneNo("00201104361948");



        // // c.getCustomerId;
        // // c.showAddress();
    

        // System.out.println(o.getOrderID());

        // Order o2 = new Order(c);
        // System.out.println(o2.getOrderID());
        // System.out.println(o2.getCustomerId());


        
// Payment pay = new Payment(o,"CASH")
//         System.out.println(pat.getPaymentMethod());

        

        
    }
    
}
