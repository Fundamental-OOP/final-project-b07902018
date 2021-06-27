package item;

import fsm.Sequence;
import fsm.State;
import fsm.StateMachine;
import item.MobileItem;
import jdk.nashorn.api.tree.SpreadTree;
import media.AudioPlayer;
import model.Sprite;
import model.World;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class GettingPicked extends Sequence {

    private final Item item;
    private final StateMachine stateMachine;

    public GettingPicked(Item item, StateMachine stateMachine, List<? extends State> states) {
        super(states);
        this.item = item;
        this.stateMachine = stateMachine;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    protected void onSequenceEnd() {
        currentPosition = 0;
        stateMachine.reset();
    }
}

