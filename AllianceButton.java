package io.github.plenglin.ftc;

import com.qualcomm.robotcore.hardware.*

/**
	By Maxim and Matthew
**/
public class AllianceButton {

    /** the ultrasonic sensor id **/
    public static final String ULTRASONIC="ultrasonic", COLOR_SENSOR="RGBsensor";

    /** distance between buttons **/
    public static final double BUTTON_DIST=3;

    /** pressing threshold **/
    public static final double BUTTON_PRESS=3;

    /** buffer distance **/
    public static final double BUFFER_DIST=3;

    private DriveAuto drive;
    private UltrasonicSensor ultrasonic;
    private ColorSensor color;
    private AllianceColor teamColor;

    public AllianceButton(DriveAuto drive, HardwareMap hwm, AllianceColor team) {
        this.ultrasonic = hwm.ultrasonicSensor.get(ULTRASONIC);
        this.color = hwm.colorSensor.get("RGBsensor");
        this.drive = drive;
        this.teamColor = teamColor;
    }

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

    public void swapLight() {
    	drive.turn(90);
    	drive.driveStraight(BUTTON_DIST, 1);
    	drive.turn(-90);
    }

    public void hitButton() {
    	/*
    	PSEUDO-ISH CODE
    	while (ultrasonic.getUltrasonicLevels() <= BUTTON_PRESS) {
    		drive.driveStraight();
    	}
    	drive.stop();
    	while (ultrasonic.getUltrasonicLevels() >= BUFFER_DIST) {
    		drive.driveBackwards();
    	}
    	drive.stop()
    	*/
    }

}