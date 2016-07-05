package br.com.frameworksystem.marvelapp.ui.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.bd.SQLiteHelper;
import br.com.frameworksystem.marvelapp.model.Character;
import br.com.frameworksystem.marvelapp.util.Constants;

/**
 * Created by wgomes on 17/06/16.
 */

public class CharacterDetailActivity extends BaseActivity {

    private Character character;
    private SQLiteDatabase db;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //no oncreate se definie o layout da activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = SQLiteHelper.getDatabase(this);

        //setando o layout
        setContentView(R.layout.activity_character_detail);

        //inserindo toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //mesmo comportament da action bar, mas continua customizavel
        setSupportActionBar(toolbar);
        //seta de voltar para a home - recria a pilha - volta para a parent a activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //intent são mensagens entre telas, é possível enviar e receber informações
        character = (Character) getIntent().getSerializableExtra("character");
        //colocando título no topo da tela
        setTitle(character.getName());

        ImageView characterImage = (ImageView) findViewById(R.id.character_image);
        TextView characterDescription = (TextView) findViewById(R.id.character_description);

        Picasso.with(this).load(character.getThumbnailUrl()).into(characterImage);
        characterDescription.setText(character.getDescription());

        Cursor cursor = recuperaDado();


    }

    //pegando o menu na toolbar (topo da tela)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.character_detail, menu);

        //criando a intent e validando tudo, sem precidar de actios send
        ShareCompat.IntentBuilder intent = ShareCompat.IntentBuilder.from(this).
                setText(character.getDescription()).setType("text/plain");
        ShareActionProvider actionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider
                (menu.findItem(R.id.action_share));
        actionProvider.setShareIntent(intent.getIntent());


        //ShareCompat.configureMenuItem(menu, R.id.action_share, intent);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //validando se o usuario clicou no botao share
        if (item.getItemId() == R.id.action_favorite) {
            item.setIcon(R.drawable.ic_action_liked);
            registerRemoveFavorite();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void registerRemoveFavorite() {
        ContentValues dados = new ContentValues();

        dados.put("name", character.getName());
        dados.put("description",character.getDescription());
        dados.put("favorite",1);

        if (!db.isOpen()) {
            db = SQLiteHelper.getDatabase(this);
        }
        db.insert(Constants.CHARACTER_TABLE, null, dados);
    }

    private Cursor recuperaDado() {

        Cursor cursor;
        String where = "name=?";
        String[] colunas = new String[]{"name", "description", "favorite"};
        String argumentos[] = new String[]{character.getName()};
        cursor = db.query("character", colunas, where, argumentos, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (cursor.moveToNext()){

        }

//        db.close();
        return cursor;
    }




    //metodo para compartilhar contéudo
    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, character.getDescription());
        intent.putExtra(Intent.EXTRA_TITLE, character.getName());
        //informando que tipo de arquivo pode ser commpartilhado, neste cado todos tipos
        intent.setType("*/*");
        //verificando se o usuario tem apps para compartilhar
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}

