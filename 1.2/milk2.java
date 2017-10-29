import java.util.StringTokenizer;
import java.io.*;

/*
ID: kingrandomguy
LANG: JAVA
TASK: milk2
*/

class Farmer{
	public int start;
	public int end;
	public Farmer(int start,int end) {
		this.start=start;
		this.end=end;
	}
	public String toString() {
		return "Farmer[start: " + start + ", end: " + end + "]";
	}
}
class milk2 {
	public static void sortStart(Farmer[] arr) {
        	int n = arr.length;
        	for (int i = 0; i < n-1; i++) {
        	    int min_idx = i;
        	    for (int j = i+1; j < n; j++){
        	        if (arr[j].start < arr[min_idx].start){
        	            min_idx = j;
			}
		    }
        	    Farmer temp = arr[min_idx];
        	    arr[min_idx] =  arr[i];
        	    arr[i] =  temp;
        	}
    	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter("milk2.out");
		int N = Integer.parseInt(f.readLine());
		Farmer[] arr = new Farmer[N];
		int count=0;
		while(f.ready()) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Farmer farmer = new Farmer(start, end);
			arr[count] = farmer;
			count++;
		}
		f.close();
		sortStart(arr);
		int start = arr[0].start;
        	int end = arr[0].end;
        	int maxMilked = end-start;
        	int maxGap = 0;
        	for(int i=1; i<arr.length; i++) {
        	    Farmer a = arr[i];
        	    if (a.start <= end) {
        	        end = Math.max(a.end, end);
        	    } 
        	    else {
        	        maxMilked = Math.max(maxMilked, end-start);
        	        maxGap = Math.max(maxGap, a.start-end);
        	        start = a.start;
        	        end = a.end;
        	    }
        	}
		out.println(maxMilked + " " + maxGap);
		out.close();
	}
}
