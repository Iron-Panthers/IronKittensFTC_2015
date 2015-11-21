public class AutoRedRamp
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	AllianceButton allianceButton = new AllianceButton();
	AutoRedRampButt(){};

	public void goRamp
	{
		driveAuto.driveStraight(81.5, 0.5);
		driveAuto.turnLeft(90);
		driveAuto.driveStraight(32.68. 0.5);
		while(true)
		{
			driveAuto.driveStraight(1, 1);
			if(allianceButton.checkDist() < 20.0 && allianceButton.checkDist() > 18.0)
			{
				break;
			}
		}
	}
}
