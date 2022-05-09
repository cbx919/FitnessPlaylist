import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 * FitList  
 * 8 May 2022
 * CIS111BONL02 - Dr. Martin 
 * @authors Julia Hansford, Chris Bonner, Geoffrey Gaines
 * 
 * Categorize the queries that will be available for the user to choose from via JCbeckBox.
 * Create the tools and features needed to design an efficient, user-friendly GUI.
 * Create containers for objects to dwell in until they are called and to make GUI items.
 * Create instance of youtubeAPI so method videoSearch() can be applied to user query choice via ActionListener.
 */
public class gui5
{
    
    protected String[] optionsToChoose = {"Cardio", "Arms", "Legs", "Push", "Pull"};
	protected String[] cardioOptions = {"Swimming", "Running", "Cycling", "Jump Rope", "Walking"};
	protected String[] armsOptions = {"Bicep", "Forearm", "Tricep", "Chin-up", "Seated Row"};
	protected String[] legsOptions = {"Squat", "Lunge", "Calf Raise", "Leg Press", "Deadlift"};
	protected String[] pushOptions = {"Chest", "Shoulder", "Dips", "Push-up", "Pressing"};
	protected String[] pullOptions = {"Shrug", "Lat Pulldown", "Pull-up", "Back", "Dumbbell Row"};
	
