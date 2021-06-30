package model;

import java.awt.Color;
import java.awt.Dimension;
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

    private final int gridWidth = 75;

    private final int gridHeight = 75;

    private final SpriteShape staticItemShape 
        = new SpriteShape(new Dimension(75, 75), new Dimension(10, 10), new Dimension(55, 55));

    private final SpriteShape mobileItemShape
        = new SpriteShape(new Dimension(50, 50), new Dimension(33, 38), new Dimension(66, 105));

    public WorldExample2(CollisionHandler collisionHandler, int width, int height, ScoreBoard scoreboard, List<Sprite> sprites, JPanel panel) {
        super(collisionHandler, width, height, scoreboard, sprites, panel);
        
        for(int i = 0; i < 12; ++i){
            addSprite(new WoodPlatform(computeCoordinate(i, 0), staticItemShape));
        }

        addSprite(new ApplePieStove(computeCoordinate(0, 2), staticItemShape, mobileItemShape));
        addSprite(new PieBox(computeCoordinate(0, 3), staticItemShape, mobileItemShape));
        addSprite(new BreadBasket(computeCoordinate(0, 4), staticItemShape, mobileItemShape));
        addSprite(new FriedEggStove(computeCoordinate(0, 5), staticItemShape, mobileItemShape));
        
        
        addSprite(new Plant1(computeCoordinate(0, 1), staticItemShape));
        addSprite(new Plant1(computeCoordinate(0, 6), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(1, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(2, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(4, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(5, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(7, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(8, 7), staticItemShape));



        addSprite(new TrashCan(computeCoordinate(1, 1), staticItemShape));
        addSprite(new EggBasket(computeCoordinate(1, 6), staticItemShape, mobileItemShape));

        addSprite(new AppleBox(computeCoordinate(3, 7), staticItemShape, mobileItemShape));

        addSprite(new SaladBowl(computeCoordinate(4, 4), staticItemShape, mobileItemShape));

        addSprite(new SandwichMaker(computeCoordinate(5, 4), staticItemShape, mobileItemShape));

        addSprite(new CheeseBlock(computeCoordinate(6, 7), staticItemShape, mobileItemShape));

        addSprite(new SpinachGarden(computeCoordinate(8, 1), staticItemShape, mobileItemShape));
        addSprite(new TomatoBasket(computeCoordinate(8, 6), staticItemShape, mobileItemShape));

        addSprite(new WoodPlatform(computeCoordinate(9, 1), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(9, 2), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(9, 3), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(9, 5), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(9, 6), staticItemShape));
        
        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null, null)));


        PickupWindow window = new PickupWindow(computeCoordinate(9, 6), staticItemShape, scoreboard, scoreComputer);
        addSprite(window); 
        //scoreboard.setX(1050);
        addSprite(new OrderDiplayer(50, 600, window, panel));
        
    }

    public Point computeCoordinate(int Xgrid, int Ygrid){
        return new Point(Xgrid * gridWidth, Ygrid * gridHeight);
    }

    public  Point defaultPlayer1Location(){
        return new Point(200, 100);
    }

    public  Point defaultPlayer2Location(){
        return new Point(500, 100);
    }
    
    @Override
    public SpriteShape getCharacterShape(){
        return new SpriteShape(new Dimension(146 / 2, 176 / 2),
                new Dimension(40 / 2, 38 / 2), new Dimension(66 / 2, 104 / 2));
    }
}
