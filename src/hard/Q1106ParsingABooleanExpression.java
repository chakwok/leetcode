package hard;

public class Q1106ParsingABooleanExpression {
    public static void main(String[] args) {
        Q1106ParsingABooleanExpression app = new Q1106ParsingABooleanExpression();
        System.out.println(app.parseBoolExpr("!(f)"));
        System.out.println(app.parseBoolExpr("|(f,t)"));
        System.out.println(app.parseBoolExpr("&(t,f)"));
        System.out.println(app.parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    public boolean parseBoolExpr(String expression) {
        return evaluate(0, expression.length(), expression);
    }

    private boolean evaluate(int lo, int hi, String expression) {
        if(expression.charAt(lo) == 't') {
            return true;
        } else if(expression.charAt(lo) == 'f') {
            return false;
        }

        int nested = 1;
        int pos = lo + 2;
        while (nested != 0) {
            if(expression.charAt(pos) == '(') {
                nested += 1;
            } else if(expression.charAt(pos) == ')') {
                nested -= 1;
            }

            pos ++;
        }
        pos--;
        pos--;

        if(expression.charAt(lo) == '!') {
            return not(lo + 2, pos, expression);
        } else if(expression.charAt(lo) == '&') {
            return and(lo + 2, pos, expression);
        } else if(expression.charAt(lo) == '|') {
            return or(lo + 2, pos, expression);
        }

        System.out.println("not here");
        return false;

    }

    private boolean not(int lo, int hi, String str) {
        return !evaluate(lo, hi, str);
    }

    private boolean and(int lo, int hi, String str) {
        boolean result = true;
        int start = lo;
        int nested = 0;
        for(int i = lo; i <= hi; i++) {
            if(str.charAt(i) == '(') {
                nested +=1;
            } else if(str.charAt(i) == ')') {
                nested -=1;
            }
            if(nested == 0 && str.charAt(i) == ',') {
                result = result && evaluate(start, i, str);
                start = i + 1;
            }
        }
        return result && evaluate(start, hi, str);

//        return evaluate(lo, split, str) && evaluate(split + 1, hi, str);
    }
    private boolean or(int lo, int hi, String str) {
//        return evaluate(lo, split, str) || evaluate(split + 1, hi, str);
        boolean result = false;
        int start = lo;
        int nested = 0;
        for(int i = lo; i <= hi; i++) {
            if(str.charAt(i) == '(') {
                nested +=1;
            } else if(str.charAt(i) == ')') {
                nested -=1;
            }
            if(nested == 0 && str.charAt(i) == ',') {
                result = result || evaluate(start, i, str);
                start = i + 1;
            }
        }
        return result || evaluate(start, hi, str);
    }

}
