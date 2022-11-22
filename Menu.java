import file.FileManager;
import gift.GiftForming;
import sweets.Candy;
import java.util.List;

class Program {
    public void help() {
        System.out.println("HELP MENU");
        System.out.println("""
                In this program you can create your NewYearGift
                Firstly you should choose candies and then program will show you
                candies with given range of sugar, sorting by price and weight of your gift!"""
        );
    }
    public void start() {
        System.out.println("START CREATING GIFT");
        List<Candy> availableSweets = Candy.getAvailableSweets();
        System.out.println("Choose sweets for your NewYearGift!\n" + availableSweets);
        new GiftForming().startGiftForming();
    }
    public void exit() {
        System.out.println("EXIT");
        System.exit(0);
    }

    public void history() {
        var gift = FileManager.getGiftFromFile();
        var candies = gift.getCandies();

        if (!candies.isEmpty()) {
            System.out.println("Your previous gift candies:");
            System.out.println(candies);
        }
    }
}
class Invoker {
    private final Command startCommand;
    private final Command helpCommand;
    private final Command exitCommand;
    private final Command historyCommand;

    public Invoker(Command start, Command help, Command exit, Command history) {
        startCommand = start;
        helpCommand = help;
        exitCommand = exit;
        historyCommand = history;
    }

    public void startProgram() { startCommand.execute(); }

    public void helpProgram() {
        helpCommand.execute();
    }

    public void exitProgram() {
        exitCommand.execute();
    }

    public void historyProgram() {
        historyCommand.execute();
    }
}
class StartProgram implements Command {
    Program program;
    public StartProgram(Program program) {
        this.program = program; }
    public void execute() {
        program.start();
    }

    @Override
    public String getMenu() {
        return null;
    }
}
class ExitProgram implements Command {
    Program program;
    public ExitProgram(Program program) {
        this.program = program;
    }
    @Override
    public void execute() {
        program.exit();
    }

    @Override
    public String getMenu() {
        return null;
    }
}
class HelpProgram implements Command {
    Program program;

    public HelpProgram(Program program) {
        this.program = program;
    }

    @Override
    public void execute() {
        program.help();
    }

    @Override
    public String getMenu() {
        return null;
    }
}

class HistoryProgram implements Command {
    Program program;
    public HistoryProgram(Program program) {
        this.program = program;
    }
    @Override
    public void execute() {
        program.history();
    }

    @Override
    public String getMenu() {
        return null;
    }
}


