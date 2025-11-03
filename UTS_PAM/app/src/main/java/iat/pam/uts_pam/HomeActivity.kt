package iat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private var selectedMenu: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val nama = intent.getStringExtra("nama")
        findViewById<TextView>(R.id.tvNama).text = "Halo, $nama"

        // =======================
        // DEKLARASI SEMUA BUTTON
        // =======================
        val btnBuy1 = findViewById<Button>(R.id.btnBuy1)
        val btnBuy2 = findViewById<Button>(R.id.btnBuy2)
        val btnBuy3 = findViewById<Button>(R.id.btnBuy3)
        val btnBuy4 = findViewById<Button>(R.id.btnBuy4)
        val btnBuy5 = findViewById<Button>(R.id.btnBuy5)
        val btnBuy6 = findViewById<Button>(R.id.btnBuy6)
        val btnBuy7 = findViewById<Button>(R.id.btnBuy7)
        val btnBuy8 = findViewById<Button>(R.id.btnBuy8)
        val btnBuy9 = findViewById<Button>(R.id.btnBuy9)
        val btnBuy10 = findViewById<Button>(R.id.btnBuy10)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        // =======================
        // LISTENER SET MENU
        // =======================
        btnBuy1.setOnClickListener { chooseMenu("Beef Steak") }
        btnBuy2.setOnClickListener { chooseMenu("Red Velvet Cake") }
        btnBuy3.setOnClickListener { chooseMenu("Matcha") }
        btnBuy4.setOnClickListener { chooseMenu("Bruule Cheese") }
        btnBuy5.setOnClickListener { chooseMenu("Capucino") }
        btnBuy6.setOnClickListener { chooseMenu("Geprek") }
        btnBuy7.setOnClickListener { chooseMenu("Milkshake") }
        btnBuy8.setOnClickListener { chooseMenu("Pancake") }
        btnBuy9.setOnClickListener { chooseMenu("Risol Mayo") }
        btnBuy10.setOnClickListener { chooseMenu("Spageti") }

        btnCheckout.setOnClickListener {
            if (selectedMenu == null) {
                Toast.makeText(this, "Silakan pilih menu dulu", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, AddressActivity::class.java)
                intent.putExtra("nama", nama)
                intent.putExtra("menu", selectedMenu)
                startActivity(intent)
            }
        }
    }

    private fun chooseMenu(menu: String) {
        selectedMenu = menu
        Toast.makeText(this, "Kamu memilih $menu", Toast.LENGTH_SHORT).show()
    }
}
