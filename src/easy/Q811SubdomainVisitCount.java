package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            int pos = s.indexOf(".");
            while (pos != -1) {
                String d = s.substring(pos + 1);
                map.put(d, map.getOrDefault(d, 0) + n);
                pos = s.indexOf(".", pos + 1);
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }


        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(String.format("%d %s", entry.getValue(), entry.getKey()));
        }


        return result;
    }



    //still slow
    public List<String> subdomainVisitsSlightlyBetterOnly(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }

        List<String> result = new LinkedList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            result.add(String.format("%d %s", entry.getValue(), entry.getKey()));
        }

        return result;
    }



    public List<String> subdomainVisitsSlow(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String cpdomain: cpdomains) {
            String[] split = cpdomain.split(" ");
            String[] subDomains = split[1].split("\\.");
            map.put(subDomains[subDomains.length - 1], map.getOrDefault(subDomains[subDomains.length - 1], 0) + Integer.valueOf(split[0]));
            StringBuilder sb = new StringBuilder(subDomains[subDomains.length - 1]);
            for(int i = subDomains.length - 2; i >= 0; i--) {
                sb.insert(0, ".");
                sb.insert(0, subDomains[i]);
                String toAdd = sb.toString();
                map.put(toAdd, map.getOrDefault(toAdd, 0) + Integer.valueOf(split[0]));
            }
        }

        List<String> result = new LinkedList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            result.add(String.format("%d %s", entry.getValue(), entry.getKey()));
        }

        return result;
    }
}
