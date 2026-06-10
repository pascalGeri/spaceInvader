/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btaahaus.spaceInvader;

import com.almasb.fxgl.entity.component.Component;

/**
 *
 * @author Administrator
 */
public class FireBallComponent extends Component {
    double speed = 0;

    public FireBallComponent(double speed) {
        this.speed = speed; 
    }
    
    
    public void moveDown() {
        entity.translateY(speed);
    }

}
