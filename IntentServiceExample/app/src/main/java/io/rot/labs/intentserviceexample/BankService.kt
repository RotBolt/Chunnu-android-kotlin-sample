package io.rot.labs.intentserviceexample

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver


class BankService : IntentService("BankService") {

    private var balance = 10

    private enum class Actions {
        BALANCE, DEPOSIT, WITHDRAW
    }

    private enum class PARAM {
        AMOUNT, RESULT_RECEIVER
    }

    override fun onHandleIntent(intent: Intent?) {
        intent?.run {
            val receiver = getParcelableExtra<ResultReceiver>(PARAM.RESULT_RECEIVER.name)
            when (intent.action) {
                Actions.BALANCE.name -> {

                }
            }

        }
    }

    private fun sleep(i: Int) {
        try {
            Thread.sleep(i.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    private fun handleWithdraw(resultReceiver: ResultReceiver, amount: Int) {
        val bundle = Bundle()
        var code = 0
        sleep(1000)

        if (amount > balance) {
            code = BankReceiver.RESULT_CODE_ERROR
            bundle.putSerializable(BankReceiver.PARAM_EXCEPTION, Exception("Not Enough Credit"))
        } else {
            code = BankReceiver.RESULT_CODE_OK
            balance -= amount
            bundle.putSerializable(BankReceiver.PARAM_RESULT, true)
        }
        resultReceiver.send(code, bundle)
    }

    private fun handleDeposit(resultReceiver: ResultReceiver, amount: Int) {
        val bundle = Bundle()
        var code = 0
        sleep(1000)

        if (amount < 0) {
            code = BankReceiver.RESULT_CODE_ERROR
            bundle.putSerializable(BankReceiver.PARAM_EXCEPTION, Exception("Not Enough Credit"))
        } else {
            code = BankReceiver.RESULT_CODE_OK
            balance += amount
            bundle.putSerializable(BankReceiver.PARAM_RESULT, true)
        }
        resultReceiver.send(code, bundle)
    }

    private fun handleRetreiveBalance(resultReceiver: ResultReceiver) {
        val bundle = Bundle()
        val code: Int = BankReceiver.RESULT_CODE_OK
        sleep(500)
        bundle.putSerializable(BankReceiver.PARAM_RESULT, balance)
        resultReceiver.send(code, bundle)
    }


    fun startServiceForBalance(
        context: Context,
        resultReceiverCallBack: BankReceiver.ResultReceiverCallBack
    ) {
        val bankResultReceiver =
            BankReceiver(Handler(context.mainLooper))
        bankResultReceiver.setReceiverCallBack(resultReceiverCallBack)
        val intent = Intent(context, BankService::class.java)
        intent.action = Actions.BALANCE.name
        intent.putExtra(
            PARAM.RESULT_RECEIVER.name,
            bankResultReceiver
        )
        context.startService(intent)
    }

    fun startServiceToDeposit(
        context: Context,
        amount: Int,
        resultReceiverCallBack: BankReceiver.ResultReceiverCallBack
    ) {
        val bankResultReceiver =
            BankReceiver(Handler(context.mainLooper))
        bankResultReceiver.setReceiverCallBack(resultReceiverCallBack)
        val intent = Intent(context, BankService::class.java)
        intent.action = Actions.DEPOSIT.name
        intent.putExtra(PARAM.AMOUNT.name, amount)
        intent.putExtra(
            PARAM.RESULT_RECEIVER.name,
            bankResultReceiver
        )
        context.startService(intent)
    }

    fun startServiceToWithdraw(
        context: Context,
        amount: Int,
        resultReceiverCallBack: BankReceiver.ResultReceiverCallBack
    ) {
        val bankResultReceiver =
            BankReceiver(Handler(context.mainLooper))
        bankResultReceiver.setReceiverCallBack(resultReceiverCallBack)
        val intent = Intent(context, BankService::class.java)
        intent.action = Actions.WITHDRAW.name
        intent.putExtra(PARAM.AMOUNT.name, amount)
        intent.putExtra(
            PARAM.RESULT_RECEIVER.name,
            bankResultReceiver
        )
        context.startService(intent)
    }

}