import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class PrintJSON {
    static void printJSON(String link, JSONKind kind) {
        StringBuilder jsonString = new StringBuilder();
        try {
            URL url = new URL(link);

            InputStream in = url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                jsonString.append(inputLine);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        // Преобразование строки JSON в список объектов
        switch (kind){
            case USER:
                List<User> users = User.parseJsonToUsers(jsonString.toString());
                System.out.println("USERS");
                for (User user : users) {
                    System.out.println(user);
                }
                break;
            case COMPANY:
                List<Company> companies = Company.parseJsonToUsers(jsonString.toString());
                System.out.println("COMPANIES");
                for (Company company : companies) {
                    System.out.println(company);
                }
                break;
        }

        // Выводим информацию о каждом пользователе

    }

    enum JSONKind{
        USER,
        COMPANY
    }
}
