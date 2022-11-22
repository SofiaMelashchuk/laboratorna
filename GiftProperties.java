package gift;
import sweets.Candy;
import java.util.Comparator;

public class GiftProperties {
    Gift gift;
    GiftProperties(Gift gift) {
        this.gift = gift;
    }

    public void printGiftCandies() {
        System.out.printf(String.valueOf(gift.getCandies()));
    }

    public void printCandiesThatMatchSugar(Double minSugar, Double maxSugar) {
        System.out.printf("\n\nCANDIES WITH MIN SUGAR - " + minSugar + " AND MAX SUGAR - " + maxSugar + "\n");
        var filteredCandies = gift.getCandies()
                .stream()
                .filter(candy -> candy.getSugar() >= minSugar && candy.getSugar() <= maxSugar)
                .toList();

        System.out.printf(String.valueOf(filteredCandies));
    }

    public void printSortedCandiesByPrice() {
        System.out.print("\n\nCANDIES SORTED BY INCREASING PRICE\n");
        var sortedCandies = gift.getCandies();
        sortedCandies.sort(Comparator.comparingDouble(Candy::getPrice));
        System.out.printf(String.valueOf(sortedCandies));
    }

    public void printTotalWeight() {
        int totalWeight = 0;
        for (final Candy candy: gift.candies) {
            totalWeight += candy.getWeight();
        }
        System.out.println("\n\nGIFT WEIGHT = " + totalWeight + " GRAMS");
    }
}
