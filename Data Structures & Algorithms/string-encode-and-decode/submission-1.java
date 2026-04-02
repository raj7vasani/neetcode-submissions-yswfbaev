class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        char sep = '€';
        sb.append(sep);
        for (String str : strs) {
            sb.append(str).append(sep);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        String sep = "€";
        String clean = str.substring(1, str.length() - 1);
        String[] parts = clean.split(sep, -1);
        return Arrays.asList(parts);
    }
}
