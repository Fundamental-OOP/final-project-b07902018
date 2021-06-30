package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import item.mobileItem.ingredient.*;
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

public class WorldExample5 extends World {

    private final int gridWidth = 75;

    private final int gridHeight = 75;

    private final SpriteShape staticItemShape = new SpriteShape(new Dimension(75, 75), new Dimension(10, 10),
            new Dimension(55, 55));

    private final SpriteShape mobileItemShape = new SpriteShape(new Dimension(30, 30), new Dimension(0, 0),
            new Dimension(30, 30));

    public WorldExample5(CollisionHandler collisionHandler, int width, int height, ScoreBoard scoreboard,
            List<Sprite> sprites, JPanel panel) {
        super(collisionHandler, width, height, scoreboard, sprites, panel);

        addSprite(new Plant1(computeCoordinate(3, 0), staticItemShape));
        addSprite(new Plant1(computeCoordinate(6, 0), staticItemShape));

        addSprite(new EggBasket(computeCoordinate(2, 1), staticItemShape, mobileItemShape));
        addSprite(new AppleBox(computeCoordinate(4, 1), staticItemShape, mobileItemShape));
        addSprite(new PieBox(computeCoordinate(5, 1), staticItemShape, mobileItemShape));
        addSprite(new EggBasket(computeCoordinate(7, 1), staticItemShape, mobileItemShape));

        addSprite(new BreadBasket(computeCoordinate(1, 2), staticItemShape, mobileItemShape));
        addSprite(new CheeseBlock(computeCoordinate(1, 3), staticItemShape, mobileItemShape));

        addSprite(new SpinachGarden(computeCoordinate(8, 2), staticItemShape, mobileItemShape));
        addSprite(new TomatoBasket(computeCoordinate(8, 3), staticItemShape, mobileItemShape));

        addSprite(new WoodPlatform(computeCoordinate(1, 4), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(1, 5), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(2, 4), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(2, 5), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(4, 4), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(4, 5), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(5, 4), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(5, 5), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(7, 4), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(7, 5), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(7, 6), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(8, 4), staticItemShape));
        addSprite(new WoodPlatform(computeCoordinate(8, 5), staticItemShape));

        addSprite(new Plant1(computeCoordinate(0, 6), staticItemShape));

        addSprite(new ApplePieStove(computeCoordinate(1, 7), staticItemShape, mobileItemShape));
        addSprite(new SaladBowl(computeCoordinate(2, 7), staticItemShape, mobileItemShape));
        addSprite(new SandwichMaker(computeCoordinate(4, 7), staticItemShape, mobileItemShape));
        addSprite(new FriedEggStove(computeCoordinate(5, 7), staticItemShape, mobileItemShape));
        addSprite(new TrashCan(computeCoordinate(6, 7), staticItemShape));

        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        scoreComputer.addScoreConversion(new ApplePie(null, null), 30);
        scoreComputer.addScoreConversion(new FriedEgg(null, null), 10);
        scoreComputer.addScoreConversion(new Salad(null, null), 30);
        scoreComputer.addScoreConversion(new VegetableSandwich(null, null), 30);
        scoreComputer.addScoreConversion(new CheeseEggSandwich(null, null), 50);

        PickupWindow window = new PickupWindow(computeCoordinate(3, 7), staticItemShape, scoreboard, scoreComputer);

        addSprite(window);
        //scoreboard.setX(1050);
        addSprite(new OrderDiplayer(50, 600, window, panel));

    }

    public Point computeCoordinate(int Xgrid, int Ygrid) {
        return new Point(Xgrid * gridWidth, Ygrid * gridHeight);
    }

    @Override
    public Point defaultPlayer1Location() {
        return computeCoordinate(3, 6);
    }

    @Override
    public Point defaultPlayer2Location() {
        return computeCoordinate(9, 5);
    }

    @Override
    public SpriteShape getCharacterShape() {
        return new SpriteShape(new Dimension(146 / 2, 176 / 2), new Dimension(40 / 2, 38 / 2),
                new Dimension(66 / 2, 104 / 2));
    }

}
