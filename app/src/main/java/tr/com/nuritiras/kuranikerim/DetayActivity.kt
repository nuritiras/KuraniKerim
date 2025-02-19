package tr.com.nuritiras.kuranikerim

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import tr.com.nuritiras.kuranikerim.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sure=intent.getSerializableExtra("sure",Sure::class.java)
        if (sure!=null) {
            binding.textViewIsim.text = sure.isim
            binding.textViewAciklama.text = sure.aciklama
            binding.imageView.setImageResource(sure.gorsel)
        }
    }
}