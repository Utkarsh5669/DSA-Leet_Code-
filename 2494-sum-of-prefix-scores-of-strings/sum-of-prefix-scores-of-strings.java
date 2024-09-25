class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    } 
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
                node.count++;
            }
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            int score = 0;
            for (char ch : words[i].toCharArray()) {
                node = node.children[ch - 'a'];
                score += node.count;
            }
            result[i] = score;
        }
        return result;
    }
}