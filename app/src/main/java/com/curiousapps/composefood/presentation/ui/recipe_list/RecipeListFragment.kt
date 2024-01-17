package com.curiousapps.composefood.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.curiousapps.composefood.R

class RecipeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.layout_recipe_list,
            container, false
        )

        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            Column(
                modifier = Modifier
                    .border(border = BorderStroke(1.dp, Color.Cyan))
                    .background(Color.LightGray)
                    .padding(16.dp)

            ) {
                Text("THIS IS A COMPOSABLE INSIDE A FRAGMENT")
                Spacer(modifier = Modifier.padding(10.dp))
                CircularProgressIndicator(color = Color.White)
                Spacer(modifier = Modifier.padding(10.dp))
                Text("Another set of Text")
                Spacer(modifier = Modifier.padding(10.dp))

            }
        }
        return view
    //        return ComposeView(requireContext()).apply {
//            setContent {
//                Text("Hey Look A Composable 2")
//            }
//        }
//        return inflater.inflate(
//            R.layout.layout_recipe_list,
//            container, false
//        )
    }
}