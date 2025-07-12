public class GoodSting {

    public boolean isAlphabet(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public String goodString(String inStr) {
        StringBuilder outStr = new StringBuilder(inStr);
        int i = 0;
        while (i < outStr.length()) {
            if (!(isAlphabet(outStr.charAt(i)) || outStr.charAt(i) == ' ')) {
                outStr = outStr.deleteCharAt(i);
                int j = i;
                while (j < outStr.length()) {
                    if (isAlphabet(outStr.charAt(j))) {
                        outStr = outStr.deleteCharAt(j);
                        break;
                    }
                    j++;
                }
            } else {
                i++;
            }
        }
        return outStr.toString();
    }

}
