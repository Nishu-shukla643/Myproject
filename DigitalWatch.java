import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.text.*;  
import java.util.*;

public class DigitalWatch implements Runnable{  
JFrame f;  
Thread t1=null;  
int hours=0, minutes=0, seconds=0,tq=0;  
String timeString = ""; 
JButton b;  
  JProgressBar jb;    
int i=0,num=0;     
DigitalWatch(){  
    f=new JFrame();  
      JOptionPane.showMessageDialog(f,"Press OK to get current time in 12 hour format.");  
    t1 = new Thread(this);  
        t1.start();  
      JLabel l1,l2,l3;  
    l1=new JLabel("Digital Clock in 12 hour format");  
    l2=new JLabel("Right click to change color of the clock");
    l3 =new JLabel("Time Remaining");
  b=new JButton();

        b.setBounds(100,40,100,50);   
      l1.setBounds(50,50,200,500);
      l2.setBounds(50,70,200,500);
     l3.setBounds(100,150,100,50);
    
f.add(l1); f.add(l2); f.add(l3);
    f.add(b);
final JPopupMenu popupmenu = new JPopupMenu("Change color");   
         JMenuItem rd = new JMenuItem("Red");  
         JMenuItem ye = new JMenuItem("Yellow");  
         JMenuItem bl = new JMenuItem("Blue");  
         popupmenu.add(rd); popupmenu.add(ye); popupmenu.add(bl);    
 f.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {              
                popupmenu.show(f , e.getX(), e.getY());  
            }                 
         });  
         f.add(popupmenu);  
rd.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e) {              
             b.setBackground(Color.RED);  
         }  
        });   
ye.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e) {              
             b.setBackground(Color.YELLOW);  
         }  
        });   
   bl.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e) {              
             b.setBackground(Color.BLUE);  
         }  
        });    
jb=new JProgressBar(0,86400);    
jb.setBounds(40,100,160,30);        
jb.setValue(0);    
jb.setStringPainted(true);    
f.add(jb);    

   
    f.setSize(300,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
  
 public void run() {  
      try {  
         while (true) {  
  
            Calendar cal = Calendar.getInstance();  
            hours = cal.get( Calendar.HOUR_OF_DAY );  
             tq=hours;
            if ( hours > 12 ) hours -= 12;  
            minutes = cal.get( Calendar.MINUTE );  
            seconds = cal.get( Calendar.SECOND );  
  
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
            Date date = cal.getTime();  
            timeString = formatter.format( date );  
            
            printTime();  
            
        iterate();
  
            
         }  
      }  
      catch (Exception e) { }  
 }  
  
public void printTime(){  
b.setText(timeString);
  
}  
  public void iterate(){    
while(i<=86400){ 
i=(tq*3600)+(minutes*60)+seconds;   
  jb.setValue(i);    
      
  try{t1.sleep(1000);}catch(Exception e){}    
}    
}    
  
public static void main(String[] args) {  
   new DigitalWatch();  
          
  
}  }