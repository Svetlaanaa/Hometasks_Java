package J2.Hometask_3.Task1;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Moex {

    private Securities securities;

    @JsonGetter("securities")
    public Securities getSecurities() {
        return securities;
    }
}