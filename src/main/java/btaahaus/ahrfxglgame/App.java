package btaahaus.ahrfxglgame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import static com.almasb.fxgl.dsl.FXGL.getInput;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.physics.CollisionHandler;

/**
 * JavaFX App
 */
public class App extends GameApplication {
    @Override
    protected void initSettings(GameSettings setting){
        setting.setTitle("Mein erstes Game mit FXGL"); 
        setting.setFullScreenFromStart(true);
        setting.setVersion("0.0.1");
    }
    @Override
    protected void initGame(){
        Entity player = FXGL.entityBuilder()
                .type(t); 
    }

    public static void main(String[] args) {
        //Entweder so, oder nur mit launch und als Parameter args
        GameApplication.launch(App.class, args);
    }

}