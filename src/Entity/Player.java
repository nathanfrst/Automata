package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import java.awt.*;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultvalues();
    }
    public void setDefaultvalues(){

        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        if(keyH.spacePressed){
            y -= speed;
        }else if(keyH.downPressed){
            y += speed;
        }else if(keyH.leftPressed){
            x -= speed;
        }else if(keyH.rightPressed){
            x += speed;
        }
    }
    public void draw(Graphics2D g2){

        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

    }
}
