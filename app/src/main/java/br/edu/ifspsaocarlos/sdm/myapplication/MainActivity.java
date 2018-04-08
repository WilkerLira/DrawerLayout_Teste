package br.edu.ifspsaocarlos.sdm.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    //Fragment
    private FragmentManager fragmentManager;
    private Cadastro cadastroFragment;
    private final String TAG_FRAG = "FragmentCadastro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, R.string.drawer_aberto, R.string.drawer_fechado);

        drawerLayout.addDrawerListener(drawerToggle);

        //cria navigationview e depois,
        //seleciona o menu da navigationview para abrir um fragment
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //return false;
                Fragment fragment = null;
                switch (item.getItemId()) {
                  /*  case R.id.nav_login:
                        item.setChecked(true);
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.drawer_layout, new Cadastro(), TAG_FRAG).commit();
                        break;*/
                    case R.id.nav_camera:
                        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(camera);
                        break;
                    /*case R.id.nav_music:
                        Intent musica = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);//Abre gravador de voz
                        startActivity(musica);
                        break;
                        default:
                            break;*/
                }
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;

        } else {
            switch (item.getItemId()) {
                /*menu no alto da tela e opcoes do DrawerLayout, para serem abertos*/
                case R.id.nav_login:
                    Toast.makeText(this, "Acessar", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.cadastrar:
                    Toast.makeText(this, "Cadastrar", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_camera:
                    Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(camera);
                    break;
                case R.id.acessar:
                    Toast.makeText(this, "Acessar", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);

    }
}









