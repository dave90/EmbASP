package it.unical.mat.embasp.platforms.android;

import android.content.Context;

import java.util.List;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;

/*This class is a specialization of base.Handler class for Android platform*/

public class AndroidHandler extends Handler {

    /*Contex used to start the DVLService*/
//    private Context context;
    /*DLVAndroidService istance , used to start computation*/
    private AndroidReciver reciver;

    private boolean bound;

//    /*This class is used to manage service binding and unbind*/
//    private ServiceConnection mConnection = new ServiceConnection() {
//
//        @Override
//        public void onServiceConnected(ComponentName className,
//                                       IBinder service) {
//            // We've bound to DLVAndroidService, cast the IBinder and get DLVAndroidService instance
//            AndroidService.AndroidBinder binder = (AndroidService.AndroidBinder) service;
//            reciver = binder.getService();
//            bound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName arg0) {
//            bound = false;
//        }
//    };


    public AndroidHandler(AndroidReciver cl) {
        reciver = cl;
//        Intent intent = new Intent(context,cl);
//        context.bindService(intent, mConnection, context.BIND_AUTO_CREATE);



    }

    @Override
    public void startAsync(Callback c,List<Integer> program_index, List<Integer> option_index ) {

        List<InputProgram>input_programs = collect_programs(program_index);
        List<OptionDescriptor> input_options = collect_options(option_index);

        reciver.startAsync(c, input_programs, input_options);

    }
}
