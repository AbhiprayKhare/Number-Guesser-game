package number_guess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class boss {
	static int c=5;
	static int x=(int)(Math.random()*10);
	
    public static void main(String args[]) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 500);
        window.setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon(boss.class.getResource("/resources/background1.png"));
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(scaledImg);
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(null); // Set layout to null for absolute positioning
        window.setContentPane(background);

        String s = "Guess a number dear";
        JLabel l1 = new JLabel("<html><b>" + s + "</b></html>", SwingConstants.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 22));
        l1.setForeground(Color.green);
        l1.setBounds(150, 50, 300, 30); // Set position and size of the label
        background.add(l1);

        // Add a text field
        JTextField text = new JTextField(10);
        text.setBounds(200, 100, 200, 30); // Set position and size of the text field
        background.add(text);
        
        int x=(int) (Math.random()*10);
        System.out.println(x);
        JLabel l2 = new JLabel();
        l2.setFont(new Font("Arial", Font.BOLD, 22));
        l2.setForeground(Color.red);
        l2.setBounds(150, 150, 300, 30);
        background.add(l2);
        
        JLabel l3 = new JLabel();
        l3.setFont(new Font("Arial", Font.BOLD, 22));
        l3.setForeground(Color.BLACK);
        l3.setBounds(150, 200, 300, 30);
        background.add(l3);
        
        
        text.addActionListener(new ActionListener() {
		
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				String u=text.getText();
				int us;
				try
				{
					us=Integer.parseInt(u);
				}
				catch(NumberFormatException z)
				{
					l2.setText("Enter Integer number only");
					return;
				}
				if(us==x)
				{
					l2.setText("Congratulations you won");
					text.setEditable(false);
				}
				else
				{
					c--;
					if(c==0)
					{
						l2.setText("You lost damnn");
						l3.setText("Correct answer was: "+x);
						text.setEditable(false);
					}
					else
					{
						if(c<x)
						{
							l2.setText("Number is greater");
							l3.setText("Chances left : "+c);
						}
						else 
						{
							l2.setText("Number is lesser");
							l3.setText("Chances left: "+c);
						}
					}
				}
			}
		});
        
        window.setVisible(true);
    }
}
