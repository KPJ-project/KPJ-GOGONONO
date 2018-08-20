import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AlertDialog
import android.view.View

abstract class BaseDialogHelper {
    abstract val dialogView:View
    abstract val builder:AlertDialog.Builder

    open var cancelable:Boolean=true
    open var isBackGroundTransparent:Boolean=true

    open var dialog:AlertDialog?=null

    open fun create():AlertDialog{
        dialog=builder
                .setCancelable(cancelable)
                .create()

        if(isBackGroundTransparent)
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return dialog!!
    }

    open fun onCancelListener(func: ()->Unit):AlertDialog.Builder?=
            builder.setOnCancelListener {
                func()
            }
}