package danielnt.palettelibrarykotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgImagen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.flores_1))
        changePhoto(BitmapFactory.decodeResource(resources, R.drawable.flores_1))


    }

    private fun changePhoto(bitmap: Bitmap) {
        //Llamada asíncrona:
        Palette.from(bitmap).maximumColorCount(24).generate { p ->
            /*
            //Opción 1: Acceso directo a los colores principales
            txtVibrant.setBackgroundColor(p.getVibrantColor(Color.BLACK));
            txtDarkVibrant.setBackgroundColor(p.getDarkVibrantColor(Color.BLACK));
            txtLightVibrant.setBackgroundColor(p.getLightVibrantColor(Color.BLACK));
            txtMuted.setBackgroundColor(p.getMutedColor(Color.BLACK));
            txtDarkMuted.setBackgroundColor(p.getDarkMutedColor(Color.BLACK));
            txtLightMuted.setBackgroundColor(p.getLightMutedColor(Color.BLACK));
            */

            //Opción 2: Acceso a los swatches pricipales completos
            setTextViewSwatch(txtVibrant, p.vibrantSwatch)
            setTextViewSwatch(txtDarkVibrant, p.darkVibrantSwatch)
            setTextViewSwatch(txtLightVibrant, p.lightVibrantSwatch)
            setTextViewSwatch(txtMuted, p.mutedSwatch)
            setTextViewSwatch(txtDarkMuted, p.darkMutedSwatch)
            setTextViewSwatch(txtLightMuted, p.lightMutedSwatch)

            //Opción 3: Acceso a todos los swatches generados
            for (sw in p.swatches) {
                Log.i("Palette", "Color: #" + Integer.toHexString(sw.rgb) + " (" + sw.population + " píxeles)")
            }
        }
    }

    private fun setTextViewSwatch(tview: TextView, swatch: Palette.Swatch?) {
        if (swatch != null) {
            tview.setBackgroundColor(swatch.rgb)
            tview.setTextColor(swatch.bodyTextColor)
            tview.text = "Pixeles: ${swatch.population}"
        } else {
            tview.setBackgroundColor(Color.BLACK)
            tview.setTextColor(Color.WHITE)
            tview.text = "(sin definir)"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.i1 -> {
                imgImagen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.flores_1))
                changePhoto(BitmapFactory.decodeResource(resources, R.drawable.flores_1))
            }
            R.id.i2 -> {
                imgImagen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.flores_2))
                changePhoto(BitmapFactory.decodeResource(resources, R.drawable.flores_2))
            }
            R.id.i3 -> {
                imgImagen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.flores_3))
                changePhoto(BitmapFactory.decodeResource(resources, R.drawable.flores_3))
            }
            R.id.i4 -> {
                imgImagen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.flores_4))
                changePhoto(BitmapFactory.decodeResource(resources, R.drawable.flores_4))
            }
            R.id.i5 -> {
                imgImagen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.flores_5))
                changePhoto(BitmapFactory.decodeResource(resources, R.drawable.flores_5))
            }
        }
        return true
    }
}

