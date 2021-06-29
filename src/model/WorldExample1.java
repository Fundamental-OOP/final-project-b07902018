package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import item.mobileItem.ingredient.ApplePie;
import item.staticItem.*;
import item.staticItem.abandoningItem.PickupWindow;
import item.staticItem.abandoningItem.TrashCan;
import item.staticItem.craftingItem.ApplePieStove;
import item.staticItem.factoryItem.AppleBox;
import item.staticItem.factoryItem.PieBox;
import item.staticItem.factoryItem.VegetableFactory;
import order.OrderDiplayer;
import order.OrderList;
import scoring.ScoreApplePie;
import scoring.ScoreBoard;
import scoring.ScoreComputer;

public class WorldExample1 extends World {

    public WorldExample1(CollisionHandler collisionHandler, ScoreBoard scoreboard, List<Sprite> sprites) {
        super(collisionHandler, scoreboard, sprites);
        
        for(int i = 0; i < 8; ++i){
            addSprite(new WoodPlatform(new Point(i * 100, 0)));
            addSprite(new WoodPlatform(new Point(i * 100, 600)));
        }
        for(int i = 1; i < 3; ++i){
            addSprite(new WoodPlatform(new Point(0, i * 100)));
            addSprite(new WoodPlatform(new Point(700, i * 100)));
        }
        addSprite(new AppleBox(new Point(0, 300)));
        addSprite(new PieBox(new Point(0, 400)));
        addSprite(new VegetableFactory(new Point(0, 500)));


        addSprite(new ApplePieStove(new Point(300, 400)));
        addSprite(new ApplePieStove(new Point(700, 500)));
        addSprite(new TrashCan(new Point(700, 300)));

        OrderList o1 = new OrderList();
        o1.addOrder(new ApplePie(new Point(0,0)));
        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null)));

        //ScoreBoard scoreboard = new ScoreBoard(0, 100, 100);
        var w = new PickupWindow(new Point(700, 400), scoreboard, scoreComputer);
        addSprite(w);
        var o = new OrderDiplayer(100, 120, w);
        o.setColor(Color.DARK_GRAY);
        addSprite(o);
    }
    
}
