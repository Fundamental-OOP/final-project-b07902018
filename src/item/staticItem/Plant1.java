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

import static utils.ImageStateUtils.imageStatesFromFolder;

public class Plant1 extends StaticItem {

    public Plant1(Point location, SpriteShape shape) {
        super(location, shape);
        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/plant1", imageRenderer)));
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
