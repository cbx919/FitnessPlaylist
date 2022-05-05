import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class gui3 {

    protected JFrame frame, frame2, frame3, frame4, frame5, frame6;
    String[] optionsToChoose = {"Cardio", "Arms", "Legs", "Push", "Pull"};
    String[] cardioOptions = {"Swimming", "Running", "Cycling", "Canoeing", "Walking"};
    JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose); //makes drop down list
    JLabel label, label2, label3, label4, label5, label6; // label for subselection options
    //JCheckBox cB1, cB2, cB3, cB4, cB5, cB6, cB7, cB8, cB9, cB10, cB11, cB12;
    // cB13, cB14, cB15, cB16, cB17, cB18, cB19, cB20, cB21, cB22, cB23, cB24, cB25; //makes checkboxes for frames
    JButton btnOpenWindow, btnSearch, btnSearch2, btnSearch3, btnSearch4, btnSearch5;
    //JLabel resultLabel, resultLabel2, resultLabel3, resultLabel4, resultLabel5;
    JTextArea txtArea, txtArea2, txtArea3, txtArea4, txtArea5;
    youtubeAPI api = new youtubeAPI();
	
    ArrayList<String> cardioUrl = new ArrayList<String>();  //for urls for cardio
    ArrayList<JCheckBox>  cardioCheckBoxes = new ArrayList<JCheckBox>();
        
    ArrayList<String> armsUrl = new ArrayList<String>();  //for urls for the arms
    ArrayList<JCheckBox>  armsCheckBoxes = new ArrayList<JCheckBox>();
