import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int n;
    private static HashSet<String> words;

    private static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        words = new HashSet<>();

        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }

        List<String> wordsList = new ArrayList<>(words);

        Collections.sort(wordsList,  new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (String word : wordsList) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}