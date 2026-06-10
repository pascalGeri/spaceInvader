package btaahaus.spaceInvader;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import static com.almasb.fxgl.dsl.FXGL.getInput;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.texture.Texture;
import java.util.List;
import java.util.Map;
import javafx.scene.input.KeyCode;

        //rocket.setScaleX(0.15);
        //rocket.setScaleY(0.15); Die Skalierung verändert nur die Darstellung des Bildes und nicht die wirkliche Größe
        //Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        //System.out.println(screenBounds.toString()); //DAs ist der Ausdruck: Rectangle2D [minX=0.0, minY=0.0, maxX=1920.0, maxY=1040.0, width=1920.0, height=1040.0]
/**
 * JavaFX App
 */
public class App extends GameApplication {
    int screenX; 
    int screenY; 
    Entity player;
    int fireBalltimer = 0;

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
        screenX = FXGL.getAppWidth();
        screenY = FXGL.getAppHeight();
        //hier werden nur die EntityFactorys registriert. 
        new FactoryController();
        //Erzeugung des Hintergrundes
        Texture background = FXGL.texture("bgSpace.jpg", screenX, screenY);
        FXGL.entityBuilder()
                .at(0, 0)
                .view(background)
                .zIndex(-100)
                .buildAndAttach();
        createObstacles(); //Erzeugen der Hindernisse

        //Erzeugen der Rakete
        int startX = (int) screenX / 2 - 50/ 2; 
        int startY = (int) screenY / 2; 
        player = FXGL.getGameWorld().spawn("Player", new SpawnData(startX, startY)
                .put("textureSrc", "rocketSchmal.png")
                .put("speed", 10));
        /*Texture rocket = FXGL.texture("rocketSchmal.png", 50, 100);
        player = FXGL.entityBuilder() //Der Spieler wird erstellt
                .at(screenX / 2 - rocket.getWidth() / 2, screenY / 2)
                .viewWithBBox(rocket)
                .type(gameEntitys.PLAYER)
                .with(new MovingComponent(10), new CollidableComponent(true))
                .buildAndAttach();*/
    }

    @Override
    protected void initInput() {
        Input input = getInput();
        //Steurung der Bullet
        /*input.addAction(new UserAction("shootPlayer"){
           @Override
           protected void onAction(){
               FXGL.getGameWorld().spawn("Bullet", new SpawnData(
               player.getX(), player.getY(), )
               ); 
           }
        }, KeyCode.SPACE);*/0
        
        
        //Steuerung des Players
        input.addAction(new UserAction("right") {
            @Override
            protected void onAction() {
                player.getComponent(MovingComponent.class).right();
            }
        }, KeyCode.D);
        input.addAction(new UserAction("left") {
            @Override
            protected void onAction() {
                player.getComponent(MovingComponent.class).left();
            }
        }, KeyCode.A);
        input.addAction(new UserAction("up") {
            @Override
            protected void onAction() {
                player.getComponent(MovingComponent.class).up();
            }
         ; 
        }, KeyCode.W);
        input.addAction(new UserAction("down") {
            @Override
            protected void onAction() {
                player.getComponent(MovingComponent.class).down();
            }
        }, KeyCode.S);
    }

    @Override
    protected void onUpdate(double tpf) {
        int lives = FXGL.getWorldProperties().getInt("lives"); 
        int leben = FXGL.getWorldProperties().getInt("speedOfPlayer");
             
        List<Entity> listOfFireballs = FXGL.getGameWorld().getEntitiesByType(gameEntitys.FIREBALL); 
        fireBalltimer++;
        if (fireBalltimer > tpf*2000) {
            FXGL.getGameWorld().spawn("fireBall");
            fireBalltimer = 0;
        }
        for(Entity fireball : listOfFireballs){
            if(fireball.getY() < screenY){
            fireball.getComponent(MovingComponent.class).fireBallDown(); 
            }
            else fireball.removeFromWorld();
        }
    }

    protected void createObstacles() {
        int[] startYObstacle = {50, 250, 640, 700};
        int[] startXObstacle = {50, 750, 120, 650};
        for (int i = 0; i < startXObstacle.length; i++) {
            Texture meteorit = FXGL.texture("meteorit.png", 90, 90);
            FXGL.entityBuilder()
                    .viewWithBBox(meteorit)
                    .at(startXObstacle[i], startYObstacle[i])
                    .type(gameEntitys.OBSTACLE)
                    .with(new CollidableComponent(true))
                    .buildAndAttach();
        }
    }
    @Override
    protected void initGameVars(Map<String, Object> vars){ //Map ist ein Interface und ermöglicht die Speicherung von Schlüssel-Wert-Paaren. Schlüssel müssen eindeutig sein, Werte können sich wiederholen. //Die Zuweisung von Schlüssel-Wert-Paaren macht Code lesbarer, da man über einen logisch benannten Schlüssel auf Werte zugreifen kann. 
        //Erzeugung einer integer Variablen mit dem Wert 3
        vars.put("lives", 3); 
        vars.put("speedOfPlayer", 5); //Hier könnte man z.B. eine Speed des Players festlegen, die während des Spiels angepasst wird
        //
        
    }

    @Override
    protected void initPhysics() {
        //Die Syntax mit einem CollisionHandler
        FXGL.getPhysicsWorld().addCollisionHandler(new CollisionHandler(gameEntitys.PLAYER, gameEntitys.OBSTACLE) {
            @Override
            protected void onCollision(Entity player, Entity obstacle) {
                System.out.println("Kollision vorhanden");
                MovingComponent comp = player.getComponent(MovingComponent.class);
                player.setPosition(
                        comp.getLastX(),
                        comp.getLastY()
                );
            }

            @Override
            protected void onCollisionEnd(Entity player, Entity obstacle) {
                System.out.println("Kollision beendet");
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
