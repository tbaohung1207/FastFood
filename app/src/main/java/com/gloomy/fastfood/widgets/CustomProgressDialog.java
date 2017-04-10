package com.gloomy.fastfood.widgets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.gloomy.fastfood.R;

/**
 * Copyright © 2017 Gloomy
 * Created by HungTQB on 10-Apr-17.
 */
public class CustomProgressDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = View.inflate(getActivity(), R.layout.layout_progress_dialog, null);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        return dialog;
    }
}