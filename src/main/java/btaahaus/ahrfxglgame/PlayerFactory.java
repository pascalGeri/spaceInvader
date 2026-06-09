/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btaahaus.ahrfxglgame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.texture.Texture;

/**
 *
 * @author Administrator
 */
public class PlayerFactory implements EntityFactory{
    
    @Spawns("Player")
    
    public Entity newPlayer(SpawnData data){
        Texture rocket = FXGL.texture("rocketSchmal.png", 50, 100);
        return FXGL.entityBuilder()
                .view(rocket)
                .build(); 
                
    }
    
    
}
