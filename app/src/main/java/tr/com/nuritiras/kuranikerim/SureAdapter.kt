package tr.com.nuritiras.kuranikerim

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tr.com.nuritiras.kuranikerim.databinding.ActivityMainBinding
import tr.com.nuritiras.kuranikerim.databinding.RecyclerRowBinding

class SureAdapter(val sureList:ArrayList<Sure>): RecyclerView.Adapter<SureAdapter.SureViewHolder>() {
    class SureViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SureViewHolder {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SureViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sureList.size
    }

    override fun onBindViewHolder(holder: SureViewHolder, position: Int) {
        holder.binding.textViewRecyclerView.text=sureList[position].isim

        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context,DetayActivity::class.java)
            intent.putExtra("sure",sureList[position])
            holder.itemView.context.startActivity(intent)
        }

    }
}