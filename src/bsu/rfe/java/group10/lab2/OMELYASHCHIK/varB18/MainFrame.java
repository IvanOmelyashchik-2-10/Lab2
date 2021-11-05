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

    Double mem1 = 0.0;
    Double mem2 = 0.0;
    Double mem3 = 0.0;

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
        box_of_variable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel ResultM = new JLabel("Результат M:",JLabel.RIGHT);
        resultFieldM = new JTextField("0.0",30);
        resultFieldM.setMaximumSize(resultFieldM.getPreferredSize());

        Box boxResultM = Box.createHorizontalBox();
        boxResultM.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        boxResultM.add(Box.createHorizontalGlue());
        boxResultM.add(ResultM);
        boxResultM.add(Box.createHorizontalStrut(10));
        boxResultM.add(resultFieldM);
        boxResultM.add(Box.createHorizontalGlue());

        //
        JLabel forX = new JLabel("X: ");
        textFieldX = new JTextField("0",10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel forY = new JLabel("Y: ");
        textFieldY = new JTextField("0",10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel forZ = new JLabel("Z: ");
        textFieldZ = new JTextField("0",10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        Box Variables = Box.createHorizontalBox();
        Variables.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Variables.add(Box.createHorizontalGlue());
        Variables.add(forX);
        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(textFieldX);

        Variables.add(Box.createHorizontalStrut(100));
        Variables.add(forY);
        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(textFieldY);
        Variables.add(Box.createHorizontalGlue());

        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(forZ);
        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(textFieldZ);
        Variables.add((Box.createHorizontalGlue()));

        JLabel forResult = new JLabel("Результат: ");
        textFieldResult = new JTextField("0",30);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());

        Box boxResult = Box.createHorizontalBox();
        boxResult.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        boxResult.add(Box.createHorizontalGlue());
        boxResult.add(forResult);
        boxResult.add(Box.createHorizontalStrut(10));
        boxResult.add(textFieldResult);
        boxResult.add(Box.createHorizontalGlue());
        //

        JButton resultButton = new JButton("result");
        resultButton.addActionListener(new ActionListener() {
            // Определить и зарегистрировать обработчик нажатия на кнопку
            public void actionPerformed(ActionEvent e) {
                try{
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId == 1){
                        result = function1(x, y, z);
                    }
                    else{
                        result = function2(x, y, z);
                    }

                    textFieldResult.setText(result.toString());
                }catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Floating point format error", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        // MC M+
        JButton M = new JButton("M+");
        M.addActionListener(new ActionListener() {
            // Определить и зарегистрировать обработчик нажатия на кнопку
            public void actionPerformed(ActionEvent e) {
                try{
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());

                    if (numberOFvar==1) {
                        mem1 += x;
                        resultFieldM.setText(mem1.toString());

                    }
                    if (numberOFvar==2) {
                        mem2+=y;
                        resultFieldM.setText(mem2.toString());
                    }
                    if (numberOFvar==3) {
                        mem3 += z;
                        resultFieldM.setText(mem3.toString());
                    }
                    /*

*/
                }catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Floating point format error", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //очистить запоминание
        JButton MC_clear = new JButton("MC");
        MC_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numberOFvar ==1)
                {
                    textFieldX.setText("0");
                }
                if(numberOFvar ==2) {
                    textFieldY.setText("0");
                }
                if(numberOFvar ==3) {
                    textFieldZ.setText("0");
                }
            }
        });
        //Очистить все
        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldY.setText("0");
                textFieldResult.setText("0");
                ResultM.setText("0");
            }
        });

        Box boxbuttons = Box.createHorizontalBox();
        boxbuttons.add(Box.createHorizontalGlue());
        boxbuttons.add(resultButton);
        boxbuttons.add(Box.createHorizontalStrut(30));
        boxbuttons.add(clear);
        //2-3
        boxbuttons.add(M);
        boxbuttons.add(MC_clear);
        //
        boxbuttons.add(Box.createHorizontalGlue());
        boxbuttons.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        //2-3
        contentBox.add(Box.createHorizontalGlue());
        contentBox.add(box_of_variable);
        //contentBox.add(boxMemory);
        contentBox.add(boxResultM);
        contentBox.add(M);

        //
        contentBox.add(Variables);
        contentBox.add(resultButton);
        contentBox.add(boxbuttons);
        contentBox.add(boxResult);
        contentBox.add(Box.createVerticalGlue());

        getContentPane().add(contentBox, BorderLayout.CENTER);

    }
}
