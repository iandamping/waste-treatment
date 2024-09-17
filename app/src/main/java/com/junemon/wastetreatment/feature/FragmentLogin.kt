package com.junemon.wastetreatment.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import com.junemon.tappay.base.BaseFragmentViewBinding
import com.junemon.wastetreatment.databinding.FragmentLoginBinding

class FragmentLogin : BaseFragmentViewBinding<FragmentLoginBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate

    override fun initView() {

    }

    override fun viewCreated() {

    }
}