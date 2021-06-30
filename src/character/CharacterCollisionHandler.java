package character;

import model.CollisionHandler;
import model.Sprite;
import java.awt.*;
import item.staticItem.StaticItem;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class CharacterCollisionHandler implements CollisionHandler {
    @Override
    public void handle(Point originalLocation, Sprite from, Sprite to) {
        if (from instanceof Character && (to instanceof StaticItem || to instanceof Character))
            from.setLocation(new Point(originalLocation.x, originalLocation.y));
    }
}