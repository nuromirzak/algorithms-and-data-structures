// HashMap
class Solution {
    private String build(String s) {
        char[] chars = new char[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        return new String(chars);

        // Another way of building unique key is a sorting
//        char[] chars = s.toCharArray();
//
//        Arrays.sort(chars);
//
//        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String res = build(str);

            map.putIfAbsent(res, new ArrayList<>());

            map.get(res).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for (var value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}