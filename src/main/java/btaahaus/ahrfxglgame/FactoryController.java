/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btaahaus.ahrfxglgame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.GameWorld;

/**
 *
 * @author Administrator
 */
public class FactoryController {

    public FactoryController() {

        GameWorld gameWorld = FXGL.getGameWorld(); 
        gameWorld.addEntityFactory(new BeispielFactory());
        
        
        gameWorld.addEntityFactory(new FrireballFactory());
        gameWorld.addEntityFactory(new BulletFactory());
        
        
    }
    
     
}
