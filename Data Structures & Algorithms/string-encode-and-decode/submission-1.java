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
            String encondedLength;
            int currentLength = s.length();
            if (currentLength < 10) {
                encondedLength = "00" + currentLength;
            } else if (currentLength < 100) {
                encondedLength = "0" + currentLength;
            } else {
                encondedLength = "" + currentLength;
            }
            sb.append(encondedLength + s);
        }

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
        int tokenCursor = 0; 
        int wordStart = tokenCursor + 3;
        while(tokenCursor < str.length()){            
            int len = Integer.valueOf(str.substring(tokenCursor, wordStart));
            int wordEnd = wordStart + len;
            String word = str.substring(wordStart, wordEnd);
            decodedWordList.add(word);
            tokenCursor = wordEnd;
            wordStart = tokenCursor + 3;
        }

        return decodedWordList;
    }
}
