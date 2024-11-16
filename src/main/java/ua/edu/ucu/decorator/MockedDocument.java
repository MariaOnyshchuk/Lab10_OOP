package ua.edu.ucu.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MockedDocument implements Document{
    public String gcsPath;

    @Override
    public String parse(){
        try{
            Thread.sleep(2000);

        }catch (InterruptedException e){

        }
        return "Mocked Doc Parsed";
    }
}
