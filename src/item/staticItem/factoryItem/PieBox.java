package item.staticItem.factoryItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import item.mobileItem.ingredient.Apple;
import item.mobileItem.ingredient.Pie;
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

public class PieBox extends Factory {

    public PieBox(Point location, SpriteShape shape, SpriteShape productShape) {
        super(location, shape, productShape, "piebox");
    }

    @Override
    public MobileItem produceItem() {
        Pie newItem = new Pie(new Point(0, 0), productShape);
        this.world.addSprite(newItem);
        return newItem;
    }
    
}
