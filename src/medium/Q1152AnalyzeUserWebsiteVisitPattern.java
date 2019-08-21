package medium;

import java.util.*;

public class Q1152AnalyzeUserWebsiteVisitPattern {
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int[] order = new int[timestamp.length];

        List<Integer> indexOrder = new ArrayList<>(timestamp.length);

        for (int i = 0; i < timestamp.length; i++) {
            indexOrder.add(i);
        }

        Collections.sort(indexOrder, Comparator.comparing((Integer s) -> timestamp[s]));

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < indexOrder.size(); i++) {
            int pos = indexOrder.get(i);

            if(!map.containsKey(username[pos])) {
                List<String> lst = new ArrayList<>();
                lst.add(website[pos]);
                map.put(username[pos], lst);
            } else {
                List<String> lst = map.get(username[pos]);
                lst.add(website[pos]);
                map.put(username[pos], lst);
            }
        }

        Map<List<String>, Integer> seqToCount = new HashMap<>();

        for(List<String> seq: map.values()) {
            if(seq.size() < 3) {
                continue;
            }
            HashSet<List<String>> set = new HashSet<>();

            for(int j = 0; j <= seq.size() - 3; j++) {
                for(int k = j + 1; k <= seq.size() - 2; k++) {
                    for(int l = k + 1; l <= seq.size() - 1; l++) {
                        List<String> lst = new LinkedList<>();
                        lst.add(seq.get(j));
                        lst.add(seq.get(k));
                        lst.add(seq.get(l));
                        if(!set.contains(lst)) {
                            set.add(lst);
                            seqToCount.put(lst, seqToCount.getOrDefault(lst, 0) + 1);
                        }

                    }
                }
            }
        }

        int value = -1;
        List<String> result = null;
        for(Map.Entry<List<String>, Integer> entry: seqToCount.entrySet()) {
            if(entry.getValue() > value) {
                value = entry.getValue();
                result = entry.getKey();
            } else if(entry.getValue() == value) {
                if(!compare(entry.getKey(), result)) {
                    result = entry.getKey();
                }
            }
        }

        return result;
    }

    public static boolean compare(List<String> l1, List<String> l2) {
        for(int i = 0; i < l1.size(); i++) {
            int diff = l1.get(i).compareTo(l2.get(i));
            if(diff > 0) {
                return true;
            } else if(diff < 0){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(mostVisitedPattern(new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"}, new int[]{527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930}, new String[]{"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"}));
    }


}
