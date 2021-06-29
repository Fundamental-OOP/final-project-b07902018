package item.staticItem.factoryItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import item.mobileItem.ingredient.Apple;
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

public class SpinachGarden extends Factory {

    public SpinachGarden(Point location) {
        super(location, "spinachgarden");
    }

    @Override
    public MobileItem produceItem() {
        Spinach newItem = new Spinach(new Point(150, 150));
        this.world.addSprite(newItem);
        return newItem;
    }

}
