package cl.puntogestion.dogapi.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.puntogestion.dogapi.model.IModel;
import cl.puntogestion.dogapi.model.api.IDogDataBase;
import cl.puntogestion.dogapi.model.api.RetrofitClient;
import cl.puntogestion.dogapi.model.RazasLista;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements IPresenter{

    IModel imodel;
    IPresenterViewList iPresenterViewList;


    public Presenter(IPresenterViewList iPresenterViewList, IModel imodel) {
        this.iPresenterViewList = iPresenterViewList;
        this.imodel = imodel;

    }

    @Override
    public void loadBreeds() {

    }

    @Override
    public void loadBreedImages(String raza) {

    }

    @Override
    public void loadSubBreedImages(String raza, String subraza) {

    }

    public interface IPresenterViewList {
        void notificar(List<String> lista);
    }
}
