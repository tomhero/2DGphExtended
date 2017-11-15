import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Creator");
        window.setBounds(250, 250, 600, 300);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        Font myFont = new Font(Font.SANS_SERIF, Font.PLAIN, 25);

        JLabel info = new JLabel("Input board's width and height.");
        info.setFont(myFont);
        info.setBounds(125, 10, 450, 100);

        JTextField wInput = new  JTextField();
        wInput.setBounds(125, 100, 100, 25);
        wInput.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel xSign = new JLabel("X");
        xSign.setFont(myFont);
        xSign.setBounds(290, 100, 100, 25);

        JTextField hInput = new  JTextField();
        hInput.setBounds(364, 100, 100, 25);
        hInput.setHorizontalAlignment(SwingConstants.CENTER);

        JButton createBtn = new JButton("create new board");
        createBtn.setFont(myFont);
        createBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createBtn.setBounds(169, 150, 250, 45);
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = Integer.parseInt(wInput.getText());
                int height = Integer.parseInt(hInput.getText());
                new Chessboard(width, height);
            }
        });

        window.add(info);
        window.add(wInput);
        window.add(xSign);
        window.add(hInput);
        window.add(createBtn);
        window.setVisible(true);
    }
}
