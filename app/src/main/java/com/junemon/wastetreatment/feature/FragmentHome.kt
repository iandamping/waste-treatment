package com.junemon.wastetreatment.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import com.junemon.tappay.base.BaseFragmentViewBinding
import com.junemon.wastetreatment.databinding.FragmentHomeBinding

class FragmentHome:BaseFragmentViewBinding<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun initView() {

    }

    override fun viewCreated() {

    }
}