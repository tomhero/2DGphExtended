import javax.swing.*;
import java.awt.*;

public class Chessboard {
    Chessboard (int width, int height) {
        JFrame board = new JFrame("chessboard");
        board.setBounds(100, 100, width, height);
        board.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        board.setVisible(true);
    }
}
