package ar.edu.unlam.marvelcharactersunlam2.android

import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.marvelcharactersunlam2.android.databinding.ListItemCharacterBinding
import ar.edu.unlam.marvelcharactersunlam2.data.Character
import com.squareup.picasso.Picasso

class CharacterViewHolder(private val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        binding.name.text = character.name
        binding.description.text = character.description
        if (character.thumbnailUrl.isNotEmpty()) {
            Picasso.get()
                .load(character.thumbnailUrl)
                .into(binding.image)
        } else {
            binding.image.setImageURI(null)
        }
    }

}
