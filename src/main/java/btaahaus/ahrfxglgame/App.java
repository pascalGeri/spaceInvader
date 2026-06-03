package btaahaus.ahrfxglgame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import static com.almasb.fxgl.dsl.FXGL.getInput;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;

/**
 * JavaFX App
 */
public class App extends GameApplication {

    Entity player;

    @Override
    protected void initSettings(GameSettings setting) {
        setting.setTitle("Mein erstes Game mit FXGL");
        setting.setFullScreenAllowed(true);
        setting.setWidth(1280);
        setting.setHeight(880);
        //setting.setFullScreenFromStart(true);
        setting.setVersion("0.0.1");
    }

    @Override
    protected void initGame() {
        int screenX = FXGL.getAppWidth();
        int screenY = FXGL.getAppHeight();
        Texture rocket = FXGL.texture("rocket.png", 50, 100);
        Texture background = FXGL.texture("bgSpace.jpg", screenX, screenY);
        //rocket.setScaleX(0.15);
        //rocket.setScaleY(0.15); Die Skalierung verändert nur die Darstellung des Bildes und nicht die wirkliche Größe
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        System.out.println(screenBounds.toString()); //DAs ist der Ausdruck: Rectangle2D [minX=0.0, minY=0.0, maxX=1920.0, maxY=1040.0, width=1920.0, height=1040.0]
        FXGL.entityBuilder()
                .at(0,0)
                .view(background)
                .zIndex(-100)
                .buildAndAttach(); 
        createObstacles(); //Erzeugen der Hindernisse
        player = FXGL.entityBuilder() //Der Spieler wird erstellt
                .at(screenX / 2 - rocket.getWidth() / 2, screenY / 2)
                .viewWithBBox(rocket)
                .type(gameEntitys.PLAYER)
                .with(new JumperComponent(), new CollidableComponent(true))
                .buildAndAttach();
    }

    @Override
    protected void initInput() {
        Input input = getInput();
        input.addAction(new UserAction("right") {
            @Override
            protected void onAction() {
                player.getComponent(JumperComponent.class).right();
            }
        }, KeyCode.D);
        input.addAction(new UserAction("left") {
            @Override
            protected void onAction() {
                player.getComponent(JumperComponent.class).left();
            }
        }, KeyCode.A);
        input.addAction(new UserAction("up") {
            @Override
            protected void onAction() {
                player.getComponent(JumperComponent.class).up();
            }
         ; 
        }, KeyCode.W);
        input.addAction(new UserAction("down") {
            @Override
            protected void onAction() {
                player.getComponent(JumperComponent.class).down();
            }
        }, KeyCode.S);
    }

    protected void onUpdate() {

    }

    protected void createObstacles() {
        int[] startYObstacle = {50, 250, 640, 700};
        int[] startXObstacle = {50, 750, 120, 650};
        for (int i = 0; i < startXObstacle.length; i++) {
            Texture meteorit = FXGL.texture("meteorit.png", 100, 100);
            FXGL.entityBuilder()
                    .viewWithBBox(meteorit)
                    .at(startXObstacle[i], startYObstacle[i])
                    .type(gameEntitys.OBSTACLE)
                    .with(new CollidableComponent(true))
                    .buildAndAttach();
        }
    }

    @Override
    protected void initPhysics() {
        //Die Syntax mit einem CollisionHandler
        FXGL.getPhysicsWorld().addCollisionHandler(new CollisionHandler(gameEntitys.PLAYER, gameEntitys.OBSTACLE) {
            @Override
            protected void onCollisionBegin(Entity player, Entity obstacle) {
                System.out.println("getroffen");
                player.getComponent(JumperComponent.class).setCanMove(false);
            }

            @Override
            protected void onCollisionEnd(Entity player, Entity obstacle) {
                player.getComponent(JumperComponent.class).setCanMove(true);
            }
        });
    }

    public static void main(String[] args) {

        //Entweder so, oder nur mit launch und als Parameter args
        System.out.println("Das Spiel wurde gestartet. yeah");
        GameApplication.launch(App.class, args); //Die Gameapplication braucht den Parameter args
        //Alles nach launch wird in der main nicht mehr ausgeführt. 

    }

}
