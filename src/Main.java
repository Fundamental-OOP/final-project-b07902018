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
import model.WorldExample1;
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

        Game game = new Game();  // controller
        // GameView view = new GameView(game);  // view
        game.start(game);  // run the game and the game loop
        // view.launch(); // launch the GUI
    }
}
