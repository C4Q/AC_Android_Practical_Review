package nyc.c4q.dogsapp.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nyc.c4q.dogsapp.R;

public class DogsRvAdapter extends RecyclerView.Adapter<DogsRvAdapter.DogViewHolder> {

    private List<String> imageUrls;

    public DogsRvAdapter(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_item_view,parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.bindImage(imageUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    static class DogViewHolder extends RecyclerView.ViewHolder {

        private ImageView dogImageView;

        DogViewHolder(View itemView) {
            super(itemView);

            dogImageView = itemView.findViewById(R.id.dog_image);
        }

        void bindImage(String imageUrl) {
            Picasso.get().load(imageUrl).into(dogImageView);
        }
    }
}
