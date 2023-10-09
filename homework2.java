public class homework2 {
    public static void main(String[] args) {

        for (double x = -3; x <= 4; x += 0.5) {
            // raise the first power
            double raiseFirstPower = 9 * Math.pow(x, 3);
            double raiseSecondPower = -27 * Math.pow(x, 2);
            double thirdElement = -4 * x;
            // raise the denominator side
            double raiseBottomPower = (Math.pow(x, 2) * 3) + 1;
            double squareRoot = Math.sqrt(raiseBottomPower);
            double raiseSecond = Math.pow(x, 4);
            double calculateAbs = Math.abs(5 - raiseSecond);

            double y =
                    (raiseFirstPower + raiseSecondPower + thirdElement + 12) / (squareRoot + calculateAbs);
            System.out.printf("x:%.1f y:%2.3f\n ", x,y);
        }
    }
}