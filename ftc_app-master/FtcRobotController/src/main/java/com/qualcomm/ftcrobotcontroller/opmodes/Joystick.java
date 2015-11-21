package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by ibm on 11/4/2015.
 */
public class Joystick {
    public Gamepad gamepad;
    public float yJoystickScale = (float)0.75;

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
        return yJoystickScale*gamepad.left_stick_y;
    }

    public float rightStickY(){
        return yJoystickScale*gamepad.right_stick_y;
    }

    public float leftTrigger(){
        return gamepad.left_trigger;
    }

    public float rightTrigger(){
        return gamepad.right_trigger;
    }
}
