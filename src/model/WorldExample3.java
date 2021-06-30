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

public class WorldExample3 extends World {

    private final int gridWidth = 75;

    private final int gridHeight = 75;

    private final SpriteShape staticItemShape 
        = new SpriteShape(new Dimension(75, 75), new Dimension(10, 10), new Dimension(55, 55));

    private final SpriteShape mobileItemShape
        = new SpriteShape(new Dimension(30, 30), new Dimension(0, 0), new Dimension(30, 30));
    
    public WorldExample3(CollisionHandler collisionHandler, int width, int height, ScoreBoard scoreboard, List<Sprite> sprites, JPanel panel) {
        super(collisionHandler, width, height, scoreboard, sprites, panel);
        
        for(int i = 1; i < 4; ++i){
            addSprite(new Barrel(computeCoordinate(i, 0), staticItemShape));
        }
        for(int i = 8; i < 11; ++i){
            addSprite(new Barrel(computeCoordinate(i, 0), staticItemShape));
        }

        addSprite(new Plant1(computeCoordinate(0, 1), staticItemShape));
        addSprite(new EggBasket(computeCoordinate(1, 1), staticItemShape, mobileItemShape));
        addSprite(new BreadBasket(computeCoordinate(4, 1), staticItemShape, mobileItemShape));
        addSprite(new Barrel(computeCoordinate(5, 1), staticItemShape));
        addSprite(new Barrel(computeCoordinate(6, 1), staticItemShape));
        addSprite(new CheeseBlock(computeCoordinate(7, 1), staticItemShape, mobileItemShape));
        addSprite(new SpinachGarden(computeCoordinate(10, 1), staticItemShape, mobileItemShape));
        addSprite(new WoodPlatform(computeCoordinate(11, 1), staticItemShape));

        addSprite(new Barrel(computeCoordinate(0, 2), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(11, 2), staticItemShape));

        addSprite(new ApplePieStove(computeCoordinate(0, 3), staticItemShape, mobileItemShape));
        addSprite(new SaladBowl(computeCoordinate(5, 3), staticItemShape, mobileItemShape));

        addSprite(new FriedEggStove(computeCoordinate(0, 4), staticItemShape, mobileItemShape));
        addSprite(new SandwichMaker(computeCoordinate(6, 4), staticItemShape, mobileItemShape));
        addSprite(new Plant1(computeCoordinate(11, 4), staticItemShape));
        
        addSprite(new Barrel(computeCoordinate(0, 5), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(11, 5), staticItemShape));

        addSprite(new PieBox(computeCoordinate(0, 6), staticItemShape, mobileItemShape));
        addSprite(new AppleBox(computeCoordinate(4, 6), staticItemShape, mobileItemShape));
        addSprite(new Barrel(computeCoordinate(5, 6), staticItemShape));
        addSprite(new Barrel(computeCoordinate(6, 6), staticItemShape));
        addSprite(new TomatoBasket(computeCoordinate(7, 6), staticItemShape, mobileItemShape));
        addSprite(new TrashCan(computeCoordinate(11, 6), staticItemShape));
        
        

        addSprite(new WoodPlatform(computeCoordinate(1, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(2, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(3, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(8, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(9, 7), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(10, 7), staticItemShape));


    
        
        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null, null)));


        PickupWindow window = new PickupWindow(computeCoordinate(11, 3), staticItemShape, scoreboard, scoreComputer);
        addSprite(window); 
        //scoreboard.setX(1050);
        addSprite(new OrderDiplayer(50, 600, window, panel));

        
    }

    public Point computeCoordinate(int Xgrid, int Ygrid){
        return new Point(Xgrid * gridWidth, Ygrid * gridHeight);
    }

    @Override
    public Point defaultPlayer1Location() {
        return computeCoordinate(2, 2);
    }

    @Override
    public Point defaultPlayer2Location() {
        return computeCoordinate(9, 5);
    }
    
    @Override
    public SpriteShape getCharacterShape(){
        return new SpriteShape(new Dimension(146 / 2, 176 / 2),
                new Dimension(40 / 2, 38 / 2), new Dimension(66 / 2, 104 / 2));
    }
}
