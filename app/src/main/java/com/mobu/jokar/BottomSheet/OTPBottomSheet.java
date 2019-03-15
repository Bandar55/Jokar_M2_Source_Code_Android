package com.mobu.jokar.BottomSheet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.google.gson.Gson;
import com.mobu.jokar.R;
import com.mobu.jokar.activities.MapProfessinalWorkerActivity;
import com.mobu.jokar.activities.SignIn;
import com.mobu.jokar.activities.SignUp;
import com.mobu.jokar.activities.SignUpMobileActivity;
import com.mobu.jokar.bean.CommanResponse;
import com.mobu.jokar.bean.OtpResendResponse;
import com.mobu.jokar.bean.SignUpWithMobileResp;
import com.mobu.jokar.database.SharedPreferenceWriter;
import com.mobu.jokar.retrofit.ApiClientConnection;
import com.mobu.jokar.retrofit.ApiInterface;
import com.mobu.jokar.retrofit.MyDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPBottomSheet extends BottomSheetDialogFragment {
    @BindView(R.id.pinview)
    Pinview pinview;
    private String commingType = "";
    private SignUpWithMobileResp signUpWithMobileResp;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.otp_bottom_sheet, container, false);
        ButterKnife.bind(this, view);


        getOtpScreen();

        sendOtp();

        return view;
    }

    private void sendOtp() {

        Gson gson = new Gson();

        signUpWithMobileResp = gson.fromJson(SharedPreferenceWriter.getInstance(getActivity()).getString("kSignUpData"), SignUpWithMobileResp.class);
        Log.d("Otp", signUpWithMobileResp.getData().getMobileOtp());


    }

    void getOtpScreen() {

        Handler handler = new Handler();
        int TIMEDALEYSLASHSCREEN = 60000;
        handler.postDelayed(() -> {

            if (pinview.getValue().length() == 4) {

                SharedPreferences sharedpreferences = getActivity().getSharedPreferences("kAppPreferences", Context.MODE_PRIVATE);

                commingType = sharedpreferences.getString("commingTypeMobile", null);

                if (commingType.equalsIgnoreCase("SignInMobile") && commingType != null) {
                    getActivity().finish();
                    startActivity(SignUp.getIntent(getActivity()));


                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("commingTypeMobile", "");
                    editor.commit();

                } else {

                    otpVerification();
                }
            }

        }, TIMEDALEYSLASHSCREEN);
    }


    private void showWelcomeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.welcome_dialog, null);  // this line
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button btnOk = dialog.findViewById(R.id.okBtn);
        TextView tvWelcomeToJokar = dialog.findViewById(R.id.tvWelcomeToJokar);

        SpannableString spannableString = new SpannableString(getString(R.string.hello_nihar_welcome_to_jokar_family));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.purpalMedium)), 24, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvWelcomeToJokar.setText(spannableString);

        btnOk.setOnClickListener(v1 -> {
            SharedPreferences sharedpreferences = getActivity().getSharedPreferences("kAppPreferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("kIsFirstTime", false);
            editor.commit();

            getActivity().finish();
            startActivity(MapProfessinalWorkerActivity.getIntent(getActivity(), ""));
            dialog.dismiss();

        });

    }

    private void otpVerification() {

        MyDialog.getInstance(getActivity()).hideDialog();
        MyDialog.getInstance(getActivity()).showDialog(getActivity());
        ApiInterface apiInterface = ApiClientConnection.getInstance().createApiInterface();
        Call<CommanResponse> call = apiInterface.otpVerification(signUpWithMobileResp.getData().getId(), signUpWithMobileResp.getData().getMobileNumber());
        call.enqueue(new Callback<CommanResponse>() {
            @Override
            public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equalsIgnoreCase("SUCCESS")) {

                        showWelcomeDialog();
                        Toast.makeText(getActivity(), "" + response.body().getResponseMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "" +  response.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<CommanResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
                t.printStackTrace();

            }
        });

    }

    @OnClick({R.id.tvResendCode})
    void onClick(View view){
        switch (view.getId()){
            case R.id.tvResendCode:
                resendCode();
        }
    }

    private void resendCode() {


        MyDialog.getInstance(getActivity()).hideDialog();
        MyDialog.getInstance(getActivity()).showDialog(getActivity());
        ApiInterface apiInterface = ApiClientConnection.getInstance().createApiInterface();
        Call<OtpResendResponse> call = apiInterface.otpResend(signUpWithMobileResp.getData().getId(), signUpWithMobileResp.getData().getMobileNumber(),signUpWithMobileResp.getData().getCountryCode());
        call.enqueue(new Callback<OtpResendResponse>() {
            @Override
            public void onResponse(Call<OtpResendResponse> call, Response<OtpResendResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equalsIgnoreCase("SUCCESS")) {


                        Toast.makeText(getActivity(), "" + response.body().getData(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "" +  response.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<OtpResendResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
                t.printStackTrace();

            }
        });



    }


}
