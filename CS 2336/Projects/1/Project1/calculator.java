//Alex Lundin
//07-06-2017
//Lecture Template
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Component;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.*;
//actionlistner is abstact - cant be initialized

public class calculator extends JFrame implements ActionListener{

   //Variables
   final int MAX_INPUT_LENGTH = 20;
   final int INPUT_MODE = 0;
   final int RESULT_MODE = 1;
   final int ERROR_MODE = 2;
   int displayMode;
   boolean clearOnNextDigit, percent;
   
   double lastNumber;
   String lastOperator;
 	   
	private JPanel mainFrame, subFrame1, viewPanel, viewButtonPane, subFrame2, resultPanel, resultFieldPanel, resultBitsPanel, buttonPanel, buttonPanelEast, buttonPanelWest, mainButtonPane, radioButtonNorth, radioButtonSouth;
	private JLabel num1Label, num2Label, viewLabel, resultLabel, eastLabel, westLabel;
	private JButton viewButton, editButton, helpButton, mainButtons[];
	private JTextField num1Field, num2Field, resultField, binaryField1;
   private JRadioButton hexRadio, decRadio, octRadio, binRadio, qWordRadio, dWordRadio, wordRadio, byteRadio;
   
   static String hexString = "Hex";
   static String decString = "Dec";
   static String octString = "Oct";
   static String binString = "Binary";
   
   
   static String qWordString = "Qword";
   static String dWordString = "Dword";
   static String wordString = "Word";
   static String byteString = "Byte";
   
