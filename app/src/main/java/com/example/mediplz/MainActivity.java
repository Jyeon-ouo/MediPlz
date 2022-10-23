package com.example.mediplz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.mediplz.databinding.ActivityMainBinding;

import fragment.MedicineCalendarFragment;
import fragment.OtcDrugAddFragment;
import fragment.OtcDrugManagementFragment;
import fragment.PrescriptionAddFragment;
import fragment.PrescriptionManagementFragment;
import fragment.WasteDrugInfoFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Fragment MedicineCalendarFragment;
    private Fragment OtcDrugManagementFragment;
    private Fragment PrescriptionManagementFragment;
    private Fragment WasteDrugInfoFragment;
    private Fragment OtcDrugAddFragment;
    private Fragment PrescriptionAddFragment;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewBinding();
        initialize();
        bottomNavigationSelect();

        OtcDrugAddFragment = new OtcDrugAddFragment();
        getSupportFragmentManager().findFragmentById(R.id.otc_add_btn);

        PrescriptionAddFragment = new PrescriptionAddFragment();
        getSupportFragmentManager().findFragmentById(R.id.pre_add_btn);
        }
    
    //뷰바인딩
    private void viewBinding(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    //초기화
    private void initialize(){
        binding.bottomNav.setItemIconTintList(null);
        menu = binding.bottomNav.getMenu();

        MedicineCalendarFragment = new MedicineCalendarFragment();
        //첫화면
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, MedicineCalendarFragment).commit();
        menu.findItem(R.id.medicine_calendar_fragment).setIcon(R.drawable.icon_calendar);
    }

    private void bottomNavigationSelect(){
        binding.bottomNav.setOnItemSelectedListener(item -> {
            changeFragment(item);
            return true;
        });
    }

    //아이콘 클릭
    @SuppressLint("NonConstantResourceId")
    public void changeFragment(MenuItem item){
        switch (item.getItemId()){
            case R.id.medicine_calendar_fragment:
                if(MedicineCalendarFragment == null){
                    MedicineCalendarFragment = new MedicineCalendarFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, MedicineCalendarFragment).commit();
                }
                screenChange(MedicineCalendarFragment, item);
                break;
            case R.id.otc_drug_management_fragment:
                if(OtcDrugManagementFragment == null){
                    OtcDrugManagementFragment = new OtcDrugManagementFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, OtcDrugManagementFragment).commit();
                }
                screenChange(OtcDrugManagementFragment, item);
                break;
            case R.id.prescription_management_fragment:
                if(PrescriptionManagementFragment == null){
                    PrescriptionManagementFragment = new PrescriptionManagementFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, PrescriptionManagementFragment).commit();
                }
                screenChange(PrescriptionManagementFragment, item);
                break;
            case R.id.waste_drug_info_fragment:
                if(WasteDrugInfoFragment == null){
                    WasteDrugInfoFragment = new WasteDrugInfoFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, WasteDrugInfoFragment).commit();
                }
                screenChange(WasteDrugInfoFragment, item);
                break;
            default:
                break;
        }
    }

    //화면 전환
    @SuppressLint("NonConstantResourceId")
    private void screenChange(Fragment fragment, MenuItem item){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
        menu.findItem(R.id.medicine_calendar_fragment).setIcon(R.drawable.icon_calendar_white);
        menu.findItem(R.id.otc_drug_management_fragment).setIcon(R.drawable.icon_medicine1_white);
        menu.findItem(R.id.prescription_management_fragment).setIcon(R.drawable.icon_medicine2_white);
        menu.findItem(R.id.waste_drug_info_fragment).setIcon(R.drawable.icon_map_white);

        switch (item.getItemId()){
            case R.id.medicine_calendar_fragment:
                item.setIcon(R.drawable.icon_calendar);
                break;
            case R.id.otc_drug_management_fragment:
                item.setIcon(R.drawable.icon_medicine1);
                break;
            case R.id.prescription_management_fragment:
                item.setIcon(R.drawable.icon_medicine2);
                break;
            case R.id.waste_drug_info_fragment:
                item.setIcon(R.drawable.icon_map);
                break;
            default:
                break;
        }
    }



    //생성된 모든 화면 숨김처리
//    private void allScreenHide(){
//        if (MedicineCalendarFragment != null) getSupportFragmentManager().beginTransaction().hide(MedicineCalendarFragment).commit();
//        if (OtcDrugManagementFragment != null) getSupportFragmentManager().beginTransaction().hide(OtcDrugManagementFragment).commit();
//        if (PrescriptionManagementFragment != null) getSupportFragmentManager().beginTransaction().hide(PrescriptionManagementFragment).commit();
//        if (WasteDrugInfoFragment != null) getSupportFragmentManager().beginTransaction().hide(WasteDrugInfoFragment).commit();
//    }

}