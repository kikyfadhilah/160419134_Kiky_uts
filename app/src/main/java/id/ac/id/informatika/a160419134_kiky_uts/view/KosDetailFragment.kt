package id.ac.id.informatika.a160419134_kiky_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.id.informatika.a160419134_kiky_uts.R


/**
 * A simple [Fragment] subclass.
 * Use the [KosDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KosDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kos_detail, container, false)
    }
}