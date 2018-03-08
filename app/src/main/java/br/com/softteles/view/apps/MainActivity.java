package br.com.softteles.view.apps;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//Imports
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.*;
import android.app.*;
import android.content.*;
import android.net.*;
import android.graphics.*;
import android.widget.*;
import android.media.*;
import android.view.KeyEvent;
import android.annotation.SuppressLint;
import android.view.ViewGroup;

//Imports

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static WebView view;
    private static WebView view_admin;
    private static String url ="http://www.redevidatel.com.br";
    private static String url_admin ="http://www.redevidatel.com.br/admin";
    private static String url_recarga ="http://www.redevidatel.com.br/recarga";

    public boolean temInternet() {
        ConnectivityManager manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        //limpar
        view.clearView();
        return info != null && info.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            //inicio View Pager
            view = (WebView) findViewById(R.id.WebView1);
            WebView view = (WebView) this.findViewById(R.id.WebView1);
            view.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    //Make the bar disappear after URL is loaded, and changes string to Loading...
                    setTitle("Loading...");
                    setProgress(progress * 100); //Make the bar disappear after URL is loaded

                    // Return the app name after finish loading
                    if (progress == 100)
                        setTitle(R.string.app_name);
                }
            });
            view.setWebViewClient(new MyBrowser());
            view.getSettings().setLoadsImagesAutomatically(true);
            view.getSettings().setJavaScriptEnabled(true);
            WebSettings webSettings = view.getSettings();
            view.setInitialScale(1);
            //view.getSettings().setBuiltInZoomControls(true);
            view.getSettings().setUseWideViewPort(true);
            view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            view.loadUrl(url);
            //Fim View Pager
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_exit) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);

            // set title
            alertDialogBuilder.setTitle("Exit");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Do you really want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            //inicio View Pager
            view=(WebView)findViewById(R.id.WebView1);
            WebView view = (WebView)this.findViewById(R.id.WebView1);
            view.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress)
                {
                    //Make the bar disappear after URL is loaded, and changes string to Loading...
                    setTitle("Loading...");
                    setProgress(progress * 100); //Make the bar disappear after URL is loaded

                    // Return the app name after finish loading
                    if(progress == 100)
                        setTitle(R.string.app_name);
                }
            });
            view.setWebViewClient(new MyBrowser());
            view.getSettings().setLoadsImagesAutomatically(true);
            view.getSettings().setJavaScriptEnabled(true);
            WebSettings webSettings = view.getSettings();
            view.setInitialScale(1);
            //view.getSettings().setBuiltInZoomControls(true);
            view.getSettings().setUseWideViewPort(true);
            view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            view.loadUrl(url);
            //Fim View Pager

        } else if (id == R.id.nav_admin) {
            // Handle the admin action
            //inicio View Pager
            view=(WebView)findViewById(R.id.WebView1);
            WebView view = (WebView)this.findViewById(R.id.WebView1);
            view.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress)
                {
                    //Make the bar disappear after URL is loaded, and changes string to Loading...
                    setTitle("Loading...");
                    setProgress(progress * 100); //Barra de porcentagem * 100

                    // Retorna o nome do APP quando Estiver 100%
                    if(progress == 100)
                        setTitle(R.string.app_name);
                }
            });
            view.setWebViewClient(new MyBrowser());
            view.getSettings().setLoadsImagesAutomatically(true);
            view.getSettings().setJavaScriptEnabled(true);
            WebSettings webSettings = view.getSettings();
            view.setInitialScale(1);
            //view.getSettings().setBuiltInZoomControls(true);
            view.getSettings().setUseWideViewPort(true);
            view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            view.loadUrl(url_admin);
            //Fim View Pager

        } else if (id == R.id.nav_recarga) {
            //inicio View Pager
            view=(WebView)findViewById(R.id.WebView1);
            WebView view = (WebView)this.findViewById(R.id.WebView1);
            view.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress)
                {
                    setTitle("Loading...");
                    setProgress(progress * 100); //Make the bar disappear after URL is loaded
                    if(progress == 100)
                        setTitle(R.string.app_name);
                }
            });
            view.setWebViewClient(new MyBrowser());
            view.getSettings().setLoadsImagesAutomatically(true);
            view.getSettings().setJavaScriptEnabled(true);
            WebSettings webSettings = view.getSettings();
            view.setInitialScale(1);
            view.getSettings().setUseWideViewPort(true);
            view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            view.loadUrl(url_recarga);
            //Fim View Pager

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // public boolean shouldOverrideUrlLoading(WebView view, String urlNewString, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            // view.loadUrl(url);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {
            view.loadUrl(urlNewString);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        else if (view.canGoBack()) {
            view.goBack();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);

            // set title
            alertDialogBuilder.setTitle("Exit");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Do you really want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }

    }

}
