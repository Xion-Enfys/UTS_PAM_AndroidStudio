package iat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    // Mengubah tipe data menjadi MutableList<String> untuk mendukung banyak item
    // Namun, berdasarkan logika Checkout Anda yang hanya mengirim satu item,
    // kita tetap menggunakan String? untuk item terakhir yang diklik.
    private var selectedMenu: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 1. Ambil data nama dari Intent sebelumnya
        val nama = intent.getStringExtra("nama")
        findViewById<TextView>(R.id.tvNama).text = "Halo, $nama"

        // 2. Deklarasi dan inisialisasi semua Button (termasuk btnBuy3 yang hilang)
        val btnBuy1 = findViewById<Button>(R.id.btnBuy1)
        val btnBuy2 = findViewById<Button>(R.id.btnBuy2)
        // PERBAIKAN: Deklarasi btnBuy3
        val btnBuy3 = findViewById<Button>(R.id.btnBuy3)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        // --- Atur Listener Tombol Beli ---

        // Pilih menu Beef Steak
        btnBuy1.setOnClickListener {
            selectedMenu = "Beef Steak"
            Toast.makeText(this, "Kamu membeli Beef Steak!", Toast.LENGTH_SHORT).show()
        }

        // Pilih menu Red Velvet Cake
        btnBuy2.setOnClickListener {
            selectedMenu = "Red Velvet Cake"
            Toast.makeText(this, "Kamu membeli Red Velvet Cake!", Toast.LENGTH_SHORT).show()
        }

        //Pilih menu Matcha
        btnBuy3.setOnClickListener {
            selectedMenu = "Matcha" // PERBAIKAN: Simpan "Matcha"
            Toast.makeText(this, "Kamu membeli Matcha!", Toast.LENGTH_SHORT).show()
        }

        // Button Check Out
        btnCheckout.setOnClickListener {
            if (selectedMenu == null) {
                Toast.makeText(this, "Silakan pilih menu terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, AddressActivity::class.java)
                intent.putExtra("nama", nama)
                // Mengirim menu yang terakhir dipilih
                intent.putExtra("menu", selectedMenu)
                startActivity(intent)
            }
        }
    }
}