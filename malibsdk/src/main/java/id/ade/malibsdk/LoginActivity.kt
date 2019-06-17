package id.ade.malibsdk

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            if (name.text.toString().isNullOrBlank()) name.error
            else if (pass.text.toString().isNullOrBlank()) pass.error
            else {
                if (name.text.toString() == pass.text.toString())
                    finishAffinity()
                else
                    Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showDialog()
    }


    private fun showDialog() {

        lateinit var dialog: AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Keluar aplikasi.")
        builder.setMessage("Yakin mau keluar aplikasi.")


        val dialogClickListener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    dialog.dismiss()
                    finishAffinity()
                }
                DialogInterface.BUTTON_NEGATIVE -> dialog.dismiss()
            }
        }
        builder.setPositiveButton("YES", dialogClickListener)
        builder.setNegativeButton("NO", dialogClickListener)
        dialog = builder.create()

        dialog.show()
    }
}