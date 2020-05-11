package com.notepoint.stackoverflowmvc.screens.common;
/*
     Created by Suman on 5/9/2020.
*/

import androidx.appcompat.app.AppCompatActivity;

import com.notepoint.stackoverflowmvc.CustomApplication;
import com.notepoint.stackoverflowmvc.common.dependancyInjection.CompositionRoot;

public class BaseActivity extends AppCompatActivity {

    protected CompositionRoot getComposition(){
        return ((CustomApplication)getApplication()).getCompositionRoot();
    }
}
