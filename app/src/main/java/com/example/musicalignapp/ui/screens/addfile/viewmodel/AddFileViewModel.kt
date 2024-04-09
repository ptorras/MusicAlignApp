package com.example.musicalignapp.ui.screens.addfile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicalignapp.core.generators.Generator
import com.example.musicalignapp.di.InterfaceAppModule.IdGeneratorAnnotation
import com.example.musicalignapp.di.InterfaceAppModule.PackageDateGeneratorAnnotation
import com.example.musicalignapp.domain.usecases.addfile.UploadPackageUseCase
import com.example.musicalignapp.ui.core.ScreenState
import com.example.musicalignapp.ui.uimodel.FileUIModel
import com.example.musicalignapp.ui.uimodel.ImageUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddFileViewModel @Inject constructor(
    private val uploadPackageUseCase: UploadPackageUseCase,
    @IdGeneratorAnnotation private val idGenerator: Generator<String>,
    @PackageDateGeneratorAnnotation private val packageDateGenerator: Generator<String>
) : ViewModel() {

    private var _uiState = MutableStateFlow<ScreenState<Boolean>>(ScreenState.Empty())
    val uiState: StateFlow<ScreenState<Boolean>> = _uiState

    private var _packageState = MutableStateFlow(AddFileUIModel())
    val packageState: StateFlow<AddFileUIModel> = _packageState

    fun onNameChanged(packageName: CharSequence?) {
        _packageState.update { it.copy(packageName = packageName.toString()) }
    }

    fun onAddProductSelected() {
        viewModelScope.launch {
            _uiState.value = ScreenState.Loading()

            val result = withContext(Dispatchers.IO) {
                uploadPackageUseCase(
                    _packageState.value.toDomain(
                        idGenerator.generate(),
                        packageDateGenerator.generate()
                    )
                )
            }
            if (result) {
                _uiState.value = ScreenState.Success(true)
            } else {
                _uiState.value = ScreenState.Error("Error")
            }
        }
    }

    fun onImageUploaded(image: ImageUIModel) {
        _packageState.update { it.copy(image = image) }
    }

    fun onImageDeleted() {
        _packageState.update { it.copy(image = ImageUIModel("", "")) }
    }

    fun onFileUploaded(file: FileUIModel) {
        _packageState.update { it.copy(file = file) }
    }

    fun onFileDeleted() {
        _packageState.update { it.copy(file = FileUIModel("", "", "")) }
    }
}