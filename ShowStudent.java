import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ShowStudent extends JFrame{
	
	private Container container = getContentPane();
	private JLabel title = new JLabel("Student Information");
    private JLabel idLabel = new JLabel("Id");
    private JLabel nameLabel = new JLabel("Name");
    private JLabel majorLabel = new JLabel("Major");
    private JLabel creditLabel = new JLabel("Credit completed");
    private JLabel genderLabel = new JLabel("Gender");
    private JLabel attendLabel = new JLabel("Attendence (days)");
    private JLabel cgpaLabel = new JLabel("CGPA");
    
    private static JLabel sId = new JLabel();
    private static JLabel sName = new JLabel();
    private static JLabel sMajor = new JLabel();
    private static JLabel sCredCom = new JLabel();
    private static JLabel sGender = new JLabel();
    private static JLabel sAttend = new JLabel();
    private static JLabel sCgpa = new JLabel();
    
    static String wantUpdateId;
    
    
    private JButton updateButton = new JButton("UPDATE");
    
    private JButton deleteButton = new JButton("DELETE");
    
    private JButton menuButton = new JButton("MENU");
    
    
    
    public static void main(String[] args) {
    	
    	
    	ShowStudent frame = new ShowStudent();

        
        frame.setTitle("Student Management System");
        frame.setVisible(true);
        frame.setBounds(600, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        
        try {
        	
             
            File file = new File("F:\\eclipse-workspace\\Student Manage System\\students.txt");
      			
      			
      		ArrayList<Student> sr = new ArrayList<Student>();

      		ObjectOutputStream oos = null;
            ObjectInputStream ois = null;
      		ListIterator li = null;
      			
              
      		if(file.isFile()) {
              	
              	
              	ois = new ObjectInputStream(new FileInputStream(file));
              	
              	sr = (ArrayList<Student>)ois.readObject();
              	
              	ois.close();
              	
              	
                  
                  
              	li = sr.listIterator();
              	
              	
              	while(li.hasNext()) {
              		
              		Student s = (Student)li.next();
              		    	            		
              		if(s.sId.equals(Dashboard.searchId)) {
              			
              			sId.setText(s.sId);
              			sName.setText(s.sName);
              			sMajor.setText(s.sMajor);
              			sCredCom.setText(s.sCredCom);
              			sGender.setText(s.sGender);
              			sAttend.setText(s.sAttend);
              			sCgpa.setText(s.sCgpa);
              			
              		} 
              	}
              	
      		}   
        	
        } catch(Exception x) {
        	
        	
        	x.printStackTrace();
        }
        
      
		
      
	}
    

 
 
    ShowStudent() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
    	
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	title.setBounds(180,30,300,30);
    	idLabel.setBounds(100, 80, 100, 30);
        nameLabel.setBounds(100, 150, 180, 30);
        majorLabel.setBounds(100, 220, 100, 30);
        creditLabel.setBounds(100, 290, 100, 30);
        genderLabel.setBounds(100, 360, 100, 30);
        attendLabel.setBounds(100, 430, 140, 30);
        cgpaLabel.setBounds(100, 500, 100, 30);
        
        
        sId.setBounds(270,80,300,30);
        sName.setBounds(270, 150, 100, 30);
        sMajor.setBounds(270, 220, 100, 30);
        sCredCom.setBounds(270, 290, 100, 30);
        sGender.setBounds(270, 360, 100, 30);
        sAttend.setBounds(270, 430, 100, 30);
        sCgpa.setBounds(270, 500, 100, 30);
        
        
        updateButton.setBounds(200,570,100,50);
        
        deleteButton.setBounds(340,570,100,50);
        
        menuButton.setBounds(60,570,100,50);
    }
 
    public void addComponentsToContainer() {
    	
    	container.add(title);
    	container.add(idLabel);
        container.add(nameLabel);
        container.add(majorLabel);
        container.add(creditLabel);
        container.add(genderLabel);
        container.add(attendLabel);
        container.add(cgpaLabel);
        
        container.add(sId);
        container.add(sName);
        container.add(sMajor);
        container.add(sCredCom);
        container.add(sGender);
        container.add(sAttend);
        container.add(sCgpa);
        
        container.add(updateButton);
        container.add(deleteButton);
        container.add(menuButton);
        
    }
    
    
    public void addActionEvent() {
    	
    	
    	deleteButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			try {   
    				
    				
    				JFrame f = new JFrame();
                
    				File file = new File("F:\\eclipse-workspace\\Student Manage System\\students.txt");
          			
          			
    				ArrayList<Student> sr = new ArrayList<Student>();

    				ObjectOutputStream oos = null;
    				ObjectInputStream ois = null;
    				ListIterator li = null;
          			
                  
    				if(file.isFile()) {
    					
    					boolean found = false;
                  	
                  	
    					ois = new ObjectInputStream(new FileInputStream(file));
                  	
    					sr = (ArrayList<Student>)ois.readObject();
                  	
    					ois.close();
                  	
                  	
                      
                      
    					li = sr.listIterator();
                  	
                  	
    					while(li.hasNext()) {
                  		
    						Student s = (Student)li.next();
                  		    	            		
    						if(s.sId.equals(Dashboard.searchId)) {
    							
    							
                  			
    							li.remove();
    							
    							found = true;	
    							
    						}
                  		}
    					
    					
    					
    					if(found) {
    						
    						oos = new ObjectOutputStream(new FileOutputStream(file));
    						
    						oos.writeObject(sr);
    						
    						oos.close();
    						
    						JOptionPane.showMessageDialog(f, "Successfully deleted");
    						
    						Dashboard.main(new String[]{});
		    	    		
		        			dispose();  
 
    					} else {
    						
    						
    						JOptionPane.showMessageDialog(f, "ID not found");
    						
    					}
    						
    						
                  		
                  	}
                  	
          		   
            	
            } catch(Exception x) {
            	
            	
            	x.printStackTrace();
            }
            

    		}
    	});
    	
    	
    	
    	
    	
    	updateButton.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e)  {
    		
    			
    			try {  
    				
    				wantUpdateId = Dashboard.searchId;
    				
    				
    				UpdateStudentInfo.main(new String[]{});
    	    		
        			dispose();  
        			
    				
    			}catch(Exception x) {
    				
    				x.printStackTrace();
    				
    			}
    			
		        

    			
    			
    		}
    		
    	});
    	
    	menuButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			Dashboard.main(new String[]{});
	    		
    			dispose();
    			
    		}
    	});
    		
        
    }
 
 

 
}
