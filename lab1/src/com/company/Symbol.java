package com.company;

public class Symbol {
    char symbol;
    int priority = 0;



    public  Symbol(char c, int p) {
        symbol = c;
        priority = p;
    }

    public Symbol() {
        symbol = '.';
        priority = 0;
    }

    public boolean isValid() {
        return this.symbol != '.';
    }

}