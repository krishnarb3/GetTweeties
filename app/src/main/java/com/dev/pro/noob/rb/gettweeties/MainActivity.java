package com.dev.pro.noob.rb.gettweeties;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;


public class MainActivity extends ActionBarActivity implements OpeningFragment.OnFragmentInteractionListener
{
    Toolbar toolbar;
    static String consumer_key = "BJNHshkxLcmXaoKwcG6hZmiw8";
    static String consumer_secret = "SoKjwVxYuEJrmxZdvQQnDU5lSkA2QREg32kD5QIG9O8Gl9vApi";
    static String pref_name = "twitter_oauth";
    static final String pref_key_token = "oauth_token";
    static final String pref_key_secret = "oauth_token_secret";
    static final String pref_key_login = "isTwitterLogedIn";
    static final String callback_url = "oauth://t4jsample";
    static final String url_auth = "auth_url";
    static final String url_verifier = "oauth_verifier";
    static final String url_token = "oauth_token";
    private static Twitter twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Get Tweeties");
        Uri uri = getIntent().getData();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        //OpeningFragment fragment = OpeningFragment.newInstance();
        //ft.replace(R.id.,fragment,"Main Fragment");
        ft.commit();
    }

    public void getFromTwitter()
    {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumer_key);
        builder.setOAuthConsumerSecret(consumer_secret);
        Configuration configuration = builder.build();
        TwitterFactory factory = new TwitterFactory(configuration);
        twitter = factory.getInstance();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }
}
