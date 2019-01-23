import javax.swing.*;
import java.awt.*;

public class TicGUI {
    public JFrame mainFrame;//定义一个JFrame窗口
    public JPanel jPanel;//定义一个JPanel布局
    public JButton button[][] = new JButton[3][3];//定义九个按钮

    /*用九个button代替了九宫格，每个button初始text设置为空*/

    public TicGUI() {//重载无参构造方法
        mainFrame = new JFrame("Tic-Tac-Toe");//将图形界面的标题设置为Tic-Tac-Toe
        jPanel = new JPanel(new GridLayout(3, 3));//将按钮设置为3行3列，GridLayout-网格布局，主要用于类似于计算器的布局方式
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                button[i][j] = new JButton();//新建按钮
                button[i][j].setText(" ");//按钮的text设置为空
                jPanel.add(button[i][j]);
            }
        mainFrame.add(jPanel);//JPanel布局布局放入JFrame窗口
       /* mainFrame.setSize(500, 500);//将JFrame窗口大小设置为500*500
        mainFrame.setLocation(300, 200);//设置JFrame窗口默认位置*/
       //上面两行内容可以用下面的setBounds方法替换
        mainFrame.setBounds(300,200,500,500);
        mainFrame.setVisible(true);//显示JFrame窗口
    }
}
