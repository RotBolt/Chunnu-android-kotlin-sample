package io.rot.labs.intentserviceexample

import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import java.io.Serializable


public class BankReceiver(handler: Handler) : ResultReceiver(handler) {

    companion object{
        val RESULT_CODE_OK = 1100
        val RESULT_CODE_ERROR = 666
        val PARAM_EXCEPTION = "exception"
        val PARAM_RESULT = "result"
    }

    private lateinit var receiverCallback: ResultReceiverCallBack

    fun setReceiverCallBack(value: ResultReceiverCallBack) {
        this.receiverCallback = value
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
        if (this::receiverCallback.isInitialized) {
            if (resultCode == RESULT_CODE_OK) {
                receiverCallback.onSuccess(resultData.getSerializable(PARAM_RESULT))
            } else if (resultCode == RESULT_CODE_ERROR) {
                receiverCallback.onError(
                    Throwable(
                        "Fail Message ${resultData.getSerializable(
                            PARAM_EXCEPTION
                        )}"
                    )
                )
            }
        }
    }

    interface ResultReceiverCallBack {
        fun <R> onSuccess(data: R)
        fun onError(e: Throwable)
    }

}


