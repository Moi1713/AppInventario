package sv.edu.ues.eisi.proyecto1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bienvenido al Sistema de Control de Inventario!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}