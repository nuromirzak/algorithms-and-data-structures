// Sorting
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] abc = new int[26];

        for (int i = 0; i < s.length(); i++) {
            abc[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            abc[t.charAt(i) - 'a']--;
        }

        for (int i : abc) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}

// Map
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] abc = new int[26];

        for (int i = 0; i < s.length(); i++) {
            abc[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            abc[t.charAt(i) - 'a']--;
        }

        for (int i : abc) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}