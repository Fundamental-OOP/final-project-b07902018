package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import item.mobileItem.ApplePie;
import item.staticItem.*;
import order.OrderList;
import scoring.ScoreApplePie;
import scoring.ScoreBoard;
import scoring.ScoreComputer;

public class WorldExample1 extends World {

    public WorldExample1(CollisionHandler collisionHandler, ScoreBoard scoreboard, List<Sprite> sprites) {
        super(collisionHandler, scoreboard, sprites);
        
        for(int i = 0; i < 8; ++i){
            addSprite(new Table(new Point(i * 100, 0)));
            addSprite(new Table(new Point(i * 100, 600)));
        }
        for(int i = 1; i < 6; ++i){
            addSprite(new Table(new Point(0, i * 100)));
            addSprite(new Table(new Point(700, i * 100)));
        }
        addSprite(new ApplePieStove(new Point(300, 400)));
        addSprite(new AppleFactory(new Point(100, 300)));
        addSprite(new PieFactory(new Point(100, 400)));
        addSprite(new VegetableFactory(new Point(100, 500)));
        addSprite(new TrashCan(new Point(600, 300)));

        OrderList o1 = new OrderList();
        o1.addOrder(new ApplePie(new Point(0,0)));
        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null)));

        //ScoreBoard scoreboard = new ScoreBoard(0, 100, 100);
        addSprite(new PickupWindow(new Point(600, 400), o1, scoreboard, scoreComputer));
    }
    
}
