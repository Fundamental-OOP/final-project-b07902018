import controller.Game;
import character.Walking;

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

        while(true){
            Game game = new Game();  // controller
        // GameView view = new GameView(game);  // view
            game.start(game);
            try{
                game.gmp.join();
            }catch (Exception e){
                System.out.println(e);
            };
        }
          // run the game and the game loop
        // view.launch(); // launch the GUI
    }
}
