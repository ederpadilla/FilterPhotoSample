package jr.eder.developer.example.com.filtersample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ederpadilla on 10/10/16.
 */

public class FiltrosAdapter extends RecyclerView.Adapter<FiltrosAdapter.TitularesViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private List<Filtro> filtroList;
    private Context context;

    public FiltrosAdapter(List<Filtro> filtroList, Context context) {
        this.filtroList = filtroList;
        this.context = context;
    }
    /**Aqui definimos el item que vamos a inyectar al recycler view
     * le implementamos un onclick listener */
    @Override
    public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_button, viewGroup, false);
        itemView.setOnClickListener(this);
        TitularesViewHolder tvh = new TitularesViewHolder(itemView);
        return tvh;
    }

    View roootView;

    @Override
    public void onBindViewHolder(TitularesViewHolder viewHolder, int pos) {
        Filtro item = filtroList.get(pos);
        viewHolder.bindTitular(item);


    }

    @Override
    public int getItemCount() {
        return filtroList.size();

    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    /**Aqui es donde entra el onclick
     * y se encarga de aparecer o desaparecer el contenido*/
    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
        TitularesViewHolder titularesViewHolder = new TitularesViewHolder(view);


    }
    /**En esta clase definimos los objetos dentro del item
     * y definimos lo que se le va a asignar y su comportamiento
     * */

    public class TitularesViewHolder
            extends RecyclerView.ViewHolder {

        @BindView(R.id.btn)
        Button button;

        public TitularesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTitular(Filtro filtro) {
        button.setText(filtro.getNombre());
        }


    }
}
