import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LoginOrRegistration extends JFrame {
	
	private Container container = getContentPane();
	private JLabel title = new JLabel("Welcome to Student Management System");
	private JButton regButton = new JButton("Teacher Registration"); 
    private JButton loginButton = new JButton("Teacher Login");
  
    public static void main(String[] args) {
    	
    	
    	try {
    		
    		LoginOrRegistration frame = new LoginOrRegistration();
            
            frame.setTitle("Student Management System");
            frame.setVisible(true);
            frame.setBounds(600, 100, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
    		
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	
    	
 
    }
 
 
    public LoginOrRegistration() {
    	
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
    	
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	
    	title.setBounds(50,60,260,60);
    	
    	regButton.setBounds(80, 200, 200, 60);
    	
        loginButton.setBounds(80, 300, 200, 60);
        
    }
 
    public void addComponentsToContainer() {
    	
    	container.add(title);
    	container.add(regButton);
        container.add(loginButton);
        
    }
    
    
    public void addActionEvent() {
    
        regButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			try {
    				
    				TeacherRegistration.main(new String[]{});
    	    		
        			dispose();
    				
    			}catch (Exception x) {
    				
    				x.printStackTrace();
    				
    			}
    			
    			
    		
    		}
    	});
        
        loginButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    		TeacherLogin.main(new String[]{});
    		
    		dispose();
    		
    		}
    	});
        
    	
    }
}


   