package entity;

import java.util.Date;

public class History {
    private Double num1;
    private Double num2;
    private double result;
    private String operation;
    private Date dt;

    public History(Double num1, Double num2, Double result, String operation, Date dt) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
        this.dt = dt;
    }

    public Double getNum1() {
        return num1;
    }

    public Double getNum2() {
        return num2;
    }

    public Double getResult() {
        return result;
    }

    public String getOperation() {
        return operation;
    }
}
