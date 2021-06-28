package controller;

import java.util.ArrayList;

import item.mobileItem.MobileItem;
import order.Order;

public class OrderList {
    
    private ArrayList<Order> pendingOrders;

    public OrderList(){
        pendingOrders = new ArrayList<>();
    }

    public void addOrder(Order order){
        pendingOrders.add(order);
    }

    public void removeOrder(Order order){
        pendingOrders.remove(order);
    }

    public boolean contain(MobileItem item){
        for(Order order : pendingOrders){
            if(order.compatibleWithOrder(item)){
                return true;
            }
        }
        return false;
    }

    public void completeOrder(MobileItem item){
        for(Order order : pendingOrders){
            if(order.compatibleWithOrder(item)){
                removeOrder(order);
                break;
            }
        }
    }
    
}
