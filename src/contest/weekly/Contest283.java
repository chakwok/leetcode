package contest.weekly;

import helper.TreeNode;

import java.util.*;

public class Contest283 {
    public static void main(String[] args) {
        var app = new Contest283();
        /*System.out.println(app.cellsInRange("K1:L2"));
        System.out.println(app.cellsInRange("A1:F1"));*/
        //expecteed 794, actual 3628
//        System.out.println(app.minimalKSum(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84}, 35));
//        System.out.println(app.minimalKSum(new int[]{5,6}, 6));

//        System.out.println(app.minimalKSum(new int[]{1,4,25,10,25}, 2));
        System.out.println(app.createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}}));

    }

    public List<String> cellsInRange(String s) {
        char fromCol = s.charAt(0);
        char toCol = s.charAt(3);
        int fromRow = Integer.parseInt(s.substring(1,2));
        int toRow = Integer.parseInt(s.substring(4));

        int maxRow = Math.max(fromRow, toRow);
        List<String> out = new LinkedList<>();
        while(fromCol <= toCol) {
            for(int i = fromRow ; i <= toRow; i++) {
                out.add(String.format("%s%d", fromCol, i));
            }

            fromCol++;
        }
        return out;
    }

    public long minimalKSum(int[] nums, int k) {
        long out = 0;
        Set<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }
        nums = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int j = 0;
        while(iter.hasNext()) {
            nums[j++] = iter.next();
        }

        int prev = 0;


        for(int i = 0; i < nums.length; i++) {
            if(k == 0) {
                return out;
            }
            if(prev < nums[i] - 1) {
                int start = prev + 1;
                int end = Math.min(nums[i] - 1, start + k - 1);
                out += getRangeSum(start, end);
                k -= end - start + 1;
            }
            prev = nums[i];
        }
        if(k > 0) {
            int start = nums[nums.length - 1] + 1;
            int end = start + k - 1;
            out += getRangeSum(start, end);
        }



        return out;
    }

    private long getRangeSum(int from, int to) {
        long sum = from+to;
        int n = to - from + 1;
        return sum * n / 2;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        //get root
        Set<Integer> node = new HashSet<>();
        for(int[] description : descriptions) {
            node.add(description[0]);
        }

        for(int[] description : descriptions) {
            node.remove(description[1]);
        }

        int rootVal = node.iterator().next();

        //build map
        Map<Integer, List<int[]>> map = new HashMap(); //parentsToDesc
        for(int[] description : descriptions) {
            List<int[]> v= map.getOrDefault(description[0], new LinkedList<>());
            v.add(description);
            map.put(description[0], v);
        }

        //build node
        TreeNode root = new TreeNode(rootVal);
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            TreeNode par = q.pop();
            List<int[]> descs = map.get(par.val);
            if(descs == null) {
                continue;
            }
            for(int[] desc : descs) {
                TreeNode newNode = new TreeNode(desc[1]);
                if(desc[2] == 1) {
                    par.left = newNode;
                } else {
                    par.right = newNode;
                }
                q.add(newNode);
            }

        }

        return root;
    }


}
