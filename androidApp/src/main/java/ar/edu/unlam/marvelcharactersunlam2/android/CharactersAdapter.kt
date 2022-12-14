package ar.edu.unlam.marvelcharactersunlam2.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.marvelcharactersunlam2.android.databinding.ListItemCharacterBinding
import ar.edu.unlam.marvelcharactersunlam2.data.Character

class CharactersAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val charactersList = mutableListOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ListItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItemAt(position))
    }

    override fun getItemCount() = charactersList.size

    fun submitList(characters: List<Character>) {
        with(charactersList) {
            clear()
            addAll(characters)
        }
        notifyDataSetChanged()
    }

    private fun getItemAt(position: Int) = charactersList[position]
}