package com.mobu.jokar.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.SelectTimeAdapter;
import com.mobu.jokar.adapter.ThreeLevelListAdapter;
import com.mobu.jokar.utils.NLevelItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapProfessinalWorkerActivity extends AppCompatActivity {
    List<NLevelItem> list;

    private ExpandableListView expandableListView;
    CopyOnWriteArrayList<String> dataData;
    private SelectTimeAdapter selectTimeAdapter;
    private String type = "";
    @BindView(R.id.rlMainDown)
    RelativeLayout relativeLayoutDown;
    @BindView(R.id.rlMainSelectService)
    RelativeLayout rlMainSelectService;
    @BindView(R.id.btn_go_order)
    ImageView ivRequestOrder;
    boolean isFirstTime = false;
    SharedPreferences sharedpreferences;
    private String commingType="";


    /**
     * The Parent Group Names.
     */
    String[] parent = new String[]{"Movies", "Games"}; // comment this when uncomment bottom
    /**
     * The Movies Genre List.
     */
    // We have two  main category. (third one is left for example addition)
    String[] movies = new String[]{"Horror", "Action", "Thriller/Drama"};
    /**
     * The Games Genre List.
     */
    String[] games = new String[]{"Fps", "Moba", "Rpg", "Racing"};
    /**
     * The Serials Genre List.
     */
    // String[] serials = new String[]{"Crime", "Family", "Comedy"};


    /**
     * The Horror movie list.
     */
    // movies category has further genres
    String[] horror = new String[]{"Conjuring", "Insidious", "The Ring"};
    /**
     * The Action Movies List.
     */
    String[] action = new String[]{"Jon Wick", "Die Hard", "Fast 7", "Avengers"};
    /**
     * The Thriller Movies List.
     */
    String[] thriller = new String[]{"Imitation Game", "Tinker, Tailer, Soldier, Spy", "Inception", "Manchester by the Sea"};
    /**
     * The Fps games.
     */
    // games category has further genres
    String[] fps = new String[]{"CS: GO", "Team Fortress 2", "Overwatch", "Battlefield 1", "Halo II", "Warframe"};
    /**
     * The Moba games.
     */
    String[] moba = new String[]{"Dota 2", "League of Legends", "Smite", "Strife", "Heroes of the Storm"};
    /**
     * The Rpg games.
     */
    String[] rpg = new String[]{"Witcher III", "Skyrim", "Warcraft", "Mass Effect II", "Diablo", "Dark Souls", "Last of Us"};
    /**
     * The Racing games.
     */
    String[] racing = new String[]{"NFS: Most Wanted", "Forza Motorsport 3", "EA: F1 2016", "Project Cars"};
    // serials genre list
    /*String[] crime = new String[]{"CSI: MIAMI", "X-Files", "True Detective", "Sherlock (BBC)", "Fargo", "Person of Interest"};
    String[] family = new String[]{"Andy Griffith", "Full House", "The Fresh Prince of Bel-Air", "Modern Family", "Friends"};
    String[] comedy = new String[]{"Family Guy", "Simpsons", "The Big Bang Theory", "The Office"};
*/
    /**
     * Datastructure for Third level movies.
     */
    LinkedHashMap<String, String[]> thirdLevelMovies = new LinkedHashMap<>();
    /**
     * Datastructure for Third level games.
     */
    LinkedHashMap<String, String[]> thirdLevelGames = new LinkedHashMap<>();

    /**
     * Datastructure for Third level Serials.
     */
    // LinkedHashMap<String, String[]> thirdLevelSerials = new LinkedHashMap<>();
    /**
     * The Second level.
     */
    List<String[]> secondLevel = new ArrayList<>();
    /**
     * The Data.
     */
    List<LinkedHashMap<String, String[]>> data = new ArrayList<>();

    @BindView(R.id.iv_backDelivery)
    ImageView btnBack;

    public static Intent getIntent(Context context, String type) {
        Intent intent = new Intent(context, MapProfessinalWorkerActivity.class);
        intent.putExtra("type", type);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_professinal_worker);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            type = (String) getIntent().getSerializableExtra("type");
            if (type.equalsIgnoreCase("btn_prfsnal_worker")) {
                relativeLayoutDown.setVisibility(View.GONE);
                rlMainSelectService.setVisibility(View.VISIBLE);
                ivRequestOrder.setImageDrawable(getResources().getDrawable(R.drawable.request_btn));

            } else {
                ivRequestOrder.setImageDrawable(getResources().getDrawable(R.drawable.btn));
                relativeLayoutDown.setVisibility(View.VISIBLE);
                rlMainSelectService.setVisibility(View.GONE);
            }
        }


        //listView = (ListView) findViewById(R.id.listView1);
        list = new ArrayList<NLevelItem>();
        dataData = new CopyOnWriteArrayList<>();
        prepareData();
    }

    @OnClick({R.id.rlMainSelectService, R.id.iv_back, R.id.tv_select_time, R.id.btn_go_order,
            R.id.btnComments, R.id.iv_backDelivery})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlMainSelectService:
                showDialog();
                break;
            case R.id.iv_back:
                Intent intent = new Intent(MapProfessinalWorkerActivity.this, NavDrawerActivity.class);
                startActivity(intent);
            case R.id.tv_select_time:
                openBottomSheetBanner();
                break;
            case R.id.btn_go_order:


                SharedPreferences sharedpreferences = getSharedPreferences("kAppPreferences", Context.MODE_PRIVATE);

                isFirstTime = sharedpreferences.getBoolean("kIsFirstTime", true); // getting String
                if (isFirstTime) {
                    startActivity(SignUpOptions.getIntent(this));
                    finish();
                } else {

                    commingType=sharedpreferences.getString("commingType", null);
                    if(commingType.equalsIgnoreCase("SignUp")){
                       // dialogTermsCondition(commingType);

                            showDialogInstruction();
                       // SharedPreferences sharedpreferences = getSharedPreferences("kAppPreferences", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("commingType","SignIn");
                        editor.commit();

                    }else {
                        //showDialogInstruction();
                        dialogTermsCondition(commingType);
                    }

                }
                // startActivity(SignUpOptions.getIntent(this));
                // dialogTermsCondition();

                break;

            case R.id.btnComments:
                onBackPressed();
                break;

            case R.id.iv_backDelivery:
                onBackPressed();
                break;
        }
    }

    private void showDialog() {
        //Dialog dialog=new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.service_main);
        EditText header = (EditText) dialog.findViewById(R.id.edt_search);
        expandableListView = (ExpandableListView) dialog.findViewById(R.id.expandible_listview);
        // second level category names (genres)
        secondLevel.add(movies);
        secondLevel.add(games);
        // secondLevel.add(serials);
        // movies category all data
        thirdLevelMovies.put(movies[0], horror);
        thirdLevelMovies.put(movies[1], action);
        thirdLevelMovies.put(movies[2], thriller);
        // games category all data
        thirdLevelGames.put(games[0], fps);
        thirdLevelGames.put(games[1], moba);
        thirdLevelGames.put(games[2], rpg);
        thirdLevelGames.put(games[3], racing);
        // serials category all data
      /*  thirdLevelSerials.put(serials[0], crime);
        thirdLevelSerials.put(serials[1], family);
        thirdLevelSerials.put(serials[2], comedy);
*/
        // all data
        data.add(thirdLevelMovies);
        data.add(thirdLevelGames);
        //data.add(thirdLevelSerials);


        // expandable listview


        // parent adapter
        ThreeLevelListAdapter threeLevelListAdapterAdapter = new ThreeLevelListAdapter(this, parent, secondLevel, data);


        // set adapter
        expandableListView.setAdapter(threeLevelListAdapterAdapter);


        // OPTIONAL : Show one list at a time
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });


        dialog.show();

    }

    private void prepareData() {
        dataData.add("Within 1 hour");
        dataData.add("Within 2 hour");
        dataData.add("Within 3 hour");
        dataData.add("Within 4 hour");
        dataData.add("Within 5+ hour");


    }


    private void openBottomSheetBanner() {
        View view = getLayoutInflater().inflate(R.layout.custom_buttonsheet_layout, null);
        final Dialog mBottomSheetDialog = new Dialog(this, R.style.MaterialDialogSheetAnimation);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = mBottomSheetDialog.findViewById(R.id.rv_bottom_sheet);
        selectTimeAdapter = new SelectTimeAdapter(this, dataData);
        recyclerView.setAdapter(selectTimeAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHorizontalFadingEdgeEnabled(true);
        selectTimeAdapter.notifyDataSetChanged();

        TextView textView = (TextView) view.findViewById(R.id.tv_order);


        if (type.equalsIgnoreCase("btn_prfsnal_worker")) {
            textView.setText("I want My Service");
        } else {
            textView.setText("I want My Order");
        }

        view.findViewById(R.id.ok_txt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetDialog.dismiss();
            }
        });
    }


    private void dialogTermsCondition(String commingType) {
        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_professional_terms_condition_layout);

        //TextView header = (TextView) dialog.findViewById(R.id.header);
        TextView btnOK = (TextView) dialog.findViewById(R.id.tv_ok);
        TextView btnCancel = (TextView) dialog.findViewById(R.id.tv_cancel);

        if(commingType.equalsIgnoreCase("SignUp")){
            dialog.findViewById(R.id.checkbox).setVisibility(View.VISIBLE);

        }else {
            dialog.findViewById(R.id.checkbox).setVisibility(View.GONE);
        }

        //header.setText(R.string.leaveorg_title);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogSubmitSuccess();

                dialog.dismiss();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();
            }
        });


        dialog.show();

    }

    private void showDialogInstruction() {
        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_instraction);

        dialog.findViewById(R.id.tv_ok).setOnClickListener(v ->{
            dialog.dismiss();
            if (type.equalsIgnoreCase("btn_prfsnal_worker")) {


                startActivity(RequireProfessionalWorkerActivity.getIntent(MapProfessinalWorkerActivity.this));

            } else {

                startActivity(RequireDeliveryPersonDashboardActivity.getIntent(MapProfessinalWorkerActivity.this));
            }

        });
        dialog.findViewById(R.id.tv_cancel).setOnClickListener(v -> {

            dialog.dismiss();
        });


        dialog.show();

    }


    private void dialogSubmitSuccess() {
        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_submit_successfully_layout);


        TextView btnOK = (TextView) dialog.findViewById(R.id.tv_ok);


        btnOK.setOnClickListener(view -> {
            if (type.equalsIgnoreCase("btn_prfsnal_worker")) {

                startActivity(RequireProfessionalWorkerActivity.getIntent(MapProfessinalWorkerActivity.this));

            } else {

                startActivity(RequireDeliveryPersonDashboardActivity.getIntent(MapProfessinalWorkerActivity.this));
            }


            dialog.dismiss();
        });


        dialog.show();

    }


}
