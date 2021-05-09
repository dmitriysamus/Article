import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFinder {

    public String findString (String searchString, List<String> lines) {
        boolean marker = false;
        String result = "Не найдено";
        Pattern patternStart = Pattern.compile(searchString);
        Pattern patternEnd = Pattern.compile("Конец теста.");
        Pattern patternNotRun = Pattern.compile(searchString + ".+Не проводился.");
        List <String> cutLines = new ArrayList<>();
        cutLines.addAll(lines);
        int cut = 0;
        for (String i:lines) {
            if (!marker) {

                Matcher matcherStart = patternStart.matcher(i);
                while (matcherStart.find()) {
                    result = "\nНомер абзатца " + lines.indexOf(i) + "\nПозиция начала теста "
                            + matcherStart.start();
                    Matcher matcherEnd = patternEnd.matcher(i);
                    while (matcherEnd.find()) {
                        result += "\nНомер абзатца " + (cutLines.indexOf(i) + cut) + "\nПозиция конца теста "
                                + matcherEnd.end();
                    }
                    marker = true;
                }

                Matcher matcherNotRun = patternNotRun.matcher(i);
                while (matcherNotRun.find()) {
                    result = "Тест не проводился!" + "\nНомер абзатца " + (cutLines.indexOf(i) + cut) + "\nПозиция начала теста "
                            + matcherNotRun.start() + "\nПозиция конца теста " + matcherNotRun.end();
                    marker = false;
                }

            } else {
                Matcher matcherEnd = patternEnd.matcher(i);
                while (matcherEnd.find()) {
                    result += "\nНомер абзатца " + (cutLines.indexOf(i) + cut) + "\nПозиция конца теста "
                            + matcherEnd.end();
                    return result;
                }
            }

            cutLines.remove(0);
            cut += 1;

        }
        return result;
    }

}
