import java.util.*;

class excelSheet{

	public static int checkNumber(String s){
		 int sum=0;
        for(int i=0;i<s.length();i++){
            sum *= 26;
            sum += s.charAt(i)-65+1;

        }
        return sum;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		System.out.println(checkNumber(s));
	}
}