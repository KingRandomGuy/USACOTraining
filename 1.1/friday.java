import java.io.*;

/*
ID: kingrandomguy
LANG: JAVA
TASK: friday
*/

public class friday {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int[] counts = new int[7];
		int N = Integer.parseInt(f.readLine());
		f.close();
		int days=0;
		for(int i=1900; i<1900+N; i++) {
			int daysPerYear = 365;
			if((i%4==0 && i%100!=0) || i%400==0) {
				daysPerYear=366;
			}
			days+=12;
			counts[days%7]++;
			days+=31;
			counts[days%7]++;
			days+=28;
			if(daysPerYear==366) {
				days++;
			}
			counts[days%7]++;
			days+=31;
			counts[days%7]++;
			days+=30;
			counts[days%7]++;
			days+=31;
			counts[days%7]++;
			days+=30;
			counts[days%7]++;
			days+=31;
			counts[days%7]++;
			days+=31;
			counts[days%7]++;
			days+=30;
			counts[days%7]++;
			days+=31;
			counts[days%7]++;
			days+=30;
			counts[days%7]++;
			days+=19;
			System.out.println(i + " " + days);
		}
		out.println(counts[5] +" " + counts[6] + " "  + counts[0] +" " + counts[1] +" " + counts[2] +" " + counts[3] +" " + counts[4]);
		out.close();
	}

}

