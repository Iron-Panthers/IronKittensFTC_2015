//this is numero uno red push + mount

public class AutoRedRampButt
{
	AutoRedRampButt(){};
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	AllianceButton allianceButton = new AllianceButton();
	
	public void goBR
	{
		redPush.go();
		driveAuto.driveStraight(-31, 0.5);
		driveAuto.turnLeft(50);
		driveAuto.driveStraight(32.68, 0.5);
		while(true)
		{
			driveAuto.driveStraight(1, 1);
			if(allianceButton.checkDist() < 20.0 && allianceButton.checkDist() > 18.0)
			{
				break;
			}
		}
		// ROBOT is on mountain now
	}
}
