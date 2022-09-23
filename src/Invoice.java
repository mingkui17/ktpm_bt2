import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String customer;
    private List<Performance> performances = new ArrayList<Performance>();

    public Invoice(String customer) {
        this.customer = customer;
    }

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String printStatement() {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + getCustomer() + "\n";

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        for (Performance perf : getPerformances()) {
            volumeCredits += Math.max(perf.getAudience() - 30, 0);

            if ("comedy".equals(perf.getPlay().getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            result += perf.toString() + "\n";
            totalAmount += perf.getAmount();
        }
        result += "Amount owed is " + currencyFormat.format(totalAmount / 100) + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        return result;
    }
}