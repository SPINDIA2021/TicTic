package com.tiktoknew.activitesfragments.profile;

import com.tiktoknew.databinding.ActivitySeeFullImageBinding;
import com.tiktoknew.simpleclasses.AppCompatLocaleActivity;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.tiktoknew.R;
import com.tiktoknew.simpleclasses.Functions;
import com.tiktoknew.simpleclasses.Variables;

public class SeeFullImageA extends AppCompatLocaleActivity {

    ActivitySeeFullImageBinding binding;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Functions.setLocale(Functions.getSharedPreference(this).getString(Variables.APP_LANGUAGE_CODE,Variables.DEFAULT_LANGUAGE_CODE)
                , this, getClass(),false);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_see_full_image);


        imageUrl = getIntent().getStringExtra("image_url");

        binding.ivClose.setOnClickListener(v -> {
          onBackPressed();
        });

        binding.ivProfile.setController(Functions.frescoImageLoad(imageUrl,binding.ivProfile,getIntent().getBooleanExtra("isGif",false)));

    }
}