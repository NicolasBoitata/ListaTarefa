package com.example.listatarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.listatarefas.database.DatabaseHelper
import com.example.listatarefas.databinding.ActivityAdicionarTarefaBinding

class adicionar_tarefa : AppCompatActivity() {
    private val binding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    private val bancoDados by lazy {
        DatabaseHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            btnSalvar.setOnClickListener {
                salvar()
            }
        }
    }


    private fun salvar(){
        val tarefa = binding.editTarefa.text.toString()
        val sql = "INSERT INTO tarefa VALUES (null, '$tarefa', '05/03/2024');"

        try {
            bancoDados.writableDatabase.execSQL(sql)
            Log.i("info_db", "Sucesso ao salvar")
        } catch (e:Exception){
            Log.i("info_db", "Erro ao salvar")
        }
    }


}