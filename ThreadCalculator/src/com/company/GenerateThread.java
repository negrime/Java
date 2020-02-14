package com.company;

class GenerateThread implements Runnable {

    private String result;
    private int count;
    private String name;
    public GenerateThread(int _count, String _name)
    {
        this.count = _count;
        this.name = _name;
    }
    @Override
    public void run() {
        result = ArithmeticExpressionGenerator.GenerateExpression(count, name);
    }

    public String GetResult()
    {
        return result;
    }
}
