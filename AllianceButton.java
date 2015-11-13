package io.github.plenglin.ftc;

import com.qualcomm.robotcore.hardware.*;

/**
	Alliance Button utilities by Maxim
**/
public class AllianceButton {

    /** the ultrasonic sensor id **/
    public static final String ULTRASONIC = "ultrasonic";

    /** the color sensor id **/
    public static final String COLOR_SENSOR = "color";

    /** the motor id **/
    public static final String MOTOR_LEFT = "motor_left", MOTOR_RIGHT = "motor_right";

    /** drive speed **/
    public static final double SLOW = 0.25;

    /** distance between buttons (inches) **/
    public static final double BUTTON_DIST=3;

    /** pressing threshold (inches) **/
    public static final double BUTTON_PRESS=3/2.54d;

    /** buffer distance (inches) **/
    public static final double BUFFER_DIST=3;

    private DriveAuto drive;
    private DcMotor motorL, motorR;
    private UltrasonicSensor ultrasonic;
    private ColorSensor color;
    private AllianceColor teamColor;

    /**
        @param drive The driving utilities
        @param hwm The HardwareMap object that the hardware is sourced from.
        @param team Which alliance the robot is on
    */
    public AllianceButton(DriveAuto drive, HardwareMap hwm, AllianceColor team) {
        this.ultrasonic = hwm.ultrasonicSensor.get(ULTRASONIC);
        this.motorL = hwm.dcMotor.get(MOTOR_LEFT);
        this.motorR = hwm.dcMotor.get(MOTOR_RIGHT);
        this.color = hwm.colorSensor.get(COLOR_SENSOR);
        this.drive = drive;
        this.teamColor = teamColor;
    }

    /**
        Checks the color.
        @return whether the detected color matches the alliance color
    */
    public boolean checkColor() {
    	/*
    	PSEUDOCODE:
    	detected color = null
    	hue = color.argb()
    	if hue in blue range then color = blue
    	if hue in red range then color = red
    	return color == teamcolor
		*/
        return false;
    }

    /**
        Changes the light it is on.
    */
    public void swapLight() {
    	drive.turn(90);
    	drive.driveStraight(BUTTON_DIST, SLOW);
    	drive.turn(-90);
    }

    /**
        Drives forward to hit the button.
    */
    public void hitButton() {

        motorL.setDirection(DcMotor.Direction.FORWARD);
        motorR.setDirection(DcMotor.Direction.FORWARD);

        motorL.setPower(SLOW);
        motorR.setPower(SLOW);

    	while (ultrasonic.getUltrasonicLevels() <= BUTTON_PRESS) {

        }

        motorL.setDirection(DcMotor.Direction.REVERSE);
        motorR.setDirection(DcMotor.Direction.REVERSE);

    	while (ultrasonic.getUltrasonicLevels() >= BUFFER_DIST) {

        }

        motorL.setPower(0);
        motorR.setPower(0);

    }

}
