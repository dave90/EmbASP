package it.unical.mat.embasp.dlv;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
 /*AndroidDLVService is used in android applications to start the service that is used to compute DLV directlry into the device.
 * The IBinder interface , gives the user the possibility to comunicate with the service in a client/server way
 * By defaults Services run in the same process of the application , to bypass this behaivior need to add a tag <name> to AndroidManifest*/
public class AndroidDLVSerice extends Service implements it.unical.mat.embasp.base.Service {

    private IBinder binder = new DLVBinder();

    //load the static library that contains DLV code compiled for arm processors
    static{
        System.loadLibrary("dlvJNI");
    }

     /*Returns the current Service class , can be used to interact directly with the Service*/
    public class DLVBinder extends Binder{
        AndroidDLVSerice getService(){
            return new AndroidDLVSerice();
        }
    }


    /*Is called when an activity calls onBind function*/
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


     //TO FINISH
    @Override
    public void startAsync(Callback callback, final List <InputProgram> programs, final List<OptionDescriptor> options) {
        new Thread(new Runnable() {
            public void run() {

                StringBuilder finalProgram = new StringBuilder();
                for (InputProgram p : programs) {
                finalProgram.append(p.getProgram()).append(" ");
                }
                for (OptionDescriptor o :options) {
                finalProgram.append(o.getOptions()).append(" ");
                }
                long startTime = System.nanoTime();
                String result = dlvMain(finalProgram.toString());
                long stopTime = System.nanoTime();
                Log.i("DLV Execution Time", Long.toString(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime)));
            }
        }).start();

    }
}
