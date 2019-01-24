

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacToe extends TicGUI {

    private String whoseTurn = "小平";                        //小平先开始，开始时将第一个按钮的text设置为"小平"

    /*为每个button设置了点击事件*/

    public void beginGame() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                button[i][j].addActionListener(new ActionListener() {//用addActionListener方法为每个按钮设置监听
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        //将按钮的text设置为当前角色
                        ((JButton) arg0.getSource()).setText(whoseTurn);
                        //调用isWin方法进行判断
                        if (isWin(whoseTurn)) {
                            // 有人连成一条线时候提示XX赢了，同时游戏结束
                            JOptionPane.showMessageDialog(null, whoseTurn + " 赢了!", "游戏提示", JOptionPane.PLAIN_MESSAGE);
                            //showMessageDialog 弹出对话框，这个有参构造方法第一个参数是弹出位置，设置为null为显示在屏幕中间，
                            //第二个参数是对话框要显示的内容
                            //第三个参数是对话框标题
                            //第四个参数为对话框类型，分别有下面几种类型：
                            //JOptionPane.WARNING_MESSAGE 警告提示框
                            //JOptionPane.ERROR_MESSAGE 错误提示框
                            //JOptionPane.PLAIN_MESSAGE 基本对话框
                            //JOptionPane.YES_NO_OPTION 选择对话框
                            //获取输入信息对话框JOptionPane.showInputDialog(null,"请输入：\n","title",JOptionPane.PLAIN_MESSAGE);
                            //下拉列表式对话框，等于是对话框的嵌套JOptionPane.showInputDialog(null,"请选择你的身份:\n", "身份", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), obj2, "足球");
                            mainFrame.setVisible(false);//点击对话框的确定按钮后关闭JFrame窗口
                        } else if (isFull()) {//调用isFull方法
                            // 如果窗格全部满了且没人连成一条线，提示游戏结束
                            JOptionPane.showMessageDialog(null, "游戏结束!", "游戏提示", JOptionPane.PLAIN_MESSAGE);
                            mainFrame.setVisible(false);
                        } else {//没人连成一条线将新按钮的文本设置为
                            whoseTurn = (whoseTurn.equals("小平")) ? "小红" : "小平";
                        }

                    }

                });
            }
    }

    /*判断是否九个格子已经满了*/
    public boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (button[i][j].getText().equals(" "))
                    isFull = false;
            }
        return isFull;
    }

    /*游戏判断输赢*/
    public boolean isWin(String s) {
        boolean result = false;//定义一个布尔类型用来返回输赢，初始是没有人赢的，所以先赋值为FALSE
        for (int i = 0; i < 3; i++) {
            //判断某一列是否连成一条线，同一列有三种可能，所以要循环三次判断
            if ((button[i][0].getText().equals(s))
                    && (button[i][1].getText().equals(s))
                    && (button[i][2].getText().equals(s)))
                result = true;
        }

        for (int j = 0; j < 3; j++) {
            //判断某一行是否连成一条线，同一行有三种可能，所以要循环三次判断
            if ((button[0][j].getText().equals(s))
                    && (button[1][j].getText().equals(s))
                    && (button[2][j].getText().equals(s)))
                result = true;
        }

        //判断主对角线是否连成一条线，只有一种可能，不需要循环
        if ((button[0][0].getText().equals(s))
                && (button[1][1].getText().equals(s))
                && (button[2][2].getText().equals(s)))
            result = true;

        //判断负对角线是否连成一条线，也是只有一种可能，不需要循环
        if ((button[0][2].getText().equals(s))
                && (button[1][1].getText().equals(s))
                && (button[2][0].getText().equals(s)))
            result = true;

        return result;//返回result的值
    }
}