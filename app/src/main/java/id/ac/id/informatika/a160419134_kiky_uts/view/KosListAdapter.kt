package id.ac.id.informatika.a160419134_kiky_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.id.informatika.a160419134_kiky_uts.R
import id.ac.id.informatika.a160419134_kiky_uts.model.Kos
import kotlinx.android.synthetic.main.kost_list_item.view.*

class KosListAdapter (val kosList: ArrayList<Kos>) : RecyclerView.Adapter<KosListAdapter.KosViewHolder>(){
    class KosViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kost_list_item, parent, false)
        return KosViewHolder(view)
    }

    override fun onBindViewHolder(holder: KosViewHolder, position: Int) {
        val kos = kosList[position]
        with (holder.view) {
            textJenisKos.text = kos.jenis
            textNamaKos.text = kos.nama
            textKeterangan.text = kos.keterangan

            holder.view.buttonDetail.setOnClickListener {
                val action = KosListFragmentDirections.actionKosDetail()
                Navigation.findNavController(it).navigate(action)

            }
        }
    }

    override fun getItemCount() = kosList.size

    //untuk merefresh
    fun updateKosList(newKostList: ArrayList<Kos>) {
        kosList.clear()
        kosList.addAll(newKostList)
        notifyDataSetChanged()
    }

}