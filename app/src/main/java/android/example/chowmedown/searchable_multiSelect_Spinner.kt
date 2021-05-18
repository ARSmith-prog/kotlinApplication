//package android.example.chowmedown
//
//import android.content.ClipData
//import android.content.Context
//import android.util.AttributeSet
//import android.view.LayoutInflater
//import android.widget.ArrayAdapter
//import android.widget.SpinnerAdapter
//import androidx.appcompat.app.AlertDialog
//import androidx.appcompat.widget.SearchView
//import androidx.recyclerview.widget.LinearLayoutManager
//
//class searchable_multiSelect_Spinner : AppCompatSpinner, OnMultiChoiceClickListener {
//
//    private var items: ArrayList<ClipData.Item>? = null
//    private var selection: BooleanArray? = null
//    private var adapter: ArrayAdapter<Any?>
//
//    constructor(context: Context?) : super(context) {
//        adapter = ArrayAdapter<Any?>(
//            context!!,
//            R.layout.row_multi_select
//        )
//        super.setAdapter(adapter)
//    }
//
//    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
//        adapter = ArrayAdapter<Any?>(
//            context!!,
//            R.layout.row_multi_select
//        )
//        super.setAdapter(adapter)
//    }
//
//    override fun onClick(dialog: DialogInterface, which: Int, isChecked: Boolean) {
//        if (selection != null && which < selection!!.size) {
//            selection!![which] = isChecked
//            adapter.clear()
//            adapter.add(buildSelectedItemString())
//        } else {
//            throw IllegalArgumentException(
//                "Argument 'which' is out of bounds."
//            )
//        }
//    }
//
//    override fun performClick(): Boolean {
//        val builder = Builder(context)
//        val itemNames = arrayOfNulls<String>(items!!.size)
//        for (i in items!!.indices) {
//            itemNames[i] = items!![i].name
//        }
//        builder.setMultiChoiceItems(itemNames, selection, this)
//        builder.setPositiveButton(R.string.ok) { _: DialogInterface, _: Int ->
//            // pass
//        }
//        builder.show()
//        return true
//    }
//
//    override fun setAdapter(adapter: SpinnerAdapter) {
//        throw RuntimeException(
//            "setAdapter is not supported by MultiSelectSpinner."
//        )
//    }
//
//    fun setItems(items: ArrayList<Item>?) {
//        this.items = items
//        selection = BooleanArray(this.items!!.size)
//        adapter.clear()
//        adapter.add("")
//        Arrays.fill(selection, false)
//    }
//
//    fun setSelection(selection: ArrayList<Item>) {
//        for (i in this.selection!!.indices) {
//            this.selection!![i] = false
//        }
//        for ((_, value) in selection) {
//            for (j in items!!.indices) {
//                if (items!![j].value == value) {
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
//                sb.append(items!![i].name)
//            }
//        }
//        return sb.toString()
//    }
//
//    val selectedItems: ArrayList<Item>
//        get() {
//            val selectedItems = ArrayList<Item>()
//            for (i in items!!.indices) {
//                if (selection!![i]) {
//                    selectedItems.add(items!![i])
//                }
//            }
//            return selectedItems
//        }
//}
