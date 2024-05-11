package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var cardItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = repositories[position]

        holder.repositoryName.text = repository.name
        holder.repositoryCard.setOnClickListener{
            cardItemLister(repository)
        }
        holder.btnShare.setOnClickListener{
            btnShareLister(repository)
        }
    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val repositoryName: TextView
        val repositoryCard: CardView
        val btnShare: ImageView

        init {
            view.apply {
                repositoryName = findViewById(R.id.tv_repository_name)
                repositoryCard = findViewById(R.id.cv_card)
                btnShare = findViewById(R.id.iv_btn_share)
            }
        }

    }
}


