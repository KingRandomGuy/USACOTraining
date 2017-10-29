import java.io.*;

/*
ID: kingrandomguy
LANG: JAVA
TASK: beads
*/

public class beads{
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int N = Integer.parseInt(f.readLine());
		String necklace = f.readLine();
		f.close();
		int max=0;
		for(int i=1; i<N; i++) {
			int count=0;
			int pos = i-1;
			int pos2=i;
			char s1i= necklace.charAt(pos);
			char s2i= necklace.charAt(pos2);
			if(s1i=='w') {
				for(int j=0; j<necklace.length(); j++) {
					if(necklace.charAt(pos)!=s1i) {
						s1i=necklace.charAt(pos);
						break;
					}
					pos--;
					if(pos==-1) {
						pos=necklace.length()-1;
					}	
				}
			}
			pos = i-1;
			for(int j=0; j<necklace.length(); j++) {
				if(necklace.charAt(pos)!=s1i && necklace.charAt(pos)!='w') {
					break;
				}
				count++;
				pos--;
				if(pos==-1) {
					pos=necklace.length()-1;
				}	
			}
			if(s2i=='w') {
				for(int j=0; j<necklace.length(); j++) {
					if(necklace.charAt(pos2)!=s2i) {
						s2i=necklace.charAt(pos2);
						break;
					}
					pos2++;
					pos2%=necklace.length();
				}
			}
			for(int j=0; j<necklace.length(); j++) {
				if(necklace.charAt(pos2)!=s2i && necklace.charAt(pos2)!='w') {
					break;
				}
				count++;
				pos2++;
				pos2%=necklace.length();
			}
			if(count>max) {
				max=count;
			}
			if(count>necklace.length()) {
				max=necklace.length();
			}
			
			
		}
		out.println(max);
		out.close();
	}
}
