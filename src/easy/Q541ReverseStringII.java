package easy;

public class Q541ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }



    public String reverseStrSlow(String s, int k) {
        if(s == null || s.length() <= 1 || k <= 1 ) {
            return s;
        }

        int start = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        while(start <= len - 1) {
            if(len - start > 2 * k) {
                for(int i = 0; i < k; i++) {
                    sb.append(s.charAt(start + k - i - 1));
                }

                for(int i = 0; i < k; i++) {
                    sb.append(s.charAt(start + k + i));
                }
                start += 2 * k;
            } else if(len  - start > k ) {
                for(int i = 0; i < k; i++) {
                    sb.append(s.charAt(start + k - i - 1));
                }

                for(int i = 0; i < len - start - k; i++) {
                    sb.append(s.charAt(start + k + i));
                }
                break;
            } else {
                for(int i = 0; i < len - start; i++) {
                    sb.append(s.charAt(start + len - start - i - 1));
                }
                break;
            }
        }
        return sb.toString();
    }
}
