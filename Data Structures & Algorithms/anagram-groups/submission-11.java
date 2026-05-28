class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> groupedByHash = new HashMap<>();

        for (String s : strs) {
            String hash = hash(s);
            groupedByHash.putIfAbsent(hash, new ArrayList<>());
            groupedByHash.get(hash).add(s);
        }

        return groupedByHash.values().stream().toList();
    }

    private String hash(String s) {
        int[] hashArray = new int[26];
        for (char c : s.toCharArray()) {
            int hash = c - 'a';
            hashArray[hash]++;
        }
        return Arrays.toString(hashArray);
    }
}
