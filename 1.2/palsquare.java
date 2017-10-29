import java.io.*;

/*
ID: kingrandomguy
LANG: JAVA
TASK: palsquare
*/

public class palsquare {
	public static char[] dict = {'0', '1', '2', '3', '4', '5', '6' ,'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
	public static String changeBase(int N, int base, StringBuilder sb) {
		if(N==0) {
			String s = sb.toString();
			String str = "";
			for(int i=s.length()-1; i>=0; i--) {
				str+=s.charAt(i);
			}
			return str;
		}
		sb.append(dict[N%base]);
		return changeBase(N/base, base, sb);
	}
	public static boolean isPalindrome(String str) {
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i) !=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter("palsquare.out");
		int B = Integer.parseInt(f.readLine());
		f.close();
		for(int i=1; i<300; i++) {
			String numSquare = changeBase(i*i, B, new StringBuilder());
			if(!isPalindrome(numSquare)) {
				continue;
			}
			String num = changeBase(i, B, new StringBuilder());
			out.println(num + " " + numSquare);
		}
		out.close();
	}
}
