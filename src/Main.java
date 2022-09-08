import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("text.txt");

        for (Map.Entry<String, Long> entry : getSalesMap(reader).entrySet()) {
            System.out.println(entry);
        }
    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> map = new HashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            map.merge(scanner.next(), scanner.nextLong(), Long::sum);
        }
        return map;
    }

}
