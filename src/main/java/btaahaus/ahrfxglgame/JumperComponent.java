/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btaahaus.ahrfxglgame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;

/**
 *
 * @author Administrator
 */
public class JumperComponent extends Component {

    private TransformComponent entityPositions;
    private double speed;
    private boolean canMove = true;

    public void onUpdate(double tpf) {
        speed = tpf * 90;
    }

    public void up() {
        if (entity.getY() > 0 && canMove) {
            entity.translateY(-5 * speed);
        }
        else entity.translateY(speed * 25);
    }

    public void down() {
        if (entity.getY() < FXGL.getAppHeight()-entity.getHeight() && canMove) {
            entity.translateY(5 * speed);
        }
        else entity.translateY(speed * -25);
    }

    public void right() {
        if (entity.getX() < FXGL.getAppWidth()&& canMove) {
            entity.translateX(speed * 5);
        }
        else entity.translateX(speed * -25);
    }
    public void left() {
        if (entity.getX() > 0 && canMove) {
            entity.translateX(speed * -5);
        }
        else entity.translateX(speed * 25);
    }
 public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }



}
