class Scorecard {
    private boolean[] results;
    private int recorded;
    Scorecard(int questionCount) {
        results = new boolean[questionCount];
        recorded = 0;
    }
    void recordAnswer(boolean correct) {
        if (recorded < results.length) {
            results[recorded] = correct;
            recorded++;
        } else {
            System.out.println("No more answers can be recorded");
        }
    }
    int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}
public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}