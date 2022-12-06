public class reportHelper {
    private int quantity;
    private double totalValue;
    private int totalOrders;
    private Product p;
    private Customer c;

    public reportHelper(int quantity, Product p){
        this.quantity = quantity;
        this.p = p;
    }

    public reportHelper(double totalValue, Product p){
        this.totalValue = totalValue;
        this.p = p;
    }

    public reportHelper(int totalOrders, Customer c){
        this.totalOrders = totalOrders;
        this.c = c;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalValue(){
        return totalValue;
    }

    public Product getP() {
        return p;
    }

    public Customer getC() {
        return c;
    }

    public int getTotalOrders() {
        return totalOrders;
    }
}