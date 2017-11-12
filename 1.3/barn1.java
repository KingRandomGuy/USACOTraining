/*
ID: kingrandomguy
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter("barn1.out");
        StringTokenizer st = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st.nextToken());
        st.nextToken();
        int c = Integer.parseInt(st.nextToken());
        int[] stalls = new int[c];
        for(int i=0; i<c; i++) {
            stalls[i] = Integer.parseInt(f.readLine());
        }
        f.close();
        Arrays.sort(stalls);
        Set<Board> boards = new HashSet<Board>();
        boards.add(new Board(stalls[0], stalls[stalls.length-1]));
        for(int i=0; i<m-1; i++) {
            int gapLow = stalls[0];
            int gapHigh = stalls[0];
            for(Board board : boards) {
                for(int j=0; j<stalls.length-1; j++) {
                    if (stalls[j+1]-stalls[j] >= gapHigh-gapLow && board.contains(stalls[j]) && board.contains(stalls[j+1])) {
                        gapLow = stalls[j];
                        gapHigh = stalls[j+1];
                    }
                }
            }
            Board targetBoard = null;
            for(Board board : boards) {
                if (board.contains(gapLow)) {
                    targetBoard = board;
                }
            }
            boards.remove(targetBoard);
            boards.add(new Board(targetBoard.start, gapLow));
            boards.add(new Board(gapHigh, targetBoard.end));
        }
        int sum = 0;
        for(Board board : boards) {
            sum += board.end-board.start+1;
        }
        out.println(sum);
        out.close();
    }

    private static class Board {
        private final int start;
        private final int end;

        public Board(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public boolean contains(int stall) {
            return stall >= start && stall <= end;
        }
        @Override
        public int hashCode() {
            return 31+start;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Board other = (Board) obj;
            if (end != other.end)
                return false;
            if (start != other.start)
                return false;
            return true;
        }


    }
}