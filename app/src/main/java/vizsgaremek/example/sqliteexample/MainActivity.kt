package vizsgaremek.example.sqliteexample
//-- https://www.youtube.com/watch?v=OxHNcCXnxnE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val context = this
    val btn_insert = findViewById(R.id.btn_insert) as Button
    val etvName = findViewById(R.id.etvName) as TextView
    val etvAge =findViewById(R.id.etvAge) as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_insert.setOnClickListener( {
            if (etvName.text.toString().length > 0 &&
                    etvAge.text.toString().length > 0){
                var user = User(etvName.text.toString(), etvAge.text.toString().toInt())
                var db = DataBaseHandler(context)
                db.insertData(user)
            } else {
                Toast.makeText(applicationContext, "Please fill all datas", Toast.LENGTH_SHORT)
            }
        })
    }
}