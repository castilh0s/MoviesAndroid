package com.example.moviesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.moviesapp.R;
import com.example.moviesapp.repositories.Movie;

public class MoviesListActivity extends AppCompatActivity {

    private Button buttonIronMan;
    private Button buttonForrestGump;
    private Button buttonTheIncredibles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        final Intent movieIntent = new Intent(
                getApplicationContext(),
                MovieActivity.class
        );

        buttonIronMan = findViewById(R.id.buttonIronMan);
        buttonForrestGump = findViewById(R.id.buttonForrestGump);
        buttonTheIncredibles = findViewById(R.id.buttonTheIncredibles);

        buttonIronMan.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Movie ironMan = new Movie(
                                R.mipmap.iron_man_scene_foreground,
                                R.mipmap.iron_man_poster_foreground,
                                "Iron Man",
                                "30/04/2008",
                                "Tony Stark (Robert Downey Jr.) é um industrial bilionário, que também é um brilhante inventor. Ao ser sequestrado ele é obrigado por terroristas a construir uma arma devastadora mas, ao invés disto, constrói uma armadura de alta tecnologia que permite que fuja de seu cativeiro. A partir de então ele passa a usá-la para combater o crime, sob o alter-ego do Homem de Ferro."
                        );

                        movieIntent.putExtra("MOVIE", ironMan);
                        startActivity(movieIntent);
                    }
                }
        );

        buttonForrestGump.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Movie forrestGump = new Movie(
                                R.mipmap.forrest_gump_scene_foreground,
                                R.mipmap.forrest_gump_poster_foreground,
                                "Forrest Gump",
                                "06/07/1994",
                                "Quarenta anos da história dos Estados Unidos, vistos pelos olhos de Forrest Gump (Tom Hanks), um rapaz com QI abaixo da média e boas intenções. Por obra do acaso, ele consegue participar de momentos cruciais, como a Guerra do Vietnã e Watergate, mas continua pensando no seu amor de infância, Jenny Curran."
                        );

                        movieIntent.putExtra("MOVIE", forrestGump);
                        startActivity(movieIntent);
                    }
                }
        );

        buttonTheIncredibles.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Movie theIncredibles = new Movie(
                          R.mipmap.the_incredibles_scene_foreground,
                          R.mipmap.the_incredibles_poster_foreground,
                          "The Incredibles",
                          "10/12/2004",
                          "Roberto Pêra (Craig T. Nelson) já foi o maior herói do planeta, salvando vidas e combatendo o mal todos os dias sob o codinome Sr. Incrível. Porém, após salvar um homem de se suicidar, ele é processado e condenado na Justiça. Uma série de processos seguintes faz com que o Governo tenha que desembolsar uma alta quantia para pagar as indenizações, o que faz com que a opinião pública se volte contra os super-heróis. Em reconhecimento aos serviços prestados, o Governo faz a eles uma oferta: que levem suas vidas como pessoas normais, sem demonstrar que possuem superpoderes, recebendo em troca uma pensão anual. Quinze anos depois, Roberto leva uma vida pacata ao lado de sua esposa Helen (Holly Hunter), que foi a super-heroína Mulher-Elástica, e seus três filhos. Roberto agora trabalha em uma seguradora e luta para combater o tédio da vida de casado e o peso extra. Com vontade de retomar a vida de herói, ele tem a grande chance quando surge um comunicado misterioso, que o convida para uma missão secreta em uma ilha remota."
                        );

                        movieIntent.putExtra("MOVIE", theIncredibles);
                        startActivity(movieIntent);
                    }
                }
        );
    }
}
