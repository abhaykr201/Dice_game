import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SixNumbersPanel2 extends JFrame implements ActionListener{
	
	Player pl1=new Player();
	Player pl2=new Player();
	Player pl;
	JFrame frame; 
    JTextField roll;
    JTextField text[];
    JTextArea area;
    JTextField player_ ;
    int winner=0;
    
    SixNumbersPanel2(){
    	
    	frame = new JFrame("Six Numbers Game");
    	
        player_ = new JTextField();
        player_.setBounds(100, 5, 60, 30);
        player_.setEditable(false);
        player_.setText("Player 1");
        frame.add(player_);
        pl = pl1;
        
        
        JLabel label1 = new JLabel();
		label1.setText("A number between 1 to 6 will appear ");
		
		JLabel label2 =new JLabel();
		label2.setText("once in each of the following textfields");
		
		
		
		label1.setBounds(20, 40, 300, 15);
		label2.setBounds(20, 55, 300, 15);
		
		frame.add(label1);
		frame.add(label2);
		
        //adding text field for roll show
		this.text = new JTextField[6];
		int sum=0;
        for (int i =0; i < 6 ; i++ )
        {
            this.text[i] = new JTextField(3);
            sum =i*30+10;
            this.text[i].setBounds(30+sum, 75, 30, 30);
            frame.add(this.text[i]);
            
        }

        
        
        JButton button = new JButton("Roll Die");
        button.setBounds(50, 115, 100, 30);
        button.addActionListener(this);
        frame.add(button);
        
        roll = new JTextField(2);
        roll.setBounds(160, 115, 50, 30);
        roll.setEditable(false);
        frame.add(roll);
        
        area = new JTextArea();
        area.setBounds(30, 165, 200, 100);
        area.setEditable(false);
        frame.add(area);
        
        JButton button1 = new JButton("New Game");
        button1.setBounds(150, 300, 100, 30);
        button1.addActionListener(this);
        frame.add(button1);

        
        frame.setSize(300, 400);
        frame.setLayout(null); 
        frame.getContentPane().setBackground( Color.CYAN );
    }
    public void actionPerformed(ActionEvent event) {
    	// TODO Auto-generated method stub
    	
    	if (event.getSource() instanceof JButton && winner ==0)
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
    				winner =1;
    				if(pl ==pl1) {
	    				s1 = "    Player 1 is winner \n    after "+pl.j+" rolls" ;
	    				
    				}
    				else{
	    				s1 = "    Player 2 is winner \n    after "+pl.j+" rolls" ;
	    				
    				}
    				
    			}
    			for(int k = 0; k < 6; k++) {
    				if(pl.die_arr[k]!=-1) {
    					//System.out.print(" "+pl.die_arr[k]);
    					String no = ""+pl.die_arr[k];
    					text[k].setText(no);
    				}
    				else {
    					text[k].setText("");
    				}
    			}
    			area.setText(s1);
    			
    			if(pl == pl1) {
        			pl = pl2;
        			player_.setText("Player 2");
        		}
        		else {
        			pl = pl1;
        			player_.setText("Player 1");
        		}
    			
            }
    		if(clickedButton.getText().equals("New Game")) {
    			
    			pl1 = new Player();
    			pl2 = new Player();
    			pl = pl1;
    			player_.setText("Player 1");
    			for(int k = 0; k < 6; k++) {
    				text[k].setText("");
    				
    			}
    			area.setText("");
    			roll.setText("");
    		}
    		
        }
    	
    }
    	
    	public static void main(String[] args) {
    		SixNumbersPanel2 ob = new SixNumbersPanel2();
    		ob.frame.setVisible(true);
    		
    		
    	}  


}
