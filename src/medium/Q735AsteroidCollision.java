package medium;

import java.util.Arrays;
import java.util.Stack;

public class Q735AsteroidCollision {
    public static int[] asteroidCollisionNew(int[] asteroids) {
        int head = 0;
        int ptr = 1;

        while(ptr < asteroids.length) {
            if(head < 0 || asteroids[head] < 0) {
                asteroids[++head] = asteroids[ptr];
                ptr++;
                continue;
            }

            int curr = asteroids[ptr];
            if(curr >= 0) {
                asteroids[++head] = curr;
            } else {
                while(head >= 0) {
                    if(asteroids[head] >= 0) {
                        if(Math.abs(asteroids[head]) == Math.abs(asteroids[ptr])) {
                            head--;
                            break;
                        } else if(Math.abs(asteroids[head]) > Math.abs(asteroids[ptr])) {
                            break;
                        } else {
                            if(head == 0) {
                                asteroids[head] = curr;
                                break;
                            } else {
                                head--;
                            }
                        }
                    } else {
                        asteroids[++head] = curr;
                        break;
                    }
                }
            }

            ptr++;
        }

        return Arrays.copyOf(asteroids, ++head);
    }


    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) {
            return asteroids;
        }

        Stack<Integer> lifoPosAsteroids = new Stack<>();
        int destroyed = 0;

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                lifoPosAsteroids.add(i);
            } else if (asteroids[i] < 0) {
                //collide asteroids if there is prev +ve Ast
                while (lifoPosAsteroids.size() > 0 && asteroids[i] != 0) { //0 means destroyed
                    // continue to asteroids[i] is not destroyed
                    int prevPos = lifoPosAsteroids.pop();
                    if (asteroids[prevPos] == -asteroids[i]) { //asteroids[i] must be negetive
                        asteroids[prevPos] = 0;
                        asteroids[i] = 0;
                        destroyed += 2;
                    } else if (asteroids[prevPos] > -asteroids[i]) {
                        lifoPosAsteroids.push(prevPos);
                        asteroids[i] = 0;
                        destroyed++;
                    } else if (asteroids[prevPos] < -asteroids[i]) {
                        asteroids[prevPos] = 0;
                        destroyed++;
                    }
                }
            }
        }

        int[] toReturn = new int[asteroids.length - destroyed];

        for (int i = 0, j = 0; i < asteroids.length; i++) {
            if(asteroids[i] != 0) {
                toReturn[j] = asteroids[i];
                j++;
            }
        }

        return toReturn;
    }


    public int[] asteroidCollisionAns(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast: asteroids) {
            collision: {
                //!stack.isEmpty() implies it contain some element, so has a chance to collide
                // ast < 0 implies it's negative and thus has a chance to collide
                // 0 < stack.peek() implies the prev ast is +ve, has a chance to collide
                // else add all to Stack
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        //stack's ast is destroyed, then collide next
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        //both destroyed, then break;
                        stack.pop();
                    }
                    //curr ast destroyed
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
