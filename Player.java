
public class Player {
	private String str;
	int die_arr[] = new int[6];
	static int j=0;
	Player() {
		for(int i = 0; i < 6; i++) {
			die_arr[i] = -1;
		}
		this.j=0;
	}
	
	public int play() {
		
		String str="";
		Die die = new Die();
		int rnd = die.random();
		System.out.print("\nNumber rolled: "+rnd);
		
		str=""+rnd;
		this.str=str;
		die_arr[rnd-1] = rnd;
		
		if(check()) {
			return -1;
		}
		System.out.print("\nSo far, you have:");
		
		for(int i = 0; i < 6; i++) {
			if(die_arr[i]!=-1) {
				System.out.print(" "+die_arr[i]);
				
			}
		}
		j++;
		
		return 1;
		
	}
	
	private boolean check() {
		
		for(int i = 0; i < 6; i++) {
			if( die_arr[i] == -1) {
				return false;
			}
		}
		
		return true;
	}
	public String toString() {
		return this.str;
	}
}
