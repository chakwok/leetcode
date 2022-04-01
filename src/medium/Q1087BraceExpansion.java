package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1087BraceExpansion{
    public static void main(String[] args) {
        var app = new Q1087BraceExpansion();
        System.out.println(Arrays.toString(app.expand("{a,b}c{d,e}f")));
    }
    public String[] expandReduceAppend(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        int i = 0;
        StringBuilder toAppend = new StringBuilder();
        while(i < s.length()) {
            if(s.charAt(i) == '{') {
                if(toAppend.length() > 0) {
                    for(StringBuilder sb : ans) {
                        sb.append(toAppend);
                    }
                    toAppend.delete(0, toAppend.length());
                }


                int end = s.indexOf('}', i);
                String[] split = s.substring(i + 1, end).split(",");
                List<StringBuilder> tmp = new ArrayList<>();
                for(StringBuilder sb : ans) {
                    for(String str : split) {
                        StringBuilder newSb = new StringBuilder(sb);
                        newSb.append(str);
                        tmp.add(newSb);
                    }
                }
                ans = tmp;
                i = end + 1;
            } else {
                toAppend.append(s.charAt(i));
                i++;
            }
        }
        if(toAppend.length() > 0) {
            for(StringBuilder sb : ans) {
                sb.append(toAppend);
            }
            toAppend.delete(0, toAppend.length());
        }

        String[] out = new String[ans.size()];
        i = 0;
        for(StringBuilder sb : ans) {
            out[i++] = sb.toString();
        }
        Arrays.sort(out);
        return out;
    }


    public String[] expand(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '{') {
                int end = s.indexOf('}', i);
                String[] split = s.substring(i + 1, end).split(",");
                List<StringBuilder> tmp = new ArrayList<>();
                for(StringBuilder sb : ans) {
                    for(String str : split) {
                        StringBuilder newSb = new StringBuilder(sb);
                        newSb.append(str);
                        tmp.add(newSb);
                    }
                }
                ans = tmp;
                i = end + 1;
            } else {
                for(StringBuilder sb : ans) {
                    sb.append(s.charAt(i));
                }
                i++;
            }

        }

        String[] out = new String[ans.size()];
        i = 0;
        for(StringBuilder sb : ans) {
            out[i++] = sb.toString();
        }
        Arrays.sort(out);
        return out;
    }
}