import java.io.*;
import java.util.StringTokenizer;

/*
ID: kingrandomguy
LANG: JAVA
TASK: milk
*/

class milker{
	public int cost;
	public int amount;
	public milker(int cost,int amount) {
		this.cost=cost;
		this.amount=amount;
	}
	public String toString() {
		return "Farmer[cost: " + cost + ", amount: " + amount + "]";
	}
}
class milk {
	public static void sort(milker[] arr) {
    	int n = arr.length;
    	for (int i = 0; i < n-1; i++) {
    	    int min_idx = i;
    	    for (int j = i+1; j < n; j++){
    	        if (arr[j].cost < arr[min_idx].cost){
    	            min_idx = j;
		}
	    }
    	    milker temp = arr[min_idx];
    	    arr[min_idx] =  arr[i];
    	    arr[i] =  temp;
    	}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter("milk.out");
		StringTokenizer st0 = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st0.nextToken());
		int M = Integer.parseInt(st0.nextToken());
		int cost=0;
		milker[] arr = new milker[M];
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			milker milk = new milker(c, a);
			arr[i] = milk;
		}
		f.close();
		sort(arr);
		for(int i=0; i<arr.length; i++) {
			if(N<=0) {
				break;
			}
			else if(N<arr[i].amount) {
				cost+=N*arr[i].cost;
				N=0;
			}
			else {
				cost+=arr[i].amount*arr[i].cost;
				N-=arr[i].amount;
			}
		}
		out.println(cost);
		out.close();
	}
}
