package com.notepoint.stackoverflowmvc.screens.common;
/*
     Created by Suman on 5/9/2020.
*/

import androidx.appcompat.app.AppCompatActivity;

import com.notepoint.stackoverflowmvc.CustomApplication;
import com.notepoint.stackoverflowmvc.common.dependancyInjection.CompositionRoot;
import com.notepoint.stackoverflowmvc.common.dependancyInjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

//    protected CompositionRoot getComposition(){
//        return ((CustomApplication)getApplication()).getCompositionRoot();
//    }

    private ControllerCompositionRoot mControllerCompositionRoot;
    protected ControllerCompositionRoot getControllerComposition(){
        if (mControllerCompositionRoot==null){
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication)getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mControllerCompositionRoot;
    }
}
