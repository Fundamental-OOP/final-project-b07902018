package item;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
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

    protected ArrayList<MobileItem> itemOnStove;

    protected Recipe currentRecipe;

    protected ArrayList<Recipe> recipes;

    protected final SpriteShape shape;

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
                new Idle(imageStatesFromFolder("assets/item/stove", imageRenderer)));

    }

    @Override
    public Point itemPlaceLocation() {
        return this.getLocation();
    }

    @Override
    public void checkRecipes(){
        for(Recipe recipe : recipes){
            if(recipe.craftAble(itemOnStove)){
                currentRecipe = recipe;
            }
        }
    }

    @Override
    public MobileItem produceItem() {
        if(currentRecipe != null){
            MobileItem newItem = currentRecipe.craft(itemOnStove);
            newItem.setLocation(getLocation());
            newItem.setWorld(this.getWorld());
            this.getWorld().addSprite(newItem);
        }
        return null;
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
/*
    @Override
    public void putin(Item itm) {
        cft.putItem(itm);
    }
*/

    @Override  
    public void update() {
        checkRecipes();
        produceItem();
        currentRecipe = null;
    }



}
