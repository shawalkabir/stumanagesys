import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStudentInfo extends JFrame{
	
	private Container container = getContentPane();
	private JLabel title = new JLabel("Update Student Information");
    private JLabel idLabel = new JLabel("Id");
    private JLabel nameLabel = new JLabel("Name");
    private JLabel majorLabel = new JLabel("Major");
    private JLabel creditLabel = new JLabel("Credit completed");
    private JLabel genderLabel = new JLabel("Gender");
    private JLabel attendLabel = new JLabel("Attendence (days)");
    private JLabel cgpaLabel = new JLabel("CGPA");

    static JLabel idField = new JLabel();
    
    
    private JTextField nameField = new JTextField();
    private JTextField majorField = new JTextField();
    private JTextField creditField = new JTextField();
    private JTextField genderField = new JTextField();
    private JTextField attendField = new JTextField();
    private JTextField cgpaField = new JTextField();
    
    private JButton upButton = new JButton("UPDATE DATA");
    
    public static void main(String[] a) throws Exception{
    	
    	UpdateStudentInfo frame = new UpdateStudentInfo();
    	        
        frame.setTitle("Student Management System");
        frame.setVisible(true);
        frame.setBounds(600, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        
        idField.setText(ShowStudent.wantUpdateId);
 
    }
 
 
    UpdateStudentInfo() {
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
        
        upButton.setBounds(140,570,220,50);
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
        
        container.add(upButton);
        
    }
    
    
    public void addActionEvent() {
    	
    	upButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)  {
    			
    			
    			try {
    				
    				JFrame f = new JFrame();
    				
    				boolean found = false;
    				

    				File file = new File("F:\\eclipse-workspace\\Student Manage System\\students.txt");
	            
    				ArrayList<Student> std = new ArrayList<Student>();
	            
	            
	            
    				ObjectOutputStream oos = null;
    				ObjectInputStream ois = null;
    				ListIterator li = null;
	            
	            
    				if(file.isFile()) {
	            	
    					ois = new ObjectInputStream(new FileInputStream(file));
	            	
    					std = (ArrayList<Student>)ois.readObject();
	            	
    					ois.close();
	            	
	            
	            	
    					String tId,stdID, stdName, stdMajor, stdCredCom, stdGender, stdAttend, stdCgpa;
 			   
	            
			            stdID = idField.getText();
			            stdName = nameField.getText();
			            stdMajor = majorField.getText();
			            stdCredCom = creditField.getText();
			            stdGender = genderField.getText();
			            stdAttend = attendField.getText();
			            stdCgpa = cgpaField.getText();
			            tId = TeacherRegistration.tchId;
			            
			            
			            if(stdName.isEmpty() || stdMajor.isEmpty()  || stdCredCom.isEmpty()  || stdGender.isEmpty()  || stdAttend.isEmpty()  || stdCgpa.isEmpty()) {
			            	
			            	
			            	JOptionPane.showMessageDialog(f, "Cannot update. Any of the field in empty");
			            	
			            	
			            }else {
			            	
			            	li = std.listIterator();
			              	
			              	
				            while(li.hasNext()) {
	          		
				            	Student s = (Student)li.next();
	          		    	            		
				            	if(s.sId.equals(ShowStudent.wantUpdateId)) {
							
	          			
				            		li.set(new Student(tId,stdID, stdName, stdMajor, stdCredCom, stdGender, stdAttend, stdCgpa));
							
				            		found = true;	
							
				            	}
				            }
					
				            if(found) {
						
				            	oos = new ObjectOutputStream(new FileOutputStream(file));
						
				            	oos.writeObject(std);
						
				            	oos.close();
				            	
				            	
				            	JOptionPane.showMessageDialog(f, "Updated Successfully");
				            	
				            	
				            	Dashboard.main(new String[]{});
			    	    		
			        			dispose();
						
				            }else {
						
						
				            	JOptionPane.showMessageDialog(f, "ID not found");
						
				            }	
			            	
			            }
	            
	            
			            

    				}
    				
    			} catch(Exception x) {
    				
    				x.printStackTrace();
    				
    			}

    		}
    	});
    	
    }
    	
    
}    
    