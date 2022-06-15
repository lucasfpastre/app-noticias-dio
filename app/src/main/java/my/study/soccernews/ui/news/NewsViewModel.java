package my.study.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import my.study.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover Mock de Notícias
        List<News> news = new ArrayList<>();
        news.add(new News("Mussum","Mussum Ipsum, cacilds vidis litro abertis. Posuere libero varius."));
        news.add(new News("Cacilds","Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi."));
        news.add(new News("Abertis","Nullam volutpat risus nec leo commodo, ut interdum diam laoreet."));

        this.news.setValue(news);
    }

    public LiveData<News> getNews() {
        return this.news;
    }
}