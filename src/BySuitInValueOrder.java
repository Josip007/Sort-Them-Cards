
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class BySuitInValueOrder implements Comparator<Card> {

    private final ArrayList<Card> cards;

    public BySuitInValueOrder() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int compare(Card c1, Card c2) {
        int suitComparison = c1.getSuit().ordinal() - c2.getSuit().ordinal();
        if (suitComparison != 0) {
            return suitComparison;
        }
        return Integer.compare(c1.getValue(), c2.getValue());
    }
}
