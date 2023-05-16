package ca.josue_lubaki.kmmexperiments.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.kmmexperiments.domain.model.Movie
import com.seiko.imageloader.AsyncImagePainter
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.ImageLoaderConfig
import com.seiko.imageloader.model.ImageRequest
import com.seiko.imageloader.rememberAsyncImagePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * created by Josue Lubaki
 * date : 2023-04-30
 * version : 1.0.0
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MovieListItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .requiredHeight(320.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
    ){
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.onBackground.copy(alpha = 0.85f))
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = rememberAsyncImagePainter(
                        url = movie.posterImage,
                        contentScale = ContentScale.Crop,
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 2.dp,
                                bottomEnd = 2.dp,
                            )
                        )
                )

                Surface(
                    color = Color.Black.copy(alpha = 0.6f),
                    modifier = Modifier
                        .size(50.dp),
                    shape = CircleShape,
                ){
                    Image(
                        painter = painterResource("play_button.xml"),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(12.dp)
                            .align(Alignment.Center)
                    )
                }
            }

            Column(
                modifier = Modifier.padding(10.dp),
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.background
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = movie.releaseDate,
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.background
                )
            }

        }
    }
}