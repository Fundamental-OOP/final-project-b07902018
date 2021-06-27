import controller.Game;
import item.*;
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
        Knight m1 = new Knight(new Point(150, 150));
        Tabel t1 = new Tabel(new Point(300, 150));
        KnightFactory f1 = new KnightFactory(new Point(0, 150));
        World world = new World(new CharacterCollisionHandler(), p1, p2, m1, t1, f1);  // model
        Game game = new Game(world, p1, p2, m1);  // controller
        GameView view = new GameView(game);  // view
        game.start();  // run the game and the game loop
        view.launch(); // launch the GUI
    }
}
