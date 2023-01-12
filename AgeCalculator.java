import java.awt.*;  
import java.awt.event.*;  
import java.time.LocalDate;  
import java.time.Period;  
class AgeCalculator extends WindowAdapter implements ActionListener{ 
  Frame f; 
  TextField tf1,tf2,tf3;
  Label l1,l2,l3,l4,tf4;
  Label ans,wel,ent,form;
  Button calc,rset;
  AgeCalculator(){  
    f= new Frame("AGE CALCULATOR");
    f.setBackground(Color.red);
    ent=new Label("Enter Your DOB : "); 
    ent.setBounds(60,65,100,45);
    form=new Label("DD  -  MM  -  YYYY"); 
    form.setBounds(170,100,110,35);

    wel=new Label("\nWelcome to Age Calculator"); 
    wel.setBackground(Color.white);
    wel.setBounds(10,10,340,60);

    tf1=new TextField(); 
    tf1.setBackground(Color.yellow);
    tf1.setBounds(240,75,40,20);

    tf2=new TextField(); 
    tf2.setBackground(Color.yellow);
    tf2.setBounds(205,75,25,20);

    tf3=new TextField(); 
    tf3.setBackground(Color.yellow);
    tf3.setBounds(170,75,25,20);

    tf4=new Label(); 
    tf4.setBackground(Color.yellow);
    tf4.setBounds(30,140,300,50);

    calc=new Button("Calculate");
    calc.setBounds(30,200,140,50);
    calc.addActionListener(this); 

    rset=new Button("Reset");
    rset.setBounds(190,200,140,50);
    rset.addActionListener(this); 

    f.addWindowListener(this);
    //ADDING TO FRAME   
    f.add(wel);
    f.add(ent);
    f.add(form);
    f.add(tf3); 
    f.add(tf2);
    f.add(tf1);
    f.add(tf4);
    f.add(calc);
    f.add(rset);

    f.setSize(360,270);  
    f.setLayout(null);  
    f.setVisible(true);  
  } 
  public void windowClosing(WindowEvent e) {
    f.dispose();
  }

  public void actionPerformed(ActionEvent e){ 
    if(e.getSource()==calc){  
      if(tf1.getText()==""||tf2.getText()==""||tf3.getText()==""||tf4.getText()==""){
        tf4.setText("Enter valid information");
        return;
      }
      LocalDate dob = LocalDate.parse(tf1.getText()+"-"+tf2.getText()+"-"+tf3.getText());  
      tf4.setText("You are "+calculateAge(dob)+" years old");
    }
    if(e.getSource()==rset){  
      tf1.setText("");
      tf2.setText("");
      tf3.setText("");
      tf4.setText("");
    }
  }  

  public static int calculateAge(LocalDate dob){    
    LocalDate curDate = LocalDate.now();  
    if ((dob != null) && (curDate != null)){  
      return Period.between(dob, curDate).getYears();  
    }else{  
      return 0;  
    }  
  } 
  public static void main(String args[]){  
    new AgeCalculator();  
  }
}
