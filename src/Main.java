import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final String FILE_PATH = "\"C:\\Users\\Habiba\\Desktop\\Usersfile.txt\"";
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        User u1=new User();
    }

    public static void readUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5) {
                    String username = userData[0];
                    String password = userData[1];

                    if (!userExistsInArrayList(username, password)) {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setSSN(userData[2]);
                        user.setCc(userData[3]);
                        user.setAddress(userData[4]);
                        users.add(user);
                    }
                } else {
                    System.out.println("Invalid user data format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void writeUsersToFile() {
        File file = new File(FILE_PATH);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (User user : users) {
                String userString = user.getUsername() + "," + user.getPassword() + "," + user.getSSN() + "," + user.getCc() + "," + user.getAddress();
                writer.println(userString);
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static boolean userExistsInArrayList(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


}