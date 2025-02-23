package com.easylife.secretcode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DialReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_NEW_OUTGOING_CALL) {
            val phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)
            if (phoneNumber == "*#123#") { // Replace with your secret code
                val launchIntent = Intent(context, MainActivity::class.java)
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context?.startActivity(launchIntent)

                // Prevent actual call from being dialed
                abortBroadcast()
            }
        }
    }
}
