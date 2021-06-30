package order;

import java.util.List;
import item.mobileItem.*;
import item.mobileItem.ingredient.*;

public abstract class Consumer {
    
    protected List<Order> pendingOrders;

    public void produceOrder(int lowerBound, int upperBound) {
        int num = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
        for (int x = 0; x < num; ++x) {
            int random = (int) (Math.random() * 5);
            MobileItem item;
            switch (random) {
                case 0:
                    item = new FriedEgg(null, null);
                    break;
                case 1:
                    item = new CheeseEggSandwich(null, null);
                    break;
                case 2:
                    item = new Salad(null, null);
                    break;
                case 3:
                    item = new RawEgg(null, null);
                    break;
                case 4:
                    item = new ApplePie(null, null);
                    break;
                default:
                    item = new Apple(null, null);
            }
            String itemName = ((Ingredient) item).getIngredientName();
            System.out.printf("Order: %s%n", itemName);
            addOrder(item);
        }
    }

    public void addOrder(MobileItem item) {
        pendingOrders.add(new Order(item));
    }
    public List<Order> getFullList(){
        return pendingOrders;
    }

}
