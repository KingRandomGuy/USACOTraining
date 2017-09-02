import java.io.*;

/*
ID: kingrandomguy
LANG: JAVA
TASK: ride
*/
public class ride {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String one = f.readLine();
		String two = f.readLine();
		int sumone = 1, sumtwo=1;
		for(int i=0; i<one.length(); i++) {
			sumone*=one.charAt(i)-64;
		}
		for(int i=0; i<two.length(); i++) {
			sumtwo*=two.charAt(i)-64;
		}
		if(sumone%47==sumtwo%47) {
			out.println("GO");
		}
		else {
			out.println("STAY");
		}
		out.close();
	}
}
