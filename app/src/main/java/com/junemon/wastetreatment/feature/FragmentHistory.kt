package com.junemon.wastetreatment.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import com.junemon.tappay.base.BaseFragmentViewBinding
import com.junemon.wastetreatment.databinding.FragmentHistoryBinding

class FragmentHistory : BaseFragmentViewBinding<FragmentHistoryBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHistoryBinding
        get() = FragmentHistoryBinding::inflate

    override fun initView() {

    }

    override fun viewCreated() {

    }
}