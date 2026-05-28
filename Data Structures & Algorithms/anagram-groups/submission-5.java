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
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String hash = chars.length + "L" + new String(chars);
        System.out.println("hash for String " + s + " : " + hash);
        return hash;
    }
}
