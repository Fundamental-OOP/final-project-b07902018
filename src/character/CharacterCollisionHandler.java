package character;

import model.CollisionHandler;
import model.Sprite;

import java.awt.*;

import item.Tabel;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class CharacterCollisionHandler implements CollisionHandler {
    @Override
    public void handle(Point originalLocation, Sprite from, Sprite to) {
        if (from instanceof Character && to instanceof Character) {
            Rectangle body = from.getBody();
            int offsetLeft = to.getX() - body.x;
            int offsetRight = body.x + body.width - to.getX();
            if (offsetLeft < 0) {
                to.setLocation(new Point(to.getX() - (to.getRange().width + offsetLeft) / 3, to.getY()));
            } else {
                to.setLocation(new Point(to.getX() + offsetRight / 3, to.getY()));
            }
        }
        else if (from instanceof Character && to instanceof Tabel) {
            Rectangle body = from.getBody();
            int offsetLeft = to.getX() - from.getBody().x;
            int offsetUp = to.getY() - from.getBody().y;
            if (offsetLeft < 0) { 
                from.setLocation(new Point(originalLocation.x, from.getY()));
                /*
                System.out.printf("To: %d, %d, %d, %d, %d, %d%n", to.getLocation().x, to.getBody().x,
                        to.getBody().width, to.getBodyOffset().width, to.getBodySize().width, originalLocation.x);
                System.out.printf("From: %d, %d, %d, %d, %d, %d%n", from.getLocation().x, from.getBody().x,
                        from.getBody().width, from.getBodyOffset().width, from.getBodySize().width, originalLocation.x);
                */
            } else {
                from.setLocation(new Point(to.getX() - from.getBody().width, from.getY()));
                /*
                System.out.printf("To: %d, %d, %d, %d, %d, %d%n", to.getLocation().x, to.getBody().x,
                        to.getBody().width, to.getBodyOffset().width, to.getBodySize().width, originalLocation.x);
                System.out.printf("From: %d, %d, %d, %d, %d, %d%n", from.getLocation().x, from.getBody().x,
                        from.getBody().width, from.getBodyOffset().width, from.getBodySize().width, originalLocation.x);
                */
            }

            if (offsetUp < 0) {
                from.setLocation(new Point(from.getX(), originalLocation.y));
            } else {
                from.setLocation(new Point(from.getX(), to.getY() - from.getBody().height));
            }
        }
    }
}