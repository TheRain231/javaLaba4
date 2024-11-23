import java.util.ArrayList;
import java.util.List;

public class Company {
    int id;
    String name;
    String address;
    String zip;
    String country;
    int employeeCount;
    String industry;
    long marketCap;
    String domain;
    String logo;
    String ceoName;

    public Company(int id, String name, String address, String zip, String country, int employeeCount, String industry, long marketCap, String domain, String logo, String ceoName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.country = country;
        this.employeeCount = employeeCount;
        this.industry = industry;
        this.marketCap = marketCap;
        this.domain = domain;
        this.logo = logo;
        this.ceoName = ceoName;
    }

    public String toString() {
        return "ID: " + id + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "ZIP: " + zip + "\n"
                + "Country: " + country + "\n"
                + "Employee count: " + employeeCount + "\n"
                + "Industry: " + industry + "\n"
                + "Market cap: " + marketCap + "\n"
                + "Domain: " + domain + "\n"
                + "Logo URL: " + logo + "\n"
                + "CEO Name: " + ceoName + "\n"
                + "-------------------------";
    }

    public static List<Company> parseJsonToUsers(String jsonString) {
        List<Company> companies = new ArrayList<>();
        jsonString = jsonString.substring(1, jsonString.length() - 1);  // Убираем квадратные скобки
        String[] companyStrings = jsonString.split("(?<=}),\\s*(?=\\{)");  // Разделяем по объектам

        for (String companyString : companyStrings) {
            companyString = companyString.replace("{", "").replace("}", "").trim();  // Убираем фигурные скобки
            String[] fields = companyString.split(",");  // Разделяем по ключам

            int id = 0, employeeCount = 0;
            long marketCap = 0;
            String name = "", address = "", zip = "", country = "",
                    industry = "", domain = "", logo = "", ceoName = "";

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
                        case "address":
                            address = value;
                            break;
                        case "zip":
                            zip = value;
                            break;
                        case "country":
                            country = value;
                            break;
                        case "employee_count":
                            employeeCount = Integer.parseInt(value);
                            break;
                        case "market_cap":
                            marketCap = Long.parseLong(value);
                            break;
                        case "domain":
                            domain = value;
                            break;
                        case "logo":
                            logo = value;
                            break;
                        case "ceoName":
                            ceoName = value;
                            break;
                    }
                }
            }
            companies.add(new Company(id, name, address, zip, country, employeeCount, industry, marketCap, domain, logo, ceoName));
        }
        return companies;
    }
}
