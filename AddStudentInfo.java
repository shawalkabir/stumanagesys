import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * This class implements a Student class that can store student information.
 * @author Shawal
 * @version 1.0
 */

class Student extends Teacher implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6275937894273494176L;
	String sId, sName, sMajor, sCredCom, sGender, sAttend, sCgpa;
	

	/**
	 * This constructs a student with teacher id, student id, student name, student major, student credit completed,
	 *  student gender, student attendance and student CGPA.
	 * @param tId the teacher id of the student
	 * @param sId the id of the student
	 * @param sName the name of the student
	 * @param sMajor the major of the student
	 * @param sCredCom the credit completed of the student
	 * @param sGender the gender of the student
	 * @param sAttend the attendance of the student 
	 * @param sCgpa the CGPA of the student
	 */
	public Student(String tId, String sId, String sName, String sMajor, String sCredCom, String sGender,String  sAttend, String sCgpa){
		
		
		super(tId);
		
		this.sId = sId;
		this.sName = sName;
		this.sMajor = sMajor;
		this.sCredCom = sCredCom;
		this.sGender = sGender;
		this.sAttend = sAttend;
		this.sCgpa = sCgpa;
		
	}

	/**
	 * This returns the information of this student
	 * @return this student's information
	 */
	public String toString() {
		
		return sId + " " + sName + " " + sMajor + " " + sCredCom + " " + sGender + " " + sAttend + " " + sCgpa;
	}
	
	
}

public class AddStudentInfo extends JFrame{
	
	
	private Container container = getContentPane();
	private JLabel title = new JLabel("Add Student Information");
    private JLabel idLabel = new JLabel("Id");
    private JLabel nameLabel = new JLabel("Name");
    private JLabel majorLabel = new JLabel("Major");
    private JLabel creditLabel = new JLabel("Credit completed");
    private JLabel genderLabel = new JLabel("Gender");
    private JLabel attendLabel = new JLabel("Attendence (days)");
    private JLabel cgpaLabel = new JLabel("CGPA");
    
    
    
    
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField majorField = new JTextField();
    private JTextField creditField = new JTextField();
    private JTextField genderField = new JTextField();
    private JTextField attendField = new JTextField();
    private JTextField cgpaField = new JTextField();
    
    private JButton addButton = new JButton("ADD DATA");
    private JButton menuButton = new JButton("MENU");
    
    public static void main(String[] a) throws Exception{
    	
    	AddStudentInfo frame = new AddStudentInfo();
    	        
        frame.setTitle("Student Management System");
        frame.setVisible(true);
        frame.setBounds(600, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }
 
 
    AddStudentInfo() {
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
    	idLabel.setBounds(50, 80, 100, 30);
        nameLabel.setBounds(50, 150, 100, 30);
        majorLabel.setBounds(50, 220, 100, 30);
        creditLabel.setBounds(50, 290, 100, 30);
        genderLabel.setBounds(50, 360, 100, 30);
        attendLabel.setBounds(50, 430, 100, 30);
        cgpaLabel.setBounds(50, 500, 100, 30);



        idField.setBounds(180, 80, 250, 30);
        nameField.setBounds(180, 150, 250, 30);
        majorField.setBounds(180, 220, 250, 30);
        creditField.setBounds(180, 290, 250, 30);
        genderField.setBounds(180, 360, 250, 30);
        attendField.setBounds(180, 430, 250, 30);
        cgpaField.setBounds(180, 500, 250, 30);
        
        addButton.setBounds(290,570,100,50);
        menuButton.setBounds(100,570,100,50);
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
      
        container.add(idField);
        container.add(nameField);
        container.add(majorField);
        container.add(creditField);
        container.add(genderField);
        container.add(attendField);
        container.add(cgpaField);
        
        container.add(addButton);
        container.add(menuButton);
        
    }
    
    
    public void addActionEvent() {
    	
    	
    	addButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			JFrame f = new JFrame();
    			
    			try {
    				
    				File file = new File("F:\\eclipse-workspace\\Student Manage System\\students.txt");
    	            
    	            ArrayList<Student> std = new ArrayList<Student>();
    	            
    	            ObjectOutputStream oos = null;
    	            ObjectInputStream ois = null;
    	            
    	            
    	            if(file.isFile()) {
    	            	
    	            	ois = new ObjectInputStream(new FileInputStream(file));
    	            	
    	            	std = (ArrayList<Student>)ois.readObject();
    	            	
    	            	ois.close();
    	            	
    	            }
    	            	
    				
    				String tId, stdID, stdName, stdMajor, stdCredCom, stdGender, stdAttend, stdCgpa;
   
    	            
    	            stdID = idField.getText();
    	            stdName = nameField.getText();
    	            stdMajor = majorField.getText();
    	            stdCredCom = creditField.getText();
    	            stdGender = genderField.getText();
    	            stdAttend = attendField.getText();
    	            stdCgpa = cgpaField.getText();
    	            tId = TeacherRegistration.tchId;
    	            
    	            std.add(new Student(tId,stdID, stdName, stdMajor, stdCredCom, stdGender, stdAttend, stdCgpa));
    	            
    	            oos = new ObjectOutputStream(new FileOutputStream(file));
    	            
    	            oos.writeObject(std);
    	            
    	            oos.close();
    				
	            	
	            	int a = JOptionPane.showConfirmDialog(f,"Added successfully. Want to add another one?");
	            	
	            	if(a == JOptionPane.YES_OPTION){  
	            		
	            		AddStudentInfo.main(new String[]{});
	    	    		
	        			dispose();  
	            	    
	            	}  else if(a == JOptionPane.NO_OPTION) {
	            		
	            		Dashboard.main(new String[]{});
	    	    		
	        			dispose();
	            	}
    				
    				
    			}catch (Exception x) {
    				
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