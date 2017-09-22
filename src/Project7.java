import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Project7 extends JFrame {
	private JButton[] buttons = new JButton[10];
	private JButton buttonDot = new JButton(".");
	private JButton clear = new JButton("clear");

	private JLabel label1 = new JLabel("0.0");
	private JPanel innerPanel = new JPanel(new GridLayout(4, 3));

	private JPanel outerPanel = new JPanel();
	private boolean decimal = false;



	public Project7() { 
		
		this.setLayout(null);
		this.setSize(600,700);
		this.setLocation(100,40);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("This is my Numeric Pad");

		Font font = new Font("Arial", Font.BOLD, 30);

		ButtonListener ears = new ButtonListener();

		for(int i=1; i<10; i++){
			buttons[i] = new JButton(""+i);
			innerPanel.add(buttons[i]);
			buttons[i].setFont(font);
		}
		Font font2 = new Font("Arial", Font.BOLD, 20);
		buttons[0] = new JButton("0");
		buttons[0].setFont(font);
		buttonDot.setFont(font);
		clear.setFont(font2);
		innerPanel.add(buttons[0]);
		innerPanel.add(buttonDot);
		innerPanel.add(clear);
		label1.setSize(300, 25);
		label1.setLocation(0, 0);
		label1.setVisible(true);
		outerPanel.add(label1);
		outerPanel.setSize(300, 500);
		outerPanel.setBackground(Color.gray);
		outerPanel.setLocation(0, 40);
		outerPanel.setVisible(true);
		innerPanel.setSize(300, 500);
		innerPanel.setBackground(Color.gray);
		innerPanel.setLocation(0, 40);
		innerPanel.setVisible(true);
		this.add(outerPanel, BorderLayout.NORTH);
		this.add(label1, BorderLayout.NORTH);
		this.add(innerPanel, BorderLayout.CENTER);

		for (int i = 0 ; i < buttons.length; i++){
			buttons[i].addActionListener(ears);
		}

		buttonDot.addActionListener(ears);
		clear.addActionListener(ears);
	}

	public class ButtonListener implements ActionListener {   	
		public void actionPerformed(ActionEvent arg0) {
			JButton clickedOn = (JButton)arg0.getSource();
			String a, b, c, d;
			if(clickedOn.equals(clear)){
				decimal = false;
				label1.setText("0.0");
			}
			if(!clickedOn.equals(clear)){
			if(decimal == false && clickedOn.getText().equals(".")){
				decimal = true;
				label1.setText(label1.getText().substring(0, label1.getText().length()-1));
			}
			if(decimal == false && !clickedOn.getText().equals(".")){
				a = clickedOn.getText();

				b = label1.getText();
				b.substring(0, b.length()-2);
				if(b.substring(0, 1).equals("0")){
					label1.setText(b.substring(1, b.length()-2)+a+".0");
				}else
					label1.setText(b.substring(0, b.length()-2)+a+".0");
			}
			if(decimal == false && !clickedOn.getText().equals(".")){
				
			}
		
			if(decimal == true && !clickedOn.getText().equals(".")){
				c = label1.getText();
				d = clickedOn.getText();
				
				label1.setText(c+d);

				
			}

			}

		}
	}




}
