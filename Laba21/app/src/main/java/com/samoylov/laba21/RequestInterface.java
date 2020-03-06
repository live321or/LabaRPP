package com.samoylov.laba21;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("techs.ruleset.json")
    Call<List<Technologies>> getTechnologiesJson();
}
