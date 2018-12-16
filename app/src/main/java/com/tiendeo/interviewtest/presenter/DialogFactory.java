package com.tiendeo.interviewtest.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.tiendeo.interviewtest.R;
import com.tiendeo.interviewtest.data.remote.ShopApi;
import com.tiendeo.interviewtest.model.ErrorEvent;

/**
 * Create alert, toast, dialog,... as response to an user interaction.
 */
public class DialogFactory {

	public static Toast createErrorConnectionAlert(Context context) {

		Toast toast = Toast.makeText(context,
				context.getString(R.string.error_connection_description),
				Toast.LENGTH_LONG);

		return toast;

	}
}
