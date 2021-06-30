package model;

import java.awt.*;
import java.util.Collection;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import scoring.Score;
import scoring.ScoreBoard;
import timer.Timer;
import item.staticItem.FixedImageDisplayer;
import item.staticItem.TextDisplayer;

import java.awt.image.*;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class World {

    private final int gameTime = 100;

    private final List<Sprite> sprites = new CopyOnWriteArrayList<>();

    private final CollisionHandler collisionHandler;

    protected ScoreBoard scoreboard;

    protected final int worldWidth;

    protected final int worldHeight;

    protected Timer timer;

    protected TextDisplayer textDisplayer;

    protected FixedImageDisplayer recipe;

    public Timer getTimer() {
        return timer;
    }

    public World(CollisionHandler collisionHandler, int width, int height, ScoreBoard scoreboard, List<Sprite> sprites,
            JPanel panel) {
        
        worldWidth = width;

        worldHeight = height;
    
        this.collisionHandler = collisionHandler;
        
        timer = new Timer();

        textDisplayer = new TextDisplayer(935, 90);
        textDisplayer.setText("Timer");
        textDisplayer.setFontSize(25);

        String pathName = "assets/recipe2.png";
        recipe = new FixedImageDisplayer(pathName, 900, 720 - 180 * 2043 / 915, 180, 180 * 2043 / 915, panel);
        for(Sprite sprite: sprites){
            addSprite(sprite);
        }
        //scoreBoard = new ScoreBoard(0, 10, 10);
        //addSprite(scoreboard);

        var timerBackground = new FixedImageDisplayer("assets/newtimer.png", 900, 0, 180, 138, panel);
        var scoreboardBackground = new FixedImageDisplayer("assets/scoreboard.png",900,140,180,180,panel);
        var orderListBackground = new FixedImageDisplayer("assets/orderlistbg.png", 0, 600, 900, 120, panel);
        
        addSprite(timerBackground);
        addSprite(scoreboardBackground);
        addSprite(textDisplayer);
        addSprite(orderListBackground);
        addSprite(recipe);
        setScoreboard(scoreboard);

    }

    public void update() {
        if(!timer.started())timer.startTimer(gameTime);
        if(timer.getRemainTime()<=10)textDisplayer.setColor(Color.RED);
        textDisplayer.setText(timer.getCountString());
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

    public abstract Point defaultPlayer1Location();

    public abstract Point defaultPlayer2Location();

    public abstract SpriteShape getCharacterShape();

}
