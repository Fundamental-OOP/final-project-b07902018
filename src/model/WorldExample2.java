package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import item.mobileItem.ingredient.ApplePie;
import item.staticItem.*;
import item.staticItem.abandoningItem.PickupWindow;
import item.staticItem.abandoningItem.TrashCan;
import item.staticItem.craftingItem.ApplePieStove;
import item.staticItem.craftingItem.FriedEggStove;
import item.staticItem.craftingItem.SaladBowl;
import item.staticItem.craftingItem.SandwichMaker;
import item.staticItem.factoryItem.AppleBox;
import item.staticItem.factoryItem.BreadBasket;
import item.staticItem.factoryItem.CheeseBlock;
import item.staticItem.factoryItem.EggBasket;
import item.staticItem.factoryItem.PieBox;
import item.staticItem.factoryItem.SpinachGarden;
import item.staticItem.factoryItem.TomatoBasket;
import item.staticItem.factoryItem.VegetableFactory;
import order.OrderDiplayer;
import order.OrderList;
import scoring.ScoreApplePie;
import scoring.ScoreBoard;
import scoring.ScoreComputer;

public class WorldExample2 extends World {

    public WorldExample2(CollisionHandler collisionHandler, ScoreBoard scoreboard, List<Sprite> sprites,JPanel panel) {
        super(collisionHandler, scoreboard, sprites);
        
        for(int i = 1; i < 9; ++i){
            addSprite(new WoodPlatform(new Point(i * 100, 0)));
        }
        addSprite(new WoodPlatform(new Point(0, 100)));
        addSprite(new WoodPlatform(new Point(0, 600)));
        addSprite(new WoodPlatform(new Point(100, 700)));
        addSprite(new WoodPlatform(new Point(200, 700)));
        addSprite(new WoodPlatform(new Point(400, 700)));
        addSprite(new WoodPlatform(new Point(500, 700)));
        addSprite(new WoodPlatform(new Point(700, 700)));
        addSprite(new WoodPlatform(new Point(800, 700)));

        addSprite(new ApplePieStove(new Point(0, 200)));
        addSprite(new PieBox(new Point(0, 300)));
        addSprite(new BreadBasket(new Point(0, 400)));
        addSprite(new FriedEggStove(new Point(0, 500)));

        addSprite(new TrashCan(new Point(100, 100)));
        addSprite(new EggBasket(new Point(100, 600)));

        addSprite(new AppleBox(new Point(300, 700)));

        addSprite(new SaladBowl(new Point(400, 400)));

        addSprite(new SandwichMaker(new Point(500, 400)));

        addSprite(new CheeseBlock(new Point(600, 700)));

        addSprite(new SpinachGarden(new Point(800, 100)));
        addSprite(new TomatoBasket(new Point(800, 600)));

        addSprite(new WoodPlatform(new Point(900, 100)));
        addSprite(new WoodPlatform(new Point(900, 200)));
        addSprite(new WoodPlatform(new Point(900, 300)));
        addSprite(new WoodPlatform(new Point(900, 500)));
        addSprite(new WoodPlatform(new Point(900, 600)));
        
        


        OrderList o1 = new OrderList();
        o1.addOrder(new ApplePie(new Point(0,0)));
        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null)));

        //ScoreBoard scoreboard = new ScoreBoard(0, 100, 100);
        var w = new PickupWindow(new Point(900, 400), scoreboard, scoreComputer);
        addSprite(w);
        var o = new OrderDiplayer(1000, 200, w,panel);
        //o.setColor(Color.DARK_GRAY);
        addSprite(o);
    }
    
}
