package br.com.atividadeintegradora.bo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.atividadeintegradora.R;
import br.com.atividadeintegradora.model.Pessoa;

public class PessoasAdapter extends RecyclerView.Adapter<PessoasAdapter.ViewHolder> {
    private ArrayList<Pessoa> pList;
    ViewGroup parent;

    public PessoasAdapter(ArrayList<Pessoa> pessoas) {
        this.pList = pessoas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemLista = inflater.inflate(R.layout.item_lista, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemLista);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pessoa p = pList.get(position);

        TextView tvId = holder.tvId;
        tvId.setText(String.valueOf(p.getId()));

        TextView tvNome = holder.tvNome;
        tvNome.setText(p.getNome());

    }

    @Override
    public int getItemCount() {
        return this.pList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvId;
        public TextView tvNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
        }
    }
}
