class Solution {
    public boolean isAnagram(String s, String t) {
        if ((s == null || t == null) || (s.length() != t.length())) {
            return false;
        }

        Map<Character, Integer> encountered = new HashMap<>();
        for (Character sChar : s.toCharArray()) {
            encountered.merge(sChar, 1, Integer::sum);
        }

        for (Character tChar : t.toCharArray()) {
            if (!encountered.containsKey(tChar)) {
                return false;
            } else {
                encountered.compute(tChar, (k, v) -> v - 1);
                if (encountered.get(tChar) == 0) {
                    encountered.remove(tChar);
                }
            }
        }
        return encountered.size() == 0;
    }
}
