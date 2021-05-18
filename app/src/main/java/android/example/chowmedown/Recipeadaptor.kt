package android.example.chowmedown

//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.recipe_row.view.*

class Recipeadaptor: RecyclerView.Adapter<CustomViewHolder>() {

    val RecipeTitle = listOf<String>( "Recipe 1", "Recipe 2", "Recipe 3", "Recipe 4", "Recipe 5")

    //number of items
    override fun getItemCount(): Int {
        return RecipeTitle.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //render out each cell and return it inside of the method
        //how do we even creat a view?
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.recipe_row, parent, false )
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val recipeTitle = RecipeTitle.get(position)
        holder?.view?.textViewRecTitle?.text = recipeTitle



    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}