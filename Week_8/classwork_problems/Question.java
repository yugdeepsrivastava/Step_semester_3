import java.util.*;
abstract class Question {
    String question;
    String correctAnswer;
    String studentAnswer;
    double points;
    Question(String question, String correctAnswer, String studentAnswer, double points) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    abstract double calculateScore();
    abstract String getType();
}
class MCQ extends Question {
    MCQ(String q, String correct,
        String student, double points) {
        super(q, correct, student, points);
    }
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer))
            return points;
        return 0;
    }
    String getType() {
        return "MCQ";
    }
}
class TrueFalse extends Question {
    TrueFalse(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer))
            return points;
        return 0;
    }
    String getType() {
        return "TF";
    }
}
class Essay extends Question {
    Essay(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }
    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;
        String answer = studentAnswer.toLowerCase();
        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }
        if (count >= 2)
            return points * 0.75;
        if (count == 1)
            return points * 0.50;
        return 0;
    }
    String getType() {
        return "ESSAY";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String question = parts[1];
            String correct = parts[3];
            String student = parts[5];
            String remaining = parts[6].trim();
            double points = Double.parseDouble(remaining);
            if (type.equals("MCQ")) {
                questions[i] = new MCQ( question, correct, student, points);
            }
            else if (type.equals("TF")) {
                questions[i] = new TrueFalse( question, correct, student, points);
            }
            else {
                questions[i] = new Essay( question, correct, student, points);
            }
        }
        double total = 0;
        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);

            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}