package com.notepoint.stackoverflowmvc.screens.common.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.screens.common.views.BaseViewMvc;

/*
     Created by Suman on 5/14/2020.
*/

public class ToolbarViewMvc extends BaseViewMvc {

    public interface NavigateUpClickListener {
        void onNavigateUpClicked();
    }

    private NavigateUpClickListener mNavigateUpClickListener;

    private TextView mToolbarTitleTxt;
    private ImageView mBackButtonImage;

    public ToolbarViewMvc(LayoutInflater layoutInflater, ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_toolbar, parent, false));

        mToolbarTitleTxt = findViewById(R.id.txt_toolbar_title);
        mBackButtonImage = findViewById(R.id.btn_back);

        mBackButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNavigateUpClickListener.onNavigateUpClicked();
            }
        });
    }

    public void setToolbarTitle(String title) {
        mToolbarTitleTxt.setText(title);
    }

    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener) {
        mNavigateUpClickListener = navigateUpClickListener;
        mBackButtonImage.setVisibility(View.VISIBLE);
    }
}
