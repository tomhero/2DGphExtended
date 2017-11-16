import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
                try {
                    int width = Integer.parseInt(wInput.getText());
                    int height = Integer.parseInt(hInput.getText());
                    if (width < 500 || height < 500) {
                        throw new InvalidNumberException("please input number more than 500");
                    }
                    new Chessboard(width, height);
                } catch (NumberFormatException numberErr) {
                    numberErr.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Number only please.",
                            "Number Error",
                            JOptionPane.ERROR_MESSAGE);

                } catch (InvalidNumberException invalidErr) {
                    invalidErr.printStackTrace();
                    JOptionPane.showMessageDialog(window,
                            "Enter more than 500 please",
                            "Number Invalid",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        window.add(info);
        window.add(wInput);
        window.add(xSign);
        window.add(hInput);
        window.add(createBtn);
        window.setVisible(true);

        // listTest();
    }

    private static void listTest() {
        ArrayList<Integer> intList = genIntList();
        ArrayList<String> stringList = genStringList();
        System.out.println("origin -> " + intList);
        System.out.println("origin -> " + stringList + "\n");

        // normal sort asc
        Collections.sort(intList);
        System.out.println("sort asc -> " + intList);

        // sort desc
        Collections.sort(intList, Collections.reverseOrder());
        System.out.println("sort desc -> " + intList + "\n");

        // remove item
        stringList.remove("three");
        System.out.println("remove item ('three') -> " + stringList);

        // reverse item
        Collections.reverse(stringList);
        System.out.println("reverse item -> " + stringList);

        // shuffle list
        Collections.shuffle(stringList);
        System.out.println("shuffle list -> " + stringList);

        // find max min
        System.out.println("max: " + Collections.max(intList));
        System.out.println("min: " + Collections.min(intList));

        // replace all
        Collections.replaceAll(stringList, "one", "uno");
        System.out.println("replace all -> " + stringList);

        // rotate list
        Collections.rotate(stringList, 4);
        System.out.println("rotate 4 round -> " + stringList);

        // searching
        System.out.println("index of 'ono' -> " + stringList.indexOf("uno"));
    }

    private static ArrayList<String> genStringList() {
        return new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "one", "five"));
    }

    private static ArrayList<Integer> genIntList() {
        return new ArrayList<>(Arrays.asList(5,6,4,8,5,4,2,1,9));
    }
}
