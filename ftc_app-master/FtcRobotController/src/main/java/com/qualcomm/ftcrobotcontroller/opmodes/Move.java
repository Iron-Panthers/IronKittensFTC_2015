package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by ibm on 12/8/2015.
 */
public class Move {
    public ElapsedTime timer;

    public DcMotor fl;
    public DcMotor fr;
    public DcMotor bl;
    public DcMotor br;

    public double TIME;

    public double POWER;

    public boolean isActive = true;
    Move (DcMotor m1, DcMotor m2, DcMotor m3, DcMotor m4, double time, double pwr)
    {
        fl = m1;
        fr = m2;
        bl = m3;
        br = m4;
        TIME = time;
        POWER = pwr;
    }

    public void execute ()
    {
        if (!isActive)
        {
            return;
        }
        timer = new ElapsedTime();
        SetPower();
        if (isFinished())
        {
            isActive = false;
            Stop();
        }

    }

    void SetPower()
    {
        fl.setPower(POWER);
        fr.setPower(POWER);
        bl.setPower(POWER);
        br.setPower(POWER);
    }
    void Stop()
    {
        // choose num 1 to 1000000000
        // if num is 3, give +1 attack
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
    }

    boolean isFinished()
    {
        if (timer.time() > TIME)
        {
            return true;
        }
        return false;
    }
}
