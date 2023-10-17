import java.util.Scanner;
public class OnlineRetailSystem {
    public static void main(String[] args){ 
        Scanner scan = new Scanner(System.in);
        int i = 1;

        User.defaultProducts();

        do {
            System.out.print("User Log in" + "\n" );

            System.out.print("Enter user Id: " );
            int userId = scan.nextInt();

            System.out.print("Enter username: ");
            String username = scan.next();

            System.out.print("Enter email: ");
            String email = scan.next();

            User user = new User(userId,username,email);

            int acDecide = 1;
            do{
               System.out.print("Press 1. Admin log in || Press 2. Customer log in || Press 3. User Logout: ");
               int login = scan.nextInt();
               if (login == 1){
                   System.out.print("Enter Admin Id: ");
                   int adminId = scan.nextInt();
   
                   System.out.print("Enter department: ");
                   String dept = scan.next();
   
                   System.out.print("Admin ");
                   
                   Admin admin = new Admin (userId,username,email,adminId, dept);
   
                   admin.login();
                   
                   int aDecide = 1;
                   do{
                       System.out.print("\n" + "What do you want to do?" + "\n" + "1. Add Product 2. Remove Product 3. Manage Inventory: ");
                       int adminDecide = scan.nextInt();
   
                       if (adminDecide == 1) { 
                           admin.addProduct();
                       }
                       else if (adminDecide == 2){
                           admin.removeProduct();
                       }
                       else if (adminDecide == 3){
                           admin.manageInventory();
                       }
                       System.out.println("Press 1. Go back to admin menu || Press 2. Go back to Log in ");
                       int aChoice = scan.nextInt();
                       if(aChoice == 1){
                           aDecide = 1;
                       }   
                       else{
                           aDecide--;
                       }
                   }while (aDecide > 0);
   
               }
               else if (login == 2){
                   System.out.print("Enter Customer Id: ");
                   int customerId = scan.nextInt();
   
                   System.out.print("Enter address: ");
                   String address = scan.next();
   
                   System.out.print("Customer ");
   
                   Customer customer = new Customer (userId,username,email,customerId, address);
   
                   customer.login();
   
                   int cDecide = 1;
                   do{
                   System.out.println("\n" + "What do you want to do?" + "\n" + "====Press 1. Place an order || Press 2. Check order history====: ");
                   int cChoice = scan.nextInt();
                   if (cChoice == 1){
                       customer.placeOrder();
                   }
                   else if (cChoice == 2){
                       customer.viewOrderHistory();
                   }
                   System.out.println("Press 1. Go back to customer menu || Press 2. Go back to Log in");
                       int cLoop = scan.nextInt();
                       if (cLoop == 1){
                           cDecide= 1;
                       }
                       else{
                           cDecide--;
                       }
                   }while(cDecide > 0);
               }
               else if(login == 3){
                   user.logout();
                   acDecide--;
                   i--;
               }
               else{
                  System.out.print("Invalid option!" + "\n");
   
               }
               }while(acDecide > 0);
           }while (i > 0);
    }
}
