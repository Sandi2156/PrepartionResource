
import java.io.*;
import java.util.*;

public class Main {

    static FastReader in;
    static PrintWriter out;

    static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        // Switch between local files and online judge
        boolean local = new File("input.txt").exists();
        if (local) {
            in = new FastReader("input.txt");
            out = new PrintWriter(new FileWriter("output.txt"));
        } else {
            in = new FastReader();
            out = new PrintWriter(System.out);
        }

        int t = 1;  // Number of test cases
        // int t = in.nextInt(); // Uncomment if multiple test cases
        for (int tc = 0; tc < t; tc++) {
            solve();
            // out.println(tc);
        }
        out.close();
    }

    static void solve() throws IOException {
        int n = in.nextInt();

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        
        int i = 0, ans = 0;
        while(i < n) {
            int j = i;
            while(j < n && arr[j].equals(arr[i])) j++;
            i = j;
            ans++;
        }

        out.println(ans);
    }

    // ---------- FastReader class ----------
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        // For online judge (stdin)
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        // For local testing (file)
        FastReader(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            st = null;
            return br.readLine();
        }

        int[] readIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }
    }
}
