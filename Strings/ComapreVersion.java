/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/


public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] s = version1.split("\\."); //  \\. regex dot
        String[] s2 = version2.split("\\.");

        int max = Math.max(s.length, s2.length);

        for (int i = 0; i < max; i++) {
            if (i >= s.length) {
                boolean b = true;
                for (int j = i; j < s2.length; j++) {
                    if (Integer.parseInt(s2[j]) != 0) {
                        b = false;
                        break;
                    }
                }
                if (b) return 0;
                return -1;

            }
            if (i >= s2.length) {
                boolean b = true;
                for (int j = i; j < s.length; j++) {
                    if (Integer.parseInt(s[j]) != 0) {
                        b = false;
                        break;
                    }
                }
                if (b) return 0;
                return 1;
            }
            int fi = Integer.parseInt(s[i]);
            int se = Integer.parseInt(s2[i]);
            if (fi > se) return 1;
            if (se > fi) return -1;
        }
        return 0;
    }
}