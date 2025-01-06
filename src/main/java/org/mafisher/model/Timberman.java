package org.mafisher.model;

import org.mafisher.enums.RGBColorEnums;

public class Timberman {
    //true = left side
    //false = right side
    private boolean side;
    private boolean animation = false;
//    private TextColor color = new TextColor.RGB(166, 13, 31); // 166, 13, 31
    private RGBColorEnums color = RGBColorEnums.RED;

    public RGBColorEnums getColor() {
        return color;
    }

    public void setColor(RGBColorEnums color) {
        this.color = color;
    }

    public Timberman() {
        side = true;
    }

    public void switchSide(){
        side = !side;
    }

    public void setLeftSide(){
        side = true;
        animation = true;
    }

    public void setRightSide(){
        side = false;
        animation = true;
    }

    public boolean isLeftSide(){
        return side;
    }

    public boolean isRightSide(){
        return !side;
    }

    public boolean getSide(){
        return side;
    }

    public boolean getAnimation(){
        return animation;
    }

    public void setAnimation(boolean animation){
        this.animation = animation;
    }
}
