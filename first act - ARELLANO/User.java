import java.util.ArrayList;

class User {
    int userId;
    String username;
    String email;
    
     static ArrayList<Product> items = new ArrayList<Product>();
    {

    }

    public User(int userId, String username, String email){
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public void login(){
        System.out.print(this.username + " " +"have successfully logged in");
    }

    public void logout(){
        System.out.print("You have logged out!");
    }

    public static ArrayList<Product> getItemsList() {
        return items;
    }
    
    public static void defaultProducts(){ 
  
        Product p1 = new Product(1,  "Chocolate", 29.90, 10);
        Product p2 = new Product(2, "Not Chocolate", 0.50, 20);
        Product p3 = new Product(3, "Something Like Chocolate",   10,   30);

        items.add(p1);
        items.add(p2);
        items.add(p3);
    }


}
   