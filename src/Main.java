import java.io.*;
import java.util.LinkedHashMap;

public class Main {
    private static LinkedHashMap<String, Store> storeList = new LinkedHashMap<>();
    private static LinkedHashMap<String, Order> orderList = new LinkedHashMap<>();
    public static void main(String [] args) throws IOException, ClassNotFoundException {
        try {
            FileInputStream storeFIS = new FileInputStream("storeList.out");
            ObjectInputStream storeOIS = new ObjectInputStream(storeFIS);
            Main.storeList = (LinkedHashMap<String, Store>) storeOIS.readObject();
            storeOIS.close();
            storeFIS.close();
        } catch (FileNotFoundException ex) {
            //continue with empty map
        }

        try {
            FileInputStream orderFIS = new FileInputStream("orderList.out");
            ObjectInputStream orderOIS = new ObjectInputStream(orderFIS);
            Main.orderList = (LinkedHashMap<String, Order>) orderOIS.readObject();
            orderOIS.close();
            orderFIS.close();
        } catch (FileNotFoundException ex) {
            //continue with empty map
        }

        MainMenu_1_ mainMenu = new MainMenu_1_();
    }

    public static LinkedHashMap<String, Store> getStoreList(){
        return storeList;
    }

    public static LinkedHashMap<String, Order> getOrderList(){
        return orderList;
    }
}
