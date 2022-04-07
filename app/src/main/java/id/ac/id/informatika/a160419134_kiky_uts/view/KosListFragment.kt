package id.ac.id.informatika.a160419134_kiky_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.id.informatika.a160419134_kiky_uts.R
import id.ac.id.informatika.a160419134_kiky_uts.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_kos_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KosListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KosListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val kosListAdapter = KosListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kos_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = kosListAdapter

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.kosLiveData.observe(viewLifecycleOwner) {
            kosListAdapter.updateKosList(it)
        }
        viewModel.kosLoadErrorLiveData.observe(viewLifecycleOwner){
            textError.visibility = if (it) View.VISIBLE else View.GONE
        }
        viewModel.kosLoadErrorLiveData.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recView.visibility = View.GONE
                textError.visibility = View.VISIBLE
            } else {
                recView.visibility = View.VISIBLE
                textError.visibility = View.GONE
            }
        })

    }
}