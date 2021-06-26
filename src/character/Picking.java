package character;

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
public class Picking extends Sequence {

    private final Character character;
    private final StateMachine stateMachine;
    private final Set<Integer> damagingStateNumbers = new HashSet<>(List.of(6));

    public Picking(Character character, StateMachine stateMachine, List<? extends State> states) {
        super(states);
        this.character = character;
        this.stateMachine = stateMachine;
    }

    @Override
    public void update() {
        super.update();
        if (damagingStateNumbers.contains(currentPosition)) {
            effectPickUp();
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        Rectangle pickArea = pickArea();
        g.setColor(Color.BLUE);
        g.drawRect(pickArea.x, pickArea.y, pickArea.width, pickArea.height);
    }

    private void effectPickUp() {
        World world = character.getWorld();
        Rectangle pickArea = pickArea();
        var sprites = world.getSprites(pickArea);

        for (Sprite sprite : sprites) {
            if (character != sprite && sprite instanceof MobileItem) {
                sprite.setLocation(new Point(character.getX() + character.getRange().width, character.getX()));
                character.addMobileItem((MobileItem) sprite);
            }
        }

    }

    private Rectangle pickArea() {
        return character.getArea(new Dimension(87, 70),
                new Dimension(55, 88));
    }

    @Override
    protected void onSequenceEnd() {
        currentPosition = 0;
        stateMachine.reset();
    }
}
