import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;


class RegistrationForm extends JFrame {
    JPanel mainFrame = new JPanel();
    JFrame detailFrame = new JFrame("Student Details");
    JTextField textFields, newTF, tfFName, tfMName, tfLName, tfStudEmail,tfStudID;
    JLabel welcomeTxt, lblGender, lblName, lblStudEmail,lblStudID, lblCourse, studDetails, studFName, studGender, studEmail, studsId, studCourse;
    JButton registerBTN, clearBTN;
    JComboBox<String> boxGender, boxCourses;
    final private Font bigFont = new Font("Arial", Font.PLAIN, 25);
    final private Font labelFont = new Font("Arial", Font.BOLD, 14);
    final private Font tfFont = new Font("Arial", Font.BOLD, 14);

    final private Color labelColor = new Color(105, 102, 102);
    final private Color tfColor = new Color(186, 185, 185);

    RegistrationForm(){
        JLabel welcomeTxt = new JLabel("Class Registration Form");
          welcomeTxt.setFont(bigFont);
          welcomeTxt.setForeground(new Color(51,51,51));
          welcomeTxt.setBounds(30, 20, 300, 30);

          lblGender = new JLabel("<html>Gender<font color='red'> *</font></html>");
          lblGender.setFont(labelFont);
          lblGender.setForeground(labelColor);
          lblGender.setBounds(30, 80, 300, 20); 

          String[] gender = {"Male", "Female"};
          boxGender = new JComboBox<>(gender);
          boxGender.setUI(new BasicComboBoxUI(){
            @Override
            protected JButton createArrowButton() {
               JButton btn = new JButton("\u25BC");
               btn.setFont(new Font("Arial", Font.BOLD, 12));
               btn.setForeground(new Color(176, 172, 172));
                btn.setContentAreaFilled(false);
                btn.setFocusPainted(false); 
                btn.setBorder(BorderFactory.createEmptyBorder());
                return btn;
            }
          });
          
          boxGender.setBorder(new LineBorder(new Color(176, 172, 172)));
          boxGender.setFocusable(false);
          boxGender.setFont(labelFont);
          boxGender.setForeground(labelColor);
          boxGender.setBackground(new Color(255, 255 ,255));
          boxGender.setBounds(30, 100, 620, 35);
          addPadding(boxGender, 5, 5, 5, 5);
 
          lblName = new JLabel("<html>Student Name<font color='red'> *</font> </html>");
          lblName.setFont(labelFont); 
          lblName.setForeground(labelColor);
          lblName.setBounds(30, 160, 300, 20);

          tfFName = new JTextField("First");
          tfFName.setFont(tfFont);
          tfFName.setBorder(new LineBorder(new Color(176, 172, 172)));
          addPadding(tfFName,5,5,5,5);
          tfFName.setForeground(tfColor);
          tfFName.setBounds(30, 180, 160, 35);

          tfFName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                 tfFName.setText("");
            }

