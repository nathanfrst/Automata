package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private final GamePanel gp;
    private final KeyHandler keyH;

    private int frameIndex = 0;
    private int animationCounter = 0;
    private boolean moving = false;

    private static final int FRAME_WIDTH = 96;
    private static final int FRAME_HEIGHT = 96;
    private static final int FRAME_DELAY = 8; // atualiza o quadro a cada 8 updates

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultvalues();
        getPlayerImage();
    }

    public void setDefaultvalues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void getPlayerImage() {
        try {
            BufferedImage sheet = ImageIO.read(
                    getClass().getResourceAsStream("/player/RUN.png")
            );

            int frameCount = sheet.getWidth() / FRAME_WIDTH;
            runFrames = new BufferedImage[frameCount];

            for (int i = 0; i < frameCount; i++) {
                runFrames[i] = sheet.getSubimage(
                        i * FRAME_WIDTH, 0, FRAME_WIDTH, FRAME_HEIGHT
                );
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        moving = false;

        if (keyH.spacePressed) {
            y -= speed;
            moving = true;
        } else if (keyH.downPressed) {
            y += speed;
            moving = true;
        } else if (keyH.leftPressed) {
            x -= speed;
            moving = true;
        } else if (keyH.rightPressed) {
            x += speed;
            moving = true;
        }

        if (moving && runFrames != null) {
            animationCounter++;

            if (animationCounter >= FRAME_DELAY) {
                frameIndex = (frameIndex + 1) % runFrames.length;
                animationCounter = 0;
            }
        } else {
            frameIndex = 0;
            animationCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        if (runFrames != null && runFrames.length > 0) {
            int drawSize = gp.tileSize * 3;

            int drawX = (gp.screenWidth - drawSize) / 2;
            int drawY = y - gp.tileSize * 2;

            g2.drawImage(
                    runFrames[frameIndex],
                    drawX, drawY, drawSize, drawSize,
                    null
            );
        }
    }
}