package gift;
import file.FileManager;
import sweets.Candy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GiftForming {
    public void startGiftForming() {
        List<Candy> userCandies;
        List<Integer> userInput;
        Gift gift;
        GiftProperties giftProperties;

        userInput = getUserInput();
        userCandies = getCandiesFromInput(userInput);
        gift = createGift(userCandies);
        FileManager.writeGiftToFile(gift);
        giftProperties = new GiftProperties(gift);

        giftProperties.printGiftCandies();
        giftProperties.printCandiesThatMatchSugar(0.7, 1.0);
        giftProperties.printSortedCandiesByPrice();
        giftProperties.printTotalWeight();
    }

    public List<Integer> getUserInput() {
        System.out.println("Enter sweets you want to add: ");

        Scanner scanner = new Scanner(System.in);
        List<Integer> preparedInput = new ArrayList<Integer>();

        try {
            while (true) {
                preparedInput.add(scanner.nextInt());
            }
        }
        catch (Exception ignored) {}
        System.out.println("YOUR GIFT IS READY!");
        return preparedInput;
    }

    private List<Candy> getCandiesFromInput(List<Integer> input) {
        var availableSweets = Candy.getAvailableSweets();

        return input
                .stream()
                .filter(index -> index > 0 && index < availableSweets.size())
                .map(availableSweets::get)
                .toList();
    }

    private Gift createGift(List<Candy> userCandies) {
        Gift preparedGift = new Gift();

        userCandies.forEach(preparedGift::addCandy);
        return preparedGift;
    }
}
