package com.example.resepqu.ui.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.resepqu.R
import com.example.resepqu.ui.theme.ResepQuTheme

@Composable
fun ProfileScreen(
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = "https://media.licdn.com/dms/image/C4E03AQHzTBTfofQsig/profile-displayphoto-shrink_800_800/0/1616565306427?e=1689811200&v=beta&t=LZ7sF3U4vCrcSUZ8GgGZFxHSWZ_9kj_Qs0Ybu8mPEVQ",
                contentDescription = stringResource(R.string.my_photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(R.string.name),
                fontWeight = FontWeight.Medium,
                fontSize = 36.sp

            )
            Text(
                text = stringResource(R.string.email),
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ResepQuTheme {
        ProfileScreen()
    }
}
