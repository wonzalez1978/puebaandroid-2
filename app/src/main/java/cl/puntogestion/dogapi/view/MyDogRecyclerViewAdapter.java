package cl.puntogestion.dogapi.view;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cl.puntogestion.dogapi.R;
import cl.puntogestion.dogapi.view.ListDogFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * Para crear un nuevo adapter
 * 1: extender de RecyclerView.Adapter o de alguna de sus subclases
 * 2: Definir el ViewHolder que será parte del adapter
 * 3: El ViewHolder debe extender de RecyclerView.ViewHolder
 * 3: implementar el método onCreateViewHolder
 *  3.A: asignar el layout utilizado en el viewHolder
 *  3.B: retornar una nueva instancia de ViewHolder
 * 4: implementar el método onBindViewHolder
 *  4.A: Dada la posición, obtener el valor a desplegar
 *  4.B: Asignar el valor dentro del viewHolder
 * 5: Implementar getItemCount devolviendo la cantidad de elementos disponibles
 *
 * 6: Definir el comportamiento del ViewHolder (asignar la información)
 */
public class MyDogRecyclerViewAdapter extends RecyclerView.Adapter<MyDogRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MyDogRecyclerViewAdapte";
    private final List<String> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyDogRecyclerViewAdapter(List<String> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_dog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position));
        holder.mContentView.setText(mValues.get(position));
        Log.i("Valor holderItem", holder.mItem);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(mValues.get(position));
                    Log.d(TAG, mValues.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public String mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
