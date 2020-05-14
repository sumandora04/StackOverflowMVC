package com.notepoint.stackoverflowmvc.screens.common;
/*
     Created by Suman on 5/14/2020.
*/

import android.content.Context;
import android.widget.Toast;

import com.notepoint.stackoverflowmvc.R;

public class MessagesDisplayer {
    private final Context mContext;

    public MessagesDisplayer(Context mContext) {
        this.mContext = mContext;
    }

    public void displayNetworkErrorMessage() {
        Toast.makeText(mContext, R.string.error_network_call_failed, Toast.LENGTH_SHORT).show();
    }
}
