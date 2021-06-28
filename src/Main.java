import controller.Game;
import item.*;
import item.staticItem.AppleFactory;
import item.staticItem.ApplePieStove;
import item.staticItem.PieFactory;
import item.staticItem.Table;
import item.staticItem.TrashCan;
import item.staticItem.VegetableFactory;
import character.Character;
import character.CharacterCollisionHandler;
import character.Walking;
import model.World;
import views.GameView;

import java.awt.*;
import java.io.File;

import static media.AudioPlayer.addAudioByFilePath;

/**
 * Demo route: Main, GameView, Game, GameLoop, World, Sprite, Knight, FiniteStateMachine
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {
    public static void main(String[] args) {
        addAudioByFilePath(Walking.AUDIO_STEP1, new File("assets/audio/step1.wav"));
        addAudioByFilePath(Walking.AUDIO_STEP2, new File("assets/audio/step2.wav"));


        // initialization procedure
        Character p1 = new Character(new Point(0, 0));
        Character p2 = new Character(new Point(300, 300));
        Table t1 = new Table(new Point(300, 0));
        ApplePieStove s1 = new ApplePieStove(new Point(300, 150));
        AppleFactory f1 = new AppleFactory(new Point(0, 150));
        PieFactory f2 = new PieFactory(new Point(0, 300));
        TrashCan tc1 = new TrashCan(new Point(150, 300));
        VegetableFactory f3 = new VegetableFactory(new Point(150, 0));
        World world = new World(new CharacterCollisionHandler(), p1, p2, t1, s1, f1, f2, f3, tc1);  // model
        Game game = new Game(world, p1, p2);  // controller
        GameView view = new GameView(game);  // view
        game.start();  // run the game and the game loop
        view.launch(); // launch the GUI
    }
}
