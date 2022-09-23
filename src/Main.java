import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Play> plays = new HashMap<>();
        plays.put(Constants.PLAY_HAMLET_ID, new Play(Constants.PLAY_HAMLET_ID, "Hamlet", "tragedy"));
        plays.put(Constants.PLAY_AS_LIKE_ID, new Play(Constants.PLAY_AS_LIKE_ID, "As You Like It", "comedy"));
        plays.put(Constants.PLAY_OTHELLO_ID, new Play(Constants.PLAY_OTHELLO_ID, "Othello", "tragedy"));

        Invoice invoice = new Invoice("BigCo");

        invoice.getPerformances().add(new Performance(plays.get(Constants.PLAY_HAMLET_ID), 55));
        invoice.getPerformances().add(new Performance(plays.get(Constants.PLAY_AS_LIKE_ID), 35));
        invoice.getPerformances().add(new Performance(plays.get(Constants.PLAY_OTHELLO_ID), 40));

        System.out.println(invoice.printStatement());
    }
}