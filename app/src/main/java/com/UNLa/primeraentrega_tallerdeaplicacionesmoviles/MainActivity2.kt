package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var characterAdapter: CharacterAdapter? = null
    var my_toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        my_toolbar = findViewById(R.id.tbTittle)
        setSupportActionBar(my_toolbar)
        supportActionBar!!.title = "Lista de personajes"
        setupAdapterServicioRest();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_main_characters) {
            Toast.makeText(this, "Ya estás en esta pestaña", Toast.LENGTH_SHORT).show()
        }
        if (item.itemId == R.id.item_house) {
            Toast.makeText(this, "Casas", Toast.LENGTH_SHORT).show()
        }
        if (item.itemId == R.id.item_logout) {
            val itemCharacterToMenuActivity =
                Intent(this@MainActivity2, ViewPrincipalActivity::class.java)
            startActivity(itemCharacterToMenuActivity)
            val credentials =
                applicationContext.getSharedPreferences(Constantes.SP_CREDENTIAL, MODE_PRIVATE)
            val editor = credentials.edit()
            editor.putString(Constantes.USUARIO, null)
            editor.putString(Constantes.PASSWORD, null)
            editor.apply()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupAdapterServicioRest() {
        var respuesta: MutableList<Character> = mutableListOf()

        val api = RetroFitClient.retrofit.create(MyApi::class.java)
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                Log.e("TODO", Thread.currentThread().name);
                api.getCharacters()
                    .enqueue(object :  //este clientretrofit va a la calse retroclient y llama al metodo getCharacters
                        Callback<List<CharacterApiRest>> {

                        override fun onResponse(
                            call: Call<List<CharacterApiRest>>,
                            response: Response<List<CharacterApiRest>> //LO que devuelve el metodo retrofit getCharacters
                        ) {
                            val characterRest = response.body()
                            characterRest?.forEach {
                                if (it.name.isNullOrEmpty() && it.culture.isNullOrEmpty() || (it.name.isNullOrEmpty())) {
                                    Log.e("TODO", "Alguna Variable es nula")
                                } else {
                                    val charac = Character(
                                        it.id,
                                        it.name,
                                        it.gender,
                                        it.culture,
                                        it.born,
                                        it.died,
                                        it.father,
                                        it.mother,
                                        it.spouse
                                    )
                                    respuesta.add(charac);
                                }
                            }
                            recyclerView = findViewById(R.id.rvReclyclerMain)
                            CharacterAdapter(respuesta) { c ->
                                c.name?.let {
                                    startActivity(
                                        Intent(
                                            this@MainActivity2,
                                            ItemCharacterActivity::class.java
                                        ).putExtra("character", c)
                                    );
                                    Toast.makeText(
                                        this@MainActivity2,
                                        c.name,
                                        Toast.LENGTH_LONG
                                    ).show();

                                }
                            }.let {
                                recyclerView.adapter = it;
                            }
                        }

                        override fun onFailure(
                            call: Call<List<CharacterApiRest>>,
                            t: Throwable
                        ) {
                            Log.e("REST", t.message ?: "");
                        }

                    })
            }
        }
    }
}