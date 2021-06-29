package item.staticItem;

import java.awt.*;

import model.Sprite;
import model.SpriteShape;

public class TextDisplayer extends Sprite{

    private int x, y;
    String text;
    Color color;
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    protected final SpriteShape shape;

    public TextDisplayer( int x, int y){
        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(40, 38), new Dimension(66, 105));

        this.x = x;
        this.y = y;
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

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawString(text,x, y);
        
    }
    
}
