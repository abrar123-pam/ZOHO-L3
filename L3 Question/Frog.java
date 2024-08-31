import java.util.Scanner;

 class Frog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 4;
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        int count = 0;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
                if (i >= minX && i <= maxX && j >= minY && j <= maxY) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}