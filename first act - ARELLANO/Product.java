public class Product {
    int productId;
    String name;
    double price;
    int stockQuantity;

    public Product(int productId, String name, double price, int stockQuantity){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    public Product(double price){
        this.price = price;
    }

    public Product(){

    }

    @Override
    public String toString() {
        return "ProductId: " + productId + " |Name: " + name + " |Price: " + price + " |StockQuantity: "
                + stockQuantity;
    }
    public void updatePrice(double price) {
        this.price = price;
    }

    public void updateStock(int stockQuantity){
        this.stockQuantity = stockQuantity;
    }
    
    public void setProductId(int productId){
        this.productId = productId;
    }
    
    public double getPrice() {
        return this.price;
      }
      
    public int getQuantity(){
        return stockQuantity;
    }
    
    public int getProductId(){
        return productId;
    }
    
    public String getProductName(){
        return name;
    }
}
