package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
public class ShopSystem{
    private final HashMap<String, Integer> itemList = new HashMap<>();
    private final ArrayList<int[]> itemLocation = new ArrayList<>();
    private final Player player;

    public ShopSystem(Player player){
        this.player = player;
        itemList.put("Health Potion",100);
        itemLocation.add(new int[] {567, 1003});
    }

    // TODO: Kevin
    //  - This is a usecase for ShopSystem
/*    public void checkLocation(){
        int x = player.getAbsXPlayer();
        int y = player.getAbsYPlayer();

        if (itemList.size() != 0){
            for (int[] coordinates: itemLocation){
                if (( x >= coordinates[0] && x <= coordinates[0] + 38) &&
                        (y >= coordinates[1] && y <= coordinates[1] + 38)){
                    purchase("Health Potion");
                }
            }
        }
    }*/

    public Set<String> getItemList() {
        return itemList.keySet();
    }

    // TODO: Kevin
    //  - This is a usecase for shop system
    public void purchase(String itemName) {
        // TODO: More on items goes here
        if (player.getGold() >= itemList.get(itemName)){
            player.removeGold(itemList.get(itemName));
            player.regenHealth(20);
            itemList.remove(itemName);

            System.out.println("Thank you for your purchase!");
            System.out.println("Balance: " + player.getGold());
        }
    }

}
