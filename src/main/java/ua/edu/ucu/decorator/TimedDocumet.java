package ua.edu.ucu.decorator;

import lombok.AllArgsConstructor;
import java.time.Duration;
import java.time.LocalTime;

@AllArgsConstructor
public class TimedDocumet implements Document{
    private Document doc;

    @Override
    public String parse(){
        LocalTime startTime = LocalTime.now();
        String parsed = doc.parse();

        LocalTime endTime = LocalTime.now();
        System.out.println("Time: " + Duration.between(startTime, endTime).getSeconds());
        return parsed;
    }

    @Override
    public String getGcsPath() {
        return doc.getGcsPath();
    }
}
