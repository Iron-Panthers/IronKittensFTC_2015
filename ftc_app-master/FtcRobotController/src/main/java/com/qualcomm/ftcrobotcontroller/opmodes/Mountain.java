package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.*;

public class Mountain
{

    public DriveAuto driveAuto;

    public Mountain(HardwareMap hardwareMap)
    {
        driveAuto = new DriveAuto(hardwareMap);
    }

    public void climb()
    {
        driveAuto.driveStraight(1, 1.0);
        driveAuto.driveStraight(0.0, 0.0);
    }
    public void backClimb()
    {
        driveAuto.driveStraight(1.0, -1.0);
        driveAuto.driveStraight(0.0, 0.0);
    }
}