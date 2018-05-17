
public class TestSixNumbers {
	public static void main(String args[]) {
		Player pl=new Player();
		int i = 1,j=0;
		
		while(i==1) {
			i = pl.play();
			System.out.print(pl.toString());
			j++;
		}
		System.out.println("\nCongratulations, you have taken "+j+" rolls to get one of  each\nnumber between 1 and 6");
	}
}
