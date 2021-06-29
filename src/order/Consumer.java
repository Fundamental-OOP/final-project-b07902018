package order;

import java.util.ArrayList;
import java.util.List;

import item.mobileItem.*;
import item.mobileItem.ingredient.*;

import java.awt.*;

public abstract class Consumer {
    
    protected List<Order> pendingOrders;

    public void produceOrder() {
        int random = (int) (Math.random() * 5);
        MobileItem item;
        switch (random) {
            case 0:
                item = new FriedEgg(null);
                break;
            case 1:
                item = new CheeseEggSandwich(null);
                break;
            case 2:
                item = new Salad(null);
                break;
            case 3:
                item = new RawEgg(null);
                break;
            case 4:
                item = new ApplePie(null);
                break;
            default:
                item = new Apple(null);
        }
        String itemName = ((Ingredient) item).getIngredientName();
        System.out.printf("Order: %s%n", itemName);
        addOrder(item);
    }

    public void addOrder(MobileItem item) {
        pendingOrders.add(new Order(item));
    }
    public List<Order> getFullList(){
        return pendingOrders;
    }

}
