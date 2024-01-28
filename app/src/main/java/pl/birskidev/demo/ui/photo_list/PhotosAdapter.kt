package pl.birskidev.demo.ui.photo_list

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pl.birskidev.demo.R
import pl.birskidev.demo.databinding.ItemPhotoBinding
import pl.birskidev.demo.domain.Photo

class PhotosAdapter : ListAdapter<Photo, ViewHolder>(ContentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PhotoViewHolder(ItemPhotoBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is PhotoViewHolder -> {
                holder.bind(getItem(position))
            }

            else -> error("Undefined ViewType")
        }
    }

    class ContentDiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.link == newItem.link &&
                    oldItem.title == newItem.title &&
                    oldItem.description == newItem.description &&
                    oldItem.published == newItem.published
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo) = true

    }
}

class PhotoViewHolder(private val binding: ItemPhotoBinding) : ViewHolder(binding.root) {
    fun bind(content: Photo) {
        with(binding) {
            itemPhotoDescription.text = Html.fromHtml(content.description, Html.FROM_HTML_MODE_LEGACY)
            Glide.with(itemView)
                .load(content.imageUrl)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                        .error(R.drawable.image_placeholder_error)
                )
                .into(binding.itemPhotoImage)
        }
    }
}