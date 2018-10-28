package Easy;

public class Q922SortArrayByParityII {
    public int[] sortArrayByParityIINew(int[] A) {
        return new int[0];
    }

    //O(n), need to loop through up to 3 times
    public int[] sortArrayByParityII(int[] A) {
        int odd = 0;
        int even = 0;
        boolean isEven = true;

        int temp;
        for (int i = 0; i < A.length;) {
            if(odd > A.length - 1 || even > A.length - 1) {
                break;
            }

            if (A[odd] % 2 != 1) {
                odd++;
            } else if (A[even] % 2 != 0) {
                even++;
            } else {
                if (isEven) {
                    if (A[i] % 2 == 1) {
                        temp = A[i];
                        A[i] = A[even];
                        A[even]  = temp;
                    }
                    even++;

                } else {
                    if (A[i] % 2 == 0) {
                        temp = A[i];
                        A[i] = A[odd];
                        A[odd] = temp;
                    }

                    odd++;

                }

                i++;
                isEven = !isEven;
            }
        }
        return A;
    }
}
