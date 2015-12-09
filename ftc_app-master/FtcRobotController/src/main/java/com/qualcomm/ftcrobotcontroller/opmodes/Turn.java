public class Turn extends Routine{
	//public DcMotor fl;
    //public DcMotor fr;
    //public DcMotor bl;
    //public DcMotor br;

    public Wait(long time, double pwr){ //time in seconds
    	TIME = time * 1000;
    	POWER = pwr;
    }

    public void executeAction(){
        System.out.println("lets git goin', time:" + TIME);

        /*
        fl.setPower(POWER);
        fr.setPower(-POWER);
        bl.setPower(POWER);
        br.setPower(-POWER);
        */
    }
    public void stopAction(){
        System.out.println("donzo kid");

        /*
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
        */
    }
}

/*
public Turn (DcMotor m1, DcMotor m2, DcMotor m3, DcMotor m4, double time, double pwr, Callback call){
    callback = call;

    fl = m1;
    fr = m2;
    bl = m3;
    br = m4;
    TIME = time;
    POWER = pwr;
}
*/
