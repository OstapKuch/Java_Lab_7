package ua.lviv.iot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private List<String> list = new ArrayList<String>();

    public static String readInputText() throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        return br.readLine();

    }


    public String deleteArticles(final String text) {
        String result = text;
        for (String s : list) {
            String upperCase = s.substring(0, 1).toUpperCase() + s.substring(1);
            Pattern pattern = Pattern.compile("((\\s)" + s + "(\\s))|("
                    + upperCase + "(\\s))|((\\s)" + s + "(\\p{Punct" + "}))");
            Matcher matcher = pattern.matcher(result);
            while (matcher.find()) {
                String plateNumber = matcher.group();
                //System.out.println(plateNumber);
            }
            result = matcher.replaceAll(" ");
        }
        return result;
    }

    public void showResults(final String result) {

        System.out.print(result);

    }


    public List getList() {
        return list;
    }

    public void addToList(final String element) {
        this.list.add(element);
    }
}
