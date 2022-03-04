package medium;

import java.util.LinkedList;

public class Q71SimplifyPath{
    public static void main(String[] args) {
        var app = new Q71SimplifyPath();
        System.out.println(app.simplifyPath("/home//foo/"));
        System.out.println(app.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> out = new LinkedList<>();

        for(String str : split) {
            if(str.length() == 0 || str.equals(".")) {
                continue;
            }  else if(str.equals("..")) {
                if(out.size() > 0) {
                    out.removeLast();
                }
            } else {
                out.add(str);
            }
        }

        StringBuilder sb = new StringBuilder();


        while(out.size() > 0) {
            sb.append(String.format("/%s", out.pop()));
        }

        return sb.length() > 0? sb.toString(): "/";
    }
}