import java.io.*;
import java.util.Arrays;

/*
ID: kingrandomguy
LANG: JAVA
TASK: transform
*/

public class transform {
	public static char[][] rotate90(char[][] arr){
		int length = arr.length-1;
		char[][] temp = new char[arr[0].length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				temp[j][length-i] = arr[i][j];
			}
		}
		return temp;
	}
	public static char[][] rotate180(char[][] arr){
		arr=rotate90(arr);
		return rotate90(arr);
	}
	public static char[][] rotate270(char[][] arr){
		arr=rotate90(arr);
		arr=rotate90(arr);
		return rotate90(arr);
	}
	public static char[][] reflect(char[][] arr){
		int length = arr.length-1;
		char[][] temp = new char[arr[0].length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				temp[i][length-j] = arr[i][j];
			}
		}
		return temp;
	}
	public static boolean isEqual(char[][] a, char[][] b) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter("transform.out");
		int N = Integer.parseInt(f.readLine());
		char[][] before = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = f.readLine();
			for(int j=0; j<N; j++) {
				before[i][j] = line.charAt(j);
			}
		}
		char[][] after = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = f.readLine();
			for(int j=0; j<N; j++) {
				after[i][j] = line.charAt(j);
			}
		}
		f.close();
		//if the rotation by 90 degrees is equal, print 1
		if(isEqual(rotate90(before),after)) {
			out.println(1);
			out.close();
		}
		//if the rotation by 180 degrees is equal, print 2
		if(isEqual(rotate180(before),after)) {
			out.println(2);
			out.close();
		}
		//if the rotation by 270 degrees is equal, print 3
		if(isEqual(rotate270(before),after)) {
			out.println(3);
			out.close();
		}
		//if the reflection is equal, print 4
		if(isEqual(reflect(before),after)) {
			out.println(4);
			out.close();
		}
		//check for combinations
		if(isEqual(rotate90(reflect(before)),after) || isEqual(rotate180(reflect(before)),after) || isEqual(rotate270(reflect(before)),after)) {
			out.println(5);
			out.close();
		}
		//if they are equal, print 6
		if(isEqual(before,after)) {
			out.println(6);
			out.close();
		}
		out.println(7);
		out.close();
	}
}
