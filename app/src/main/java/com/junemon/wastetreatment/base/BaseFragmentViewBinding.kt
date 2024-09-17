package com.junemon.tappay.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.base.DialogData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseFragmentViewBinding<out VB : ViewBinding> : Fragment() {
    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    private fun getCoroutineErrorHandler() = CoroutineExceptionHandler { _, e ->
        Timber.e("An error happened: ${e.message}")
    }

    protected fun consumeSuspend(func: suspend CoroutineScope.() -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch(getCoroutineErrorHandler()) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                func.invoke(this)
            }
        }
    }

    protected fun overrideFragmentBackPressed(func: () -> Unit) {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    func.invoke()
                }
            }
        )
    }

    abstract fun initView()

    abstract fun viewCreated()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewCreated()
    }

    protected fun toaster(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(requireContext(), message, duration).show()
    }

    protected fun showMaterialDialog(data: DialogData): MaterialAlertDialogBuilder {
        val context: Context = ContextThemeWrapper(requireContext(), R.style.MyCustomDialogTheme)
        return MaterialAlertDialogBuilder(context)
            .setTitle(data.title)
            .setMessage(data.message)
            .setCancelable(data.isCancelable)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
