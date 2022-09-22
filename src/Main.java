import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static String statement (Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoice.getCustomer() + "\n";

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        for (Performance perf : invoice.getPerformances()) {
            Play play = plays.get(perf.getPlayId());

            int thisAmount = 0;

            switch (play.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.getAudience() > 30) {
                    thisAmount += 1000 * (perf.getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.getAudience() > 20) {
                    thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                    }
                    thisAmount += 300 * perf.getAudience();
                    break;
                default:
                    throw new Error("unknown type: " + play.getType());
            }

            volumeCredits += Math.max(perf.getAudience() - 30, 0);

            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            result += play.getName() + ": " + currencyFormat.format(thisAmount/100) + " (" + perf.getAudience() + " seats)\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + currencyFormat.format(totalAmount/100) + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        return result;
    }

    public static void main(String []args){
        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));

        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("hamlet",55));
        performances.add(new Performance("as-like",35));
        performances.add(new Performance("othello",40));
        Invoice invoice = new Invoice("BigCo", performances);

        System.out.println(statement(invoice, plays));
    }
}
