package controller;

import character.Character;
import item.Item;
import item.MobileItem;
import model.Direction;
import model.World;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Game extends GameLoop {
    private final Character p1;
    private final Character p2;



    private final World world;

    public Game(World world, Character p1, Character p2) {
        this.p1 = p1;
        this.p2 = p2;

        this.world = world;
    }

    public void moveCharacter(int playerNumber, Direction direction) {
        Character character = getPlayer(playerNumber);

        character.move(direction);
        //if(character.hasMobileItem()){
        //    character.getMobileItem().move(direction);
        //}
        
    }

    public void stopCharacter(int playerNumber, Direction direction) {
        Character character = getPlayer(playerNumber);

        character.stop(direction);
        //if(character.hasMobileItem()){
        //    character.getMobileItem().stop(direction);
        //}
    }

    public void pickUpItem(int playerNumber) {
        Character character = getPlayer(playerNumber);

        if(! character.hasMobileItem()){
            character.pickUp();
        }
    }

    public void releaseItem(int playerNumber) {
        Character character = getPlayer(playerNumber);

        if(character.hasMobileItem()){
            //character.getMobileItem().freeze();
            character.tryRelease();
        }

    }

    public Character getPlayer(int playerNumber) {
        return playerNumber == 1 ? p1 : p2;
    }

    @Override
    protected World getWorld() {
        return world;
    }
}
