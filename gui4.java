import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class gui4 {

    protected JFrame frame, frame2, frame3, frame4, frame5, frame6;
    String[] optionsToChoose = {"Cardio", "Arms", "Legs", "Push", "Pull"};
	String[] cardioOptions = {"Swimming", "Running", "Cycling", "Canoeing", "Rowing"};
    JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose); //makes drop down list
    JLabel label, label2, label3, label4, label5, label6; // label for subselection options

   
    JButton btnOpenWindow, btnSearch, btnSearch2, btnSearch3, btnSearch4, btnSearch5;
    JLabel resultLabel, resultLabel2, resultLabel3, resultLabel4, resultLabel5;
    JTextArea txtArea, txtArea2, txtArea3, txtArea4, txtArea5;
    youtubeAPI api = new youtubeAPI();
	
    ArrayList<String> cardioUrl = new ArrayList<String>();  //for urls for cardio
    ArrayList<JCheckBox>  cardioCheckBoxes = new ArrayList<JCheckBox>();
        
    ArrayList<String> armsUrl = new ArrayList<String>();  //for urls for the arms
    ArrayList<JCheckBox>  armsCheckBoxes = new ArrayList<JCheckBox>();

    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        gui4 window = new gui4();
        window.frame.setVisible(true);
    }

    /**
     * Create the application.
     */
    public gui4() {
    	/**
    	 * initial selection/parent selection prompt
    	 * this selection dictates which frame is displayed next
    	 */
        jComboBox.setBounds(150, 70, 140, 20);       
      
       //initializing check boxes for cardio 
        int x = 100; 
        int y = 100;
      	int width = 150;
      	int height = 20;
      
        //frame 2 controls
       for (int j = 0; j < cardioOptions.length; j++)
       {
         cardioCheckBoxes.add(new JCheckBox(cardioOptions[j]));
         cardioCheckBoxes.get(j).setBounds(x, y, width, height);
         
         y += 50;
       }
        y = 50;
        label = new JLabel("Choose your cardio exercise for today");  //label before checkboxes 
        label.setBounds(x-50,y,width+ 150,height);         
        btnSearch = new JButton("Search");
        btnSearch.setBounds(x +150,y +150,width -30,height);
       	resultLabel = new JLabel("Results of the search");
        resultLabel.setBounds(x-50,350,width,height); //places above text areax
        txtArea = new JTextArea(30, 30);
        txtArea.setBounds(x-50,y + 350,width + 350,height +130);        
        txtArea.setEditable(false);
      //JScrollPane scrollPane = new JScrollPane(txtArea);
        //scrollPane.setVerticalScrollBarPolicy(
        		//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setPreferredSize(new Dimension(250, 250));
           
         initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame(); //makes first frame
        frame.setBounds(100, 100, 650, 600); // makes size of frame and where it opens
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.add(jComboBox);
        JButton btnOpenWindow = new JButton("Next");
        btnOpenWindow.setBounds(167, 118, 120, 23);
        frame.getContentPane().add(btnOpenWindow);

        frame2 = new JFrame();  //makes cardio frame
        frame2.setBounds(100, 100, 650, 600); //sets size and postion
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        frame2.getContentPane().setLayout(null);
      //adding checkboxes to the frame
       	for (int k = 0; k < cardioOptions.length; k++ )
        {
          frame2.add(cardioCheckBoxes.get(k));
        } 
      //adding labels button and text area to the fram
      	frame2.add(btnSearch);//adding search button  to frame 
        frame2.add(label);
        frame2.add(resultLabel);
      	frame2.add(txtArea);
     
        
      //registering nextbutton with actionListener
        btnOpenWindow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (jComboBox.getSelectedItem().equals("Cardio"))
                frame2.setVisible(true);
            	else if (jComboBox.getSelectedItem().equals("Arms"))
                frame3.setVisible(true);                
            	else if (jComboBox.getSelectedItem().equals("Legs"))
                frame4.setVisible(true);
            	else if (jComboBox.getSelectedItem().equals("Push"))
                frame5.setVisible(true);
            	else if (jComboBox.getSelectedItem().equals("Pull"))
                frame6.setVisible(true);
                
            }
        });
       
	//registering btnSearch
        btnSearch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	try 
        	{
        	txtArea.setText(null);
			for (int i = 0; i< cardioCheckBoxes.size(); i++)
			{
			  if(cardioCheckBoxes.get(i).isSelected())	
			  {
			  cardioUrl.add((api.videoSearch(cardioCheckBoxes.get(i).getText() + "exercises")));
			  txtArea.append(cardioOptions[i] + "\n");	//txtArea.append("Swimming URL \n")
			  txtArea.append(cardioUrl.get(i) + "\n");

			 }
			  
			}//end for

        }		
        	catch(Exception ex)	//catch(IOException | Exception ex)
        	{
        	System.out.println(ex);
        	}
		}
        
        });//end btnSearch Action Listener

                	
    }//end initialize method
}//end class/