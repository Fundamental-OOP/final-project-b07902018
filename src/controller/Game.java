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

    private final Item m1;

    private final World world;

    public Game(World world, Character p1, Character p2, Item m1) {
        this.p1 = p1;
        this.p2 = p2;
        this.m1 = m1;
        this.world = world;
    }

    public void moveCharacter(int playerNumber, Direction direction) {
        getPlayer(playerNumber).move(direction);
        if(getPlayer(playerNumber).hasMobileItem()){
            getPlayer(playerNumber).getMobileItem().move(direction);
        }
        
    }

    public void stopCharacter(int playerNumber, Direction direction) {
        getPlayer(playerNumber).stop(direction);
        if(getPlayer(playerNumber).hasMobileItem()){
            getPlayer(playerNumber).getMobileItem().stop(direction);
        }
    }

    public void pickUpItem(int playerNumber) {
        getPlayer(playerNumber).pickUp();
    }

    public void releaseItem(int playerNumber) {
        getPlayer(playerNumber).release();
    }

    public Character getPlayer(int playerNumber) {
        return playerNumber == 1 ? p1 : p2;
    }

    @Override
    protected World getWorld() {
        return world;
    }
}
