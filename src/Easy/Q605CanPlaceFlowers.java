package Easy;

public class Q605CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int maxCap = (flowerbed.length + 1) / 2;

        if(n > maxCap) {
            return false;
        } else if(n == 0) {
            return true;
        } else if (flowerbed.length == 1) {
            return 1 == (1^(flowerbed[0]));
        }

        int canPlant = 0;

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) {
                continue;
            }

            if(i == 0) {
                if(flowerbed[1] == 0) {
                    canPlant++;
                    i++;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[flowerbed.length - 2] == 0) {
                    canPlant++;
                    i++;
                }
            }
            else {
                    if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        canPlant++;
                        i++;
                    }
                }
        }
        return (canPlant >= n);
    }

    public static void main(String[] args) {
        boolean ans = canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
        System.out.println(ans);
    }
}
