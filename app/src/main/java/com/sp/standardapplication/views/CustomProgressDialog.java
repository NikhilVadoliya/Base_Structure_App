package com.sp.standardapplication.views;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;

import com.sp.standardapplication.R;






public class CustomProgressDialog extends Dialog {
    MaterialProgressBar progress1;

    Context mContext;
    CustomProgressDialog dialog;

    public CustomProgressDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public CustomProgressDialog show(CharSequence message) {

        dialog = new CustomProgressDialog(mContext, R.style.ProgressDialog);
        dialog.setContentView(R.layout.view_material_progress);

        progress1 = (MaterialProgressBar) dialog.findViewById(R.id.progress1);


        //progress1.setColorSchemeResources(R.color.red,R.color.green,R.color.blue,R.color.orange);
        progress1.setColorSchemeResources(R.color.colorAccent);
//        ImageView imageView = (ImageView) dialog.findViewById(R.id.spinnerImageView);
//        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
//        spinner.start();
//
//		if(message == null || message.length() == 0) {
//			dialog.findViewById(R.id.message).setVisibility(View.GONE);
//		} else {
//			TextView txt = (TextView)dialog.findViewById(R.id.message);
//			txt.setText(message);
//		}
        dialog.setCancelable(false);
        //dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.0f;
        dialog.getWindow().setAttributes(lp);
        //noinspection deprecation
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//
        if (dialog != null) {
            dismiss();
            dialog.show();
//            progress1.setVisibility(View.VISIBLE);
        }
        return dialog;
    }

    public CustomProgressDialog dismiss(CharSequence message) {
        if (dialog != null) {
            dialog.dismiss();
//            progress1.setVisibility(View.INVISIBLE);
        }

        return dialog;

    }

    public CustomProgressDialog hide(CharSequence message) {
        if (dialog != null) {
            dialog.hide();
        }
        return dialog;
    }
}
