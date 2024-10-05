class Solution {

    int[] count1 = new int[26];
    int[] count2 = new int[26];

    public boolean equalPermutation() {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();

        // initializing zero
        for (int i = 0; i < 26; i++) {
            count1[i] = 0;
            count2[i] = 0;
        }

        // apply count on same size of n1
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (equalPermutation()) {
            return true;
        }

        // sliding window
        for (int i = n1; i < n2; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - n1) - 'a']--;
            if (equalPermutation()) {
                return true;
            }
        }

        return false;
    }
}