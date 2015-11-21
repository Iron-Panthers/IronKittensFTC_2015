package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Joystick {
    public Gamepad gamepad;

    public Joystick(Gamepad gamepad){
        this.gamepad = gamepad;
    }

    public float leftStickX(){
        return gamepad.left_stick_x;
    }

    public float rightStickX(){
        return gamepad.right_stick_x;
    }

    public float leftStickY(){
        return gamepad.left_stick_y;
    }

    public float rightStickY(){
        return gamepad.right_stick_y;
    }

    public boolean leftBumper() { return gamepad.left_bumper; }

    public boolean rightBumper() { return gamepad.right_bumper; }

    public boolean yButton() { return gamepad.y; }

    public boolean xButton() { return gamepad.x;}

    public boolean backButton() { return gamepad.back;}
}