public class popularProductHelper{
    private int quantity;
    private Product p;
    public popularProductHelper(int quantity, Product p){
        this.quantity = quantity;
        this.p = p;
    }
    public int getQuantity() {
        return quantity;
    }

    public Product getP() {
        return p;
    }
}