package order;

import item.staticItem.ImageDisplayer;
import item.staticItem.PickupWindow;
import item.staticItem.TextDisplayer;
import item.staticItem.abandoningItem.PickupWindow;

public class OrderDiplayer extends TextDisplayer {
    
    protected PickupWindow pickupWindow;
    
    public OrderDiplayer(int x, int y, PickupWindow puw) {
        super("assets/recipe/1.png", x, y);
        pickupWindow = puw;
    }

    @Override
    public void update() {
        this.setText(getOrderString());
    }
    
    private String getOrderString(){
        String s = "Order: ";
        try{
        for (var v:pickupWindow.getPendingOrders().pendingOrders){
            s+=v.getOrderContent().getClass().getSimpleName();
            s+=", ";
        }}catch(Exception e){
            
        }
        return s;
    }
    
}
