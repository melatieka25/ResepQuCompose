package com.example.resepqu.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.resepqu.ui.theme.ResepQuTheme

@Composable
fun StepListItem(
    text: String,
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
                .clip(CircleShape)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StepListItemPreview() {
    ResepQuTheme {
        StepListItem(
            text = "Siapkan bahan, dan haluskan bumbu halus.",
            photoUrl = "https://cdn.yummy.co.id/content-images/images/20220214/2winrpkw6DMaGsFWcoeDD30sn9kdKlVZ-31363434383136313632d41d8cd98f00b204e9800998ecf8427e.jpg?x-oss-process=image/resize,w_220,h_220,m_fixed,image/format,webp",
        )
    }
}