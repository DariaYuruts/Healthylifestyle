package com.example.healthylifestyle.Information;

public class CPFC {
    int cpfc;
    String cpfcDate;

    public CPFC() {}

    public CPFC(int cpfc, String cpfcDate) {
        this.cpfc = cpfc;
        this.cpfcDate = cpfcDate;
    }

    public int getCpfc() { return cpfc; }

    public void setCpfc(int cpfc) { this.cpfc = cpfc; }

    public String getCpfcDate() { return cpfcDate; }

    public void setCpfcDate(String cpfcDate) { this.cpfcDate = cpfcDate; }
}
