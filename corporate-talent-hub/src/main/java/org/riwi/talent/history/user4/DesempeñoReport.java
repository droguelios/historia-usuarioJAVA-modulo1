package org.riwi.talent.history.user4;

public record DesempeñoReport(int idempleado ,double promedio , String feedback) {
    public DesempeñoReport{
        if (promedio < 0  || promedio < 5){
            throw new IllegalArgumentException("the performance must be between 0 and 5");
        }
    }
}
