public class Split {

    double amount;
    User user;

    public Split( User user, double amount) {
        this.amount = amount;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

}
