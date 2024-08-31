import java.util.*;

class encrypt{
	
	public static void checkFrequency(String s,int x){
		
		Map<Character,Integer> map = new HashMap<>();
		char[] arr = s.toCharArray();
		for(int i=0;i<arr.length;i++){
			char c = arr[i];
			int count = 0;
			for(int j=0;j<arr.length;j++){
				if(arr[j] == c){
					count++;
				}
			}
			map.put(c,count);
		}
		StringBuilder sb = new StringBuilder();
		for (char curr : arr) {
            int value = map.get(curr);
            if (value % 2 == 0) {
                int diff = ((curr - 'a' + x) % 26) + 'a'; 
                sb.append((char)diff);
            } else {
                int diff = ((curr - 'a' - x + 26) % 26) + 'a'; 
                sb.append((char)diff);
            }
        }
		
		System.out.println(sb.toString());
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int x = sc.nextInt();
		
		checkFrequency(input,x);
	}
}	