import controller.Game;
import item.*;
import item.mobileItem.ApplePie;
import item.staticItem.AppleFactory;
import item.staticItem.ApplePieStove;
import item.staticItem.PickupWindow;
import item.staticItem.PieFactory;
import item.staticItem.Table;
import item.staticItem.TrashCan;
import item.staticItem.VegetableFactory;
import character.Character;
import character.CharacterCollisionHandler;
import character.Walking;
import model.World;
import model.Sprite;
import order.OrderList;
import scoring.ScoreApplePie;
import scoring.ScoreComputer;
import scoring.ScoreBoard;
import views.GameView;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static media.AudioPlayer.addAudioByFilePath;

/**
 * Demo route: Main, GameView, Game, GameLoop, World, Sprite, Knight, FiniteStateMachine
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {
    public static void main(String[] args) {
        addAudioByFilePath(Walking.AUDIO_STEP1, new File("assets/audio/step1.wav"));
        addAudioByFilePath(Walking.AUDIO_STEP2, new File("assets/audio/step2.wav"));

        // List<Sprite> Sprites = new ArrayList<>();
        // initialization procedure
        // Character p1 = new Character(new Point(0, 0));
        // Character p2 = new Character(new Point(300, 300));
        // Sprites.add(p1);
        // Sprites.add(p2);
        // Sprites.add(new Table(new Point(300, 0)));
        // Sprites.add(new ApplePieStove(new Point(300, 150)));
        // Sprites.add(new AppleFactory(new Point(0, 150)));
        // Sprites.add(new PieFactory(new Point(0, 300)));
        // Sprites.add(new VegetableFactory(new Point(150, 0)));
        // Sprites.add(new TrashCan(new Point(150, 300)));

        // OrderList o1 = new OrderList();
        // o1.addOrder(new ApplePie(new Point(0, 0)));
        // ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        // scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null)));

        // Scoreboard scoreboard = new Scoreboard(0, 100, 100);
        // Sprites.add(new PickupWindow(new Point(450, 450), o1, scoreboard, scoreComputer));
        // World world = new World(new CharacterCollisionHandler(), scoreboard, Sprites);  // model
        // Game game = new Game(world, p1, p2);  // controller
        Game game = new Game();
        // GameView gameview = new GameView(game);  // view
        game.start(game);  // run the game and the game loop
        // view.launch(); // launch the GUI
    }
}
