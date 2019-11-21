package com.example.doctors.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctors.R;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText,nText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This are the previous appointments");


    }

    public LiveData<String> getText() {
        return mText;
    }
}