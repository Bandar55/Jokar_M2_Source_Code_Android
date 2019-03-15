package com.mobu.jokar.retrofit;


import com.mobu.jokar.bean.CommanResponse;
import com.mobu.jokar.bean.OtpResendResponse;
import com.mobu.jokar.bean.SignUpResponse;
import com.mobu.jokar.bean.SignUpWithMobileResp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by mobulous06 on 19/7/17.
 */
public interface ApiInterface {

    @GET("getStaticContent")
    Call<SignUpResponse> getStaticContent();

    @FormUrlEncoded
    @POST("signup")
    Call<SignUpResponse> signup(@Field("fullName") String fullName,
                                @Field("userName") String userName,
                                @Field("name") String name,
                                @Field("gender") String gender,
                                @Field("dob") String dob,
                                @Field("country") String country,
                                @Field("email") String email,
                                @Field("countryCode") String countryCode,
                                @Field("appLanguage") String appLanguage,
                                @Field("speakLanguage") String speakLanguage,
                                @Field("mobileNumber") String mobileNumber,
                                @Field("deviceType") String deviceType,
                                @Field("deviceToken") String deviceToken,
                                @Field("profilePic") String profilePic);


    @FormUrlEncoded
    @POST("signupWithMobile")
    Call<SignUpWithMobileResp> signUpWithMobile(@Field("countryCode") String countryCode,
                                                @Field("mobileNumber") String mobileNumber);




    @FormUrlEncoded
    @POST("signupWithMobile")
    Call<CommanResponse> otpVerification(@Field("mobileOtp") String mobileOtp,
                                          @Field("userId") String userId);



    @FormUrlEncoded
    @POST("resendMobileOtp")
    Call<OtpResendResponse> otpResend(@Field("userId") String userId,
                                      @Field("mobileNumber") String mobileNumber,
                                      @Field("countryCode") String countryCode);


//    @GET("search?term=Michael+jackson")
//    Call<TestResponse> MealType();

}
