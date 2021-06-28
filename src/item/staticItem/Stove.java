package item.staticItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import crafting.Crafter;
import crafting.Recipe;
import crafting.recipe.TwoToOne;

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class Stove extends StaticItem implements PlaceItemOn, Maker {

    protected final long cookTime = 3000;

    protected long readyTime = Long.MAX_VALUE;

    protected ArrayList<MobileItem> itemOnStove;

    protected Recipe currentRecipe;

    protected ArrayList<Recipe> recipes;

    protected final SpriteShape shape;

    private State cookingState;

    protected boolean isCooking = false;

    protected MobileItem pendingItem = null;
    

    //public Crafter cft;

    public Stove(Point location) {
        super(location);

        itemOnStove = new ArrayList<>();

        recipes = new ArrayList<>();

        //cft = new Crafter();
        //cft.rcps.add(new TwoToOne());
        
        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(40, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/stove/idle", imageRenderer)));
        cookingState = new WaitingPerFrame(4,
        new Idle(imageStatesFromFolder("assets/item/stove/cooking", imageRenderer)));
    }

    @Override
    public Point itemPlaceLocation() {
        return this.getLocation();
    }

    @Override
    public void checkRecipes(){
        if(isCooking) return;
        for(Recipe recipe : recipes){
            if(recipe.craftAble(itemOnStove)){
                currentRecipe = recipe;
                readyTime = System.currentTimeMillis()+cookTime;
                isCooking = true;
                pendingItem = currentRecipe.craft(itemOnStove);
                System.out.println(readyTime);
                //TODO: add a cooking sprite
            }
        }
    }

    @Override
    public void evokeCurrentRecipe() {
        if(isCooking && pendingItem!= null && System.currentTimeMillis() >= readyTime){
            readyTime = Long.MAX_VALUE;
            isCooking = false;
            //TODO: remove cooking sprite
            pendingItem.setLocation(getLocation());
            pendingItem.setWorld(this.getWorld());
            this.getWorld().addSprite(pendingItem);
            pendingItem = null;
        }
    } 

    @Override
    public void tryAcquireItem(MobileItem item) {
        itemOnStove.add(item);
        item.setLocation(itemPlaceLocation());
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

    @Override 
    public void render(Graphics g) {
        if(isCooking){
            cookingState.render(g);
        }
        else{
            idle.render(g);
        }
    } 

    @Override  
    public void update() {
        checkRecipes();
        evokeCurrentRecipe();
        currentRecipe = null;
    }



}
