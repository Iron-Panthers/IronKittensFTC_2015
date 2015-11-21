public class AutoBlueRampButt
{
	BluePush bluePush = new BluePush();
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Mountain();

	public void execute() 
	{
		bluePush.go();
		driveAuto.driveStraight(-69.75,0.5);
		driveAuto.turnLeft(50);
		driveAuto.driveStraight(32.68, 0.5);
		mountain.climb();
	}
}
