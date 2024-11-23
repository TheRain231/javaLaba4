import java.util.ArrayList;
import java.util.List;

class User {
    int id;
    String name;
    String company;
    String username;
    String email;
    String address;
    String zip;
    String state;
    String country;
    String phone;
    String photo;

    public User(int id, String name, String company, String username, String email, String address,
                String zip, String state, String country, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.username = username;
        this.email = email;
        this.address = address;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.photo = photo;
    }

    public String toString() {
        return "ID: " + id + "\n"
                + "Name: " + name + "\n"
                + "Username: " + username + "\n"
                + "Company: " + company + "\n"
                + "Email: " + email + "\n"
                + "Address: " + address + "\n"
                + "ZIP: " + zip + "\n"
                + "State: " + state + "\n"
                + "Country: " + country + "\n"
                + "Phone: " + phone + "\n"
                + "Photo URL: " + photo + "\n"
                + "-------------------------";
    }

    public static List<User> parseJsonToUsers(String jsonString) {
        List<User> users = new ArrayList<>();
        jsonString = jsonString.substring(1, jsonString.length() - 1);  // Убираем квадратные скобки
        String[] userStrings = jsonString.split("(?<=}),\\s*(?=\\{)");  // Разделяем по объектам

        for (String userString : userStrings) {
            userString = userString.replace("{", "").replace("}", "").trim();  // Убираем фигурные скобки
            String[] fields = userString.split(",");  // Разделяем по ключам

            int id = 0;
            String name = "", company = "", username = "", email = "", address = "", zip = "",
                    state = "", country = "", phone = "", photo = "";

            for (String field : fields) {
                String[] keyValue = field.split("\":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim().replace("\"", "");
                    String value = keyValue[1].trim().replace("\"", "");

                    switch (key) {
                        case "id":
                            id = Integer.parseInt(value);
                            break;
                        case "name":
                            name = value;
                            break;
                        case "company":
                            company = value;
                            break;
                        case "username":
                            username = value;
                            break;
                        case "email":
                            email = value;
                            break;
                        case "address":
                            address = value;
                            break;
                        case "zip":
                            zip = value;
                            break;
                        case "state":
                            state = value;
                            break;
                        case "country":
                            country = value;
                            break;
                        case "phone":
                            phone = value;
                            break;
                        case "photo":
                            photo = value;
                            break;
                    }
                }
            }
            users.add(new User(id, name, company, username, email, address, zip, state, country, phone, photo));
        }

        return users;
    }
}