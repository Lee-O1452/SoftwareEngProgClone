import java.util.LinkedHashMap;

public class Main {
    private static LinkedHashMap<Integer, Store> storeList = new LinkedHashMap<>();
    public static void main(String [] args){
        MainMenu_1_ mainMenu = new MainMenu_1_();
    }
    public static LinkedHashMap<Integer, Store> getStoreList(){
        return storeList;
    }
}
