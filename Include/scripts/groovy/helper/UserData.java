package helper;

import com.github.javafaker.Faker;
import com.kms.katalon.core.configuration.RunConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class UserData {

    public String gender;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String day;
    public String month;
    public String year;
    public boolean newsletter;

    public static UserData getNewUser() {
        Faker faker = new Faker();
        Random random = new Random();

        UserData user = new UserData();

        // Generate gender
        user.gender = random.nextBoolean() ? "Male" : "Female";

        // Generate name
        user.firstName = faker.name().firstName();
        user.lastName = faker.name().lastName();

        // Generate email and password
        user.email = "auto_" + System.currentTimeMillis() + "@gmail.com";
        user.password = faker.internet().password(8, 12);

        // Generate DOB
        int day = faker.number().numberBetween(1, 32);
        int monthIndex = faker.number().numberBetween(0, 12);
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        user.month = months[monthIndex]+" ";

        int year = faker.number().numberBetween(1900, 2025);
        user.day = String.valueOf(day);
        user.year = String.valueOf(year)+" ";

        // Newsletter
        user.newsletter = random.nextBoolean();

        try {
            // Ensure folder exists
            File file = new File(RunConfiguration.getProjectDir() + "/Include/config/dataBase.properties");
            File folder = file.getParentFile();
            if (!folder.exists()) folder.mkdirs();

            // Unique user index
            long userIndex = System.currentTimeMillis();

            // Write user data block in required format
            FileWriter fw = new FileWriter(file, true); // append mode
            fw.write("#--------------------------------------------------------------------------------------------------------\n");
            fw.write("email" + userIndex + "=" + user.email + "\n");
            fw.write("password" + userIndex + "=" + user.password + "\n");
            fw.write("firstName" + userIndex + "=" + user.firstName + "\n");
            fw.write("lastName" + userIndex + "=" + user.lastName + "\n");
            fw.write("gender" + userIndex + "=" + user.gender + "\n");
            fw.write("day" + userIndex + "=" + user.day + "\n");
            fw.write("month" + userIndex + "=" + user.month + "\n");
            fw.write("year" + userIndex + "=" + user.year + "\n");
            fw.write("newsletter" + userIndex + "=" + user.newsletter + "\n");
            fw.write("#--------------------------------------------------------------------------------------------------------\n");
            fw.flush();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
