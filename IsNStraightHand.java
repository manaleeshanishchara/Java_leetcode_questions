import java.util.*;

class IsNStraightHand {

    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;

        boolean answer = isNStraightHand(hand, groupSize);

    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int handSize = hand.length;
        if (handSize % groupSize != 0) {
            return false;
        }

        // TreeMap to store the count of each card value
        Map<Integer, Integer> cardCount = new TreeMap<>();
        for (int i = 0; i < handSize; i++) {
            cardCount.put(hand[i], cardCount.getOrDefault(hand[i], 0) + 1);
        }

        while (cardCount.size() > 0) {
            int current_card = cardCount.entrySet().iterator().next().getKey();

            for (int i = 0; i < groupSize; i++) {

                if (!cardCount.containsKey(current_card + i)) {
                    return false;
                }

                cardCount.put(current_card + i, cardCount.get(current_card + i) - 1);

                if (cardCount.get(current_card + i) == 0) {
                    cardCount.remove(current_card + i);
                }

            }
        }

        return true;
    }
}