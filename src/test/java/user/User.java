package user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class User {

    private String firstName;
    private String lastName;
    private int gender;

    String[] maleFirstName = {"Peter", "Mark", "John", "Stephen"};
    String[] maleLastName = {"Smith", "Johnson", "Williams", "Jones"};
    String[] femaleFirstName = {"Alicia", "Amanda", "Catherine", "Jennifer"};
    String[] femaleLastName = {"Taylor", "White", "Harris", "Gonzalez"};
    String[] userAddress = {"Green Street 1", "9th Street 8", "Jones Street 59", "1st Avenue"};
    String[] userLocality = {"New York", "Boston", "Baltimore", "Denver"};
    String[] userRegion = {"AB", "DA", "WT", "AD"};

    Random random = new Random();

    private int randomIndex() {
        return random.nextInt(4);
    }

    public User() {
        this.gender = random.nextInt(2);
        this.firstName = createFirstName();
        this.lastName = createLastName();

    }

    public String createFirstName() {
        if (gender == 0) {
            this.firstName = maleFirstName[randomIndex()];
        } else {
            this.firstName = femaleFirstName[randomIndex()];
        }
        return firstName;
    }

    public String createLastName() {
        if (gender == 0) {
            this.lastName = maleLastName[randomIndex()];
        } else {
            this.lastName = femaleLastName[randomIndex()];
        }
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGender() {
        return gender;
    }

    private int createRandomValue(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public String createDateOfBirth() {
        int day = createRandomValue(1, 28);
        int month = createRandomValue(1, 12);
        int year = createRandomValue(1960, 2000);
        LocalDate date = LocalDate.of(year, month, day);
        String myDate = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return myDate;
    }

    public String createSSN() {
        String numberSSN = "";
        while (numberSSN.length() < 10) {
            int num = random.nextInt(9);
            numberSSN += Integer.toString(num);
        }
        return numberSSN.substring(0, 3) + "-" + numberSSN.substring(4, 6) + "-" + numberSSN.substring(5, 9);
    }

    public String createEmailAddress() {
        int number = random.nextInt(80);
        return this.firstName.toLowerCase() + number + "@mail.com";
    }

    public String userCompleteAddress(int fieldIndex) {
        String address = userAddress[randomIndex()];
        String locality = userLocality[randomIndex()];
        String region = userRegion[randomIndex()];
        switch (fieldIndex) {
            case 0:
                return address;
            case 1:
                return locality;
            case 2:
                return region;
            case 3:
                String postalCode = "";
                while (postalCode.length() < 5) {
                    postalCode += random.nextInt(9);
                }
                return postalCode;
            case 4:
                String country = "US";
                return country;
            case 5:
            case 6:
            case 7:
                return createPhoneNumber();
            default:
                return "array doesn't exist";
        }
    }

    public String createPhoneNumber() {
        String phoneNumber = "";
        while (phoneNumber.length() < 11) {
            phoneNumber += random.nextInt(9);
        }
        return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10);
    }
}
