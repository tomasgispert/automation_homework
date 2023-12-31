package com.solvd.aux_homework;

import com.solvd.automation_homework.Muscle;
import com.solvd.enums.MusclePrimaryFunction;

import java.util.logging.Logger;

public class AuxMain {

    public static void main(String[] args) {

        final Logger LOGGER = Logger.getLogger("AuxMain.class");
        Muscle quadriceps = new Muscle(1,"Quadriceps",MusclePrimaryFunction.EXTENSOR,true);
        Muscle hamstrings = new Muscle(1,"Hamstrings", MusclePrimaryFunction.FLEXOR,true);


        CustomLinkedList<Muscle> cll = new CustomLinkedList<>();
        cll.add(quadriceps);
        cll.add(hamstrings);
        LOGGER.info(cll.toString());

        CustomLinkedList<String> cll2 = new CustomLinkedList<>();
        cll2.add("X");
        cll2.add("Y");
        cll2.add("Z");
        cll2.addFirst("B");
        cll2.addFirst("A");
        LOGGER.info(cll2.toString());
    }
}
