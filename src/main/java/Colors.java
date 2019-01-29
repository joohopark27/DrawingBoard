package main.java;

public enum Colors {

    RED (0xFF0000),
    BLUE (0x0000FF),
    GREEN (0x00FF00),
    BLACK (0x000000),
    YELLOW (0xFFFF00),
    AQUA (0x00FFFF),
    NAVY (0x000080),
    PURPLE (0x800080),
    WHITE (0xFFFFFF);

    private int val;

    Colors(int val){

        this.val = val;

    }

    public int getVal(){

        return val;

    }

}
