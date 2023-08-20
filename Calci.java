package com.calculator;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
public class Calci implements ActionListener
{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,equButton,delButton,clrButton;
	JPanel panel;
	
	Font myfont = new Font("Arial",Font.BOLD,35);
	double num1=0;
	double num2=0;
	double result=0;
	char operator;
	
	
	Calci()
	{
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		//frame.setBackground(Color.black);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myfont);
		textfield.setEditable(false);
		textfield.getBorder();
		textfield.setBackground(Color.white);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
	    clrButton = new JButton("clear");
		divButton = new JButton("/");
		delButton = new JButton("delete");
		equButton = new JButton("=");
		decButton = new JButton(".");
		
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = clrButton;
		functionButtons[5] = delButton;
		functionButtons[6] = equButton;
		functionButtons[7] = decButton;
		
		for(int i =0;i<8;i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myfont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++)
		{
			numberButtons[i]= new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myfont);
			numberButtons[i].setFocusable(false);
		}
		delButton.setBounds(50,430,145,50);
		clrButton.setBounds(205,430,145,50);
		
		panel= new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.WHITE);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);

		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(clrButton);
		frame.add(delButton);
		frame.add(textfield);
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args)
	{
		Calci calc = new Calci();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
       		for(int i = 0; i<10;i++)
       		{
       			if(e.getSource()==numberButtons[i])
       			{
       				textfield.setText(textfield.getText().concat(String.valueOf(i)));
       			}
       		}
       		if(e.getSource()==decButton)
   			{
   				textfield.setText(textfield.getText().concat("."));
   			}
       		if(e.getSource()==addButton) 	
   			{
   				num1=Double.parseDouble(textfield.getText());
   				operator = '+';
   				textfield.setText("");
            }
       		if(e.getSource()==subButton) 	
   			{
   				num1=Double.parseDouble(textfield.getText());
   				operator = '-';
   				textfield.setText("");
            }
       		if(e.getSource()==mulButton) 	
   			{
   				num1=Double.parseDouble(textfield.getText());
   				operator = '*';
   				textfield.setText("");
            }
       		if(e.getSource()==divButton) 	
   			{
   				num1=Double.parseDouble(textfield.getText());
   				operator = '/';
   				textfield.setText("");
            }
       		if(e.getSource()==equButton) 	
   			{
   				num2=Double.parseDouble(textfield.getText());
   				switch(operator)
   				{
   				case'+':
   					result=num1+num2;
   					break;
   				case'-':
   					result=num1-num2;
   					break;
   				case'*':
   					result=num1*num2;
   					break;
   				case'/':
   					result=num1/num2;
   					break;
   				 }
   				textfield.setText(String.valueOf(result));
   				num1=result;
            }
       		if(e.getSource()==clrButton) 	
   			{
   				textfield.setText("");
            }
       		if(e.getSource()==delButton) 	
   			{
       			String string =textfield.getText();
       			textfield.setText("");
       			for(int i =0;i<string.length()-1;i++)
       			{
       				textfield.setText(textfield.getText()+string.charAt(i));
       			}
            }
}
}