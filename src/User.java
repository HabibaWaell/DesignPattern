import java.io.*;
import java.util.Scanner;

public class User {
    private String username, password, SSN, cc, address;

    public User() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Register \n2. Login\n3. Update Personal Info\n4. Exit");
        int choice = scan.nextInt();

        if (choice == 1) {
            signup();
            loginchecker();
            Main.writeUsersToFile();
        }
        if (choice == 2) {
            loginchecker();
        }
        if (choice == 3) {
            updatePersonalInfo();
        }


    }

    public void signup() throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scan.nextLine();
        System.out.println("Enter your password");
        String pass = scan.nextLine();
        System.out.println("Enter your credit card");
        String cc = scan.nextLine();
        System.out.println("Enter your SSN");
        String ssn = scan.nextLine();
        System.out.println("Enter your location");
        String ad= AddAdress();
        String path;
        path = "C:/Users/Habiba/Desktop/Usersfile.txt";
        File file = new File(path);
        FileWriter writer = new FileWriter(file, true);
        writer.write("\n" + username + "\t");
        writer.write(pass + "\t");
        writer.write(cc + "\t");
        writer.write(ssn + "\t");
        writer.write(ad + "\t");

        writer.close();
        System.out.println("Sign Up successful");


    }

    public String AddAdress() {
        System.out.println("Select your address from the options:");
        System.out.println("1. New Cairo");
        System.out.println("2. Nasr City");
        System.out.println("3. Maadi");
        System.out.println("4. Shrouk");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();


        switch (choice) {
            case 1:
                address = "New Cairo";
                break;
            case 2:
                address = "Nasr City";
                break;
            case 3:
                address = "Maadi";
                break;
            case 4:
                address = "Shrouk";
                break;
            default:
                address = "Unknown";
        }
        return address;

    }

    public void loginchecker() throws IOException {
        do {
            boolean islogin = login();
            if (islogin) {
                System.out.println("Login successful");
                break;
            } else {
                System.out.println("Login Failed ");

            }
        }
        while (true);
    }

    public boolean login() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        boolean autheniticated = false;
        System.out.println("enter your username");
        String username = scan.nextLine();

        System.out.println("enter your password");
        String pass = scan.nextLine();
        String path;
        path = "C:/Users/Habiba/Desktop/Usersfile.txt";

        File file = new File(path);
        Scanner inputBuffer = new Scanner(file);
        while (inputBuffer.hasNext()) {
            String line = inputBuffer.nextLine();
            String[] values = line.split("\t");
            if (values[0].equals(username))
            {
                if (values[1].equals(pass))
                {
                    autheniticated = true;
                    break;
                }
            }
        }

        return autheniticated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public   void updatepersonalinfo()  {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Update Personal Information");
        System.out.println("Username: " + this.getUsername());
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        this.setUsername(newUsername);

        System.out.println("SSN: " + this.getSSN());
        System.out.print("Enter new SSN: ");
        String newSSN = scanner.nextLine();
        this.setSSN(newSSN);

        System.out.println("Credit Card: " + this.getCc());
        System.out.print("Enter new credit card number: ");
        String newCc = scanner.nextLine();
        this.setCc(newCc);

        System.out.println("Address: " + this.getAddress());
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        this.setAddress(newAddress);

        Main.writeUsersToFile();

        System.out.println("Personal information updated successfully.");
    }*/
    public void updatePersonalInfo() {
        Scanner scanner = new Scanner(System.in);

        // Read existing user data from the file
        readUserDataFromFile();

        System.out.println("Update Personal Information");
        System.out.println("Username: " + this.getUsername());
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        this.setUsername(newUsername);

        System.out.println("SSN: " + this.getSSN());
        System.out.print("Enter new SSN: ");
        String newSsn = scanner.nextLine();
        this.setSSN(newSsn);

        System.out.println("Credit Card: " + this.getCc());
        System.out.print("Enter new credit card number: ");
        String newCc = scanner.nextLine();
        this.setCc(newCc);

        System.out.println("Address: " + this.getAddress());
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        this.setAddress(newAddress);

        // Update the file with the new user data
        writeUserDataToFile();

        System.out.println("Personal information updated successfully.");
    }

    private void readUserDataFromFile() {
        // Code to read user data from a file and set the attributes
        String path;
        path = "C:/Users/Habiba/Desktop/Usersfile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            this.username = reader.readLine();
            this.SSN = reader.readLine();
            this.cc = reader.readLine();
            this.address = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
        }
    }

    private void writeUserDataToFile() {
        // Code to write user data to a file
        String path;
        path = "C:/Users/Habiba/Desktop/Usersfile.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(this.getUsername());
            writer.newLine();
            writer.write(this.getSSN());
            writer.newLine();
            writer.write(this.getCc());
            writer.newLine();
            writer.write(this.getAddress());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
        }
    }
}