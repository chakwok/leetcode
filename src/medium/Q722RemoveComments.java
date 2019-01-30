package medium;

import java.util.ArrayList;
import java.util.List;

public class Q722RemoveComments {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }

    //non destructive
    //would never work, as each line is considered as one instance that takes in one comments only
    //will need an while loop to process >1 comments in each line
    public static List<String> removeCommentsWontWork(String[] source) {
        ArrayList<String> toReturn = new ArrayList<>();

        boolean isInBlock = false;
        for (String line: source) {
            int blockIndex = line.indexOf("/*");
            int lineIndex = line.indexOf("//");

            if (isInBlock) {
                int blockEndIndex = line.indexOf("*/");
                if (blockEndIndex != -1) {
                    if (blockEndIndex != line.length() - 2) {
                        toReturn.add(toReturn.remove(toReturn.size() - 1) + (line.substring(blockEndIndex + 2)));
                    }
                    isInBlock = false;
                }
                continue;
            }

            if (blockIndex == -1 && lineIndex == -1) {
                toReturn.add(line);
                continue;
            }


            if (blockIndex!= -1 && lineIndex!= -1) {
                if (blockIndex > lineIndex) {
                    blockIndex = -1;
                } else if (lineIndex > blockIndex) {
                    lineIndex = -1;
                }
            }


            //found block comments
            if (blockIndex != -1) {
                int blockEndIndex = line.substring(blockIndex + 2).indexOf("*/");
                blockEndIndex = (blockEndIndex == -1)? -1 : blockEndIndex + blockIndex + 2;
                if (blockEndIndex != -1) {
                    if (!(blockIndex == 0 && blockEndIndex == line.length() - 2)) {
                        toReturn.add(line.replaceFirst("/\\*.*\\*/", ""));
                    }
                } else {
                    if (blockIndex > 0) {
                        toReturn.add(line.substring(0, blockIndex));
                    }
                    isInBlock = true;
                }

            }

            //there must be a line comments
            if (lineIndex > 0) {
                toReturn.add(line.substring(0, lineIndex));
            }
        }

        return toReturn;
    }

    public static void main(String[] args) {
        System.out.println("  // variable declaration ".indexOf("//"));
        System.out.println("  // variable declaration ".substring(0, 2));
        System.out.println((new String[] {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
    }
}

