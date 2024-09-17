package com.junemon.wastetreatment.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import com.junemon.tappay.base.BaseFragmentViewBinding
import com.junemon.wastetreatment.databinding.FragmentProfileBinding

class FragmentProfile : BaseFragmentViewBinding<FragmentProfileBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    override fun initView() {

    }

    override fun viewCreated() {

    }
}