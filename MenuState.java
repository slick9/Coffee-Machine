package machine;

public enum MenuState {
    MAIN_MENU("Write action (buy, fill, take, remaining, exit): "),
    OFF("Switching off the machine"),
    BUY("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "),
    REMAINING("remaining"),
    FILLING("filling"),
    TAKE("taking");

    String menuOutput;

    MenuState(String menuOutput){
        this.menuOutput = menuOutput;
    }

}