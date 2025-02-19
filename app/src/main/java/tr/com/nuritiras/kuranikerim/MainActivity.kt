package tr.com.nuritiras.kuranikerim

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import tr.com.nuritiras.kuranikerim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sureList: ArrayList<Sure>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fatiha=Sure("Fâtiha","Sure, 7 ayetten oluşur.",R.drawable.fatiha)
        val bakara=Sure("Bakara","Sure, 286 ayetten oluşur.",R.drawable.bakara)
        val aliimran=Sure("Âl-i İmrân","Sure, 200 ayetten oluşur.",R.drawable.aliimran)
        val nisa=Sure("Nisâ","Sure, 176 ayetten oluşur.",R.drawable.nisa)

        sureList= arrayListOf(fatiha,bakara,aliimran,nisa)
        val adapter=SureAdapter(sureList)
        binding.sureRecyclerView.layoutManager= LinearLayoutManager(this)
        binding.sureRecyclerView.adapter=adapter

    }
}