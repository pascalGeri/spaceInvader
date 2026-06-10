package btaahaus.spaceInvader;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.texture.Texture;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */

public class FrireballFactory implements EntityFactory {

    int x = 0;

    @Spawns("fireBall")
    public Entity newFireball(SpawnData data) {
        double height = setHeight();
        double width = 0.5 * height;
        Texture fireBall = FXGL.texture("fireBallSenkrecht.png", width, height);
        return FXGL.entityBuilder(data)
                .at(randomStartX(), -height)
                .type(gameEntitys.FIREBALL)
                .viewWithBBox(fireBall)
                .with(new MovingComponent(10*Math.random() +3))
                .build();
    }
    protected double randomStartX() {
        return FXGL.getAppWidth() * Math.random();
    }

    protected double setHeight() {
        double value = 0;
        do {
            value = 200 * Math.random();
        } while (value < 80);
        return value;
    }
}
