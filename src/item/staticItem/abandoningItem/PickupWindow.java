package item.staticItem.abandoningItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import item.mobileItem.ingredient.ApplePie;
import item.staticItem.PlaceItemOn;
import item.staticItem.StaticItem;
import model.Direction;
import model.Sprite;
import model.SpriteShape;
import order.OrderList;
import scoring.ScoreComputer;
import scoring.ScoreBoard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class PickupWindow extends StaticItem implements PlaceItemOn {

    private OrderList pendingOrders;

    private ScoreBoard scoreboard;

    private ScoreComputer scoreComputer;

    private ArrayList<MobileItem> items;


    public PickupWindow(Point location, SpriteShape shape, ScoreBoard scoreboard, ScoreComputer scoreComputer) {
        super(location, shape);
        items = new ArrayList<>();
        this.pendingOrders = new OrderList();
        this.scoreboard = scoreboard;
        this.scoreComputer = scoreComputer;
        

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/pickupwindow", imageRenderer)));
    }

    @Override
    public Point itemPlaceLocation(MobileItem item) {
        return this.getLocation();
    }
    public OrderList getPendingOrders() {
        return pendingOrders;
    }


    @Override
    public void tryAcquireItem(MobileItem item) {
        items.add(item);
        item.setLocation(itemPlaceLocation(item));
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

    public void clearItems(){
        for(MobileItem item : items){
            item.getWorld().removeSprite(item);
            //item.setWorld(null);
        }
        items.clear();
    }

    @Override
    public void update(){
        for (MobileItem item : items) {
            if (pendingOrders.contain(item)) {
                pendingOrders.completeOrder(item);
                scoreboard.increaseScore(scoreComputer.computeScore(item));
            }else{
                scoreboard.setScore(Math.max(0, scoreboard.getScore()-10));
            }
        }
        clearItems();
    }

    @Override
    public boolean hasSpace() {
        return true;
    }

    @Override
    public boolean hasItem() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canPickUpItem() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public MobileItem popItem() {
        // TODO Auto-generated method stub
        return null;
    }

}
