public class AutoRedOppRamp
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	AllianceButton allianceButton = new AllianceButton();
	AutoRedOppRamp(){};

	public void goOppRamp
	{
		driveAuto.wait(10);
		driveAuto.driveStraight(52.1, 0.5);
		driveAuto.turnRight(90);
		driveAuto.driveStraight(40, 0.5);
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
