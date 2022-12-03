import java.util.LinkedHashMap;

public class Main {
    private static LinkedHashMap<String, Store> storeList = new LinkedHashMap<>();
    public static void main(String [] args){
        MainMenu_1_ mainMenu = new MainMenu_1_();
    }
    public static LinkedHashMap<String, Store> getStoreList(){
        return storeList;
    }
}
