class RnaTranscription {
    String transcribe(String dnaString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dnaString.length(); i++) {
            char ch = dnaString.charAt(i);
            if (ch == 'G') {
                sb.append("C");
            } else if (ch == 'C') {
                sb.append("G");
            } else if (ch == 'T') {
                sb.append("A");
            } else if (ch == 'A') {
                sb.append("U");
            }
        }
        return sb.toString();
    }
}