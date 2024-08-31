import java.util.*;

class AlphaArrangements{
	
	

	public static void arrangeString(String input){
		
		ArrayList<Character> small = new ArrayList<>();
		ArrayList<Character> capital = new ArrayList<>();
		
		for(char c: input.toCharArray()){
			if(c >= 'a' && c <= 'z'){
				small.add(c);
			}else{
				capital.add(c);
			}
		}
		Collections.sort(small);
		Collections.sort(capital);
		StringBuilder sb = new StringBuilder();
		int s = 0,c = 0;
		for(char ch : input.toCharArray()){
			if(ch >= 'a' && ch <= 'z'){
				sb.append(small.get(s++));
			}else{
				sb.append(capital.get(c++));
			}
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		arrangeString(input);
	}
}