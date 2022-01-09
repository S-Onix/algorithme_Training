package algorithm_fc.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KNapSack {
    /**
     * 1. 비율에 따른 정렬이 필요하다.
     * */

    public void fractionalKnapsackProblem(double limitWeight, ArrayList<Thing> things){

        double totalValue = 0.0;
        double fraction = 0.0;


        Collections.sort(things);

        for(Thing t : things) {
            System.out.println("weight : "+ t.weight + " / value : " + t.value + " / really value : " + t.value/t.weight);
        }

        for(int i = 0 ; i < things.size(); i++) {
            if(limitWeight - things.get(i).weight > 0) {
                totalValue += (double) things.get(i).value;
                limitWeight -= (double) things.get(i).weight;
                System.out.println("wegith : " + things.get(i).weight  + " / value : "+ things.get(i).value);

            }else {
                fraction =  limitWeight / things.get(i).weight;
                totalValue += (double) (things.get(i).value * fraction);

                System.out.println("wegith : " + things.get(i).weight  + " / value : "+ things.get(i).value + " / fraction : " + fraction);
                break;
            }
        }

        System.out.println(totalValue);

    }

    public static void main(String[] args) {
        ArrayList<Thing> thingList = new ArrayList<>();

        Thing t1 = new Thing(10,10);
        Thing t2 = new Thing(15,12);
        Thing t3 = new Thing(20,10);
        Thing t4 = new Thing(25,8);
        Thing t5 = new Thing(30,5);

        thingList.add(t1);
        thingList.add(t2);
        thingList.add(t3);
        thingList.add(t4);
        thingList.add(t5);

        KNapSack solve = new KNapSack();
        solve.fractionalKnapsackProblem(30.0, thingList);

    }


}

class Thing implements Comparable<Thing>{
    public double weight;
    public double value;

    public Thing(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Thing o) {
        return (int) ((o.value / o.weight)- (this.value / this.weight));
    }
}
