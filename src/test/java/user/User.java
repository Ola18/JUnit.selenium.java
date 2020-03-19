package user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NewUser {

    String[] maleFirstName = {"Peter", "Mark", "John", "Stephen"};
    String[] maleLastName = {"Smith", "Johnson", "Williams", "Jones"};
    String[] femaleFirstName = {"Alicia", "Amanda", "Catherine", "Jennifer"};
    String[] femaleLastName = {"Taylor", "White", "Harris", "Gonzalez"};
    String[] userAddress = {"Green Street 1", "9th Street 8", "Jones Street 59", "1st Avenue"};
    String[] userLocality = {"New York", "Boston", "Baltimore", "Denver"};
    String[] userRegion = {"AB", "DA", "WT", "AD"};

    Random random = new Random();

    final private int num = random.nextInt(maleFirstName.length);
    final private boolean gender = femaleGender();

    public NewUser() {
    }

    public boolean femaleGender() {
        boolean gender = random.nextBoolean();
        return gender;
    }

    public int getGender() {
        if (gender) {
            return 1;
        } else {
            return 0;
        }
    }

    public String createFirstName() {
        String firstName;
        if (gender) {
            firstName = femaleFirstName[num];
        } else {
            firstName = maleFirstName[num];
        }
        return firstName;
    }

    public String createLastName() {
        String lastName;
        if (gender) {
            lastName = femaleLastName[num];
        } else {
            lastName = maleLastName[num];
        }
        return lastName;
    }

    private int createRandomValue(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public String createDateOfBirth() {
        int day = createRandomValue(1, 28);
        int month = createRandomValue(1, 12);
        int year = createRandomValue(1960, 2005);
        LocalDate date = LocalDate.of(year, month, day);
        String myDate = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return myDate;
    }

    public String createSSN() {
        Random random = new Random();
        String numberSSN = "";
        while (numberSSN.length() < 10) {
            int num = random.nextInt(9);
            numberSSN += Integer.toString(num);
        }
        return numberSSN.substring(0, 3) + "-" + numberSSN.substring(4, 6) + "-" + numberSSN.substring(5, 9);
    }

    public String createEmailAddress() {
        int number = random.nextInt(80);
        return createFirstName().toLowerCase() + number + "@mail.com";
    }

    public String userCompleteAddress(int fieldIndex) {
        String address = userAddress[num];
        String locality = userLocality[num];
        String region = userRegion[num];
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
