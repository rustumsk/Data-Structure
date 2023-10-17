import java.util.Scanner;
public class Admin extends User{
    private int adminId;
    private String department;

    Scanner scan = new Scanner(System.in);
    

    public Admin (int userId, String username, String email, int adminId, String department){
        super(userId,username,email);
        this.adminId = adminId;
        this.department = department;
    }
    
    public void addProduct(){

        int iCount = items.size();  
        int id = items.size() + 1;
        
        System.out.print("Enter Product Name: ");
        String name = scan.next();
        
        System.out.print("Enter Product Price: ");
        double price = scan.nextDouble();
        
        System.out.print("Enter quantity: ");
        int quanti = scan.nextInt();
  
        Product p4 = new Product(id , name, price, quanti);

        items.add(p4);
    
        System.out.println(items.get(iCount).toString() + " Is Added!");
    }

    public void removeProduct(){

        for(int i = 0 ;i < items.size() ; i++){
            System.out.println(items.get(i));
        }
        
        System.out.println("What product do you want to remove?: ");
        int remove = scan.nextInt();
        
        if(remove > items.size()){
            System.out.println("Invalid product ID!!");
            return;
        }
        
        int index = remove-1;
        items.remove(index);
        System.out.println("The product is removed!");
        for (int i = 0; i < items.size(); i++) {
        
            if (items.get(i).getProductId() >= remove) {
                items.get(i).setProductId(items.get(i).getProductId() - 1);
            }
        }
    }

    public void manageInventory(){
        
        for(int i = 0 ;i < items.size() ; i++){
            System.out.println(items.get(i).toString());
        }
        
        System.out.println("Press P.Change Price || Press Q. Change Quantity");
        String mDecide = scan.next();
        
        if(mDecide.toLowerCase().contains("p")){
            for(int i = 0 ;i < items.size() ; i++){
            System.out.println(items.get(i).toString());
        }
        
        System.out.println("What product price do u want to change?" + "\n" + "Enter product's id: ");
        int pChange = scan.nextInt();

        System.out.println("Enter the product's new price: ");
        double newPrice = scan.nextDouble();

        items.get(pChange - 1).updatePrice(newPrice);
        }
        else if(mDecide.toLowerCase().contains("q")){
            for(int i = 0 ;i < items.size() ; i++){
            System.out.println(items.get(i).toString());
        }
        
        System.out.println("What product quantity do u want to change?" + "\n" + "Enter product's id: ");
        int qChange = scan.nextInt();

        System.out.println("Enter the product's new Quantity: ");
        int newQuantity = scan.nextInt();

        items.get(qChange - 1).updateStock(newQuantity);
        }
    }
}
