package Easy;

import java.util.Arrays;

public class Q455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        for (int j = 0; i < g.length && j < s.length;) {
            if (g[i] <= s[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i;
    }
}
