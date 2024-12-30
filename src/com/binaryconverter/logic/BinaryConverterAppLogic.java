package com.binaryconverter.logic;

public class BinaryConverterAppLogic {
    private int decimalValue;
    private StringBuilder binaryOutput = new StringBuilder();

    public void setDecimalValue(int decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Decimal value must be non-negative");
        }
        this.decimalValue = decimal;
    }

    public String getBinaryRepresentation() {
        if (decimalValue == 0) {
            return "0";
        }

        int value = decimalValue;

        while (value > 0) {
            binaryOutput.append(value % 2);
            value /= 2;
        }
        
        System.out.println("info : convert success");
        // Reverse the StringBuilder to get the correct binary order
        return binaryOutput.reverse().toString();
    }
    
    public void clearBinary() {
    	binaryOutput.setLength(0);
    	decimalValue = 0;
    	System.out.println("info : input has been reset");
    }
}

