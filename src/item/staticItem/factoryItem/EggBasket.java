package item.staticItem.factoryItem;

import java.awt.Point;

import item.mobileItem.MobileItem;
import item.mobileItem.ingredient.RawEgg;

public class EggBasket extends Factory {

    public EggBasket(Point location) {
        super(location, "eggbasket");
        //TODO Auto-generated constructor stub
    }

    @Override
    public MobileItem produceItem() {
        RawEgg newItem = new RawEgg(new Point(150, 150));
        this.world.addSprite(newItem);
        return newItem;
    }
    
}
