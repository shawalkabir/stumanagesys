import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
 
public class TeacherLogin extends JFrame{
	
	private Container container = getContentPane();
    private JLabel idLabel = new JLabel("ID");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField idField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("LOGIN");
    
    private JLabel regLabel = new JLabel("Not Registered ?");
    
    private JButton regButton = new JButton("REGISTER");
    
    
    public static void main(String[] a) {
    	
        TeacherLogin frame = new TeacherLogin();
        
        frame.setTitle("Student Management System");
        frame.setVisible(true);
        frame.setBounds(600, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        
 
    }
 
 
    TeacherLogin() {
    	
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        
 
    }
 
    public void setLayoutManager() {
    	
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	idLabel.setBounds(50, 80, 100, 30);
        passwordLabel.setBounds(50, 140, 100, 30);
        idField.setBounds(150, 80, 150, 30);
        passwordField.setBounds(150, 140, 150, 30);
        loginButton.setBounds(130, 200, 100, 30);
        
        regLabel.setBounds(135, 270, 100, 30);
        
        regButton.setBounds(130, 320,100,30);
    }
 
    public void addComponentsToContainer() {
    	
    	container.add(idLabel);
        container.add(passwordLabel);
        container.add(idField);
        container.add(passwordField);
        container.add(loginButton);
        
        container.add(regLabel);
        container.add(regButton);;
        
    }
 
    public void addActionEvent() {
    	
    	loginButton.addActionListener(new ActionListener() {
    		
    		JFrame f = new JFrame();

			public void actionPerformed(ActionEvent e) {
     			
     			try {
     				
     				File file = new File("F:\\eclipse-workspace\\Student Manage System\\teacher.txt");
     				
     				
     				ArrayList<Teacher> thr = new ArrayList<Teacher>();

     				
     				ObjectOutputStream oos = null;
    	            ObjectInputStream ois = null;
     				ListIterator li = null;
     				
    	            
    	            if(file.isFile()) {
    	            	
    	            	boolean found = false;
    	            	
    	            	ois = new ObjectInputStream(new FileInputStream(file));
    	            	
    	            	thr = (ArrayList<Teacher>)ois.readObject();
    	            	
    	            	ois.close();
    	            	
    	            	String logID;
        			
        	            String logPwd;
        	            
        	            logID = idField.getText();
        	        
        	            logPwd = String.valueOf(passwordField.getPassword());
        	            
        	            
        	            li = thr.listIterator();
    	            	
    	            	
    	            	while(li.hasNext()) {
    	            		
    	            		Teacher t = (Teacher)li.next();
    	            		    	            		
    	            		if(t.tId.equals(logID) && t.tPass.equals(logPwd)) {
    	            			
    	            				found = true;
    	            				
    	            				TeacherRegistration.tchId = t.tId;
    	            				
    	            		} 
    	            	}
    	            	
    	            	if(found == true) {
    	            		
    	            		
    	            		
            				Dashboard.main(new String[]{});

	    	     			dispose();
	    	     			
    	            	}else {
    	            		
    	            		JOptionPane.showMessageDialog(f, "Invalid ID or Password");
    	            		
    	            	}
    	            	
    	            	
    	            	
    	            } else {
    	            	
    	            	JOptionPane.showMessageDialog(f, "Invalid ID or Password");
    	            	
    	            }
     				
     			}catch(Exception x) {
     				
     				x.printStackTrace();
     			}
     			
     			
     		
     		}
     	});
    	
    	
    	regButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			
    			try {
    				
    				TeacherRegistration.main(new String[]{});
    	    		
        			dispose();
    				
    				
    			} catch (Exception x) {
    				
    				x.printStackTrace();
    			}
    			
    			
    			
    		}
    	});

   }
 
 

 
}
 
