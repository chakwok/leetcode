package hard;

import java.util.List;
import java.util.PriorityQueue;

public class Q1095FindinMountainArray {
    int findInMountainArray(int target, MountainArray A) {
        int n = A.length(), lo, hi, mi, peak = 0;
        // find index of peak
        lo  = 0;
        hi = n - 1;
        while (lo < hi) {
            mi = (lo + hi) / 2;
            if (A.get(mi) < A.get(mi + 1))
                lo = peak = mi + 1;
            else
                hi = mi;
        }
        // find target in the left of peak
        lo = 0;
        hi = peak;
        while (lo <= hi) {
            mi = (lo + hi) / 2;
            if (A.get(mi) < target)
                lo = mi + 1;
            else if (A.get(mi) > target)
                hi = mi - 1;
            else
                return mi;
        }
        // find target in the right of peak
        lo = peak;
        hi = n - 1;
        while (lo <= hi) {
            mi = (lo + hi) / 2;
            if (A.get(mi) > target)
                lo = mi + 1;
            else if (A.get(mi) < target)
                hi = mi - 1;
            else
                return mi;
        }
        return -1;
    }

    // falling one test case out of 77. Need to find the state that tells if I am over the peak or not
    public int findInMountainArrayFailedOneBad(int target, MountainArray mountainArr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        findInMountainArray(target, mountainArr, 0, mountainArr.length() - 1, pq);
        if(pq.size() > 0) {
            return pq.peek();
        }

        return -1;
    }

    private int findInMountainArray(int target, MountainArray arr, int lo, int hi, PriorityQueue<Integer> pq) {
        int md = lo + (hi - lo) /2;
        if(arr.get(lo) == target) {
            pq.add(lo);
        }
        if(arr.get(hi) == target) {
            pq.add(hi);
        }



        int val =arr.get(md);
        if(val == target) {
            pq.add(md);
        }
        int ans;
        if(md - 1 >= 0) {
            int below = arr.get(md - 1);
            if(below == target) {
                pq.add( md - 1);
            }

            if(below < val && target < below) {
                ans = findInMountainArray(target, arr, lo, md - 1, pq);
                if(ans != -1) {
                    pq.add(ans);
                }
            }

            if(below > val && target > below) {
                ans = findInMountainArray(target, arr, lo, md - 1, pq);
                if(ans != -1) {
                    pq.add(ans);
                }
            }
        }

        if(md + 1 < arr.length()) {
            int above = arr.get(md + 1);
            if(target == above) {
                pq.add(md + 1);
            }

            if(above > val && target > above) {
                ans = findInMountainArray(target, arr, md + 1, hi, pq);
                if(ans != -1) {
                    pq.add(ans);
                }
            }

            if(above < val && target < above) {
                ans = findInMountainArray(target, arr, md + 1, hi, pq);
                if(ans != -1) {
                    pq.add(ans);
                }
            }
        }

        return -1;
    }

    public static int findInMountainArray(int target, List<Integer> mountainArr) {
        return findInMountainArray(target, mountainArr, 0, mountainArr.size() - 1);
    }

    private static int findInMountainArray(int target, List<Integer> arr, int lo, int hi) {
        int md = lo + (hi - lo) /2;
        int val =arr.get(md);
        if(val == target) {
            return md;
        }

        if(md - 1 >= 0) {
            int below = arr.get(md - 1);
            if(below == target) {
                return md - 1;
            }

            if(below < val && target < below) {
                findInMountainArray(target, arr, lo, md - 1);
            }

            if(below > val && target > below) {
                findInMountainArray(target, arr, lo, md - 1);
            }
        }

        if(md + 1 < arr.size()) {
            int above = arr.get(md + 1);
            if(target == above) {
                return md + 1;
            }

            if(above > val && target > above) {
                findInMountainArray(target, arr, md + 1, hi);
            }

            if(above < val && target < above) {
                findInMountainArray(target, arr, md + 1, hi);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(findInMountainArray());
    }

    private static class MountainArray {
        int get(int a) {return  1;};
        int length() {return 1;}
    }
}

