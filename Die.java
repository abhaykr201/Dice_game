 
import java.util.Random;

public class Die {
	
	public int random() {
		
		return 1+(new Random()).nextInt(6);
	}
}
