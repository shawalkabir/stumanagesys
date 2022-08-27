import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
 
public class Dashboard extends JFrame {
	
	private Container container = getContentPane();
	private JButton infoButton = new JButton("Student's Information"); 
    private JButton addButton = new JButton("Add Student");
    private JButton logoutButton = new JButton("Logout");
    
    static String searchId;
  
    public static void main(String[] args) {
    	
    	
    	try {
    		
    		Dashboard frame = new Dashboard();
            
            frame.setTitle("Student Management System");
            frame.setVisible(true);
            frame.setBounds(600, 100, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
    		
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	
    	
 
    }
 
 
    public Dashboard() {
    	
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
    	
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	
    	infoButton.setBounds(80,100,200,60);
    	
    	addButton.setBounds(80, 200, 200, 60);
    	
        logoutButton.setBounds(80, 300, 200, 60);
        
    }
 
    public void addComponentsToContainer() {
    	
    	container.add(infoButton);
    	container.add(addButton);
        container.add(logoutButton);
        
    }
    
    
    public void addActionEvent() {
    	
    	JFrame f = new JFrame();
    	
    
        addButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			try {
    				
    				AddStudentInfo.main(new String[]{});
    	    		
        			dispose();  
    				
    			}catch (Exception x) {
    				
    				x.printStackTrace();
    				
    			}
	
    		}
    	});
        
        infoButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			try {
    				
    				
			        searchId = JOptionPane.showInputDialog(f,"Enter Student ID");  
			        
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
		              		    	            		
		              		if(s.sId.equals(searchId) && s.tId.equals(TeacherRegistration.tchId)) {
		              			
		              			found = true;
		              			
		              		} 
		              		
		              	}
		              	
		              	if(!found) {
		              		
		              		JOptionPane.showMessageDialog(f, "ID not found");   	            		
		              		
		              	}else {
		              		
		              		ShowStudent.main(new String[]{});
		     				
		     				dispose();
		              	}

		              	
		      		} else {
		              	
		              	JOptionPane.showMessageDialog(f, "Invalid ID or file not found");
		              	
		      		} 
			        
			       
				

    				
    			}catch (Exception x) {
    				
    				x.printStackTrace();
    				
    			}
	
    		}
    	});
        
        
        logoutButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			try {
    				
    				LoginOrRegistration.main(new String[]{});
    	    		
        			dispose();  
    				
    			}catch (Exception x) {
    				
    				x.printStackTrace();
    				
    			}
	
    		}
    	});
        

    }
}


   