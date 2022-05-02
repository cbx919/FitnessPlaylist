import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui2 {

    private JFrame frame, frame2, frame3, frame4, frame5, frame6;
    String[] optionsToChoose = {"Cardio", "Arms", "Legs", "Push", "Pull"};
    JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose); //makes drop down list
    JLabel label, label2, label3, label4, label5, label6; // label for subselection options
    JCheckBox cB1, cB2, cB3, cB4, cB5, cB6, cB7, cB8, cB9, cB10; //makes checkboxes for frame 2
    JButton btnSearch = new JButton("Search"); //search button for when we add the links
    youtubeAPI api = new youtubeAPI();
    String url = "";
    String url1 = "";
    String url2 = "";
    String url3 = "";
    String url4 = "";
    String url5 = "";
    String url6 = "";
    String url7 = "";
    String url8 = "";
    String url9 = "";
    JLabel resultLabel;




    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        gui2 window = new gui2();
        window.frame.setVisible(true);
    }

    /**
     * Create the application.
     */
    public gui2() {
        jComboBox.setBounds(150, 70, 140, 20);


        label = new JLabel("Choose Your Cardio exercise for Today");  //Makes title?
        label.setBounds(50,50,300,20); //places checkbox
        label2 = new JLabel("Choose Your Arm exercise for Today");  //Makes title?
        label2.setBounds(50,50,300,20); //places checkbox
        cB1 = new JCheckBox("Swimming");        //makes swim checkbox
        cB1.setBounds(100,100,150,20); //places checkbox
        cB2 = new JCheckBox("Running");         //makes run checkbox
        cB2.setBounds(100,150,150,20); //places checkbox
        cB3 = new JCheckBox("Cycling");     //makes cycling checkbox
        cB3.setBounds(100,200,150,20); //places checkbox
        cB4 = new JCheckBox("Walking");        //makes walk checkbox
        cB4.setBounds(100,250,150,20);  //places checkbox
        cB5 = new JCheckBox("Rowing");      //makes rowing checkbox
        cB5.setBounds(100,300,150,20); //places checkbox
        cB6 = new JCheckBox("Bicep curling");        //makes swim checkbox
        cB6.setBounds(100,100,150,20); //places checkbox
        cB7 = new JCheckBox("Forearm");         //makes run checkbox
        cB7.setBounds(100,150,150,20); //places checkbox
        cB8 = new JCheckBox("Tricep");     //makes cycling checkbox
        cB8.setBounds(100,200,150,20); //places checkbox
        cB9 = new JCheckBox("Chin-up");        //makes walk checkbox
        cB9.setBounds(100,250,150,20);  //places checkbox
        cB10 = new JCheckBox("Seated Row");      //makes rowing checkbox
        cB10.setBounds(100,300,150,20); //places checkbox
        btnSearch.setBounds(250, 200, 120, 23); //places search button
        resultLabel = new JLabel("Result");
        resultLabel.setBounds(50,350,500,120); //places checkbox
        //String url = "";
        
        //System.out.println(btnSearch);


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



        frame2 = new JFrame();  //makes second frame
        frame2.setBounds(100, 100, 650, 600); //sets size and postion
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        frame2.getContentPane().setLayout(null);
        frame2.add(cB1);frame2.add(cB2);frame2.add(cB3);frame2.add(cB4);frame2.add(cB5);
        frame2.add(btnSearch);
        frame2.add(label);
        frame2.add(resultLabel);
        
        frame3 = new JFrame();  //makes second frame
        frame3.setBounds(100, 100, 650, 600); //sets size and postion
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        frame3.getContentPane().setLayout(null);
        frame3.add(cB6);frame3.add(cB7);frame3.add(cB8);frame3.add(cB9);frame3.add(cB10);
        frame3.add(btnSearch);
        frame3.add(label2);
        frame3.add(resultLabel);


        JButton btnOpenWindow = new JButton("Next");
        btnOpenWindow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (jComboBox.getSelectedItem().equals("Cardio"))
                frame2.setVisible(true);
            	if (jComboBox.getSelectedItem().equals("Arms"))
                frame3.setVisible(true);
            	if (jComboBox.getSelectedItem().equals("Legs"))
                frame4.setVisible(true);
            	if (jComboBox.getSelectedItem().equals("Push"))
                frame5.setVisible(true);
            	if (jComboBox.getSelectedItem().equals("Pull"))
                frame6.setVisible(true);
            }
        });
        btnOpenWindow.setBounds(167, 118, 120, 23);
        frame.getContentPane().add(btnOpenWindow);
    

        btnSearch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	try
        	{
        		if(cB1.isSelected())	//remove all items method somewhere if user changes choice
        								//also look into text box / text field for better display
        		{
        			url = (api.videoSearch(cB1.getText() + "exercises"));
        		}
        		 if(cB2.isSelected())
        		{
        			url1 = (api.videoSearch(cB2.getText() + "exercises"));
        		}
        		 if(cB3.isSelected())
        		{
        			url2 = (api.videoSearch(cB3.getText() + "exercises"));
        		}
        		 if(cB4.isSelected())
        		{
        			url3 = (api.videoSearch(cB4.getText() + "exercises"));
        		}
        		 if(cB5.isSelected())
        		{
        			url4 = (api.videoSearch(cB5.getText() + "exercises"));
        		}
         		if(cB6.isSelected())	//remove all items method somewhere if user changes choice
         		{
         			url5 = (api.videoSearch(cB6.getText() + "exercises"));
         		}
         		 if(cB7.isSelected())
         		{
         			url6 = (api.videoSearch(cB7.getText() + "exercises"));
         		}
         		 if(cB8.isSelected())
         		{
         			url7 = (api.videoSearch(cB8.getText() + "exercises"));
         		}
         		 if(cB9.isSelected())
         		{
         			url8 = (api.videoSearch(cB9.getText() + "exercises"));
         		}
         		 if(cB10.isSelected())
         		{
         			url9 = (api.videoSearch(cB10.getText() + "exercises"));
         		}
        		//if(!url.equals("")) 
        		 String urls = "";
        		 urls += url + "\n" + url1 + "\n" + url2 + "\n" +
        				 url3 +"\n" + url4 + "\n" + url5 + "\n" +
        				 url6 + "\n" + url7 + "\n" + url8 + "\n"+
        				 url9;
        			 resultLabel.setText(urls);
        	}
        	catch(Exception ex)
        	{
        		System.out.println(ex);
        	}
        }

		//@Override
		//public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		//}
        });
    }}