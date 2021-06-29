package order;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.*;

import item.Idle;
import item.mobileItem.ingredient.Ingredient;
import item.staticItem.TextDisplayer;
import item.staticItem.abandoningItem.PickupWindow;
import model.Sprite;
import model.SpriteShape;

public class OrderDiplayer extends Sprite{
    
    protected PickupWindow pickupWindow;
    private int x, y;
    String text;
    Image image = null;
    JPanel panel;
    //Color color;
    protected final SpriteShape shape;


    public OrderDiplayer(int x, int y, PickupWindow puw,JPanel ot) {
        shape = new SpriteShape(new Dimension(146, 176), new Dimension(40, 38), new Dimension(66, 105));

        panel = ot;
        this.x = x;
        this.y = y;
        //super("assets/recipe/1.png", x, y);
        pickupWindow = puw;
    }

    @Override
    public void update() {
        text=(getOrderString());
    }
    
    private String getOrderString(){
        String s = "Order: ";
        try{
        for (var v:pickupWindow.getPendingOrders().pendingOrders){
            s+=v.getOrderContent().getClass().getSimpleName();
            s+=", ";
            var test =v.getOrderContent();
            if(test instanceof Ingredient){
                image = ((Ingredient) test).getImageStates().get(0).getImage();
            }
        }}catch(Exception e){
            
        }
        return s;
    }

    @Override
    public void render(Graphics g) {
        if(image!=null)
        g.drawImage(image, x, y, panel);
        else g.drawString(text,x,y);
        
    }

    @Override
    public Rectangle getRange() {
        return new Rectangle(location, shape.size);
    }

    @Override
    public Dimension getBodyOffset() {
        return shape.bodyOffset;
    }

    @Override
    public Dimension getBodySize() {
        return shape.bodySize;
    }
    
}
