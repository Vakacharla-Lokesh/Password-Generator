import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Welcome_GUI extends JFrame implements ActionListener{
    Image img;
    JButton nextButton = new JButton("Next");
    JLabel WelcomeLabel = new JLabel("\tWelcome to Password Generator!");
    Welcome_GUI() throws IOException{
        setTitle("Welcome");
        setLayout(new BorderLayout());
        setSize(350, 350);

        Image myPicture = ImageIO.read(new File("icon_3.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(picLabel, BorderLayout.CENTER);
        picLabel.setPreferredSize(new Dimension(WIDTH, 200));
        WelcomeLabel.setPreferredSize(new Dimension(WIDTH, 20));
        panel.add(WelcomeLabel, BorderLayout.SOUTH);
        // add(picLabel);
        // WelcomeLabel.setPreferredSize(new Dimension(WIDTH, 20));
        // add(WelcomeLabel);
        add(panel);
        nextButton.addActionListener(this);
        nextButton.setPreferredSize(new Dimension(WIDTH, 20));
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