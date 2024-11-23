public class Main {
    public static void main(String[] args) {
        String[] links = {"https://fake-json-api.mock.beeceptor.com/users",
                "https://fake-json-api.mock.beeceptor.com/companies"};

        PrintJSON.printJSON(links[0], PrintJSON.JSONKind.USER);
        System.out.println();
        PrintJSON.printJSON(links[1], PrintJSON.JSONKind.COMPANY);
    }
}