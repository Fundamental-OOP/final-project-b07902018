package order;

import java.util.ArrayList;
import java.util.List;

import item.mobileItem.*;
import item.mobileItem.ingredient.*;

import java.awt.*;

public abstract class Consumer {
    
    protected List<Order> pendingOrders;

    public void produceOrder() {
        int random = (int) (Math.random() * 14);
        MobileItem item = new Apple(null);
        String itemName = "no";
        switch (random) {
            case 0:
                item = new Apple(null);
                itemName = "Apple";
                break;
            case 1:
                item = new Pie(null);
                itemName = "Pie";
                break;
            case 2:
                item = new ApplePie(null);
                itemName = "ApplePie";
                break;
            case 3:
                item = new EnsaladaCompleta(null);
                break;
            case 4:
                item = new EnsaladaDeLechugaMaizYCebolla(null);
                break;
            case 5:
                item = new EnsaladaDeLechugaPepinoYCebolla(null);
                break;
            case 6:
                item = new EnsaladaDeLechugaTomateYCebolla(null);
                break;
            case 7:
                item = new EnsaladaDeTomateMaizYCebolla(null);
                break;
            case 8:
                item = new EnsaladaDeTomatePepinoYCebolla(null);
                break;
            case 9:
                item = new Lechuga(null);
                break;
            case 10:
                item = new Maiz(null);
                break;
            case 11:
                item = new Onion(null);
                break;
            case 12:
                item = new Pepino(null);
                break;
            case 13:
                item = new Tomato(null);
                break;
        }
        if (item instanceof Ingredient)
            itemName = ((Ingredient) item).getIngredientName();
        System.out.printf("Order: %s%n", itemName);
        addOrder(item);
    }

    public void addOrder(MobileItem item) {
        pendingOrders.add(new Order(item));
    }
}
