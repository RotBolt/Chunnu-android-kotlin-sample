package io.rot.labs.intentserviceexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference


class MainActivity : AppCompatActivity() {

    private lateinit var bankService: BankService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bankService = BankService()

        btnDeposit.setOnClickListener {
            deposit()
            info()
        }

        btnWithdraw.setOnClickListener {
            withdraw()
            info()
        }

        info()
    }

    private fun withdraw() {
        bankService.startServiceToWithdraw(this, 10, TransferMoneyResultReceiver(this, false))
        info()
    }

    private fun deposit() {
        bankService.startServiceToDeposit(this, 10, TransferMoneyResultReceiver(this, true))
        info()
    }

    private fun info() {
        bankService.startServiceForBalance(this, AccountInfoResultReceiver(this))
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    private class TransferMoneyResultReceiver(
        activity: MainActivity?,
        private val deposit: Boolean
    ) : BankReceiver.ResultReceiverCallBack {
        private val activityRef: WeakReference<MainActivity> = WeakReference<MainActivity>(activity)

        override fun <R> onSuccess(data: R) {
            if (activityRef.get() != null) {
                activityRef.get()!!.showMessage(if (deposit) "Deposited" else "Withdrew")
            }
        }

        override fun onError(e: Throwable) {
            if (activityRef.get() != null) {
                activityRef.get()!!.showMessage(e.message!!)
            }
        }
    }

    private class AccountInfoResultReceiver(activity: MainActivity?) :
        BankReceiver.ResultReceiverCallBack {
        private val activityRef: WeakReference<MainActivity> = WeakReference<MainActivity>(activity)

        override fun <R> onSuccess(data: R) {
            if (activityRef.get() != null) {
                activityRef.get()!!.tvBalance.setText("Your balance: $data")
            }
        }

        override fun onError(e: Throwable) {
            activityRef.get()!!.showMessage("Account info failed")
        }
    }
}