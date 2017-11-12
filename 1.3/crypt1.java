import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
ID: kingrandomguy
LANG: JAVA
TASK: crypt1
*/
public class crypt1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter("crypt1.out");
		int N = Integer.parseInt(f.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		f.close();
		int[] firstNums = new int [N * N * N];
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					int val = nums[i]*100 + nums[j] * 10 + nums[k];
					String valStr = val+"";
					if(valStr.length()!=3) {
						continue;
					}
					firstNums[idx++] = nums[i]*100 + nums[j] * 10 + nums[k];
				}
			}
		}
		idx=0;
		int[] secondNums = new int [N * N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int val1 = nums[i]*10 + nums[j];
				String val1Str = val1+"";
				if(val1Str.length()!=2) {
					continue;
				}
				secondNums[idx++] = nums[i]*10 + nums[j];
			}
		}
		Arrays.sort(firstNums);
		ArrayList<Integer> firstNum = new ArrayList<Integer>();
		removeDuplicates(firstNums, firstNum);
		ArrayList<Integer> secondNum = new ArrayList<Integer>();
		removeDuplicates(secondNums, secondNum);
		int count = 0;
		for(int i=0; i<firstNum.size(); i++) {
			int fNum = firstNum.get(i);
			for(int j=0; j<secondNum.size(); j++) {
				int sNum = secondNum.get(j);
				if(isValidNumber(fNum*sNum, nums)) {
					int ones = sNum%10;
					int tens = sNum/10;
					if(isValidNumber(fNum*ones, nums) && isValidNumber(fNum*tens, nums)) {
						if((fNum*ones+"").length()==3 && (fNum*tens + "").length()==3) {
							count++;
						}

					}
					else {
						continue;
					}
				}
				else {
					continue;
				}
			}
		}
		System.out.println(count);
		out.println(count);
		out.close();
	}
	public static boolean isValidNumber(int a, int[] nums) {
		String str = a + "";
		for(int i=0; i<str.length(); i++) {
			boolean bool = false;
			for(int j=0; j<nums.length; j++) {
				if(Integer.parseInt(str.charAt(i) + "")==nums[j]) {
					bool = true;
				}
			}
			if(!bool) {
				return false;
			}
		}
		return true;
	}
	public static void removeDuplicates(int[] firstNums, ArrayList<Integer> firstNum) {
		int current = firstNums[0];
		boolean found = false;

		for (int i = 0; i < firstNums.length; i++) {
		    if (current == firstNums[i] && !found) {
		        found = true;
		    } else if (current != firstNums[i]) {
		    	firstNum.add(current);
		        current = firstNums[i];
		        found = false;
		    }
		}
		firstNum.add(current);
	}
}
