package character;

import fsm.CyclicSequence;
import fsm.ImageState;
import model.Direction;

import java.util.List;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Walking extends CyclicSequence {
    public static final String AUDIO_STEP1 = "step1";
    public static final String AUDIO_STEP2 = "step2";
    private final Character character;

    public Walking(Character character, List<ImageState> states) {
        super(states);
        this.character = character;
    }

    @Override
    public void update() {
        super.update();
        for (Direction direction : character.getDirections()) {
            character.getWorld().move(character, direction.translate());
        }  
    }

    @Override
    public String toString() {
        return "Walking";
    }
}
