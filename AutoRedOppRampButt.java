public class AutoRedOppRampButt
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	AllianceButton allianceButton = new AllianceButton();
	AutoRedOppRampButt(){};

	public void goBOR
	{
		redPush.go();
		driveAuto.driveStraight(69.75, 0.5);
		driveAuto.turnRight(131);
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
