package ua.edu.ucu;

import ua.edu.ucu.decorator.MockedDocument;
import ua.edu.ucu.decorator.TimedDocumet;

public class Main {
    public static void main(String[] args) {
        MockedDocument mock = new MockedDocument("paht");
        TimedDocumet timedDocumet = new TimedDocumet(mock);
        System.out.println(timedDocumet.parse());
    }


}