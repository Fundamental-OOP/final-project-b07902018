package model;

import java.awt.*;
import java.util.Collection;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

import scoring.Score;
import scoring.ScoreBoard;
import timer.Timer;
import item.staticItem.TextDisplayer;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class World {

    private final List<Sprite> sprites = new CopyOnWriteArrayList<>();

    private final CollisionHandler collisionHandler;

    protected ScoreBoard scoreboard;

    protected final int worldWidth;

    protected final int worldHeight;

    protected Timer timer;

    public World(CollisionHandler collisionHandler, int width, int height, ScoreBoard scoreboard, List<Sprite> sprites) {
        
        worldWidth = width;

        worldHeight = height;
    
        this.collisionHandler = collisionHandler;
        
        timer = new Timer();

        TextDisplayer tdp = new TextDisplayer(800, 800);
        tdp.setText("Timer");
        this.addSprite(tdp);

        for(Sprite sprite: sprites){
            addSprite(sprite);
        }
        setScoreboard(scoreboard);
        //scoreBoard = new ScoreBoard(0, 10, 10);
        //addSprite(scoreboard);
    }

    public void update() {
        for (Sprite sprite : sprites) {
            sprite.update();
        }
    }

    public void addSprites(Sprite... sprites) {
        stream(sprites).forEach(this::addSprite);
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
        sprite.setWorld(this);
    }

    public void removeSprite(Sprite sprite) {
        sprites.remove(sprite);
        sprite.setWorld(null);
    }

    public void move(Sprite from, Dimension offset) {
        Point originalLocation = new Point(from.getLocation());
        from.getLocation().translate(offset.width, offset.height);

        Rectangle body = from.getBody();
        // collision detection
        for (Sprite to : sprites) {
            if (to != from && body.intersects(to.getBody())) {
                collisionHandler.handle(originalLocation, from, to);
            }
        }
    }

    public Collection<Sprite> getSprites(Rectangle area) {
        return sprites.stream()
                .filter(s -> area.intersects(s.getBody()))
                .collect(toSet());
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public int getScore(){
        return this.scoreboard.getScore();
    }

    public void setScoreboard(ScoreBoard scoreboard){
        this.scoreboard = scoreboard;
        addSprite(scoreboard);
    }

    // Actually, directly couple your model with the class "java.awt.Graphics" is not a good design
    // If you want to decouple them, create an interface that encapsulates the variation of the Graphics.
    public void render(Graphics g) {
        for (Sprite sprite : sprites) {
            sprite.render(g);
        }
    }

    public Point player1Location(){
        return new Point(200, 100);
    }

    public Point player2Location(){
        return new Point(500, 100);
    }

}
