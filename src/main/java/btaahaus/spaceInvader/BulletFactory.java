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
public class BulletFactory  implements EntityFactory{
 
    @Spawns("Bullet")
    public Entity newBullet(SpawnData data){
        String bulletSrc = data.get("bulletSrc"); 
        Texture bullet = FXGL.texture(bulletSrc, 5, 12); 
        return FXGL.entityBuilder()
                .at(data.getX(), data.getY())
                .viewWithBBox(bullet)
                .type(gameEntitys.BULLET)
                .with(new MovingComponent(15), new CollidableComponent(true))
                .build(); 
    }
    
    
}
