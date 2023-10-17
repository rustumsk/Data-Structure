import java.time.LocalDateTime;
import java.util.ArrayList;
public class Order {
    int orderId;
    int customerId;
    String products;
    double totalAmount = 0;
    LocalDateTime orderDate;
    static double price;

    Customer customer = new Customer();

    public static ArrayList<Order> orderList = new ArrayList<>();{
    }
    
    //public static ArrayList<Order> order = new ArrayList<>();{}

    public Order(int orderId, int customerId, String products, double totalAmount, LocalDateTime orderDate){
        this.orderId = orderId;
        this.customerId = customerId;
        this.products = products;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }
    
    public Order(int customerId, LocalDateTime orderDate){
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "orderId: " + orderId + " | customerId: "+customerId+ " | Product: " + products + " | Price: " + totalAmount + " | orderDate: "
                + orderDate;
    }

    public void calculateTotalAmount() {
        for(int i = 0 ;i < orderList.size() ; i++){
            price += orderList.get(i).getTotalAmount();
        }
        System.out.println("Total Amount:" + price);
    }

    public void addProductToOrder(){
        for(int i = 0 ;i < orderList.size() ; i++){
            System.out.println(orderList.get(i).toString());
        }
        System.out.println("Is added to order!");
        
    }

    public void confirmOrder(){
        System.out.println("The order is confirmed!");
        for(int i = 0 ;i < orderList.size() ; i++){
            System.out.println(orderList.get(i).toString());
        }
    }
    public double getTotalAmount(){
        return this.totalAmount;
    }
    public void getOrderHistory(){
        for(int i = 0 ;i < orderList.size() ; i++){
            System.out.println(orderList.get(i).toString());
        }
    }
}