	protected JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose); //makes drop down list for homeFrame
    
    protected JFrame homeFrame, cardioFrame, armsFrame, legsFrame, pushFrame, pullFrame;
	protected JLabel homeLabel, cardioLabel, armsLabel, legsLabel, pushLabel, pullLabel; // label for subselection options
	protected JButton btnOpenWindow, cardioSearch, armsSearch, legsSearch, pushSearch, pullSearch;
	protected JLabel cardioResultLabel, armsResultLabel, legsResultLabel, pushResultLabel, pullResultLabel;
	protected JTextArea cardioTxtArea, armsTxtArea, legsTxtArea, pushTxtArea, pullTxtArea;
	
	protected youtubeAPI api = new youtubeAPI();
	
	protected String urlCardio = "";
	protected ArrayList<JCheckBox>  cardioCheckBoxes = new ArrayList<JCheckBox>();
        
	protected String urlArms = "";
	protected ArrayList<JCheckBox>  armsCheckBoxes = new ArrayList<JCheckBox>();
	
	protected String urlLegs = "";
	protected ArrayList<JCheckBox>  legsCheckBoxes = new ArrayList<JCheckBox>();
	
	protected String urlPush = "";
	protected ArrayList<JCheckBox>  pushCheckBoxes = new ArrayList<JCheckBox>();
	
	protected String urlPull = "";
	protected ArrayList<JCheckBox>  pullCheckBoxes = new ArrayList<JCheckBox>();

    /**
     * Launch the application.
     * GUI class can act as its own Driver class since it utilizes main method.
     * Call the GUI constructor so homeFrame may appear and allow user to decide the sequence of events.
     */
    public static void main(String[] args) 
    {
        gui5 window = new gui5();
        window.homeFrame.setVisible(true);
    }
    /**
     * Create the application and objects that populate the GUI.
     * Assign locations and properties of objects in second frame corresponding to user input selection.
     * Automatically create JCheckBoxes for each category by looping through String[]'s declared above.
     * Call method initialize().
     */
    public gui5() 
    {
        jComboBox.setBounds(275, 200, 140, 20);
        homeLabel = new JLabel("Choose which type of exercise you are focusing on today");
        homeLabel.setBounds(140,140,333,20);
        
        int x = 100; 
        int y = 100;
        int width = 150;
        int height = 20;
        
        for (int j = 0; j < cardioOptions.length; j++)
        {
        	cardioCheckBoxes.add(new JCheckBox(cardioOptions[j]));
        	cardioCheckBoxes.get(j).setBounds(x, y, width, height);
        	y += 50;
        }
        
        y = 50;
        cardioLabel = new JLabel("Choose your cardio exercise for today");  //label before checkboxes 
        cardioLabel.setBounds(x-50,y,width+ 150,height);         
        cardioSearch = new JButton("Search");
        cardioSearch.setBounds(x +150,y +150,width -30,height);
       	cardioResultLabel = new JLabel("Results of the search");
        cardioResultLabel.setBounds(x-50,350,width,height); //places above text area
        cardioTxtArea = new JTextArea(30, 30);
        cardioTxtArea.setBounds(x-50,y + 350,width + 350,height +130);        
        cardioTxtArea.setEditable(false);	//user can't manipulate output
        y = 100;
        
        
        for (int l = 0; l < armsOptions.length; l++)
        {
        	armsCheckBoxes.add(new JCheckBox(armsOptions[l]));
        	armsCheckBoxes.get(l).setBounds(x, y, width, height);
        	y += 50;
        }
        
        y = 50;
        armsLabel = new JLabel("Choose your arm exercise for today");  //label before checkboxes 
        armsLabel.setBounds(x-50,y,width+ 150,height);         
        armsSearch = new JButton("Search");
        armsSearch.setBounds(x +150,y +150,width -30,height);
        armsResultLabel = new JLabel("Results of the search");
        armsResultLabel.setBounds(x-50,350,width,height); //places above text area
        armsTxtArea = new JTextArea(30, 30);
        armsTxtArea.setBounds(x-50,y + 350,width + 350,height +130);        
        armsTxtArea.setEditable(false);
        y = 100;
         
         
        for (int o = 0; o < legsOptions.length; o++)
        {
        	legsCheckBoxes.add(new JCheckBox(legsOptions[o]));
           	legsCheckBoxes.get(o).setBounds(x, y, width, height);
           	y += 50;
        }
         
        y = 50;
        legsLabel = new JLabel("Choose your leg exercise for today");  //label before checkboxes 
        legsLabel.setBounds(x-50,y,width+ 150,height);         
        legsSearch = new JButton("Search");
        legsSearch.setBounds(x +150,y +150,width -30,height);
        legsResultLabel = new JLabel("Results of the search");
        legsResultLabel.setBounds(x-50,350,width,height); //places above text area
        legsTxtArea = new JTextArea(30, 30);
        legsTxtArea.setBounds(x-50,y + 350,width + 350,height +130);        
        legsTxtArea.setEditable(false);
        y = 100;
          
          
        for (int r = 0; r < pushOptions.length; r++)
        {
        	pushCheckBoxes.add(new JCheckBox(pushOptions[r]));
        	pushCheckBoxes.get(r).setBounds(x, y, width, height);
        	y += 50;
        }
          
        y = 50;
        pushLabel = new JLabel("Choose your push exercise for today");  //label before checkboxes 
        pushLabel.setBounds(x-50,y,width+ 150,height);         
        pushSearch = new JButton("Search");
        pushSearch.setBounds(x +150,y +150,width -30,height);
        pushResultLabel = new JLabel("Results of the search");
        pushResultLabel.setBounds(x-50,350,width,height); //places above text area
        pushTxtArea = new JTextArea(30, 30);
        pushTxtArea.setBounds(x-50,y + 350,width + 350,height +130);        
        pushTxtArea.setEditable(false);
        y = 100;
           
           
        for (int u = 0; u < pullOptions.length; u++)
        {
        	pullCheckBoxes.add(new JCheckBox(pullOptions[u]));
        	pullCheckBoxes.get(u).setBounds(x, y, width, height);
        	y += 50;
        }
           
        y = 50;
        pullLabel = new JLabel("Choose your pull exercise for today");  //label before checkboxes 
        pullLabel.setBounds(x-50,y,width+ 150,height);         
        pullSearch = new JButton("Search");
        pullSearch.setBounds(x +150,y +150,width -30,height);
        pullResultLabel = new JLabel("Results of the search");
        pullResultLabel.setBounds(x-50,350,width,height); //places above text area
        pullTxtArea = new JTextArea(30, 30);
        pullTxtArea.setBounds(x-50,y + 350,width + 350,height +130);        
        pullTxtArea.setEditable(false);
        y = 100;
         
            
        initialize();

    }

    /**
     * Initialize the contents of the frames and assign object properties/positions.
     * Edit and critique each second frame possibility so they look professional with similar object placement.
     * Register ActionListener with multiple JButtons so proper functionality may occur.
     * Call api object in each Search Button so JCheckBox selection can be passed as String in method videoSearch().
     * @exception ClassCastException
     */
    protected void initialize() 
    {
        homeFrame = new JFrame(); //makes first frame
        homeFrame.setBounds(100, 100, 650, 400); // makes size of frame and where it opens
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.getContentPane().setLayout(null);
        homeFrame.add(jComboBox);
        homeFrame.add(homeLabel);
        JButton btnOpenWindow = new JButton("Next");
        btnOpenWindow.setBounds(300, 300, 100, 33);
        homeFrame.getContentPane().add(btnOpenWindow);

        cardioFrame = new JFrame();  //makes cardio frame
        cardioFrame.setBounds(100, 100, 650, 600); //sets size and postion
        cardioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        cardioFrame.getContentPane().setLayout(null);
        //adding check boxes to frame
       	for (int k = 0; k < cardioOptions.length; k++)
        {
       		cardioFrame.add(cardioCheckBoxes.get(k));
        } 
       	//adding labels button and text area to the frame
       	cardioFrame.add(cardioSearch);//adding search button  to frame 
       	cardioFrame.add(cardioLabel);
       	cardioFrame.add(cardioResultLabel);
       	cardioFrame.add(cardioTxtArea);
       	
        armsFrame = new JFrame();  //makes arms frame
        armsFrame.setBounds(100, 100, 650, 600); //sets size and postion
        armsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        armsFrame.getContentPane().setLayout(null);
        
       	for (int m = 0; m < armsOptions.length; m++)
        {
       		armsFrame.add(armsCheckBoxes.get(m));
        } 
       	armsFrame.add(armsSearch);//adding search button  to frame 
       	armsFrame.add(armsLabel);
       	armsFrame.add(armsResultLabel);
       	armsFrame.add(armsTxtArea);
       	
        legsFrame = new JFrame();  //makes cardio frame
        legsFrame.setBounds(100, 100, 650, 600); //sets size and postion
        legsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        legsFrame.getContentPane().setLayout(null);
        
       	for (int p = 0; p < legsOptions.length; p++)//adding check boxes to frame
        {
       		legsFrame.add(legsCheckBoxes.get(p));
        } 
       	//adding labels button and text area to the frame
       	legsFrame.add(legsSearch);//adding search button  to frame 
       	legsFrame.add(legsLabel);
       	legsFrame.add(legsResultLabel);
       	legsFrame.add(legsTxtArea);
       	
        pushFrame = new JFrame();  //makes cardio frame
        pushFrame.setBounds(100, 100, 650, 600); //sets size and position
        pushFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        pushFrame.getContentPane().setLayout(null);
        
       	for (int s = 0; s < legsOptions.length; s++)//adding check boxes to frame
        {
       		pushFrame.add(pushCheckBoxes.get(s));
        } 
       	//adding labels button and text area to the frame
       	pushFrame.add(pushSearch);//adding search button  to frame 
       	pushFrame.add(pushLabel);
       	pushFrame.add(pushResultLabel);
       	pushFrame.add(pushTxtArea);
       	
        pullFrame = new JFrame();  //makes cardio frame
        pullFrame.setBounds(100, 100, 650, 600); //sets size and postion
        pullFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //tells what to do when frame is closed
        pullFrame.getContentPane().setLayout(null);
        
       	for (int v = 0; v < pullOptions.length; v++)//adding check boxes to frame
        {
       		pullFrame.add(pullCheckBoxes.get(v));
        } 
       	//adding labels button and text area to the frame
       	pullFrame.add(pullSearch);//adding search button  to frame 
       	pullFrame.add(pullLabel);
       	pullFrame.add(pullResultLabel);
       	pullFrame.add(pullTxtArea);
     
       	//registering next button with actionListener
        btnOpenWindow.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) 
            {
            	if (jComboBox.getSelectedItem().equals("Cardio"))
            		cardioFrame.setVisible(true);
            	else if (jComboBox.getSelectedItem().equals("Arms"))
            		armsFrame.setVisible(true);                
            	else if (jComboBox.getSelectedItem().equals("Legs"))
            		legsFrame.setVisible(true);
            	else if (jComboBox.getSelectedItem().equals("Push"))
            		pushFrame.setVisible(true);
            	else if (jComboBox.getSelectedItem().equals("Pull"))
            		pullFrame.setVisible(true);
            }
        });

        //registering cardioSearch
        cardioSearch.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		try
        		{
        			cardioTxtArea.setText("");
        		
        			for (int i = 0; i< cardioCheckBoxes.size(); i++)
        			{
        				if(cardioCheckBoxes.get(i).isSelected())	
        				{
        					urlCardio = (api.videoSearch(cardioCheckBoxes.get(i).getText() + "exercises"));
        					cardioTxtArea.append(cardioOptions[i] + " video: \n");	
        					cardioTxtArea.append(urlCardio + "\n");
        				}
        			}
        		}		
        		catch(ClassCastException ex)	//catch(IOException | Exception ex)
        		{
        			System.out.println(ex);
        		}
        	}
        });//end cardioSearch Action Listener
        
        armsSearch.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		try
        		{
        			armsTxtArea.setText("");
        		
        			for (int n = 0; n< armsCheckBoxes.size(); n++)
        			{
        				if(armsCheckBoxes.get(n).isSelected())	
        				{
        					urlArms = (api.videoSearch(armsCheckBoxes.get(n).getText() + "exercises"));
        					armsTxtArea.append(armsOptions[n] + " video: \n");	
        					armsTxtArea.append(urlArms + "\n");
        				}
        			}
        		}		
        		catch(ClassCastException ex)	//catch(IOException | Exception ex)
        		{
        			System.out.println(ex);
        		}
        	}
        });//end armsSearch Action Listener
        
        legsSearch.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		try
        		{
        			legsTxtArea.setText("");
        		
        			for (int q = 0; q< legsCheckBoxes.size(); q++)
        			{
        				if(legsCheckBoxes.get(q).isSelected())	
        				{
        					urlLegs = (api.videoSearch(legsCheckBoxes.get(q).getText() + "exercises"));
        					legsTxtArea.append(legsOptions[q] + " video: \n");	
        					legsTxtArea.append(urlLegs + "\n");
        				}
        			}
        		}		
        		catch(ClassCastException ex)	//catch(IOException | Exception ex)
        		{
        			System.out.println(ex);
        		}
        	}
        });//end legsSearch Action Listener
        
        pushSearch.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		try
        		{
        			pushTxtArea.setText("");
        		
        			for (int t = 0; t< pushCheckBoxes.size(); t++)
        			{
        				if(pushCheckBoxes.get(t).isSelected())	
        				{
        					urlPush = (api.videoSearch(pushCheckBoxes.get(t).getText() + "exercises"));
        					pushTxtArea.append(pushOptions[t] + " video: \n");	
        					pushTxtArea.append(urlPush + "\n");
        				}
        			}
        		}		
        		catch(ClassCastException ex)	//catch(IOException | Exception ex)
        		{
        			System.out.println(ex);
        		}
        	}
        });//end pushSearch Action Listener
        
        pullSearch.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		try
        		{
        			pullTxtArea.setText("");
        		
        			for (int w = 0; w < pullCheckBoxes.size(); w++)
        			{
        				if(pullCheckBoxes.get(w).isSelected())	
        				{
        					urlPull = (api.videoSearch(pullCheckBoxes.get(w).getText() + "exercises"));
        					pullTxtArea.append(pullOptions[w] + " video: \n");	
        					pullTxtArea.append(urlPull + "\n");
        				}
        			}
        		}		
        		catch(ClassCastException ex)	//catch(IOException | Exception ex)
        		{
        			System.out.println(ex);
        		}
        	}
        });//end pullSearch Action Listener
  
    }//end method initialize() 
}//end class