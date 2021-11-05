package bsu.rfe.java.group10.lab2.OMELYASHCHIK.varB18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private JTextField textFieldY;
    private JTextField textFieldX;
    private JTextField textFieldZ;
    private JTextField textFieldResult;
    private ButtonGroup radioButtons = new ButtonGroup();
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;
    //Функция2
    public double function2(double x, double y, double z){
        return Math.tan(x*x) + Math.sqrt(y)/z * Math.log10(x+y) ;
    }
    //Функция1
    public double function1(double x, double y, double z){
        return Math.pow((Math.log((1+z)*(1+z)) + Math.cos(Math.PI*y*y*y)),1/4) /
                Math.pow((Math.cos(Math.pow(Math.E,x))) + Math.sqrt(1/x) + Math.pow(Math.E,x*x),Math.sin(x));
    }
    private void addRadioButton(String name, int formulaId){
        //СОздание радио кнопок и обработка нажатия
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    //MC M+
    private int numberOFvar = 1;
    private JTextField resultFieldM;
    private ButtonGroup radio_variable = new ButtonGroup();
    private Box box_of_variable = Box.createHorizontalBox();

    double mem1 = 0.0;
    double mem2 = 0.0;
    double mem3 = 0.0;

    private void addRadioVariable(String name, int numberOFvar){
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.resultFieldM = resultFieldM;
            }
        });
        radio_variable.add(button);
        box_of_variable.add(button);
    }


    MainFrame () {
        super("Вычесление значения функции");
        setSize(WIDTH,HEIGHT);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setLocation(10,10);
        addRadioButton("Function 1",1);
        addRadioButton("Function 2",2);

        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(),true);
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //MC M+
        setLocation(200,100);
        addRadioVariable("x",1);
        addRadioVariable("Y", 2);
        addRadioVariable("Z",3);

        radio_variable.setSelected(radio_variable.getElements().nextElement().getModel(),true);
        box_of_variable.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel ResultM = new JLabel("Результат M:",JLabel.RIGHT);

        textFieldX = new JTextField("0.0", 10 );
        textFieldX.setMaximumSize(new Dimension(2 * textFieldX.getPreferredSize().width, textFieldX.getPreferredSize().height));


    }
}
