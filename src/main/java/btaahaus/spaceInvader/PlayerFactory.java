/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btaahaus.spaceInvader;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.texture.Texture;

/**
 *
 * @author Administrator
 */
public class PlayerFactory implements EntityFactory{
    
    @Spawns("Player")
    
    public Entity newPlayer(SpawnData data){
        //Hier wird eine Variable festgelegt, die erst bei der 
        //Instanziierung festgelegt wird. 
        String textureSrc = data.get("textureSrc"); 
        Texture rocket = FXGL.texture(textureSrc, 50, 100);
        int speed = data.get("speed"); 
        
        //die X- und Y-Werte stehen standardmäßig zur
        //Verfügung und können über die getter-Methoden 
        //aufgerufen werden. 
        return FXGL.entityBuilder()
                .at(data.getX(), data.getY())
                .viewWithBBox(rocket)
                .with(new MovingComponent(speed), new CollidableComponent(true))
                .type(gameEntitys.PLAYER)
                .build(); 
                
    }
    
    
}
