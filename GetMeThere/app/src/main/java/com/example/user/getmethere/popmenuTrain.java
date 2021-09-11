package com.example.user.getmethere;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 5/30/2017.
 */

public class popmenuTrain extends DialogFragment implements View.OnClickListener {
    View form;
    Button accept;
    Button cancel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        form=inflater.inflate(R.layout.activity_gettrain_info,container,false);
        accept=(Button)form.findViewById(R.id.accept);
        cancel=(Button)form.findViewById(R.id.cancel);
        accept.setOnClickListener(this);
        cancel.setOnClickListener(this);
        getDialog().setTitle("Trip informations");
        return form;
    }

    @Override
    public void onClick(View v) {
        Button bu=(Button)v;
        if(bu.getText().toString().equals("Cancel")) {
            this.dismiss();//bekhfi el nefze

        }
        else {
            Intent i=new Intent(v.getContext(),payment.class);
            startActivity(i);

        }
    }
}
