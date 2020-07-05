// package yolo.yodo.example;

package machine;
import java.util.Scanner;
import machine.CoffeeConstants.*;
import machine.MenuState;

import static machine.MenuState.*;

public class CoffeeMachine {
    Scanner scanner = new Scanner(System.in);
    int water;
    int milk;
    int beans;
    int cups;
    int money;
    MenuState menuState;


    public CoffeeMachine(){
        water = 400;
        milk = 540;
        beans = 120;
        cups = 9;
        money = 550;
        menuState = MAIN_MENU;
    }// constructor ends


    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        while (machine.menuState!= OFF){
            machine.getInput();

        }
    }

    public void  getInput() {
        switch (menuState){
            case MAIN_MENU:
                System.out.println(MAIN_MENU.menuOutput);
                setState(scanner.next());
                break;
            case BUY:
                System.out.println(BUY.menuOutput);
                buy(scanner.next());
                break;
            case TAKE:
                System.out.println(TAKE.menuOutput);
                take();
                break;
            case FILLING:
                System.out.println(FILLING.menuOutput);
                fill();
                break;
            case REMAINING:
                ingredients();
                break;
            case OFF:
                break;

        }
    }

    public void setState(String input){
        switch (input){
            case "buy":
                menuState = BUY;
                break;
            case  "fill":
                menuState = FILLING;
                break;
            case  "take":
                menuState = TAKE;
                break;
            case "remaining":
                menuState = REMAINING;
                break;
            case  "exit":
                menuState = OFF;
                break;
            default:
                System.out.println("Please enter valid action: ");
        }
    }

    public void ingredients() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups+ " of disposable cups");
        System.out.println(money + " of money\n");
        menuState = MAIN_MENU;
    }

    public  void fill(){
        System.out.print("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        beans += scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
        menuState = MenuState.MAIN_MENU;
    }

    public void  buy(String drink){
        switch (drink){
            case "1":
                coffeeSelection(CoffeeConstants.ESPRESSO);
                break;
            case  "2":
                coffeeSelection(CoffeeConstants.LATTE);
                break;
            case "3":
                coffeeSelection(CoffeeConstants.CAPPUCCINO);
                break;
            case "back":
                menuState = MAIN_MENU;
                break;
            default:
                System.out.println("invalid selection");
        }

    }


    public  void  take(){
        System.out.println("I gave you $" + money);
        money =0;
        menuState = MenuState.MAIN_MENU;
    }

    public void coffeeSelection(CoffeeConstants selection){
        if (check_resources(selection.getWater(),selection.getMilk(), selection.getBeans(), selection.getCups())){
            water -= selection.getWater();
            milk -= selection.getMilk();
            beans -= selection.getBeans();
            cups -= selection.getCups();
            money += selection.getCost();
        }
        menuState = MenuState.MAIN_MENU;
    }



    public boolean check_resources(int water , int milk, int beans, int cups){
        if (this.water>=water&& this.milk >=milk &&
             this.beans >= beans && this.cups >= cups){
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }else if (this.water<water){
            System.out.println("Sorry not enough water!");
        }else  if (this.beans<beans){
            System.out.println("Sorry not enough coffee beans!");
        }else if (this.milk<milk){
            System.out.println("Sorry not enough milk!");
        }else {
            System.out.println("Sorry not enough cups!");
        }
        return false;
    }


}
