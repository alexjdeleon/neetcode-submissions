class Solution {
    public String encode(List<String> strs) {
        if (strs == null) {
            return null;
        }

        if (strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            String encondedLength = s.length() + "!";
            sb.append(encondedLength + s);
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null) {
            return null;
        }

        if (str.equals("")) {
            return Collections.emptyList();
        }

        List<String> decodedWordList = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '!') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            decodedWordList.add(str.substring(i, j));
            i = j;
        }

        return decodedWordList;
    }
}
