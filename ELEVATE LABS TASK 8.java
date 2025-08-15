import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption; // 1-based index

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of questions
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"},
                2
        ));
        quiz.add(new Question(
                "Who developed Java programming language?",
                new String[]{"James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum"},
                1
        ));
        quiz.add(new Question(
                "Which data structure uses LIFO (Last In First Out)?",
                new String[]{"Queue", "Array", "Stack", "LinkedList"},
                3
        ));

        int score = 0;
        System.out.println("=== Welcome to the Quiz ===\n");

        // Loop through questions
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println((i + 1) + ". " + q.questionText);

            // Display options
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ") " + q.options[j]);
            }

            // Get user's answer
            System.out.print("Your answer (1-" + q.options.length + "): ");
            int answer = sc.nextInt();

            // Check correctness
            if (q.isCorrect(answer)) {
                System.out.println(" Correct!\n");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + q.options[q.correctOption - 1] + "\n");
            }
        }

        // Show final score
        System.out.println("=== Quiz Over ===");
        System.out.println("Your final score: " + score + " / " + quiz.size());

        sc.close();
    }
}
