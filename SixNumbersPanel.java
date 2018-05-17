import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SixNumbersPanel extends JFrame implements ActionListener{
	Player pl=new Player();
	JFrame frame; 
	
    JTextField roll;
    
    JTextField text[];
    JTextArea area;
    
    
    SixNumbersPanel(){
    	
    	frame = new JFrame("Six Numbers Game");
    	
        
        JLabel label1 = new JLabel();
		label1.setText("A number between 1 to 6 will appear ");
		
		JLabel label2 =new JLabel();
		label2.setText("once in each of the following textfields");
		
		
		
		label1.setBounds(20, 20, 300, 15);
		label2.setBounds(20, 35, 300, 15);
		
		frame.add(label1);
		frame.add(label2);
		
        //adding text field for roll show
		this.text = new JTextField[6];
		int sum=0;
        for (int i =0; i < 6 ; i++ )
        {
            this.text[i] = new JTextField(3);
            sum =i*30+10;
            this.text[i].setBounds(30+sum, 60, 30, 30);
            frame.add(this.text[i]);
            
        }

        
        
        JButton button = new JButton("Roll Die");
        button.setBounds(50, 100, 100, 30);
        button.addActionListener(this);
        frame.add(button);
        
        roll = new JTextField(2);
        roll.setBounds(160, 100, 50, 30);
        roll.setEditable(false);
        frame.add(roll);
        
        area = new JTextArea();
        area.setBounds(30, 150, 200, 200);
        area.setEditable(false);
        frame.add(area);

        
        frame.setSize(300, 400);
        frame.setLayout(null); 
        frame.getContentPane().setBackground( Color.CYAN );
    }


@Override
public void actionPerformed(ActionEvent event) {
	// TODO Auto-generated method stub
	
	if (event.getSource() instanceof JButton)
    {
		JButton clickedButton = (JButton) event.getSource();
		int i=1;
		if(clickedButton.getText().equals("Roll Die"))
        {
			String s1;
			i=pl.play();
			roll.setText(pl.toString());
			
				s1 = "No of rolls: " + pl.j;
				
			
			if(i==-1) {
				s1 = "    Congratulations you have \n    taken "+
						pl.j+"  rolls  to get one \n    of each number between  \n1 and 6" ;
			}
			for(int k = 0; k < 6; k++) {
				if(pl.die_arr[k]!=-1) {
					//System.out.print(" "+pl.die_arr[k]);
					String no = ""+pl.die_arr[k];
					text[k].setText(no);
				}
			}
			area.setText(s1);
			
        }
    }
	
}
	
	public static void main(String[] args) {
		SixNumbersPanel ob = new SixNumbersPanel();
		ob.frame.setVisible(true);
		
		
	}  
}