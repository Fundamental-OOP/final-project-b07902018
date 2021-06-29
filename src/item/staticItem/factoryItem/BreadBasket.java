package item.staticItem.factoryItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import item.mobileItem.ingredient.Apple;
import item.mobileItem.ingredient.Bread;
import item.mobileItem.ingredient.Spinach;
import item.staticItem.StaticItem;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class BreadBasket extends Factory {

    public BreadBasket(Point location) {
        super(location, "breadbasket");
    }

    @Override
    public MobileItem produceItem() {
        Bread newItem = new Bread(new Point(150, 150));
        this.world.addSprite(newItem);
        return newItem;
    }

}
