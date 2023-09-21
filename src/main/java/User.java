public class User {
    private String surname;
    private String firstName;
    private String patronymic;
    private int birthYear;
    private String email;

    public User(String surname, String firstName, String patronymic, int birthYear, String email) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void showInfo() {
        System.out.println("Full name: " + surname + " " + firstName + " " + patronymic);
        System.out.println("Year of birth: " + birthYear);
        System.out.println("EMail: " + email);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
