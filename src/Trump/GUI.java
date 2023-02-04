package Trump;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.BorderFactory;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class GUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private SimpleDateFormat timeFormat;
    private String time;
    GUI(){
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        time = timeFormat.format(java.util.Calendar.getInstance().getTime());
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("pls don't click");
        button.addActionListener(this);
        label = new JLabel(time);
        //BORDER
        //set size
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,20,20));
        //set something–?
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        //FRAME
        //add border to frame
        frame.add(panel, BorderLayout.CENTER);
        //set frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test");
        frame.setLayout(new FlowLayout());
        frame.setBounds(10,10,800,600);
        //frame.setSize(300,300);
        frame.setResizable(true);
        //frame.pack();
        frame.setVisible(true);

        //REFRESH
        refresh();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void refresh(){
        while (true)
        {
            time = timeFormat.format(java.util.Calendar.getInstance().getTime());
            label.setText(time);
            try {
                Thread.sleep(1000/20);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] arg){
        new GUI();
    }
}