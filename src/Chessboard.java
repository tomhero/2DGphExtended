import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Chessboard extends JFrame {
    Chessboard (int width, int height) {
        this.setTitle("chessboard");
        this.setBounds(100, 100, width, height);
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int w = this.getWidth(), h = this.getHeight();
        int boxW = w / 10, boxH = h / 10;

        int currentX = 0, currentY = 0, row = 1;

        Font myFont = new Font("Courier New", Font.BOLD, (w / 40 + h / 40) / 2);
        g.setFont(myFont);

        for (int j = 0; j < 64; j++) {

            if (j % 8 == 0) {
                currentY += boxH;
                currentX = boxW;
                row += 1;
            }

            if (row % 2 == 0) {
                if (j % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(getRandColor());
                }
            } else {
                if (j % 2 == 0) {
                    g.setColor(getRandColor());
                } else {
                    g.setColor(Color.WHITE);
                }
            }

            g.fillRect(currentX, currentY, boxW, boxH);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(j + 1), currentX + ((boxW / 2) - (boxW / 10)), currentY + (boxH / 2) + (boxH / 20));
            currentX += boxW;
        }

        g.setColor(Color.BLACK);
        g.drawRect(w / 10, h / 10, boxW * 8, boxH * 8);

    }

    private Color getRandColor() {
        Random rand = new Random();
        int red = rand.nextInt(55) + 200;
        int green = rand.nextInt(55) + 200;
        int blue = rand.nextInt(55) + 200;
        return new Color(red, green, blue);
    }
}
