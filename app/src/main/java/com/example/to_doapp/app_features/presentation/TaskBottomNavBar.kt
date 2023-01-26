package com.example.to_doapp.app_features.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.to_doapp.R

@Composable
fun TaskBottomNavBar() {

    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary),
            horizontalArrangement = Arrangement.SpaceAround
        ) {


            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxSize()
                    .weight(1F)
                    .offset(x = -14.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Color.Gray
                )
            }


            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxSize()
                    .weight(1F)
                    .offset(x = 14.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_completed_task_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp),
                    tint = Color.Gray
                )
            }
        }

    }

}
