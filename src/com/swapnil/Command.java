package com.swapnil;

public  class Command{
    public int count;
    public CommandType type;

    public Command(int c, CommandType t){
        this.count = c;
        this.type = t;
    }
}