/*package com.qualcomm.ftcrobotcontroller.opmodes;


public class AutoRedRampButt
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	AllianceButton allianceButton = new AllianceButton();

	public void goFace
	{
		redPush.go();
		driveAuto.driveStraight(-31, 0.5);
		driveAuto.turnLeft(50);
		while(allianceButton.checkDist() < 10.0)
		{
			driveAuto.driveStraight(1, 1);
		}

		// ROBOT is on mountain now
	}
}*/
