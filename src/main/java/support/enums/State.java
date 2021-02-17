package support.enums;


//Alternative solution: Create a method that loops through all state items, calls getText, and selects item if text.equals(expected)

public enum State {

    ALABAMA(1),
    COLORADO(6);

    private Integer value;

    State(Integer value){
        this.value=value;
    }

    public Integer getValue(){
        return value;
    }
}
