package com.example.magasin_cms;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SingleChoiceDialogFragment2 extends DialogFragment {
    int def=0;

    public interface SingleChoiceListener{
        void onPositiveButtonClicked2(String[] options,int def);
        void onNegativeButtonClicked2();}

    SingleChoiceListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener= (SingleChoiceListener) context;
        }catch (Exception e){
            throw new ClassCastException(getActivity().toString()+" SingleChoiceListener must be implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        String[] options=getActivity().getResources().getStringArray(R.array.Shifts);
        builder.setTitle("select your choice").setSingleChoiceItems(options, def, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                def=i;
            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onPositiveButtonClicked2(options,def);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onNegativeButtonClicked2();
            }
        });
        return builder.create();

    }
}
