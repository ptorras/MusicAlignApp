package com.example.musicalignapp.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicalignapp.databinding.ItemPackageBinding
import com.example.musicalignapp.domain.model.PackageModel

class PackagesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemPackageBinding.bind(view)

    fun render(onItemSelected: () -> Unit, packageModel: PackageModel) {
        binding.apply {
            Glide.with(binding.tvTitle.context).load(packageModel.imageUrl).into(ivPackage)
            tvTitle.text = packageModel.packageName
            tvLastModificationDate.text = packageModel.lastModifiedDate
            tvFileName.text = packageModel.fileName
            binding.cvPackageItem.setOnClickListener { onItemSelected() }
        }
    }

}