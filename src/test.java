
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class test {

	public static void main(String[] args) {
		
		ArrayList set=new ArrayList();
		while(set.size()<10) {
			int rnum=(int)(Math.random()*5);
							
					set.add(rnum);
				
			
			
		}
		String[] str= {"아반떼","소나타","그렌져","제네시스","GV80"};
		for(int i=0; i<set.size(); i++) {
			System.out.println(str[(int)set.get(i)]);
		}
		System.out.println(set);
	}

	
	 
}
