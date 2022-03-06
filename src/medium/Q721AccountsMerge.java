package medium;

import java.util.*;

public class Q721AccountsMerge{
    public static void main(String[] args) {
        var app = new Q721AccountsMerge();
        List<List<String>> accounts = List.of(
                List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("Mary","mary@mail.com"),
                List.of("John","johnnybravo@mail.com")
        );
        System.out.println(app.accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();

        BalancedDisjointSet ds = new BalancedDisjointSet(accounts.size());
        int i = 0;
        for(List<String> account: accounts) {
            Iterator<String> iter = account.iterator();
            iter.next();
            while(iter.hasNext()) {
                String email = iter.next();
                if(!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    int id = map.get(email);
                    ds.union(id, i);
                }

            }


            i++;
        }

        Map<Integer, TreeSet<String>> store = new HashMap<>();
        for(int j = 0; j < accounts.size(); j++) {
            int root = ds.find(j);
            TreeSet<String> ts = store.getOrDefault(root, new TreeSet<>());
            List<String> emails = accounts.get(j);
            for(int k = 1; k < emails.size(); k++) {
                ts.add(emails.get(k));
            }
            store.put(root, ts);
        }

        List<List<String>> out = new LinkedList<>();
        for(Map.Entry<Integer, TreeSet<String>> entry: store.entrySet()) {
            LinkedList<String> lst = new LinkedList<>();
            int id = entry.getKey();
            lst.add(accounts.get(id).get(0));
            lst.addAll(entry.getValue());
            out.add(lst);
        }

        return out;
    }

    class BalancedDisjointSet {
        int[] root;
        int[] height;

        public BalancedDisjointSet(int n) {
            root = new int[n];
            height = new int[n];

            for(int i = 0; i < n; i++) {
                root[i] = i ;
            }
        }

        public int find(int val) {
            if(root[val] != val) {
                return root[val] = find(root[val]);
            } else {
                return val;
            }
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if(rootI == rootJ) {
                return;
            }

            if(height[i] > height[j]) {
                root[rootJ] = rootI;
            } else if(height[j] < height[j]) {
                root[rootI] = rootJ;
            } else {
                root[rootJ] = rootI;
                height[i]++;
            }
        }
    }
}