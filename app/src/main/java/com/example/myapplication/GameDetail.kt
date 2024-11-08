import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityGameDetailBinding



class GameDetail: AppCompatActivity() {
    companion object {
        const val GAME_TITLE = "game_title"
        const val RELEASE_DATE = "release_date"
        const val PLATFORM = "platform"
        const val GENRE = "genre"
        const val DEVELOPER = "developer"
        const val RATING = "rating"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val binding: ActivityGameDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_detail)


        val gameTitle = intent.getStringExtra(GAME_TITLE)
        val releaseDate = intent.getStringExtra(RELEASE_DATE)
        val platform = intent.getStringExtra(PLATFORM)
        val genre = intent.getStringExtra(GENRE)
        val developer = intent.getStringExtra(DEVELOPER)
        val rating = intent.getStringExtra(RATING)


        binding.titleView.text = gameTitle
        binding.releaseDateView.text = releaseDate
        binding.platformView.text = platform
        binding.genreView.text = genre
        binding.developerView.text = developer
        binding.ratingView.text = rating


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
