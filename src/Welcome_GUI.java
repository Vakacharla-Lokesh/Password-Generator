import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;

public class Welcome_GUI extends JFrame implements ActionListener{
    Image img;
    JButton nextButton = new JButton("Next");
    JLabel WelcomeLabel = new JLabel("\tWelcome to Password Generator!");
    Welcome_GUI(){
        setTitle("Welcome");
        setLayout(new BorderLayout());
        setSize(350, 350);
        add(WelcomeLabel, BorderLayout.CENTER);
        nextButton.addActionListener(this);
        nextButton.setSize(40, 25);
        add(nextButton, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Insets getInsets(){
        return new Insets(10, 20, 10, 20);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            setVisible(false);
            new Choice_GUI();
            dispose();
        }
    }
    
}