/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btaahaus.spaceInvader;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;

/**
 *
 * @author Administrator
 */
public class MovingComponent extends Component {

    private TransformComponent entityPositions;
    private double speed;
    private double lastX;
    private double lastY;

    public MovingComponent(double speed) {
        this.speed = speed; 
    }
    @Override
    public void onUpdate(double tpf) {
        speed = tpf * 90; //Speed ist nur ein Factor, der die Synchronisation mit der FPS regelt
    }

    public void up() {
        lastX = entity.getX();
        lastY = entity.getY();
        if (entity.getY() > 0) {
            entity.translateY(-5 * speed);
        }
    }

    
    public void down() {
        lastX = entity.getX();
        lastY = entity.getY();
        if (entity.getY() < FXGL.getAppHeight() - entity.getHeight()) {
            entity.translateY(5 * speed);
        }
    }
    public void fireBallDown() {
        lastX = entity.getX();
        lastY = entity.getY();
        entity.translateY(5 * speed);
       
    }
    public void bulletMove(int bulletSpeed) {
        lastX = entity.getX();
        lastY = entity.getY();
        entity.translateY(-bulletSpeed * speed);
       
    }

    public void right() {
        lastX = entity.getX();
        lastY = entity.getY();
        if (entity.getX() < FXGL.getAppWidth()) {
            entity.translateX(speed * 5);
        }
    }

    public void left() {
        lastX = entity.getX();
        lastY = entity.getY();
        if (entity.getX() > 0) {
            entity.translateX(speed * -5);
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getLastY() {
        return this.lastY;
    }

    public double getLastX() {
        return this.lastX;
    }
}
