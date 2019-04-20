package easy;

public class Q821ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        int posU = 0;
        while(S.charAt(posU) != C) {
            posU++;
        }

        fillArrayDesc(posU, 0, result);

        int num = 1;
        for(int i = posU + 1; i < S.length(); i++) {
            result[i] = num++;

            if(S.charAt(i) == C) {
                fillArrayDesc(i, i - (int)((i- posU) / 2.0), result);
                num = 1;
                posU = i;
            }
        }
        return result;
    }

    private void fillArrayDesc(int end, int start, int[] arr) {
        int num = 0;
        for(int i = end; i >= start; i--) {
            arr[i] = num++;
        }
    }
}
