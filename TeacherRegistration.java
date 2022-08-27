import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Teacher implements Serializable{

	private static final long serialVersionUID = -7061580730609223360L;
	
	String tId;
	String tName;
	String tPass;
	
	public Teacher(String tId){
		
		this.tId = tId;
	}
	
	
	public Teacher(String tId, String tName, String tPass){
		
		this.tId = tId;
		this.tName = tName;
		this.tPass = tPass;		
	}
	
	
	public String toString() {
		
		return tId + " " + tName + " " + tPass;
	}
	
}

 
public class TeacherRegistration extends JFrame{
	
	private Container container = getContentPane();
    private JLabel idLabel = new JLabel("ID");
    private JLabel nameLabel = new JLabel("NAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton regButton = new JButton("REGISTER");
    
    private JLabel logLabel = new JLabel("Already Registered ?");
    private JButton logButton = new JButton("LOGIN");
    
    public static String tchId;
    
    public static void main(String[] a) throws Exception{
    	
    	TeacherRegistration frame = new TeacherRegistration();
        
        frame.setTitle("Student Management System");
        frame.setVisible(true);
        frame.setBounds(600, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
 
 
    TeacherRegistration() {
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
        nameLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        idField.setBounds(150, 80, 150, 30);
        nameField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        
        regButton.setBounds(100, 280, 150, 30);
        
        logLabel.setBounds(120, 340, 170, 30);
        
        logButton.setBounds(130, 370,100,30);
    }
 
    public void addComponentsToContainer() {
    	container.add(idLabel);
        container.add(nameLabel);
        container.add(passwordLabel);
        container.add(idField);
        container.add(nameField);
        container.add(passwordField);
        container.add(regButton);
        container.add(logLabel);
        container.add(logButton);
        
    }
    
 
    public void addActionEvent() {
    	
    	
    	regButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			try {
    				
    				JFrame f = new JFrame();
    				
    				File file = new File("F:\\eclipse-workspace\\Student Manage System\\teacher.txt");
    	            
    	            ArrayList<Teacher> thr = new ArrayList<Teacher>();
    	            
    	            ObjectOutputStream oos = null;
    	            ObjectInputStream ois = null;
    	            
    	            
    	            if(file.isFile()) {
    	            	
    	            	ois = new ObjectInputStream(new FileInputStream(file));
    	            	
    	            	thr = (ArrayList<Teacher>)ois.readObject();
    	            	
    	            	ois.close();
    	            	
    	            }
    	            
    				
    				
    				String teacherID;
    				
    				String teacherName;
    				
    	            String teacherPwd;
    	            
    	            teacherID = idField.getText();
    	            teacherName = nameField.getText();
    	            teacherPwd = String.valueOf(passwordField.getPassword());
    	            
    	            
    	            if(teacherID.isEmpty() || teacherName.isEmpty()  || teacherPwd.isEmpty()) {
		            	
		            	
		            	JOptionPane.showMessageDialog(f, "Field cannot be empty");
		            	
		            	
		            }else {
		            	
		            	thr.add(new Teacher(teacherID,teacherName,teacherPwd));
	    	            
	    	            oos = new ObjectOutputStream(new FileOutputStream(file));
	    	            
	    	            oos.writeObject(thr);
	    	            
	    	            oos.close();
	    	            
	    	            
	    	            tchId = teacherID;
	    				
	    				Dashboard.main(new String[]{});
	    	    		
	        			dispose();
		            	
		            }
    	            
    				
    			}catch (Exception x) {
    				
    				x.printStackTrace();
    				
    			}
    			
    			
    		
    		}
    	});
    	
    	
    	logButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			
    			try {
    				
    				TeacherLogin.main(new String[]{});
    	    		
        			dispose();
    				
    				
    			} catch (Exception x) {
    				
    				x.printStackTrace();
    			}
    			
    			
    			
    		}
    	});
        
    }
 
 

 
}
 
