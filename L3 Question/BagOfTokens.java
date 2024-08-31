import java.util.*;

class BagOfTokens {

    public static int maxScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int i = 0;
        int j = tokens.length - 1;

        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;
            } else if (score > 0) {
                power += tokens[j];
                score--;
                j--;
            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of tokens: ");
        int n = sc.nextInt();
        int[] tokens = new int[n];

        System.out.println("Enter tokens: ");
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }

        System.out.println("Enter initial power: ");
        int power = sc.nextInt();

        int ans = maxScore(tokens, power);
        System.out.println("Maximum score achievable: " + ans);
    }
}
