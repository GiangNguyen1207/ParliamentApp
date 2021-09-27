package com.example.android.parliament.screens.memberList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.android.parliament.R
import com.example.android.parliament.databinding.FragmentMemberListBinding

class MemberListFragment : Fragment() {
    private lateinit var memberListViewModel: MemberListViewModel
    private lateinit var memberListVmFactory: MemberListVmFactory
    private val args: MemberListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMemberListBinding>(inflater,
            R.layout.fragment_member_list,container,false)

        binding.lifecycleOwner = this

        val party = args.party

        memberListVmFactory = MemberListVmFactory(requireContext())
        memberListViewModel = ViewModelProvider(this, memberListVmFactory)
            .get(MemberListViewModel::class.java)

        memberListViewModel.readMemberList(party)
        memberListViewModel.allMembers.observe(viewLifecycleOwner, {
            println(it)
        })

        return binding.root
    }

}
