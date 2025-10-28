package iat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddressActivity : AppCompatActivity() {

    private lateinit var tvJudul: TextView
    private lateinit var etNama: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etPhone: EditText
    private lateinit var etNotes: EditText
    private lateinit var btnKirimPesanan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        // Inisialisasi komponen
        tvJudul = findViewById(R.id.tvJudul)
        etNama = findViewById(R.id.etNama)
        etAlamat = findViewById(R.id.etAlamat)
        etPhone = findViewById(R.id.etPhone)
        etNotes = findViewById(R.id.etNotes)
        btnKirimPesanan = findViewById(R.id.btnKirimPesanan)

        // Ambil data dari intent sebelumnya
        val nama = intent.getStringExtra("nama")
        val menu = intent.getStringExtra("menu")

        tvJudul.text = "Detail Pesanan: $menu"

        btnKirimPesanan.setOnClickListener {
            val namaPenerima = etNama.text.toString()
            val alamat = etAlamat.text.toString()
            val phone = etPhone.text.toString()
            val notes = etNotes.text.toString()

            if (namaPenerima.isEmpty() || alamat.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                // Optional toast konfirmasi
                Toast.makeText(
                    this,
                    "Pesanan $menu untuk $namaPenerima telah dikirim ke alamat: $alamat",
                    Toast.LENGTH_LONG
                ).show()

                // Lanjut ke OrderActivity
                val intent = Intent(this, OrderActivity::class.java)
                intent.putExtra("nama", namaPenerima)
                intent.putExtra("menu", menu)
                startActivity(intent)
                finish() // supaya tidak bisa kembali ke AddressActivity
            }
        }
    }
}
