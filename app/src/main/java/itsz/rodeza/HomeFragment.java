package itsz.rodeza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import itsz.rodeza.adapter.ListAdapter;
import itsz.rodeza.model.ListElement;
import itsz.rodeza.network.ApiClient;
import itsz.rodeza.network.ApiElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    List<ListElement> elements;
    ListAdapter adapter;//creamos un objeto de nuestra clase creada ListElement
    RecyclerView recyclerView; //creamos una variable de tipo RecyclerView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_home, container, false); //Enlazamos eh inflamos nuestro fragmenthome
        recyclerView=root.findViewById(R.id.recycler); //enlazamos nuestro recyclerview con el fragment del xml
        //init(); //llamamos nuestro metodo init
        showElements();
        return root; //retornamos nuestro objeto root
    }
    public void showElements(){
        Call<List<ListElement>> call= ApiClient.getElemnt().create(ApiElement.class).getElements();
        call.enqueue(new Callback<List<ListElement>>() {
            @Override
            public void onResponse(Call<List<ListElement>> call, Response<List<ListElement>> response) {
                if(response.isSuccessful()){
                    elements=response.body();
                    adapter=new ListAdapter(elements,getContext());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ListElement>> call, Throwable t) {
                //Toast.makeText(requireContext(), "Error: " + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}