/*
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
    String url10 = ""; 
    String url11 = "";
    String url12 = "";
    String url13 = "";
    String url14 = "";
    String url15 = "";
    String url16 = "";
    String url17 = "";
    String url18 = "";
    String url19 = "";
    */
    /*
    protected static ArrayList<String> queries = new ArrayList<>();	//append "exercises" to query in search
    /**
     * static initializer to declare query terms outside of main method so they can be accessed in other files
     * throughout project
     * reference: https://stackoverflow.com/questions/30022282/adding-elements-into-arraylist-outside-of-main-method
     */
    /*
    static {
        queries.add("Swimming"); queries.add("Running"); queries.add("Cycling");
        queries.add("Walking"); queries.add("Rowing");	//end of cardio selections
        queries.add("Bicep curling"); queries.add("Forearm"); queries.add("Tricep");
        queries.add("Chin-up"); queries.add("Seated Row");	//end of arms selections
        queries.add("Squat"); queries.add("Lunge"); queries.add("Calf Raise");
        queries.add("Leg Press"); queries.add("Deadlift");	//end of legs selections
        queries.add("Chest"); queries.add("Shoulder"); queries.add("Tricep");
        queries.add("Pushup variation"); queries.add("Bench Press");	//end of push selections
        queries.add("Shrug"); queries.add("Seated Lat Pulldown"); queries.add("Pullup variation");
        queries.add("Back"); queries.add("Dumbbell row");	//end of pull selections
    }

    */
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        gui3 window = new gui3();
        window.frame.setVisible(true);
    }

    /**
     * Create the application.
     */
    
    public gui3() 
    {
    	/**
    	 * initial selection/parent selection prompt
    	 * this selection dictates which frame is displayed next
    	 */
    	jComboBox.setBounds(150, 70, 140, 20);
     

        /**
         * sub-selection prompt, specific exercise that agrees with parent choice
         */
 
        //label3 = new JLabel("Choose Your Leg exercise for today");  
       //label3.setBounds(50,50,300,20); 
        //label4 = new JLabel("Choose Your Push exercise for today"); 
       // label4.setBounds(50,50,300,20); 
      int x = 100;
      int y = 50;
      int width = 150;
      int height = 20;
       //initializing check boxes for cardio 
      for (int j=0; j< cardioOptions.length; j++)
      {
    	  cardioCheckBoxes.add(new JCheckBox(cardioOptions[j]));
    	  cardioCheckBoxes.get(j).setBounds(x,(y+50),width,height);
    	  
    	  y+=50;
      }
      //*/
      //frame 2 controls
      /*
        cardioCheckBoxes.add(new JCheckBox("Swimming"));
        cardioCheckBoxes.get(0).setBounds(100,100,150,20);
      	cardioCheckBoxes.add(new JCheckBox("Running"));
        cardioCheckBoxes.get(1).setBounds(100,150,150,20);
        cardioCheckBoxes.add(new JCheckBox("Cycling"));
        cardioCheckBoxes.get(2).setBounds(100,200,150,20);
        cardioCheckBoxes.add(new JCheckBox("Canoeing"));
        cardioCheckBoxes.get(3).setBounds(100,250,150,20);
        cardioCheckBoxes.add(new JCheckBox("Walking"));
        cardioCheckBoxes.get(4).setBounds(100,300,150,20);
       */
      	y = 50;
        label = new JLabel("Choose your cardio exercise for today");  
        label.setBounds(50,50,300,20); 
        //resultLabel = new JLabel("Result");
        //resultLabel.setBounds(50,350,500,120); //places checkbox
        btnSearch = new JButton("Search");
        btnSearch.setBounds(250,200,120,23);
        txtArea = new JTextArea(30, 30);
        txtArea.setBounds(50,350,500,120);
        //JScrollPane scrollPane = new JScrollPane(txtArea);
        txtArea.setEditable(false);
        
        initialize();
    }
        //scrollPane.setVerticalScrollBarPolicy(
        		//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setPreferredSize(new Dimension(250, 250));
        //initialize();
    	//}
        //frame 3 controls:
        /*
        armsCheckBoxes.add(new JCheckBox("Bicep Curling"));
        armsCheckBoxes.get(0).setBounds(100,100,150,20);
      	armsCheckBoxes.add(new JCheckBox("Forearm"));
        armsCheckBoxes.get(1).setBounds(100,150,150,20);
        armsCheckBoxes.add(new JCheckBox("Tricep"));
        armsCheckBoxes.get(2).setBounds(100,200,150,20);
        armsCheckBoxes.add(new JCheckBox("Chin Up"));
        armsCheckBoxes.get(3).setBounds(100,250,150,20);
        armsCheckBoxes.add(new JCheckBox("Seated Row"));
        armsCheckBoxes.get(4).setBounds(100,300,150,20);
        label2 = new JLabel("Choose your arm exercise for today");  
        label2.setBounds(50,50,300,20); 
        btnSearch2 = new JButton("Search");
        btnSearch2.setBounds(250,200,120,23);
        txtArea2 = new JTextArea(30,30);
        txtArea2.setBounds(50,350,500,120);
        txtArea2.setEditable(false);
        */
        
        //frame 4 controls:
        
        /*
        cB1 = new JCheckBox(queries.get(0));        //makes swim checkbox
        cB1.setBounds(100,100,150,20); 				//places checkbox
        cB2 = new JCheckBox(queries.get(1));        //makes run checkbox
        cB2.setBounds(100,150,150,20); 				//places checkbox
        cB3 = new JCheckBox(queries.get(2));     	//makes cycling checkbox
        cB3.setBounds(100,200,150,20); 				//places checkbox
        cB4 = new JCheckBox(queries.get(3));        //makes walk checkbox
        cB4.setBounds(100,250,150,20);  			//places checkbox
        cB5 = new JCheckBox(queries.get(4));      	//makes rowing checkbox
        cB5.setBounds(100,300,150,20); 				//places checkbox
        cB6 = new JCheckBox(queries.get(5));        //makes bicep curling checkbox
        cB6.setBounds(100,100,150,20); 				//places checkbox
        cB7 = new JCheckBox(queries.get(6));        //makes forearm checkbox
        cB7.setBounds(100,150,150,20); 				//places checkbox
        cB8 = new JCheckBox(queries.get(7));     	//makes tricep checkbox
        cB8.setBounds(100,200,150,20); 				//places checkbox
        cB9 = new JCheckBox(queries.get(8));        //makes chin-up checkbox
        cB9.setBounds(100,250,150,20);  			//places checkbox
        cB10 = new JCheckBox(queries.get(9));      	//makes seated row checkbox
        cB10.setBounds(100,300,150,20); 			//places checkbox
        cB11 = new JCheckBox(queries.get(10));      //makes squat checkbox
        cB11.setBounds(100,100,150,20); 			//places checkbox
        cB12 = new JCheckBox(queries.get(11));      //makes lunge checkbox
        cB12.setBounds(100,150,150,20); 			//places checkbox
        cB13 = new JCheckBox(queries.get(12));     	//makes calf raise checkbox
        cB13.setBounds(100,200,150,20); 			//places checkbox
        cB14 = new JCheckBox(queries.get(13));      //makes leg press checkbox
        cB14.setBounds(100,250,150,20);  			//places checkbox
        cB15 = new JCheckBox(queries.get(14));      //makes deadlift checkbox
        cB15.setBounds(100,300,150,20); 			//places checkbox
        cB16 = new JCheckBox(queries.get(15));      //makes chest checkbox
        cB16.setBounds(100,100,150,20); 			//places checkbox
        cB17 = new JCheckBox(queries.get(16));      //makes shoulder checkbox
        cB17.setBounds(100,150,150,20); 			//places checkbox
        cB18 = new JCheckBox(queries.get(17));     	//makes tricep checkbox
        cB18.setBounds(100,200,150,20); 			//places checkbox
        cB19 = new JCheckBox(queries.get(18));      //makes push-up variation checkbox
        cB19.setBounds(100,250,150,20);  			//places checkbox
        cB20 = new JCheckBox(queries.get(19));      //makes bench press checkbox
        cB20.setBounds(100,300,150,20); 			//places checkbox
        */

        /*
        btnSearch.setBounds(250, 200, 120, 23); //places search button
        btnSearch2 = new JButton("Search");
        btnSearch2.setBounds(250, 200, 120, 23); //places search button
        btnSearch3 = new JButton("Search");
        btnSearch3.setBounds(250, 200, 120, 23); //places search button
        btnSearch4 = new JButton("Search");
        btnSearch4.setBounds(250, 200, 120, 23); //places search button
        */
        
        //resultLabel = new JLabel("Result");
        //resultLabel.setBounds(50,350,500,120); //places checkbox
      /*
        resultLabel2 = new JLabel("Result");
        resultLabel2.setBounds(50,350,500,120); //places checkbox
        resultLabel3 = new JLabel("Result");
        resultLabel3.setBounds(50,350,500,120); //places checkbox
        resultLabel4 = new JLabel("Result");
        resultLabel4.setBounds(50,350,500,120); //places checkbox
		*/
    

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
        for (int k = 0; k < cardioOptions.length; k++) {
        	frame2.add(cardioCheckBoxes.get(k));
        }
        /*
        frame2.add(cardioCheckBoxes.get(0));
        frame2.add(cardioCheckBoxes.get(1));
        frame2.add(cardioCheckBoxes.get(2));
        frame2.add(cardioCheckBoxes.get(3));
        frame2.add(cardioCheckBoxes.get(4));
        */
        frame2.add(btnSearch);
        frame2.add(label);
        //frame2.add(resultLabel);
        //frame2.add(scrollPane);
        frame2.add(txtArea);
        
      
         //Frame 3 for Arms 
        /*
        frame3 = new JFrame();  //makes arms frame
        frame3.setBounds(100, 100, 650, 600); //sets size and postion
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        frame3.getContentPane().setLayout(null);
        frame3.add(armsCheckBoxes.get(0));
      	frame3.add(armsCheckBoxes.get(1));
      	frame3.add(armsCheckBoxes.get(2));
      	frame3.add(armsCheckBoxes.get(3));
      	frame3.add(armsCheckBoxes.get(4));
        frame3.add(btnSearch2);
        frame3.add(label2);
        //frame3.add(resultLabel2);
        frame3.add(txtArea2);
      */
       /* 
        frame4 = new JFrame();  //makes legs frame
        frame4.setBounds(100, 100, 650, 600); //sets size and postion
        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        frame4.getContentPane().setLayout(null);
        frame4.add(cB11);frame4.add(cB12);frame4.add(cB13);frame4.add(cB14);frame4.add(cB15);
        frame4.add(btnSearch3);
        frame4.add(label3);
        frame4.add(resultLabel3);
        
        frame5 = new JFrame();  //makes push frame
        frame5.setBounds(100, 100, 650, 600); //sets size and postion
        frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        frame5.getContentPane().setLayout(null);
        frame5.add(cB16);frame5.add(cB17);frame5.add(cB18);frame5.add(cB19);frame5.add(cB20);
        frame5.add(btnSearch4);
        frame5.add(label4);
        frame5.add(resultLabel4);
`		*/

      //registering nextbutton with actionListener
        btnOpenWindow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (jComboBox.getSelectedItem().equals("Cardio"))
                frame2.setVisible(true);
          
            	else if (jComboBox.getSelectedItem().equals("Arms"))
                frame3.setVisible(true);
          /*      
            	if (jComboBox.getSelectedItem().equals("Legs"))
                frame4.setVisible(true);
            	if (jComboBox.getSelectedItem().equals("Push"))
                frame5.setVisible(true);
            	if (jComboBox.getSelectedItem().equals("Pull"))
                frame6.setVisible(true);
                */
            }
        });
        //btnOpenWindow.setBounds(167, 118, 120, 23);
        //frame.getContentPane().add(btnOpenWindow);
    
	//registering btnSearcgh
        btnSearch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	try
        	{
        		txtArea.setText(null);
        		for (int i = 0; i < cardioCheckBoxes.size(); i++)
        		{
        		if(cardioCheckBoxes.get(i).isSelected())	//remove all items method somewhere if user changes choice
        		{
                  cardioUrl.add((api.videoSearch(cardioCheckBoxes.get(i).getText() + "exercises")));
                  txtArea.append(cardioOptions[i] + "\n");
                  txtArea.append(cardioUrl.get(i) + "\n");
                }
                if(cardioCheckBoxes.get(1).isSelected()) 
        		{
                  cardioUrl.add((api.videoSearch(cardioCheckBoxes.get(1).getText() + "exercises")));
                  txtArea.append(cardioUrl.get(1) + "\n");
        		}
        		if(cardioCheckBoxes.get(2).isSelected())
        		{
                 cardioUrl.add((api.videoSearch(cardioCheckBoxes.get(2).getText() + "exercises")));
                 txtArea.append(cardioUrl.get(2) + "\n");
        		}
        		if(cardioCheckBoxes.get(3).isSelected())
        		{
                  cardioUrl.add((api.videoSearch(cardioCheckBoxes.get(3).getText() + "exercises")));
                  txtArea.append(cardioUrl.get(3) + "\n");
        		}
        		if(cardioCheckBoxes.get(4).isSelected())
        		{
                  cardioUrl.add((api.videoSearch(cardioCheckBoxes.get(4).getText() + "exercises")));
                  txtArea.append(cardioUrl.get(4) + "\n");
        		}
        	}
        }
                                /*
         		if(cB6.isSelected())	
         		{url5 = (api.videoSearch(cB6.getText() + "exercises"));}
         		 if(cB7.isSelected())
         		{url6 = (api.videoSearch(cB7.getText() + "exercises"));}
         		 if(cB8.isSelected())
         		{url7 = (api.videoSearch(cB8.getText() + "exercises"));}
         		 if(cB9.isSelected())
         		{url8 = (api.videoSearch(cB9.getText() + "exercises"));}
         		 if(cB10.isSelected())
         		{url9 = (api.videoSearch(cB10.getText() + "exercises"));}
         		if(cB11.isSelected())	
         		{url10 = (api.videoSearch(cB11.getText() + "exercises"));}
         		if(cB12.isSelected())
         		{url11 = (api.videoSearch(cB12.getText() + "exercises"));}
         		if(cB13.isSelected())
         		{url12 = (api.videoSearch(cB13.getText() + "exercises"));}
         		if(cB14.isSelected())
         		{url13 = (api.videoSearch(cB14.getText() + "exercises"));}
         		if(cB15.isSelected())
         		{url14 = (api.videoSearch(cB15.getText() + "exercises"));}
         		if(cB16.isSelected())	
         		{url15 = (api.videoSearch(cB16.getText() + "exercises"));}
         		if(cB17.isSelected())
         		{url16 = (api.videoSearch(cB17.getText() + "exercises"));}
         		if(cB18.isSelected())
         		{url17 = (api.videoSearch(cB18.getText() + "exercises"));}
         		if(cB19.isSelected())
         		{url18 = (api.videoSearch(cB19.getText() + "exercises"));}
         		if(cB20.isSelected())
         		{url19 = (api.videoSearch(cB20.getText() + "exercises"));}
                
                */
        		//if(!cardioUrl.get(0).equals(""))         		 
           			// resultLabel.setText(cardioUrl.get(0));
        	
        	catch(Exception ex)
        	{
        		System.out.println(ex);
        	}
        }		
		
        });//end btnSearch Action Listener
    }
}
		//btnsearch2 for frame 3
        /*
        btnSearch2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	try
        	{
        		txtArea2.setText(null);
        		if(armsCheckBoxes.get(0).isSelected())	
        		{
                  armsUrl.add((api.videoSearch(armsCheckBoxes.get(0).getText() + "exercises")));
                  txtArea2.append(armsUrl.get(0) + "\n");
                }
                if(armsCheckBoxes.get(1).isSelected()) 
        		{
                  armsUrl.add((api.videoSearch(armsCheckBoxes.get(1).getText() + "exercises")));
                  txtArea2.append(armsUrl.get(1) + "\n");
        		}
        		if(armsCheckBoxes.get(2).isSelected())
        		{
                 armsUrl.add((api.videoSearch(armsCheckBoxes.get(2).getText() + "exercises")));
                 txtArea2.append(armsUrl.get(2) + "\n");
        		}
        		if(armsCheckBoxes.get(3).isSelected())
        		{
                  armsUrl.add((api.videoSearch(armsCheckBoxes.get(3).getText() + "exercises")));
                  txtArea2.append(armsUrl.get(3) + "\n");
        		}
        		if(armsCheckBoxes.get(4).isSelected())
        		{
                  armsUrl.add((api.videoSearch(armsCheckBoxes.get(4).getText() + "exercises")));
                  txtArea2.append(armsUrl.get(4) + "\n");
        		}

        	}
        	catch(Exception ex)
        	{
        		System.out.println(ex);
        	}
        }		
		
        });//end btnSearch2 Action Listener (arms)
    }
}*/
//end class/