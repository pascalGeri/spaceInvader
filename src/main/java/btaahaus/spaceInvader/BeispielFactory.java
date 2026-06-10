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

public class BeispielFactory implements EntityFactory {
    //Die Definition von Eigenschaften ist normal möglich
    @Spawns("BeispielFactory") 
    public Entity newEntity(SpawnData data){
        return FXGL.entityBuilder()
                .at(data.getX(), data.getY())
                //weitere Eigenschaften, Components usw. 
                .build(); 
    }
    //Hier ist es möglich, weitere Methoden zu deklarieren
}
