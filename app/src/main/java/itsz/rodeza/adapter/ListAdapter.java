package itsz.rodeza.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import itsz.rodeza.R;
import itsz.rodeza.model.ListElement;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList,Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }
    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder,final int position){
        holder.tv_nombre.setText(mData.get(position).getTitulo());
        Glide.with(context).load(mData.get(position).getPortada()).into(holder.iconImage);
    }
    public void setItems(List<ListElement> items){
        mData = items;
    }
    //Clase ViewHolder crea el tipo de elemento a mostarar
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView tv_nombre,tv_cuidad,tv_status;
        //Constructor enlaza los elementos creadas en esta clase con los id del layout inflado
        ViewHolder(View itemView){
            super(itemView);
            iconImage=itemView.findViewById(R.id.iv);
            tv_nombre=itemView.findViewById(R.id.tv_nombre);
            tv_cuidad=itemView.findViewById(R.id.tv_cuidad);
            tv_status=itemView.findViewById(R.id.tv_status);
        }
    }

}