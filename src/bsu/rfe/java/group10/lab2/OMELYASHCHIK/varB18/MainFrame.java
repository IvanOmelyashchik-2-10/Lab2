package bsu.rfe.java.group10.lab2.OMELYASHCHIK.varB18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private JTextField textFieldY;
    private JTextField textFieldX;
    private JTextField textFieldResult;
    private ButtonGroup radioButtons = new ButtonGroup();
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;
    MainFrame () {
        super("Вычесление значения функции");
        setSize(WIDTH,HEIGHT);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setLocation((toolkit.getScreenSize().width - WIDTH)/2,(toolkit.getScreenSize().height - HEIGHT)/2);

        textFieldX = new JTextField("0.0", 10 );
        textFieldX.setMaximumSize(new Dimension(2 * textFieldX.getPreferredSize().width, textFieldX.getPreferredSize().height));


    }
}
