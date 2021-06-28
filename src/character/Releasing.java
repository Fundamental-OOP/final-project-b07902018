package character;

import fsm.Sequence;
import fsm.State;
import fsm.StateMachine;
import item.mobileItem.MobileItem;
import item.staticItem.PlaceItemIn;
import item.staticItem.PlaceItemOn;
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
public class Releasing extends Sequence {

    private final Character character;
    private final StateMachine stateMachine;

    public Releasing(Character character, StateMachine stateMachine, List<? extends State> states) {
        super(states);
        this.character = character;
        this.stateMachine = stateMachine;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        Rectangle releaseArea = releaseArea();
        g.setColor(Color.BLUE);
        g.drawRect(releaseArea.x, releaseArea.y, releaseArea.width, releaseArea.height);
    }

    private void effectRelease() {
        World world = character.getWorld();
        Rectangle releaseArea = releaseArea();
        var sprites = world.getSprites(releaseArea);

        for (Sprite sprite : sprites) {
            if (character != sprite && sprite instanceof PlaceItemOn) {
                PlaceItemOn place = (PlaceItemOn) sprite;
                if(place.hasSpace()){
                    character.getMobileItem().beReleased();
                    character.releaseMobileItem(place);
                } 
            }
        }

    }

    private Rectangle releaseArea() {
        return character.getArea(new Dimension(87, 70),
                new Dimension(55, 88));
    }

    @Override
    protected void onSequenceEnd() {
        effectRelease();
        currentPosition = 0;
        stateMachine.reset();
    }
}
