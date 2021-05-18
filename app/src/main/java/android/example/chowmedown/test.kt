//package android.example.chowmedown
//
//import android.app.AlertDialog
//import android.content.ClipData
//import android.content.Context
//import android.content.DialogInterface
//import android.util.AttributeSet
//import android.widget.ArrayAdapter
//import android.widget.SpinnerAdapter
//import androidx.appcompat.widget.AppCompatSpinner
//import java.util.*
//
//
//class MultiSelectionSpinner : AppCompatSpinner, DialogInterface.OnMultiChoiceClickListener {
//    var items: ArrayList<ClipData.Item>? = null
//    var selection: BooleanArray? = null
//    var adapter: ArrayAdapter<*>
//
//    constructor(context: Context?) : super(context!!) {
//        adapter = ArrayAdapter<Any?>(
//                context,
//                android.R.layout.simple_spinner_item
//        )
//        super.setAdapter(adapter)
//    }
//
//    constructor(context: Context?, attrs: AttributeSet?) : super(
//            context!!,
//            attrs
//    ) {
//        adapter = ArrayAdapter<Any?>(
//                context,
//                android.R.layout.simple_spinner_item
//        )
//        super.setAdapter(adapter)
//    }
//
//    override fun onClick(
//            dialog: DialogInterface,
//            which: Int,
//            isChecked: Boolean) {
//        if (selection != null && which < selection!!.size) {
//            selection!![which] = isChecked
//            adapter.clear()
//            adapter.add(buildSelectedItemString())
//        } else {
//            throw IllegalArgumentException(
//                    "Argument 'which' is out of bounds."
//            )
//        }
//    }
//
//    override fun performClick(): Boolean {
//        val builder: AlertDialog.Builder = AlertDialog.Builder(getContext())
//        val itemNames = arrayOfNulls<String>(items!!.size)
//        for (i in items!!.indices) {
//            itemNames[i] = items!![i].getName()
//        }
//        builder.setMultiChoiceItems(itemNames, selection, this)
//        builder.setPositiveButton("OK", DialogInterface.OnClickListener { arg0, arg1 ->
//            // Do nothing
//        })
//        builder.show()
//        return true
//    }
//
//    override fun setAdapter(adapter: SpinnerAdapter?) {
//        throw RuntimeException(
//                "setAdapter is not supported by MultiSelectSpinner."
//        )
//    }
//
//
//    fun setItems(items: ArrayList<ClipData.Item>?) {
//        this.items = items
//        selection = BooleanArray(this.items!!.size)
//        adapter.clear()
//        adapter.add("")
//        Arrays.fill(selection, false)
//    }
//
//    fun setSelection(selection: ArrayList<ClipData.Item>) {
//        for (i in this.selection!!.indices) {
//            this.selection!![i] = false
//        }
//        for (sel in selection) {
//            for (j in items!!.indices) {
//                if (items!![j].getValue().equals(sel.getValue())) {
//                    this.selection!![j] = true
//                }
//            }
//        }
//        adapter.clear()
//        adapter.add(buildSelectedItemString())
//    }
//
//    private fun buildSelectedItemString(): String {
//        val sb = StringBuilder()
//        var foundOne = false
//        for (i in items!!.indices) {
//            if (selection!![i]) {
//                if (foundOne) {
//                    sb.append(", ")
//                }
//                foundOne = true
//                sb.append(items!![i].getName())
//            }
//        }
//        return sb.toString()
//    }
//
//    val selectedItems: ArrayList<ClipData.Item>
//        get() {
//            val selectedItems = ArrayList<ClipData.Item>()
//            for (i in items!!.indices) {
//                if (selection!![i]) {
//                    selectedItems.add(items!![i])
//                }
//            }
//            return selectedItems
//        }
//}

//
//###
//
//
//var Spinner: MultiSelectionSpinner
//
//Spinner = test.findViewById(R.id.items) as MultiSelectionSpinner
//
//Spinner.setItems(items = null)
//
//
//
//
//val items: ArrayList<Item> = ArrayList()
//
//Spinner.setSelection(selectedItems);
//
//
//val selectedItems: ArrayList<Item> = Spinner.getSelectedItems()
//
//}
//}


