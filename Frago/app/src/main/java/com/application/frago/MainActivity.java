package com.application.frago;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.application.frago.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Default nastavení prvniho Fragmentu
        replaceFragment(new HomeFragment());

        //vyber pri kliknuti na spodni nav
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;


            if (item.getItemId() == R.id.list)  //nakupni seznam
                selectedFragment = new ListFragment();
            if (item.getItemId() == R.id.home)  //Hl stranka
                selectedFragment = new HomeFragment();


            if (selectedFragment != null) { //jinak nic
                replaceFragment(selectedFragment);
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment); // nastavení hlavniho okna
        fragmentTransaction.commit();   //potvrzeni
    }
}