	// calculator class
	public calculator() {

// 		this.setSize(420,355);
// 		this.setVisible(true);
// 		this.setTitle("My First Calculator");
// 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		this.setResizable(false);
		   
		Border raisedBorder = BorderFactory.createRaisedBevelBorder();
		subFrame1 = new JPanel();
		subFrame1.setPreferredSize(new Dimension(390, 325));
		//subFrame1.setLayout (new BorderLayout(390, 325));
      subFrame1.setLayout (new BorderLayout());

      
		//https://stackoverflow.com/questions/5808195/removing-the-three-dots-from-a-jbutton
      
		viewButton = new JButton ("View");
      editButton = new JButton ("Edit");
      helpButton = new JButton ("Help");
      
      viewButton.setPreferredSize(new Dimension(55, 10));
      viewButton.setFont(new Font("Arial", Font.BOLD, 10));
      viewButton.setMargin(new Insets(0, 0, 0, 0)); 
      viewButton.setBorder(null); 
      editButton.setPreferredSize(new Dimension(55, 10));
      editButton.setFont(new Font("Arial", Font.BOLD, 10));
      editButton.setMargin(new Insets(0, 0, 0, 0));
      editButton.setBorder(null);
      helpButton.setPreferredSize(new Dimension(55, 10));
      helpButton.setFont(new Font("Arial", Font.BOLD, 10));
      helpButton.setMargin(new Insets(0, 0, 0, 0));
      helpButton.setBorder(null);
      
      viewLabel = new JLabel ("ViewPanel");
		viewPanel = new JPanel();
		//viewPanel.setPreferredSize(new Dimension(385, 25));
		viewPanel.setBorder(raisedBorder);


		GroupLayout layout = new GroupLayout(viewPanel);
		//layout.setAutoCreateGaps(true);
		//layout.setAutoCreateContainerGaps(true);

		viewPanel.setLayout(layout);
      
		layout.setHorizontalGroup(layout.createSequentialGroup()
		.addComponent(viewButton)//, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(editButton)//, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(helpButton)//, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		layout.linkSize(SwingConstants.HORIZONTAL, viewButton, editButton,helpButton );

		layout.setVerticalGroup(layout.createSequentialGroup()
		.addGroup(layout.createParallelGroup(CENTER)
			.addComponent(viewButton)//, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(editButton)//, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(helpButton)//, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         )
		);

		subFrame1.add(viewPanel, BorderLayout.NORTH);

		resultPanel = new JPanel();
      resultPanel.setPreferredSize(new Dimension(385,60));
      resultPanel.setLayout (new BorderLayout());
      
		resultFieldPanel = new JPanel(new BorderLayout());
      resultFieldPanel.setPreferredSize(new Dimension(385,30));      
		resultField = new JTextField(5);
		resultField.setEditable(true);
      resultFieldPanel.add(resultField, BorderLayout.CENTER);
      resultField.addActionListener(this); 
      
      resultBitsPanel = new JPanel();
      resultBitsPanel.setPreferredSize(new Dimension(385,30));
      
      binaryField1 = new JTextField(15);
      binaryField1.setEditable(false);
      resultBitsPanel.add(binaryField1);
      
		resultPanel.setBorder(raisedBorder);
      resultPanel.add(resultFieldPanel, BorderLayout.NORTH);
      resultPanel.add(resultBitsPanel, BorderLayout.SOUTH);
   
		subFrame1.add(resultPanel, BorderLayout.CENTER);

		buttonPanel = new JPanel();
	   buttonPanel.setLayout (new BorderLayout());
      buttonPanel.setBorder(raisedBorder);
      
      
      
      
      
      buttonPanelWest = new JPanel();
      buttonPanelWest.setLayout (new BorderLayout());
      buttonPanelWest.setPreferredSize(new Dimension(60,225));
      
      radioButtonNorth = new JPanel(new GridLayout(0, 1));
      
      
      hexRadio = new JRadioButton(hexString);
      hexRadio.setMnemonic(KeyEvent.VK_H);
      hexRadio.setActionCommand(hexString);
      hexRadio.addActionListener(this);  
          
      decRadio = new JRadioButton(decString);
      decRadio.setMnemonic(KeyEvent.VK_D);
      decRadio.setActionCommand(decString); 
      decRadio.addActionListener(this); 
            
      octRadio = new JRadioButton(octString);
      octRadio.setMnemonic(KeyEvent.VK_O);
      octRadio.setActionCommand(octString);
      octRadio.addActionListener(this);        
      
      binRadio = new JRadioButton(binString);
      binRadio.setMnemonic(KeyEvent.VK_B);
      binRadio.setActionCommand(binString);
      binRadio.addActionListener(this); 
        
      radioButtonNorth.add(hexRadio);
      radioButtonNorth.add(decRadio);
      radioButtonNorth.add(octRadio);
      radioButtonNorth.add(binRadio);
           
      
      radioButtonSouth = new JPanel(new GridLayout(0, 1));
      
      qWordRadio  = new JRadioButton(qWordString);
      qWordRadio.setMnemonic(KeyEvent.VK_Q);
      qWordRadio.setActionCommand(qWordString);
      qWordRadio.addActionListener(this); 
            
      dWordRadio  = new JRadioButton(dWordString);
      dWordRadio.setMnemonic(KeyEvent.VK_Z);
      dWordRadio.setActionCommand(dWordString);
      dWordRadio.addActionListener(this); 
            
      wordRadio  = new JRadioButton(wordString);
      wordRadio.setMnemonic(KeyEvent.VK_W);
      wordRadio.setActionCommand(wordString); 
      wordRadio.addActionListener(this);
            
      byteRadio = new JRadioButton(byteString);
      byteRadio.setMnemonic(KeyEvent.VK_Y);
      byteRadio.setActionCommand(byteString); 
      byteRadio.addActionListener(this);      
      
      radioButtonSouth.add(qWordRadio);
      radioButtonSouth.add(dWordRadio);
      radioButtonSouth.add(wordRadio);
      radioButtonSouth.add(byteRadio);
      
      
      
      buttonPanelWest.add(radioButtonNorth,BorderLayout.NORTH);
      buttonPanelWest.add(radioButtonSouth,BorderLayout.SOUTH);
      
      
      
      buttonPanel.add(buttonPanelWest,BorderLayout.WEST);
      
      
      
      
      
      
      
      
      
      buttonPanelEast = new JPanel();
      eastLabel = new JLabel ("E");
      buttonPanelEast.add(eastLabel);
      buttonPanelEast.setLayout (new BorderLayout());
      
      mainButtonPane = new JPanel();
      mainButtonPane.setPreferredSize(new Dimension(325,225));
      mainButtons = new JButton[46];
      
      mainButtons[0] = new JButton ("Quot");
      mainButtons[1] = new JButton ("Mod");  
      mainButtons[2] = new JButton ("A");
      mainButtons[3] = new JButton ("*");
      mainButtons[4] = new JButton ("*");
      mainButtons[5] = new JButton ("*");
      mainButtons[6] = new JButton ("*");
      mainButtons[7] = new JButton ("*");
      mainButtons[8] = new JButton ("9");
      mainButtons[9] = new JButton ("*");
      mainButtons[10] = new JButton ("B");
      mainButtons[11] = new JButton ("<");
      mainButtons[12] = new JButton ("CE");
      mainButtons[13] = new JButton ("C");
      mainButtons[14] = new JButton ("-+");
      mainButtons[15] = new JButton ("~");
      mainButtons[16] = new JButton ("17");
      mainButtons[17] = new JButton ("*");
      mainButtons[18] = new JButton ("C");
      mainButtons[19] = new JButton ("7");
      mainButtons[20] = new JButton ("8");
      mainButtons[21] = new JButton ("9");
      mainButtons[22] = new JButton ("/");
      mainButtons[23] = new JButton ("%");
      mainButtons[24] = new JButton ("25");
      mainButtons[25] = new JButton ("*");
      mainButtons[26] = new JButton ("D");
      mainButtons[27] = new JButton ("4");
      mainButtons[28] = new JButton ("5");
      mainButtons[29] = new JButton ("6");
      mainButtons[30] = new JButton ("*");
      mainButtons[31] = new JButton ("1/X");
      mainButtons[32] = new JButton ("33");
      mainButtons[33] = new JButton ("*");
      mainButtons[34] = new JButton ("E");
      mainButtons[35] = new JButton ("1");
      mainButtons[36] = new JButton ("2");
      mainButtons[37] = new JButton ("3");
      mainButtons[38] = new JButton ("-");
	  // tall equals button
      mainButtons[39] = new JButton ("=");
      mainButtons[39].setPreferredSize(new Dimension(30,65));      
      
      mainButtons[40] = new JButton ("41");
      mainButtons[41] = new JButton ("*");
      mainButtons[42] = new JButton ("F");
	  // long 0 button
      mainButtons[43] = new JButton ("0");
      mainButtons[43].setPreferredSize(new Dimension(65,30)); 
      mainButtons[44] = new JButton (".");
      mainButtons[45] = new JButton ("+");

      
      //set button dimensions, font and margin
      
      for (int i = 0; i < mainButtons.length; i++){
      
         // don't set dimensions of equals and 0 button, they are custom
         if ((i != 39)&&(i != 43)){
         mainButtons[i].setPreferredSize(new Dimension(30,30));
         }
      
         mainButtons[i].setFont(new Font("Arial", Font.PLAIN, 10));
         mainButtons[i].setMargin(new Insets(0, 0, 0, 0));
         mainButtons[i].addActionListener(this);
      }      


		GroupLayout layout2 = new GroupLayout(mainButtonPane);
		layout2.setAutoCreateGaps(true);
		layout2.setAutoCreateContainerGaps(true);

		mainButtonPane.setLayout(layout2);
		layout2.setHorizontalGroup(layout2.createSequentialGroup()
		.addGroup(layout2.createParallelGroup(LEADING)
			.addComponent(mainButtons[0])
         .addComponent(mainButtons[8])
         .addComponent(mainButtons[16])
         .addComponent(mainButtons[24])
         .addComponent(mainButtons[32])
         .addComponent(mainButtons[40])
         )
		.addGroup(layout2.createParallelGroup(LEADING)
         .addComponent(mainButtons[1])
			.addComponent(mainButtons[9])
         .addComponent(mainButtons[17])
         .addComponent(mainButtons[25])
         .addComponent(mainButtons[33])
         .addComponent(mainButtons[41])
         )
		.addGroup(layout2.createParallelGroup(LEADING)
         .addComponent(mainButtons[2])
			.addComponent(mainButtons[10])
         .addComponent(mainButtons[18])
         .addComponent(mainButtons[26])
         .addComponent(mainButtons[34])
         .addComponent(mainButtons[42])
         )
         
         
		.addGroup(layout2.createParallelGroup(LEADING)
               .addGroup(layout2.createSequentialGroup()
               .addComponent(mainButtons[3])
               .addComponent(mainButtons[4])         
               )
               .addGroup(layout2.createSequentialGroup()
               .addComponent(mainButtons[11])
               .addComponent(mainButtons[12])
                )
               .addGroup(layout2.createSequentialGroup()
               .addComponent(mainButtons[19])
               .addComponent(mainButtons[20])
               )
               .addGroup(layout2.createSequentialGroup()
               .addComponent(mainButtons[27])
               .addComponent(mainButtons[28])
               )
               .addGroup(layout2.createSequentialGroup()
               .addComponent(mainButtons[35])
               .addComponent(mainButtons[36])
                )               
            	.addGroup(layout2.createSequentialGroup()
               .addComponent(mainButtons[43], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
               ) 
            )
 
         
         
		.addGroup(layout2.createParallelGroup(LEADING)
         .addComponent(mainButtons[5])
			.addComponent(mainButtons[13])
         .addComponent(mainButtons[21])
         .addComponent(mainButtons[29])
         .addComponent(mainButtons[37])
         .addComponent(mainButtons[44])
         )
		.addGroup(layout2.createParallelGroup(LEADING)
         .addComponent(mainButtons[6])
			.addComponent(mainButtons[14])
         .addComponent(mainButtons[22])
         .addComponent(mainButtons[30])
         .addComponent(mainButtons[38])
         .addComponent(mainButtons[45])
         )
		.addGroup(layout2.createParallelGroup(LEADING)
         .addComponent(mainButtons[7])
			.addComponent(mainButtons[15])
         .addComponent(mainButtons[23])
         .addComponent(mainButtons[31])
         .addComponent(mainButtons[39], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
         )
        
		);
      
      layout2.linkSize(SwingConstants.HORIZONTAL, mainButtons[0],mainButtons[1],mainButtons[2],mainButtons[3],mainButtons[4],mainButtons[5],mainButtons[6],mainButtons[7],mainButtons[8],mainButtons[9],mainButtons[10],mainButtons[11],mainButtons[12],mainButtons[13],mainButtons[14],mainButtons[15],mainButtons[16],mainButtons[17],mainButtons[18],mainButtons[19],mainButtons[20],mainButtons[21],mainButtons[22],mainButtons[23],mainButtons[24],mainButtons[25],mainButtons[26],mainButtons[27],mainButtons[28],mainButtons[29],mainButtons[30],mainButtons[31],mainButtons[32],mainButtons[33],mainButtons[34],mainButtons[35],mainButtons[36],mainButtons[37],mainButtons[38],mainButtons[40],mainButtons[41],mainButtons[42],mainButtons[44],mainButtons[45]);	      
		layout2.setVerticalGroup(layout2.createSequentialGroup()
      .addGroup(layout2.createParallelGroup(BASELINE)
   		.addComponent(mainButtons[0])
         .addComponent(mainButtons[1])
   		.addComponent(mainButtons[2])
         .addComponent(mainButtons[3])
   		.addComponent(mainButtons[4])
         .addComponent(mainButtons[5])
   		.addComponent(mainButtons[6])
         .addComponent(mainButtons[7])
         )
      .addGroup(layout2.createParallelGroup(BASELINE)
   		.addComponent(mainButtons[8])
         .addComponent(mainButtons[9])
   		.addComponent(mainButtons[10])
         .addComponent(mainButtons[11])
   		.addComponent(mainButtons[12])
         .addComponent(mainButtons[13])
   		.addComponent(mainButtons[14])
         .addComponent(mainButtons[15])
         )
      .addGroup(layout2.createParallelGroup(BASELINE)
   		.addComponent(mainButtons[16])
         .addComponent(mainButtons[17])
   		.addComponent(mainButtons[18])
         .addComponent(mainButtons[19])
   		.addComponent(mainButtons[20])
         .addComponent(mainButtons[21])
   		.addComponent(mainButtons[22])
         .addComponent(mainButtons[23])
         )
      .addGroup(layout2.createParallelGroup(BASELINE)
   		.addComponent(mainButtons[24])
         .addComponent(mainButtons[25])
   		.addComponent(mainButtons[26])
         .addComponent(mainButtons[27])
   		.addComponent(mainButtons[28])
         .addComponent(mainButtons[29])
   		.addComponent(mainButtons[30])
         .addComponent(mainButtons[31])
		)
      

		.addGroup(layout2.createParallelGroup(BASELINE)
               .addGroup(layout2.createSequentialGroup()
				   .addComponent(mainButtons[32])
				   .addComponent(mainButtons[40])
               )
               .addGroup(layout2.createSequentialGroup()
				   .addComponent(mainButtons[33])
				   .addComponent(mainButtons[41])
                )
               .addGroup(layout2.createSequentialGroup()
				   .addComponent(mainButtons[34])
				   .addComponent(mainButtons[42])
               )
               .addGroup(layout2.createSequentialGroup()
				   .addComponent(mainButtons[35])
				   // 0 button
				   .addComponent(mainButtons[43], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
               )
               .addGroup(layout2.createSequentialGroup()
				   .addComponent(mainButtons[36])
				   // the 0 button takes up two slots, so this is empty
                )               
            	.addGroup(layout2.createSequentialGroup()
				   .addComponent(mainButtons[37])
               .addComponent(mainButtons[44])
				
               ) 
            	.addGroup(layout2.createSequentialGroup()
				   .addComponent(mainButtons[38])
               .addComponent(mainButtons[45])
               ) 
            	.addGroup(layout2.createSequentialGroup()
			       // equals button
			      .addComponent(mainButtons[39], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
               ) 		   
            )

      );
		
      layout2.linkSize(SwingConstants.VERTICAL, mainButtons[0],mainButtons[1],mainButtons[2],mainButtons[3],mainButtons[4],mainButtons[5],mainButtons[6],mainButtons[7],mainButtons[8],mainButtons[9],mainButtons[10],mainButtons[11],mainButtons[12],mainButtons[13],mainButtons[14],mainButtons[15],mainButtons[16],mainButtons[17],mainButtons[18],mainButtons[19],mainButtons[20],mainButtons[21],mainButtons[22],mainButtons[23],mainButtons[24],mainButtons[25],mainButtons[26],mainButtons[27],mainButtons[28],mainButtons[29],mainButtons[30],mainButtons[31],mainButtons[32],mainButtons[33],mainButtons[34],mainButtons[35],mainButtons[36],mainButtons[37],mainButtons[38],mainButtons[40],mainButtons[41],mainButtons[42],mainButtons[44],mainButtons[45]);	      
      
      buttonPanelEast.add(mainButtonPane,BorderLayout.CENTER);
      
      buttonPanel.add(buttonPanelEast,BorderLayout.EAST);
		subFrame1.add(buttonPanel,BorderLayout.SOUTH);
      
		mainFrame = new JPanel();
      mainFrame.setLayout (new BorderLayout());
      
      mainFrame.add(subFrame1,BorderLayout.CENTER);
		add(mainFrame);

	} 
      
	// main driver
	public static void main(String[] args) {
		calculator window = new calculator();
      //JFrame window = new JFrame();
		window.setSize(395,355);
		window.setVisible(true);
		window.setTitle("My First Calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
	   window.pack();             

	}       
      
	public void actionPerformed  (ActionEvent e){
		int num1 = 0 , num2 = 0, sum = 0;

		if (e.getSource() == resultField){
			if (!resultField.getText().isEmpty()){
			// TODO: validate digits vs characters
			// mask so it only accepts numbers, not characters
			num1 = Integer.parseInt(resultField.getText());
			binaryField1.setText( convertDectoBinRecursive( num1));
			}
 		else
		   binaryField1.setText("Result Field Empty, binary conversion not available!!!");         
		}
       
		
		double result = 0;
         
            //Search for entered key
        for (int i = 0; i < mainButtons.length; i++)
        {
            if(e.getSource() == mainButtons[i])
            {
                switch(i)
                {
				case 0:
					//quot
					break;
				case 1:
					//mod
					if (displayMode != ERROR_MODE)
					{
						try
						{
							result = getNumberInDisplay() / 100;
							displayResult(result);
						}
						catch(Exception ex)
						{
							displayError("Invalid input for function.");
							displayMode = ERROR_MODE;
						}
					}	
					break;
				case 2:
					//A
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					//B
					break;
				case 11:
					//backspace
					break;
				case 12:
					clearExisting();
					break;
				case 13:
					clearAll();
					break;
				case 14:
					processSignChange();
					break;
				case 15:
					//sqrt
					if (displayMode != ERROR_MODE)
					{
						try
						{
							if (getDisplayString().indexOf("-") == 0)
								displayError("Invalid input for function.");
							 
							result = Math.sqrt(getNumberInDisplay());
							displayResult(result);
						}
						catch(Exception ex)
						{
							displayError("Invalid input for function.");
							displayMode = ERROR_MODE;
						}
					}	
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					//C
					break;
				case 19:
					//7
					addDigitToDisplay(7);
					break;
				case 20:
					//8
					addDigitToDisplay(8);
					break;
				case 21:
					//9
					addDigitToDisplay(9);
					break;
				case 22:
					//Divide
					processOperator("/");
					break;
				case 23:
					//mod
					if (displayMode != ERROR_MODE)
					{
						try
						{
							result = getNumberInDisplay() / 100;
							displayResult(result);
						}
						catch(Exception ex)
						{
							displayError("Invalid input for function.");
							displayMode = ERROR_MODE;
						}
					}	
					break;
				case 24:
					break;
				case 25:
					break;
				case 26:
					//D
					break;
				case 27:
					//4
					addDigitToDisplay(4);
					break;
				case 28:
					//5
					addDigitToDisplay(5);
					break;
				case 29:
					//6
					addDigitToDisplay(6);
					break;
				case 30:
					//*
					processOperator("*");
					break;
				case 31:
					//recip
					if (displayMode != ERROR_MODE)
					{
						try
						{
							if (getNumberInDisplay() == 0)
								displayError("Cannot divide by zero.");
							result = 1 / getNumberInDisplay();
							displayResult(result);
						}
						catch(Exception ex)
						{
							displayError("Cannot divide by zero.");
							displayMode = ERROR_MODE;
						}
					}	
					
					break;
				case 32:
					break;
				case 33:
					break;
				case 34:
					//E
					break;
				case 35:
					//1
					addDigitToDisplay(1);
					break;
				case 36:
					//2
					addDigitToDisplay(2);
					break;
				case 37:
					//3
					addDigitToDisplay(3);
					break;
				case 38:
					// - 
					processOperator("-");
					break;
				case 39:
					//=
					processEquals();
					break;
				case 40:
					break;
				case 41:
					break;
				case 42:
					//F
					break;
				case 43:
					//0
					addDigitToDisplay(0);
					break;
				case 44:
					//.
					addDecimalPoint();
					break;
				case 45:
					//+
					processOperator("+");
					break;
                }
            }
        }
         

         
         
         
         
	}
 
        private void addToMemory()
        {
        //needs code   
         
        }
 
        private void storeInMemory()
        {
        //needs code   
        }
 
        private void recallMemory()
        {
        //needs code
        }
 
        private void clearMemory()
        {
        //needs code
        }
 
        private void setDisplayString(String s)
        {
            resultField.setText(s);
        }
         
        String getDisplayString()
        {
            return resultField.getText();
        }
         
        private void addDigitToDisplay(int digit)
        {
            if (clearOnNextDigit)
            {
                setDisplayString("");
            }
            String inputString = getDisplayString();
            if (inputString.indexOf("0") == 0)
            {
                inputString = inputString.substring(1);
            }
            if ((!inputString.equals("0") || digit > 0) && inputString.length() < MAX_INPUT_LENGTH)
            {
                setDisplayString(inputString + digit);
            }
            displayMode = INPUT_MODE;
            clearOnNextDigit = false;
        }
         
        private void addDecimalPoint()
        {
            displayMode = INPUT_MODE;
            if (clearOnNextDigit)
            {
                setDisplayString("");
            }
            String inputString = getDisplayString();
            if (inputString.indexOf(".") < 0)
            {
                setDisplayString(new String(inputString + "."));
            }
        }
         
        private void processSignChange()
        {
            if (displayMode == INPUT_MODE)
            {
                String input = getDisplayString();
                if (input.length() > 0 && !input.equals("0"))
                {
                    if(input.indexOf("-") == 0)
                    {
                        setDisplayString(input.substring(1));
                    }
                    else
                    {
                        setDisplayString("-" + input);
                    }
                }
            }
        }
         
        private void clearAll()
        {
            setDisplayString("0");
            lastOperator = "0";
            lastNumber = 0;
            displayMode = INPUT_MODE;
            clearOnNextDigit = true;
        }
         
        private void clearExisting()
        {
            setDisplayString("0");
            clearOnNextDigit = true;
            displayMode = INPUT_MODE;
        }
         
        double getNumberInDisplay()
        {
            String input = resultField.getText();
            return Double.parseDouble(input);
        }
         
        private void processOperator(String op)
        {
            if (displayMode != ERROR_MODE)
            {
                double numberInDisplay = getNumberInDisplay();
                if (!lastOperator.equals("0"))
                {
                    try
                    {
                        double result = processLastOperator();
                        displayResult(result);
                        lastNumber = result;
                    }
                    catch (DivideByZeroException e)
                    {
                        displayError("Cannot divide by sero.");
                    }
                }
                else
                {
                    lastNumber = numberInDisplay;
                }
                clearOnNextDigit = true;
                lastOperator = op;
            }
        }
         
        private void processEquals()
        {
            double result= 0;
            if (displayMode != ERROR_MODE)
            {
                try
                {
                    result = processLastOperator();
                    displayResult(result);
                }
                catch (DivideByZeroException e)
                {
                    displayError("Cannot divide by sero.");
                }
                lastOperator = "0";
            }
        }
         
        double processLastOperator() throws DivideByZeroException
        {
            double result = 0;
            double numberInDisplay = getNumberInDisplay();
            if (lastOperator.equals("/"))
            {
                if (numberInDisplay == 0)
                {
                    throw (new DivideByZeroException());
                }
                result = lastNumber/numberInDisplay;
            }
            if (lastOperator.equals("*"))
            {
                result = lastNumber * numberInDisplay;
            }
            if (lastOperator.equals("-"))
            {
                result = lastNumber - numberInDisplay;
            }
            if (lastOperator.equals("+"))
            {
                result = lastNumber + numberInDisplay;
            }
            return result;
        }
         
        private void displayResult(double result)
        {
            setDisplayString(Double.toString(result));
            lastNumber = result;
            displayMode = RESULT_MODE;
            clearOnNextDigit = true;
        }
         
        private void displayError(String errorMessage)
        {
            setDisplayString(errorMessage);
            lastNumber = 0;
            displayMode = ERROR_MODE;
            clearOnNextDigit = true;
        }
       
   private String convertDectoBinRecursive( int inputDec){
       int modulus;
       if( inputDec <= 1){
           return Integer.toString( inputDec);
       }
       modulus = inputDec % 2;
       //Right Shift (bitwise operator)in this case equivalent to division by 2
       return convertDectoBinRecursive( inputDec >> 1) + modulus;
   }

class DivideByZeroException extends Exception

{

	public DivideByZeroException()

	{

		super();

	}

	public DivideByZeroException(String s)

	{

		super(s);

	}

}   
}


