import java.time.LocalDateTime;
import java.util.Scanner;
class Customer extends User{
    private int customerId;
    private String adress;
    int oQuantity;
    public int iQuantity;

    LocalDateTime time = LocalDateTime.now();
    Scanner scan = new Scanner(System.in);
    
    public Customer(int userId,String username, String email, int customerId, String adress){
        super(userId, username, email);
        this.customerId = customerId;
        this.adress = adress;
    }
    public Customer(){
        super(0,"","");
    }
    
    public void placeOrder(){
        int pLoop = 1;
        do{
           System.out.println("======MENU=======");
           for(int i = 0 ;i < items.size() ; i++){
               System.out.println(items.get(i).toString());
           }
           System.out.println("What product do you wish to buy?" + "\n" + "Enter the product's ID: ");
           int oDecide = scan.nextInt();
   
           int oIndex = oDecide - 1;
           
           if (items.get(oIndex).getQuantity() == 0){
               System.out.println("Error! Product out of Stock!");
               return;
           }
   
           int qCheck = 1;
           do{
           System.out.println("Enter quantity: ");
           oQuantity = scan.nextInt();
           if(oQuantity <= 0){
               System.out.println("Please enter a valid quantity!");
               qCheck = 1;
           }
           else if(oQuantity > items.get(oIndex).getQuantity()){
               System.out.println("Please Enter a valid Quantity!");
           }
           else if (items.get(oIndex).getQuantity() == 0){
               System.out.println("Product out of stock!");
               return;
           }
           else{
               qCheck--;
           }
        }while(qCheck > 0);

        Product product = new Product();
        iQuantity = items.get(oIndex).getQuantity() - oQuantity;
        items.get(oIndex).updateStock(iQuantity);

        int oProductId = items.get(oIndex).getProductId();
        String oProducts = items.get(oIndex).getProductName();
        double oPrice = items.get(oIndex).getPrice() * oQuantity;
        Order order = new Order(oProductId,customerId,oProducts,oPrice,time);
        Order.orderList.add(order);

        System.out.println("Press 1. Add product/s to order || Press 2. Continue Shopping");
        int oProductDecide = scan.nextInt();
   
        if(oProductDecide == 1){
            order.addProductToOrder();
            pLoop--;
            System.out.println("Confirm order? Yes|No");
            String confirm = scan.next();
            if(confirm.toLowerCase().contains("yes")){
                order.confirmOrder();
                order.calculateTotalAmount();
                pLoop = 0;
            }
            else{
                return;
            }
        }
        else{
            pLoop = 1;
        }
        }while(pLoop > 0);

        }
        
    public void viewOrderHistory(){
        Order order = new Order(customerId,time);
        if (Order.orderList.size() > 0){
        System.out.println("Here is your order history!");
        order.confirmOrder();
        }
        else{
            System.out.println("No order placed!");
        }
    }
}     