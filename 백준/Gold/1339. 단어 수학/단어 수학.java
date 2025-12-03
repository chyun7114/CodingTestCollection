import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int n;
    static String[] words;
    static HashMap<Character, Integer> hashMap = new HashMap<>();

    private static void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int weight = (int) Math.pow(10, len - i - 1);
                hashMap.put(c, hashMap.getOrDefault(c, 0) + weight);
            }
        }

        List<Entry<Character, Integer>> list = hashMap.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        int answer = 0;
        int targetNum = 9;

        for(Entry<Character, Integer> entry : list) {
            answer += entry.getValue() * targetNum--;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}