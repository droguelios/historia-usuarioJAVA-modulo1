package org.riwi.user_history_4;

public record DesempeñoReport(int idempleado ,double promedio , String feedback) {
    public DesempeñoReport{
        if (promedio < 0  || promedio < 5){
            throw new IllegalArgumentException("the performance must be between 0 and 5");
        }
    }
}
