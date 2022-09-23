package MySearchEngine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class GUI extends JFrame implements ActionListener{
	JLabel label1;
	JButton button1,button2;
	JPanel panel1, panel2;
	JTextField textfield1;
	JComboBox<String> dropdown;
	JTable myTable;
	Object resulttable ;
	JList<String> list;
	
	public GUI(String title) {
		super(title);
		
		//Setting the Size of the Frame
		setSize(500,500);
		panel1=new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		// Setting Layout of Panel
		setLayout(new BorderLayout());
		add(panel1);
		
		//Create Drop Down 1
		String[] SearchOption = { "Keyword"};
		dropdown = new JComboBox<String>(SearchOption);
		panel1.add(dropdown , BorderLayout.NORTH);
		
		//Create TextFeild 1
		textfield1 =new JTextField("",16);
		panel1.add(textfield1 , BorderLayout.NORTH);
		textfield1.setToolTipText("Enter the Search");
		textfield1.addActionListener(this);
		
		
		// Creating Button Number 1
		button1=new JButton("Search");
		panel1.add(button1 , BorderLayout.NORTH);
		button1.setToolTipText("Search For String Entered");
		button1.addActionListener(this);
		

		
		//Make frame visible
		setVisible(true);
		

	} //end GUI panel

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Set the action when user presses search button 
		if(e.getSource() == button1)
		{
			//Grabs the text in the textfeild assigns it to a string
			String searchterm = textfield1.getText();
			
			//Makes a new object of FolderSearch
			FolderSearch search = new FolderSearch();
			try {
				
				//Calls the SelectFiles method and passes the searchterm from the searchbar
				//Places the results into an object called resulttable
				resulttable = search.SelectFiles(searchterm);
				
				//Converts all the results to a string
				String results = resulttable.toString();
				
				//Removes these chars from the Strings, they are there by default from the TreeMap
				results =results.replace("{" , " ");
				results =results.replace("}" , " ");
				
				//Creates new lines on each ',' in the string, they are there by default from the TreeMap
				String[] finalresults = results.split(",");
				
				//Creates a Jlist of Strings to display the results
				list = new JList<String>(finalresults);
				
				//Add the Jlist to the GUI panel and set it to be viable
				panel1.add(list ,BorderLayout.SOUTH);
				setVisible(true);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} //end if 
		
	
	}//end actionPerformed
	
}//end class GUI
    

