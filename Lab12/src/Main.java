import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static FileReader reader;

    private static String getWords() {
        Scanner scanner = new Scanner(reader);
        StringBuilder string = new StringBuilder().append(scanner.nextLine());
        StringTokenizer stringTokenizer = new StringTokenizer(string.toString(), " ", false);

        ArrayList<String> words = new ArrayList<String>();
        int temp = stringTokenizer.countTokens();
        for (int i = 0; i < temp; i++) {
            words.add(stringTokenizer.nextToken());
        }

        int maxSteps = words.size();
        int step = 0;
        string = new StringBuilder();
        String last = "";
        if (words.size() > 0) {
            string.append(words.get(0));
            last = words.get(0);
            words.remove(0);
        }

        while (step != maxSteps && words.size() != 0) {
            for (int i = 0; i < words.size(); i++) {
                if (last.toLowerCase().charAt(last.length() - 1) == words.get(i).toLowerCase().charAt(0)) {
                    string.append(" ").append(words.get(i));
                    last = words.get(i);
                    words.remove(i);
                    break;
                }
            }
            step += 1;
        }
        return string.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File name: ");
        String filename = scanner.nextLine();
        reader = new FileReader(filename);
        System.out.println(getWords());
    }
}