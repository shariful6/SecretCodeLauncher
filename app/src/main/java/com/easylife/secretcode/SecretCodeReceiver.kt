package com.easylife.secretcode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SecretCodeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.provider.Telephony.SECRET_CODE") {
            val code = intent.data?.host // Retrieve the secret code (e.g., "1234")
            Log.d("SecretCodeReceiver", "Secret code received: $code")

            // Launch your app's main activity
            val launchIntent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(launchIntent)
        }
    }


}

class ActivationCodeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if ("android.provider.Telephony.SECRET_CODE" == intent.action && intent.dataString!!
                .split("://".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()[1].equals("777", ignoreCase = true)
        ) {
            val intent2 = Intent(context, MainActivity::class.java)
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent2)
        }
    }
}