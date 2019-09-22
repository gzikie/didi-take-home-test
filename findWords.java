import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.*;

public class findWords {

    /*
        Class: TrieNode
        use Trienode to go through each line of string in the source url, to generate a Trie
    */
    public static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            this.children = new TrieNode[256];
            this.isWord = false;
        }
    }

    private static TrieNode root = new TrieNode();

    private static void buildTrie() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/lad/words/master/words");
        Scanner scanner = null;

        try{
            scanner = new Scanner(url.openStream());

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                char[] chs = line.toCharArray();
                TrieNode node = root;
                for (int i = 0; i < chs.length; i++) {

                    /*
                        Since the input set of Character just contains characters from 'a' to 'z'
                        so can just skip this case: chs[i] == '-'
                    */
                    if (chs[i] == '-') continue;
                    if (node.children[chs[i] - 'a'] == null) {
                        node.children[chs[i] - 'a'] = new TrieNode();
                    }
                    node = node.children[chs[i] - 'a'];
                }
                node.isWord = true;
            }
        } finally {
            if (scanner!=null) {
                scanner.close();
              }
        }
    }

    /*
        Input with set of characters, and use a helper function: dfs(), to do backtracking to find the corresponding Strings
    */
    public static List<String> findAllWords(Set<Character> set) {
        List<String> res = new ArrayList<>();
        if (set == null || set.size() == 0) return res;

        TrieNode node = root;

        // Since we want to find the results wwith case insensitive
        // so we need to change some UpperCase character to lower first
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (Character each: set) {
            char curr = Character.toLowerCase(each);
            if (charToCount.containsKey(curr)) {
                charToCount.put(curr, charToCount.get(curr) + 1);
            } else {
                charToCount.put(curr, 1);
            }
        }

        StringBuilder temp = new StringBuilder();
        dfs(node, charToCount, res, temp);
        return res;
    }

    private static void dfs(TrieNode node, HashMap<Character, Integer> map, List<String> res, StringBuilder temp) {
        if (node.isWord && map.isEmpty()) {
            res.add(temp.toString());
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (map.containsKey(c) && node.children[c - 'a'] != null) {
                temp.append(c);

                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }

                dfs(node.children[c - 'a'], map, res, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('r');
        set.add('u');

        buildTrie();

        for (String str : findAllWords(set)) {
            System.out.println(str);
        }
    }
}