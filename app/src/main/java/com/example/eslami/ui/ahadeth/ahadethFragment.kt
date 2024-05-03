package com.example.eslami.ui.ahadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eslami.databinding.FragmentAhadethBinding

class ahadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ahadethlines()
    }

    private fun ahadethlines() {
        val listAhadeth = mutableListOf<ahadethModel>()
        val ahadeth = context?.assets?.open("ahadeeth.txt")
        val allAhadeth = ahadeth?.bufferedReader().use { it?.readText() }
        val content = allAhadeth?.trim()?.split("#")
        content?.forEach {hadeth->
            val lines = hadeth.trim().split("\n")
            val title = lines[0]
            val body = lines.toMutableList().apply {
                this.removeAt(0)
            }
            val newListtobody = body.joinToString("/n")
            val hadeth = ahadethModel(title,newListtobody)
            listAhadeth.add(hadeth)

        }
        initRec(listAhadeth)

    }

    private fun initRec(lista: MutableList<ahadethModel>) {
        val adapter = adapterAhadeth(lista)
        binding.ahadethrv.adapter = adapter

        adapter.click = adapterAhadeth.onRecClick { position, hadeth ->
            NavigateToDetailedAhadeth(hadeth)

        }
    }

    private fun NavigateToDetailedAhadeth(hadeth: ahadethModel) {
        val intent = Intent(this@ahadethFragment.context, AhadethDetailsActivity::class.java)
        intent.putExtra(constantAhadeth.hadeth,hadeth)
        startActivity(intent)
    }
}