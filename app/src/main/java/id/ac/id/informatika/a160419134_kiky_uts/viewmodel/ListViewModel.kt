package id.ac.id.informatika.a160419134_kiky_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.id.informatika.a160419134_kiky_uts.model.Kos

class ListViewModel : ViewModel() {
    val kosLiveData = MutableLiveData<ArrayList<Kos>>()
    val kosLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun refresh(){
        kosLiveData.value = arrayListOf(
            Kos("https://i1.wp.com/anakuntad.com/wp-content/uploads/2017/11/Kos-Kosan.jpg?resize=1024%2C500&ssl=1","Kos Putra","Kos Depan Ubaya", "Pakai AC"),
            Kos("https://d3p0bla3numw14.cloudfront.net/news-content/img/2021/09/02212549/Desain-Kos-Kosan-Pinterest10.jpg", "Kos Putri", "Kos Putri Ubaya", "Pakai AC"),
            Kos("https://cdn-image.hipwee.com/wp-content/uploads/2018/04/hipwee-IMG_0705-750x422.jpg", "Kos Putri", "Kos Depan Farmasi Ubaya", "Pakai AC"),
        )
        kosLoadErrorLiveData.value = false
        loadingLiveData.value = false
    }
}