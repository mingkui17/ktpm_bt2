import java.text.NumberFormat;

public class Performance {
    private int audience;
    private Play play;
    private int amount;
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
        calculateAmount();
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void calculateAmount() {
        int audience = this.getAudience();
        switch (play.getType()) {
            case "tragedy":
                this.amount = 40000;
                if (audience > 30) {
                    this.amount += 1000 * (audience - 30);
                }
                break;
            case "comedy":
                this.amount = 30000;
                if (audience > 20) {
                    this.amount += 10000 + 500 * (audience - 20);
                }
                this.amount += 300 * audience;
                break;
            default:
                throw new Error("unknown type: " + play.getType());
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%d seats)", getPlay().getName(), currencyFormat.format(getAmount() / 100),
                getAudience());
    }
}