package my.study.soccernews.ui.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import my.study.soccernews.databinding.NewsItemBinding;
import my.study.soccernews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    // Lista de Notícias que será exibida na tela
    private List<News> news;

    // Adapter (construtor) recebe a lista de notícias
    public NewsAdapter(List<News> news) {
        this.news = news;
    }

    // Cria novas views retornando os dados para o ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    // Atribui os dados da lista para o holder via binding
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = this.news.get(position);
        holder.binding.tvTitle.setText(news.getTitle());
        holder.binding.tvDescription.setText(news.getDescription());
        Picasso.get().load(news.getImage()).fit().into(holder.binding.ivThumbnail);
        holder.binding.btOpenLink.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.getLink()));
            holder.itemView.getContext().startActivity(i);
        });
    }

    // Tamanho da lista
    @Override
    public int getItemCount() {
        return this.news.size();
    }

    // Mantém a instância do elemento visual
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsItemBinding binding;

        public ViewHolder(NewsItemBinding bindig) {
            super(bindig.getRoot());
            this.binding = bindig;
        }

    }
}
