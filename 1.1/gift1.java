import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.*;

/*
ID: kingrandomguy
LANG: JAVA
TASK: gift1
*/
public class gift1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		Map<String, Integer> map = new HashMap<String, Integer>();
		int NP = Integer.parseInt(f.readLine());
		String[] names = new String[NP];
		for(int i=0; i<NP; i++) {
			String name2 = f.readLine();
			map.put(name2, 0);
			names[i] = name2;
		}
		for(int i=0; i<NP; i++) {
			String name = f.readLine();
			String twoInts = f.readLine();
			StringTokenizer st = new StringTokenizer(twoInts);
			int gifts = Integer.parseInt(st.nextToken());
			int numPeople = Integer.parseInt(st.nextToken());
			if(gifts!=0) {
				map.put(name, map.get(name)-gifts+(gifts%numPeople));
			}
			for(int j=0; j<numPeople; j++) {
				String recipient = f.readLine();
				map.put(recipient, map.get(recipient)+gifts/numPeople);
			}
		}
		for(int i=0; i<NP; i++) {
			out.println(names[i] +" " + map.get(names[i]));
		}
		out.close();
	}
}
