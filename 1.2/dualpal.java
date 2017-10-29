import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
ID: kingrandomguy
LANG: JAVA
TASK: dualpal
*/

public class dualpal {
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
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter("dualpal.out");
		StringTokenizer st = new StringTokenizer(f.readLine());
		f.close();
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int count = 0;
		int num = S;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(nums.size()<N) {
			count = 0;
			num++;
			for(int i=2; i<=10; i++) {
				String baseChanged = changeBase(num, i, new StringBuilder());
				if(isPalindrome(baseChanged)) {
					count++;
					if(count==2) {
						nums.add(num);
						break;
					}
				}
			}
		}
		for(int i=0; i<nums.size(); i++) {
			out.println(nums.get(i));
		}
		out.close();
	}
}
