/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package btaahaus.ahrfxglgame;

/**
 *
 * @author Administrator
 */
public enum gameEntitys {
    //Enums sind spezielle Klassen von Gruppen von Konstanten, enum steht für enumerations, das für spezifisch gelistet steht. Sie können zum Beispiel für den Status eines Levels stehen oder wie die 
    //verschiedenen Entitys typisieren, um sie z.B. bei Collisionen untescheiden zu können. 
    PLAYER,
    METEORITE, 
    OBSTACLE, 
    FIREBALL, 
    BULLET, 
    ITEMS, //aufhebbare Gegenstände
    COLLECTIBLE, //Sammelbare Gegenstände
    POWERUPS, //Collectible, die die Eignschaften meines Raumschiffes verbessern 
    RESSOURCEN //Werkstoffe zur Verbesserung meines Raumschiffes
}
