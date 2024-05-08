import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Choice_GUI extends JFrame implements ActionListener{
    JLabel choiceLabel = new JLabel("What would you like to do today?");
    JRadioButton ch1, ch2, ch3, ch4;
    JButton nextButton = new JButton("Next");
    JFrame fr_ref;
    Choice_GUI(){
        fr_ref = this;
        setSize(350, 350);
        setTitle("Choose");

        ch1 = new JRadioButton("Password Generator", true);
        ch2 = new JRadioButton("Pasword Checker");
        ch3 = new JRadioButton("Info");
        ch4 = new JRadioButton("Quit");
        
        ButtonGroup choicegrp = new ButtonGroup();
        choicegrp.add(ch1);
        choicegrp.add(ch2);
        choicegrp.add(ch3);
        choicegrp.add(ch4);

        setLayout(new BorderLayout());
        add(choiceLabel, BorderLayout.NORTH);
        JPanel chpanel = new JPanel();
        chpanel.setLayout(new GridLayout(4, 1));
        chpanel.add(ch1);
        chpanel.add(ch2);
        chpanel.add(ch3);
        chpanel.add(ch4);
        chpanel.setVisible(true);
        add(chpanel, BorderLayout.CENTER);
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            if(ch1.isSelected()){
                generate_password();
            }
            else if(ch2.isSelected()){
                check_strength();
            }
            else if(ch3.isSelected()){
                info_display();
            }
            else if(ch4.isSelected()){
                dispose();
                System.exit(0);
            }
        }
    }
    private void check_strength() {
        fr_ref.setVisible(false);
        
        JFrame temp = new JFrame();
        temp.setLayout(new GridLayout(3,2, 10, 50));
        temp.setSize(350, 350);
        temp.setTitle("Password Strength");

        JLabel Pass_label = new JLabel("Enter your password: ");
        JPasswordField pass_field = new JPasswordField();
        pass_field.setEchoChar('*');
        JButton check = new JButton("Check");
        JLabel Strength = new JLabel();
        JButton back_Button = new JButton("Back");
        back_Button.addActionListener((ae) -> {
            temp.dispose();
            fr_ref.setVisible(true);
        });
        check.addActionListener((ae) ->{
            if(pass_field.getPassword().length == 0){
                Strength.setText("Enter Password First.");
            }
            else{
            String pass = new String(pass_field.getPassword());
            int strength_val = new Pass_Strength().PasswordStrength(pass);
            if (strength_val == 6) {
                Strength.setText( "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines");
            } else if (strength_val >= 4) {
                Strength.setText("This is a good password :) but you can still do better");;
            } else if (strength_val >= 3) {
                Strength.setText("This is a medium password :/ try making it better");;
            } else {
                Strength.setText("This is a weak password :( definitely find a new one");
            }
            }
        });

        temp.add(Pass_label);
        temp.add(pass_field);

        temp.add(check);
        temp.add(back_Button);

        temp.add(Strength);

        temp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        temp.setVisible(true);
    }
    public void info_display() {
        fr_ref.setVisible(false);
        
        JFrame temp = new JFrame();
        temp.setSize(350, 350);
        temp.setLayout(new BorderLayout());

        JTextArea msg = new JTextArea("-> Use a minimum password length of 8 or more characters if permitted."+
        "\n-> Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted."+
        "\n-> Generate passwords randomly where feasible."+
        "\n-> Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)."+
        "\n-> Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences, usernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates)."+
        "\n-> Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user."+
        "\n-> Do not use passwords which consist wholly of any simple combination of the aforementioned weak components.");
        msg.setLineWrap(true);
        msg.setMargin(new Insets(5, 3, 5, 3));
        temp.add(msg, BorderLayout.CENTER);
        msg.setEditable(false);
        
        JButton backButton = new JButton("Back");
        temp.add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener((ae) ->{
            temp.setVisible(false);
            fr_ref.setVisible(true);
        });
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        temp.setTitle("Info");
        temp.setVisible(true);
    }

    public void generate_password(){
        fr_ref.setVisible(false);

        JFrame temp = new JFrame();
        temp.setSize(350, 350);
        temp.setTitle("Password Generator");
        temp.setLayout(new BorderLayout());

        JLabel len = new JLabel("Length: ");
        JSpinner pass_len = new JSpinner();
        pass_len.setSize(20, HEIGHT);
        pass_len.setValue(0);

        JButton backButton = new JButton("Back");
        backButton.addActionListener((ae) -> {
            temp.setVisible(false);
            fr_ref.setVisible(true);
        });
        
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT, 35, 10));
        top.add(len);
        top.add(pass_len);
        top.add(backButton);

        setLayout(new BorderLayout());

        temp.add(top, BorderLayout.NORTH);

        JLabel chooseLabel = new JLabel("Choose: ");
        JRadioButton upper_ch = new JRadioButton("Uppercase Alphabets", true);
        JRadioButton lower_ch = new JRadioButton("Lowercase Alphabets");
        JRadioButton numb_ch = new JRadioButton("Numbers");
        JRadioButton symb_ch = new JRadioButton("Symbols");
        
        JPanel chpanel = new JPanel();
        chpanel.setLayout(new GridLayout(5, 1));
        chpanel.add(chooseLabel);
        chpanel.add(upper_ch);
        chpanel.add(lower_ch);
        chpanel.add(numb_ch);
        chpanel.add(symb_ch);
        chpanel.setVisible(true);
        temp.add(chpanel, BorderLayout.CENTER);

        JPanel statJPanel = new JPanel();
        statJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        
        JTextField pass_disp = new JTextField();
        pass_disp.setForeground(Color.black);
        pass_disp.setEditable(false);
        pass_disp.setPreferredSize(new Dimension(100, 25));
        statJPanel.add(pass_disp);

        JButton copyButton = new JButton("C");
        copyButton.setPreferredSize(new Dimension(25, 25));
        copyButton.addActionListener((ae) ->{
            StringSelection stringSelection = new StringSelection(pass_disp.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        });
        statJPanel.add(copyButton);

        JButton genButton = new JButton("Generate");
        genButton.addActionListener((ae)->{
            Password pass = new Password(upper_ch.isSelected(), lower_ch.isSelected(), numb_ch.isSelected(), symb_ch.isSelected());
            pass_disp.setText(pass.create((Integer)(pass_len.getValue())));
        });
        statJPanel.add(genButton);

        temp.add(statJPanel, BorderLayout.SOUTH);
        temp.setVisible(true);
    }
}
