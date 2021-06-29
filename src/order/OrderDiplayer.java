package order;

import item.staticItem.PickupWindow;
import item.staticItem.TextDisplayer;

public class OrderDiplayer extends TextDisplayer{
    protected PickupWindow pickupWindow;
    public OrderDiplayer(int x, int y,PickupWindow puw) {
        super(x, y);
        pickupWindow = puw;
    }
    @Override
    public void update(){
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
