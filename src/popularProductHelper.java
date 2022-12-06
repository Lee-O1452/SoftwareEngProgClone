public class popularProductHelper{
    private int quantity;
    private double totalValue;
    private Product p;
    public popularProductHelper(int quantity, Product p){
        this.quantity = quantity;
        this.p = p;
    }

    public popularProductHelper(double totalValue, Product p){
        this.totalValue = totalValue;
        this.p = p;
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
}