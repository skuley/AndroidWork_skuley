package com.lec.android.a008_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {

    List<DogProfile> profiles = new ArrayList<DogProfile>();

    static DogAdapter adapter;

    public DogAdapter() {
        this.adapter = this;
    }

    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(parent.getContext());
        View profileView = inf.inflate(R.layout.profile, parent, false);
        return new ViewHolder(profileView);
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {
        DogProfile profile = profiles.get(position);
        holder.setProfile(profile);

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvAge, tvSex;
        Switch swOnOff;
        ImageButton btnDelitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // View객체 가져오기
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvSex = itemView.findViewById(R.id.tvSex);
            swOnOff = itemView.findViewById(R.id.swOnOff);
            btnDelitem = itemView.findViewById(R.id.btnDelItem);

            btnDelitem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    adapter.removeProfile(getAdapterPosition());
                    adapter.notifyDataSetChanged();

                }
            });

            swOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        tvName.setVisibility(View.INVISIBLE);
                        tvAge.setVisibility(View.INVISIBLE);
                        tvSex.setVisibility(View.INVISIBLE);
                    } else{
                        tvName.setVisibility(View.VISIBLE);
                        tvAge.setVisibility(View.VISIBLE);
                        tvSex.setVisibility(View.VISIBLE);
                    }
                }
            });
        } // ViewHolder()

        public void setProfile(DogProfile profile){
            tvName.setText(profile.getName());
            tvAge.setText(profile.getAge());
            tvSex.setText(profile.getSex());
        }
    } // ViewHolder class

    // 데이터를 다루기 위한 메소드들
    // ArrayList 의 메소드들 사용
    public void addProfile(DogProfile p){ profiles.add(p);}
    public void addProfile(int position, DogProfile p){profiles.add(position, p);}
    public void setProfiles(ArrayList<DogProfile> profiles){ this.profiles = profiles;}
    public DogProfile getProfile(int position, DogProfile p){return profiles.get(position);}
    public void removeProfile(int position){ profiles.remove(position); }

} // DogAdapter