            public void focusLost(FocusEvent e){
                String fName = tfFName.getText();
                
                if(fName.isEmpty()){
                   tfFName.setText("First");
                }else {
                tfFName.setText(fName);
                }
            }
         });

          tfMName = new JTextField("Middle");
          tfMName.setFont(tfFont);
          tfMName.setBorder(new LineBorder(new Color(176, 172, 172)));
          tfMName.setForeground(tfColor);
          tfMName.setBounds(220, 180, 160, 35);
          addPadding(tfMName,5,5,5,5);
          
          tfMName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tfMName.setText("");
            }

            public void focusLost(FocusEvent e){
                String mName = tfMName.getText();
                
                if(mName.isEmpty()){
                    tfMName.setText("Middle");
                } else {
                    tfMName.setText(mName);
                }
            }
         });

          tfLName = new JTextField("Last");
          tfLName.setFont(tfFont);
          tfLName.setBorder(new LineBorder(new Color(176, 172, 172)));
          tfLName.setForeground(tfColor);
          tfLName.setBounds(410, 180, 240, 35);
          addPadding(tfLName,5,5,5,5);

          tfLName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tfLName.setText("");
            }

            public void focusLost(FocusEvent e){
                String lName = tfLName.getText();
               
                if(lName.isEmpty()){
                    tfLName.setText("Last");
                } else {
                    tfLName.setText(lName);
                }
            }
         });

          lblStudEmail = new JLabel("<html>Student Email<font color='red'>*</font></html>");
          lblStudEmail.setFont(labelFont); 
          lblStudEmail.setForeground(labelColor);
          lblStudEmail.setBounds(30, 240, 300, 20);


          tfStudEmail = new JTextField("");
          tfStudEmail.setFont(tfFont);
          tfStudEmail.setBorder(new LineBorder(new Color(176, 172, 172)));
          tfStudEmail.setForeground(tfColor);
          tfStudEmail.setBounds(30, 260, 620, 35);
          addPadding(tfStudEmail,5,5,5,5);

        
         

          lblStudID = new JLabel("<html>Student ID<font color='red'>*</font></html>");
          lblStudID.setFont(labelFont); 
          lblStudID.setForeground(labelColor);
          lblStudID.setBounds(30, 320, 620, 20);

          tfStudID = new JTextField("");
          tfStudID.setFont(tfFont);
          tfStudID.setBorder(new LineBorder(new Color(176, 172, 172)));
          tfStudID.setForeground(tfColor);
          tfStudID.setBounds(30, 340, 620, 35);
          addPadding(tfStudID,5,5,5,5);

          tfStudID.addKeyListener(new KeyAdapter() {
            
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                }
                
            }
          });
          
          lblCourse = new JLabel("<html>List of Courses<font color='red'>*</font></html>");
          lblCourse.setFont(labelFont); 
          lblCourse.setForeground(labelColor);
          lblCourse.setBounds(30, 400, 620, 20);

          String[] courses = {"ENGL 101", "HIST101", "COMRPOG12", "TWRITE12", "ENTREP101", "PE 102", "HUM101"};
          boxCourses  = new JComboBox<>(courses);
          boxCourses.setUI(new BasicComboBoxUI(){
            @Override
            protected JButton createArrowButton() {
               JButton btn = new JButton("\u25BC");
               btn.setFont(new Font("Arial", Font.BOLD, 12));
               btn.setForeground(new Color(176, 172, 172));
                btn.setContentAreaFilled(false);
                btn.setFocusPainted(false); 
                btn.setBorder(BorderFactory.createEmptyBorder());
                return btn;
            }
          });
          
          boxCourses.setBorder(new LineBorder(new Color(176, 172, 172)));
          boxCourses.setFocusable(false);
          boxCourses.setFont(labelFont);
          boxCourses.setForeground(labelColor);
          boxCourses.setBackground(new Color(255, 255 ,255));
          boxCourses.setBounds(30, 420, 620, 35);
          addPadding(boxCourses, 5, 5, 5, 5);

          registerBTN = new JButton("REGISTER CLASS");
          registerBTN.setBounds(220, 470, 220, 40);
          registerBTN.setFont(new Font("Arial", Font.BOLD, 15));
          registerBTN.setForeground(Color.WHITE);
          registerBTN.setBackground(new Color(42, 42, 48));
          registerBTN.setFocusable(false);
          registerBTN.setBorder(BorderFactory.createEmptyBorder());
          addPadding(registerBTN, 20, 20, 20, 20);

          studFName = new JLabel();
          studGender = new JLabel();
          studEmail = new JLabel();
          studsId = new JLabel();
          studCourse = new JLabel();

          studFName.setFont(labelFont);
          studFName.setForeground(labelColor);
          studFName.setBounds(30, 10, 750, 30);
          studGender.setFont(labelFont);
          studGender.setForeground(labelColor);
          studGender.setBounds(30, 30, 500, 30);
          studEmail.setFont(labelFont);
          studEmail.setForeground(labelColor);
          studEmail.setBounds(30, 50, 750, 30);
          studsId.setFont(labelFont);
          studsId.setForeground(labelColor);
          studsId.setBounds(30, 70, 750, 30);
          studCourse.setFont(labelFont);
          studCourse.setForeground(labelColor);
          studCourse.setBounds(30, 90, 750, 30);

          registerBTN.addActionListener(new ActionListener() {
               @Override 
               public void actionPerformed(ActionEvent e){
                    String fName = tfFName.getText();
                    String mName = tfMName.getText();
                    String lName = tfLName.getText();
                    String studEm = tfStudEmail.getText();
                    String gender = (String) boxGender.getSelectedItem();
                    String studId = tfStudID.getText();
                   String course = (String) boxCourses.getSelectedItem();
              
                 

                 if(fName.isEmpty() || lName.isEmpty() || studEm.isEmpty() || studId.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill up the text fields!");
                    return;
                 }

                 if(mName.isEmpty() || mName.equals("Middle")){
                    studFName.setText("Student Name: " + lName + ", " + fName);
                    studGender.setText("Gender: " + gender);
                    studEmail.setText("Email: " + studEm);
                    studsId.setText("Student ID: " + studId);
                  studCourse.setText("Course: " + course);
                 } else {
                 studFName.setText("Student Name: " + lName + ", " + fName + " " + mName);
                 studGender.setText("Gender: " + gender);
                 studEmail.setText("Email: " + studEm);
                 studsId.setText("Student ID: " + studId);
               studCourse.setText("Course: " + course);
                 }

             
                 
                 detailFrame.add(studFName);
                 detailFrame.add(studGender);
                 detailFrame.add(studEmail);
                 detailFrame.add(studCourse);
                 detailFrame.add(studsId);
                 


                   detailFrame.setLayout(null); 
                   detailFrame.setSize(700, 300);
                   detailFrame.setVisible(true);
                   Point mainLocation = mainFrame.getLocationOnScreen();
                   Dimension mainSize = mainFrame.getSize();
                   
                   // Calculate the new location for detailFrame
                   int width = mainLocation.x + (mainSize.width - detailFrame.getWidth()) / 2;
                   int height = mainLocation.y;  // top of the mai
                   detailFrame.setLocation(width, height);
                   

               }
          });

          clearBTN = new JButton("CLEAR");
          clearBTN.setBounds(450, 475, 100, 30);
          clearBTN.setFont(new Font("Arial", Font.BOLD, 15));
          clearBTN.setForeground(Color.WHITE);
          clearBTN.setBackground(Color.BLUE);
          clearBTN.setFocusable(false);
          clearBTN.setBorder(BorderFactory.createEmptyBorder());
          addPadding(clearBTN, 20, 20, 20, 20);
   
          clearBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                detailFrame.dispose();
            }
         });
           

         this.setVisible(true);
         this.setTitle("Registration Form");
         this.setLayout(null);
         this.setSize(700, 600);
       
         
         mainFrame.setBackground(new Color(255, 255, 255));
         mainFrame.setLayout(null);
         mainFrame.setSize(700, 700);
         mainFrame.setVisible(true);
         mainFrame.add(welcomeTxt);
         mainFrame.add(lblGender);
         mainFrame.add(boxGender);
         mainFrame.add(lblName);
         mainFrame.add(tfFName);
         mainFrame.add(tfMName);
         mainFrame.add(tfLName);
         mainFrame.add(lblStudEmail);
         mainFrame.add(tfStudEmail);
         mainFrame.add(lblStudID);
         mainFrame.add(tfStudID);
         mainFrame.add(lblCourse);
         mainFrame.add(boxCourses);
         mainFrame.add(registerBTN);
         mainFrame.add(clearBTN);

         this.setResizable(false);
         this.setLocationRelativeTo(null);
         
         this.add(mainFrame);
        }

    public static void addPadding(JComponent component, int l, int r, int t, int b){
        Border paddingBorder = BorderFactory.createEmptyBorder(l,r,t,b);
        Border compoundBorder = BorderFactory.createCompoundBorder(component.getBorder(), paddingBorder);
        component.setBorder(compoundBorder);

    }

    public static void main(String[] args) {
        RegistrationForm registrationForm = new RegistrationForm();
    }
}
