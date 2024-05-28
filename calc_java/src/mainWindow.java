import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

public class MainWindow {
    //Обьявляем константы
    final int FONT_SIZE = 40;
    final String FONT_NAME = "Arial";
    final int ACTION_FONT_SIZE = 20;
    //обьявление переменной главного окна
    private JFrame wndMain;
    //обьявление массива JButton для кнопок
    ArrayList<JButton> buttons = new ArrayList<>();
    
    public MainWindow() {
        wndMainInit();
        buttonsNumbersInit();
    }

     private void wndMainInit() {
        wndMain = new JFrame("Calc");
        //создаем главное окно и настраиваем
        wndMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //говорим форме какой будет менеджер расположения виджетов
        wndMain.setLayout(new GridBagLayout());
    }

    private void buttonsNumbersInit() {
        //создаем массив JButtons

    }

    public static void main (String[] args){


        //класс с помощью которого настривается расположение ячеек виджетов
        GridBagConstraints gbcOption = new GridBagConstraints();

        //панель для виджетов, сюда все добавляется потом уже на форму
        JPanel panelMain = new JPanel();
        //устанавливаем менеджер расположения
        panelMain.setLayout(new GridBagLayout());
        //предпочтительные размеры панели
        panelMain.setPreferredSize(new Dimension(500,600));
        //цвет фона панели
        panelMain.setBackground(Color.GRAY);

        //виджет лейбл для отображения проводимой операции создание и настройка
        JLabel lblAction = new JLabel("Action");
        //выровнять текст по правому краю
        lblAction.setHorizontalAlignment(JLabel.RIGHT);
        //выбор имени шрифта и его размера
        lblAction.setFont(new Font(FONT_NAME, Font.PLAIN, ACTION_FONT_SIZE));
        //настройка расположения виджета
        //какая строка
        gbcOption.gridx = 0;
        //какой столбец
        gbcOption.gridy = 0;
        //сколько ячеек столбцов обьеденить для этого компонента
        gbcOption.gridwidth = 4;
        //указываем чтоб компонент был растянут по всему пространству ячейки
        gbcOption.fill=GridBagConstraints.HORIZONTAL;
        //какую часть родителя(ячейки) займет виджет
        gbcOption.weightx=0;
        gbcOption.weighty=0;
        //настройка отступов для лейблов
        gbcOption.insets = new Insets(0,20,0,20);
        //добавляем на форму
        panelMain.add(lblAction, gbcOption);
        gbcOption.weightx=1;
        gbcOption.weighty=1;

        //виджет лейбл для отображения результата вычислений
        JLabel lblResult = new JLabel("Result");
        lblResult.setBackground(Color.gray);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        lblResult.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridwidth = 4;
        gbcOption.gridx = 0;
        gbcOption.gridy = 1;
        gbcOption.fill = GridBagConstraints.BOTH;
        panelMain.add(lblResult, gbcOption);
        //возвращаем обьединение ячеек на место
        gbcOption.gridwidth = 1;
        //возвращаем отступы ячеек на место
        gbcOption.insets = new Insets(0, 0, 0, 0);

        //кнопка очистки результата и действий
        JButton btnClean = new JButton("C");
        btnClean.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 0;
        gbcOption.gridy = 2;
        panelMain.add(btnClean, gbcOption);

        //кнопка деления по модулю
        JButton btnPercent = new JButton("%");
        btnPercent.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 1;
        gbcOption.gridy = 2;
        panelMain.add(btnPercent, gbcOption);

        JButton btnDelete = new JButton("<-");
        btnDelete.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 2;
        gbcOption.gridy = 2;
        panelMain.add(btnDelete, gbcOption);

        JButton btnDivision = new JButton("/");
        btnDivision.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 3;
        gbcOption.gridy = 2;
        panelMain.add(btnDivision, gbcOption);

        JButton btn1 = new JButton("1");
        btn1.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 0;
        gbcOption.gridy = 3;
        panelMain.add (btn1, gbcOption);

        JButton btn2 = new JButton("2");
        btn2.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 1;
        gbcOption.gridy = 3;
        panelMain.add (btn2, gbcOption);

        JButton btn3 = new JButton("3");
        btn3.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 2;
        gbcOption.gridy = 3;
        panelMain.add (btn3, gbcOption);

        JButton btnPlus = new JButton("+");
        btnPlus.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 3;
        gbcOption.gridy = 3;
        panelMain.add (btnPlus, gbcOption);

        JButton btn4 = new JButton("4");
        btn4.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 0;
        gbcOption.gridy = 4;
        panelMain.add (btn4, gbcOption);


        JButton btn5 = new JButton("5");
        btn5.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 1;
        gbcOption.gridy = 4;
        panelMain.add (btn5, gbcOption);

        JButton btn6 = new JButton("6");
        btn6.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 2;
        gbcOption.gridy = 4;
        panelMain.add (btn6, gbcOption);

        JButton btnMinus = new JButton("-");
        btnMinus.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 3;
        gbcOption.gridy = 4;
        panelMain.add (btnMinus, gbcOption);

        JButton btn7 = new JButton("7");
        btn7.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 0;
        gbcOption.gridy = 5;
        panelMain.add (btn7, gbcOption);

        JButton btn8 = new JButton("8");
        btn8.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 1;
        gbcOption.gridy = 5;
        panelMain.add (btn8, gbcOption);

        JButton btn9 = new JButton("9");
        btn9.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 2;
        gbcOption.gridy = 5;
        panelMain.add (btn9, gbcOption);

        JButton btnMultiplication = new JButton("*");
        btnMultiplication.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 3;
        gbcOption.gridy = 5;
        panelMain.add (btnMultiplication, gbcOption);

        JButton btnPM = new JButton("+/-");
        btnPM.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 0;
        gbcOption.gridy = 6;
        panelMain.add (btnPM, gbcOption);

        JButton btnZero = new JButton("0");
        btnZero.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 1;
        gbcOption.gridy = 6;
        panelMain.add (btnZero, gbcOption);

        JButton btnPoint = new JButton(".");
        btnPoint.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 2;
        gbcOption.gridy = 6;
        panelMain.add (btnPoint, gbcOption);

        JButton btnEqually = new JButton("=");
        btnEqually.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        gbcOption.gridx = 3;
        gbcOption.gridy = 6;
        panelMain.add (btnEqually, gbcOption);

        wndMain.getContentPane().add(panelMain, gbcOption);
        wndMain.pack();
        wndMain.setVisible(true);
    }

    public void Clean (){

    }

}
