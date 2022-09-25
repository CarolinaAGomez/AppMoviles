package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    List<Usuario> usuarios;
    private OnItemClickListener onItemClickListener;

    public UsuarioAdapter(List<Usuario> usuarios, OnItemClickListener onItemClickListener) {
        this.usuarios = usuarios;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//parent.getcontex es para traer este contexto.
        View itemusuario = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);//aca se vincula el layout con la clase.
        return new UsuarioViewHolder(itemusuario); //llama al metodo de abajo de todo que devuelve cada item y se le pasa el xml donde esta conf cada item???
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {

        holder.usuario.setText(usuarios.get(position).getUsuario());  //ACa segun la posicion trae el elemento.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickLIstener(usuarios.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }


    public class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView usuario;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            usuario = itemView.findViewById(R.id.tvUsuario);
        }
    }

    interface OnItemClickListener {
        void onItemClickLIstener(Usuario usuario);
    }

    @Override
    public String toString() {
        return "UsuarioAdapter{" +
                "usuarios=" + usuarios +
                '}';
    }
}
