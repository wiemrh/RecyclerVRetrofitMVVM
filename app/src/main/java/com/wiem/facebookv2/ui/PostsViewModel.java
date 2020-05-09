package com.wiem.facebookv2.ui;

import com.wiem.facebookv2.Network.PostsClient;
import com.wiem.facebookv2.model.PostModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
   public MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData();

public void getPosts(){
    PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
        @Override
        public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
            postsMutableLiveData.setValue(response.body());
        }

        @Override
        public void onFailure(Call<List<PostModel>> call, Throwable t) {

        }
    });
}

}
