/**
 * Created by ibm on 12/8/2015.
 */
public class Move extends Routine{
    //public DcMotor fl;
    //public DcMotor fr;
    //public DcMotor bl;
    //public DcMotor br;

    public long TIME;
    public double POWER;

    public Move (long time, double pwr){ //time in seconds
        TIME = time * 1000;
        POWER = pwr;
    }

    public void executeAction(){
        System.out.println("lets git goin' pwr:" + POWER + " time:" + TIME);

        /*fl.setPower(POWER);
        fr.setPower(POWER);
         bl.setPower(POWER);
        br.setPower(POWER);
        */
    }
    public void stopAction(){
        // choose num 1 to 1000000000
        // if num is 3, give +1 attack
        /*fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);*/

        System.out.println("donzo kid");
    }

    public static void main(String[] args) {
        Move move = new Move(3.5, 5);
    }
}

/*
public Move (DcMotor m1, DcMotor m2, DcMotor m3, DcMotor m4, double time, double pwr, Callback call){
    callback = call;

    fl = m1;
    fr = m2;
    bl = m3;
    br = m4;
    TIME = time;
    POWER = pwr;
}
*/
