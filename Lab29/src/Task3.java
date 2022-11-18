import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String string = "adjwqw 23.12        USD dde 021,32 EUR dadwd.2 RUB 321.321    RUB";
        String regEx = "([1-9][0-9]*)([.,][0-9]+)?\\s+((RUB)|(EU)|(USD))";
        System.out.println(string);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            System.out.println(matcher.group().replaceAll("\\s{2,}"," "));
        }
    }
}
