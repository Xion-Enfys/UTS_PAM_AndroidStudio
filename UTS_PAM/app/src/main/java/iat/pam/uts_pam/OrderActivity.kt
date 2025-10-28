package iat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    private lateinit var tvNamaPesanan: TextView
    private lateinit var tvMenuPesanan: TextView
    private lateinit var tvKonfirmasi: TextView
    private lateinit var btnBackToHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        tvNamaPesanan = findViewById(R.id.tvNamaPesanan)
        tvMenuPesanan = findViewById(R.id.tvMenuPesanan)
        tvKonfirmasi = findViewById(R.id.tvKonfirmasi)
        btnBackToHome = findViewById(R.id.btnBackToHome)

        // Ambil data dari AddressActivity
        val nama = intent.getStringExtra("nama")
        val menu = intent.getStringExtra("menu")

        tvNamaPesanan.text = "Nama Pemesan: $nama"
        tvMenuPesanan.text = "Pesanan: $menu"

        btnBackToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("nama", nama) // biar tetap tampil halo nama
            startActivity(intent)
            finish()
        }
    }
}
