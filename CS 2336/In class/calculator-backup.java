//Alex Lundin
//07-06-2017
//Lecture Template

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//actionlistner is abstact - cant be initialized

public class calculator extends JFrame implements ActionListener{
	
      private JPanel panel1, panel2, panel3;
      private JLabel num1Label, num2Label, resultLabel;
      private JButton addButton;
      private JTextField num1Field, num2Field, resultField;
      
      // calculator class
   	public calculator() {
      
      
         panel1 = new JPanel();
         resultLabel = new JLabel ("");
         resultField = new JTextField(10);
         resultField.setEditable(false);
         panel1.add(resultLabel);
         panel1.add(resultField);
         add(panel1, BorderLayout.NORTH);


       
         
         


         

   	} 
      

     public void actionPerformed  (ActionEvent e){
         int num1 = 0 , num2 = 0, sum = 0;
         if (e.getSource() == addButton){
            if (!num1Field.getText().isEmpty()&& !num2Field.getText().isEmpty()){
            // TODO: validate digits vs characters
            // mask so it only accepts numbers, not characters
            num1 = Integer.parseInt(num1Field.getText());
            num2 = Integer.parseInt(num2Field.getText());
            sum = num1 + num2;
            resultField.setText(sum + "");
            }
            }
            else
               resultField.setText("Enter input to be added!!!");
            }
       
   public void holder (){
   
         panel4.add(num1Label);
         panel4.add(num1Field);
         panel4.add(num2Label);
         panel4.add(num2Field);
         
         add(panel4, BorderLayout.NORTH);         
         
         panel5 = new JPanel();
         addButton = new JButton("Add");
         panel5.add(addButton);
         
         add(panel5, BorderLayout.CENTER);             
         
         
         panel6 = new JPanel();
         resultLabel = new JLabel ("Result: ");
         resultField = new JTextField(10);
         resultField.setEditable(false);
         panel6.add(resultLabel);
         panel6.add(resultField);
         add(panel6, BorderLayout.SOUTH);
         addButton.addActionListener(this); //only works with an arguement that implements actionlistener interface   
   
   }

   
}


