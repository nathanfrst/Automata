package Entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage[] idleFrames;
    public BufferedImage[] runFrames;
    public BufferedImage[] attackFrames;
    public BufferedImage[] hurtFrames;

    public String direction = "right";

}