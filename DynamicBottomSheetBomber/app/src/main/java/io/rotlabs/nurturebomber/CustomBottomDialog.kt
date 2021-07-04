package io.rotlabs.nurturebomber

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomDialog : BottomSheetDialogFragment() {

    private var dialogView: View? = null

    companion object {
        fun newInstance(cardInfo: CardInfo, height: Int): CustomBottomDialog {
            val bundle = Bundle()
            bundle.putSerializable("data", cardInfo)
            bundle.putInt("height",height)
            val frag = CustomBottomDialog()
            frag.arguments = bundle
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("PUI","onCreateView")
        return inflater.inflate(R.layout.layout_bottom_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("PUI","onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        val cardInfo = arguments?.get("data") as CardInfo?

        view.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                Log.d("PUI","onGlobalLayout")
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val dialog = dialog as BottomSheetDialog
                val bottomSheet =
                    dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?

                val behavior = BottomSheetBehavior.from(bottomSheet!!)

                val newHeight = activity?.window?.decorView?.measuredHeight
                val viewGroupLayoutParams = view.layoutParams
                Log.d("PUI","height to set ${arguments?.getInt("height")}")
                viewGroupLayoutParams.height = arguments?.getInt("height") ?: 0
                view.layoutParams = viewGroupLayoutParams
            }
        })

        dialogView = view


        cardInfo?.let { card ->
            view.findViewById<TextView>(R.id.cardType).text = card.cardType
            view.findViewById<Button>(R.id.button).apply {
                text = card.CTA

                setOnClickListener {
                    card.childCard?.let {
                        newInstance(card.childCard,  arguments?.getInt("height")!! - 50).show(childFragmentManager, "")
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        dialogView?.viewTreeObserver?.addOnGlobalLayoutListener(null)
        super.onDestroyView()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("PUI","onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("PUI","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("PUI","onResume")

    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        Log.d("PUI","onAttach")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("PUI","onDetach")

    }

    override fun onPause() {
        super.onPause()
        Log.d("PUI","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PUI","onStop")

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("PUI","onCreateDialog")
        return super.onCreateDialog(savedInstanceState)
    }
}