package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class HardWare {
    public DcMotor rf;

    public DcMotor lf;

    public DcMotor lb;

    public DcMotor rb;

    //Max speed var

    public static double maxSpeed = 0.5;

    private static HardWare myInstance = null;

    public static HardWare getInstance() {
        //creating a hardware class
        if (myInstance == null) {
            myInstance = new HardWare();
        }
        return myInstance;
    }

    public void init(HardwareMap hwMap) {
        // cm1 = control hub
        // em2 = expansion hub motor 1
        // cs0 = control hub servo, port 0
        //

        rf = hwMap.get(DcMotor.class, "cm1");
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setPower(0);

        lf = hwMap.get(DcMotor.class, "cm0");
        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lf.setPower(0);

        lb = hwMap.get(DcMotor.class, "cm2");
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setPower(0);

        rb = hwMap.get(DcMotor.class, "cm3");
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setPower(0);
    }

    public void setPower(double fr, double br, double bl, double fl){
        rf.setPower(Range.clip(fr,-maxSpeed, maxSpeed));
        rb.setPower(Range.clip(br,-maxSpeed, maxSpeed));
        lf.setPower(Range.clip(fl,-maxSpeed, maxSpeed));
        lb.setPower(Range.clip(bl,-maxSpeed, maxSpeed));
    }
}
