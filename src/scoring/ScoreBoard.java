package scoring;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import model.Sprite;
import model.SpriteShape;

public class ScoreBoard extends Sprite{

    private Score score;
    private int x;
    private int y;
    protected final SpriteShape shape;

    public ScoreBoard(Score s, int x, int y){
        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(40, 38), new Dimension(66, 105));
        score =s;
        this.x = x;
        this.y = y;
    }

    public Score getScore() {
        return score;
    }

    public void increaseScore() {
        
    }


    
    @Override
    public void update() {
        
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(String.format("Time: %d, Score: %d",System.currentTimeMillis(),score.getScore()), x, y);
    }

    @Override
    public Rectangle getRange() {
        return new Rectangle(location, shape.size);
    }

    @Override
    public Dimension getBodyOffset() {
        return shape.bodyOffset;
    }

    @Override
    public Dimension getBodySize() {
        return shape.bodySize;
    }
    
}
