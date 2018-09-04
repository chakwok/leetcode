package Easy;

public class Q66PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        digits[index] += 1;
        while(digits[index] == 10) {
            if (index == 0) {
                digits[1] = 0;
                int[] toReturn = new int[digits.length + 1];
                toReturn[0] = 1;
                System.arraycopy(digits, 0, toReturn, 1, digits.length);
                return toReturn;
            }
            digits[index] = 0;
            digits[index - 1] += 1;

            index -= 1;
        }

        return digits;
    }
}
