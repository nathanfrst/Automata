import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

        final int originalTileSize = 16;
        final int scale = 3;


        final int tileSize = originalTileSize * scale; //48x48
        final int maxScreenCol = 16;
        final int maxScreenRow = 12;
        final int screenWidth = tileSize * maxScreenCol; // 768 pixels
        final int screenHeight = tileSize * maxScreenCol; // 576 pixels

        Thread gameThread;

        public GamePanel(){
                this.setPreferredSize(new Dimension(screenWidth, screenHeight));
                this.setBackground(Color.black);
                this.setDoubleBuffered(true);
        }
}
