package character;

import fsm.Sequence;
import fsm.State;
import fsm.StateMachine;
import item.Factory;
import item.KnightFactory;
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

    public Picking(Character character, StateMachine stateMachine, List<? extends State> states) {
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
                MobileItem pickedItem = (MobileItem) sprite;
                if(!pickedItem.hasOwner()){
                    pickedItem.setLocation(character.mobileItemLocation());
                    character.addMobileItem(pickedItem);
                    pickedItem.picked(character);
                    break;
                }
            }
            else if (character != sprite && sprite instanceof Factory) {
                Factory itemFactory = (Factory) sprite;
                MobileItem newItem = itemFactory.produceItem();
                newItem.setLocation(character.mobileItemLocation());
                character.addMobileItem(newItem);
                newItem.picked(character);
                break;
            }
        }
    }

    private Rectangle pickArea() {
        return character.getArea(new Dimension(87, 70),
                new Dimension(55, 88));
    }

    @Override
    protected void onSequenceEnd() {
        effectPickUp();
        
        currentPosition = 0;
        stateMachine.reset();
    }
}
