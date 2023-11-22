package br.ufc.trabalhofinalpds.cartas;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class GenerateRandomMoney {

    public GenerateRandomMoney() {
    }

    public int returnMoneyRandomly() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(15);
        list.add(25);
        list.add(30);
        list.add(40);
        list.add(45);
        list.add(50);
        list.add(80);
        list.add(100);
        list.add(150);
        list.add(200);

        return list.get(rand.nextInt(list.size()));
    }

}
