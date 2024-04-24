
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private final ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        cards.forEach(System.out::println);
    }

    public void sort() {
        cards.sort(Comparator.comparing(Card::getValue).thenComparing(Card::getSuit));
    }

    @Override
    public int compareTo(Hand hand) {
        int thisHandValue = this.cards.stream().mapToInt(Card::getValue).sum();
        int handValue = hand.cards.stream().mapToInt(Card::getValue).sum();
        return Integer.compare(thisHandValue, handValue);
    }

    public void sortBySuit() {
        cards.sort((Card c1, Card c2) -> {
            int suitDiff = c1.getSuit().ordinal() - c2.getSuit().ordinal();
            if (suitDiff != 0) {
                return suitDiff;
            }
            return Integer.compare(c1.getValue(), c2.getValue());
        });
        print();

    }
}
