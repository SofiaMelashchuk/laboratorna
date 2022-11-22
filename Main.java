import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        StartProgram startP = new StartProgram(p);
        HelpProgram helpP = new HelpProgram(p);
        ExitProgram exitP = new ExitProgram(p);
        HistoryProgram historyP = new HistoryProgram(p);

        Invoker i = new Invoker(startP, helpP, exitP, historyP);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 if START, 2 if HELP, 3 if HISTORY, 4 if EXIT");
        int num = scanner.nextInt();

        switch (num) {
            case 1 -> i.startProgram();
            case 2 -> i.helpProgram();
            case 3 -> i.historyProgram();
            case 4 -> i.exitProgram();
            default -> System.out.println("WRONG CHOICE");
        }
    }
}

