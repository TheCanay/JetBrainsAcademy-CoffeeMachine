package machine;
import java.util.Scanner;
public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    static int waterMl = 400;
    static int milkMl = 540;
    static int coffeeBeansG = 120;
    static int money = 550;
    static int disposableCups = 9;
    static boolean machineOn = true;

    private static void machineState() {
        System.out.println("The coffee machine has:\n" +
                waterMl + " of water\n" +
                milkMl + " of milk\n" +
                coffeeBeansG + " of coffee beans\n" +
                disposableCups + " of disposable cups\n" +
                money + " of money");
    }

    private static void abilityToMakeCoffee(String coffeeType) {
        switch (coffeeType) {
            case "1":
                if (waterMl - 250 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeBeansG - 16 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (disposableCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    waterMl -= 250;
                    coffeeBeansG -= 16;
                    money += 4;
                    disposableCups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if (waterMl - 350 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkMl - 75 < 0) {
                    System.out.println("Sorry, not enough milk!");
                }  else if (coffeeBeansG - 20 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (disposableCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    waterMl -= 350;
                    milkMl -= 75;
                    coffeeBeansG -= 20;
                    money += 7;
                    disposableCups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if (waterMl - 200 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkMl - 100 < 0) {
                    System.out.println("Sorry, not enough milk!");
                }  else if (coffeeBeansG - 12 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (disposableCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    waterMl -= 200;
                    milkMl -= 100;
                    coffeeBeansG -= 12;
                    money += 6;
                    disposableCups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            default:
                break;
        }
    }

    private static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();
        if(coffeeType.equals("back")) {
            return;
        } else {
            abilityToMakeCoffee(coffeeType);
        }
        return;
    }

    private static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        waterMl += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkMl += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeansG += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCups += scanner.nextInt();
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money -= money;
    }

    public static void main(String[] args) {

        while (machineOn) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String userAction = scanner.nextLine();
            switch (userAction) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    machineState();
                    break;
                case "exit":
                    machineOn = false;
                    break;
                default:
                    break;
            }
        }
    }
}
