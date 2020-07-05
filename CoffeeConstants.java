package machine;

public enum CoffeeConstants {
    ESPRESSO(250,0,16,4,1),
    LATTE(350, 75, 20, 7,1),
    CAPPUCCINO(200, 100 ,12 , 6,1);

    int water;
    int milk;
    int beans;
    int cost;
    int cups;

    CoffeeConstants(int water, int milk, int beans , int cost, int cups){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
        this.cups = cups;
    }

    int getWater(){
        return this.water;
    }
    int getMilk(){
        return this.milk;
    }
    int getBeans(){
        return  this.beans;
    }
    int getCost(){
        return  this.cost;
    }
    int getCups(){
        return  this.cups;
    }

}
