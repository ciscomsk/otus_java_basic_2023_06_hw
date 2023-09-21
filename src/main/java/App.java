import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        User user1 = new User("Михайлов", "Михаил", "Михайлович", 1986, "mickhailoff@gmail.com");
//        user1.showInfo();

        User[] users = {
                user1,
                new User("Иванов", "Иван", "Иванович", 1976, "ivanoff@gmail.com"),
                new User("Петров", "Петр", "Петрович", 1966, "petroff@gmail.com")
        };

        for (int i = 0; i < users.length; i++) {
            if ((LocalDate.now().getYear() - users[i].getBirthYear()) > 40) {
                users[i].showInfo();
            }
        }
        System.out.println();


        Box box = new Box(10.0F, 10.0F, 10.0F, "White", BoxState.CLOSED, null);
        box.showInfo();
        System.out.println();

        String drill = "drill";
        String hammer = "hammer";

        box.throwAwayItem();
        box.putItem(drill);
        box.setState(BoxState.OPEN);
        box.throwAwayItem();
        box.putItem(drill);
        box.putItem(hammer);
        box.setState(BoxState.CLOSED);
    }
}
