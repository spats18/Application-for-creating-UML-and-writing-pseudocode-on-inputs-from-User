package src;

import java.util.List;

public class StrategyLine extends Strategy{

    @Override
    public void algorithm(List<Integer> coordinates) {
        super.notifying();
    }
    public String chosen(){
        return choice;
    }
    
}
